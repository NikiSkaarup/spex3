package controllers;

import data.DB;
import model.Cupcake;
import model.OrderLine;
import model.Part;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
@WebServlet(name = "ShopController", urlPatterns = {"/shop", "/shop/"})
public class ShopController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<OrderLine> orderLines = new ArrayList<>();
        Object cart = request.getSession().getAttribute("cart");

        int top = Integer.parseInt(request.getParameter("topping"));
        int bot = Integer.parseInt(request.getParameter("bottom"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        try {
            orderLines.addAll((List<OrderLine>) cart);
        } catch (Exception ignored) {
        }

        OrderLine orderLine = new OrderLine();
        Cupcake cupcake = new Cupcake();

        cupcake.setTopping(getPart(top));
        cupcake.setBottom(getPart(bot));
        orderLine.setCupcake(cupcake);
        orderLine.setAmount(amount);
        orderLines.add(orderLine);

        request.getSession().setAttribute("cart", orderLines);
        response.sendRedirect("/shop");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        PreparedStatement ps = null;
        String selString = "SELECT id, name, topping, bottom FROM parts";
        ArrayList<Part> parts = new ArrayList<>();
        try {
            ps = DB.getConnection().prepareStatement(selString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean topping = rs.getBoolean("topping");
                boolean bottom = rs.getBoolean("bottom");
                Part part = new Part(id, name, topping, bottom);
                parts.add(part);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        StringBuilder toppings = new StringBuilder();
        StringBuilder bottoms = new StringBuilder();
        if (parts.size() <= 0) {
            response.sendRedirect("/");
            return;
        }

        for (Part part : parts) {
            String option = partToOption(part);
            if (part.isTopping())
                toppings.append(option);
            if (part.isBottom())
                bottoms.append(option);
        }

        request.setAttribute("toppings", toppings);
        request.setAttribute("bottoms", bottoms);
        request.setAttribute("sideCart", generateSideCart(request));

        RequestDispatcher rd = request.getRequestDispatcher("/shop.jsp");
        rd.forward(request, response);
    }

    private String partToOption(Part part) {
        return "<option value='" +
                part.getId() +
                "'>" +
                part.getName() +
                "</option>";
    }

    private Part getPart(int id) {
        Part part = new Part();
        PreparedStatement ps = null;
        String selString = "SELECT id, name, topping, bottom, price FROM " +
                "parts WHERE id = ?";
        try {
            ps = DB.getConnection().prepareStatement(selString);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                part.setId(rs.getInt("id"));
                part.setName(rs.getString("name"));
                part.setTopping(rs.getBoolean("topping"));
                part.setBottom(rs.getBoolean("bottom"));
                part.setPrice(rs.getBigDecimal("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return part;
    }

    private String generateSideCart(HttpServletRequest request) {
        List<OrderLine> orderLines = new ArrayList<>();
        Object cart = request.getSession().getAttribute("cart");

        try {
            orderLines.addAll((List<OrderLine>) cart);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<ul id='sideCart'>");
        for (OrderLine orderLine : orderLines) {
            sb.append("<li><span class='top'>Top: ");
            sb.append(orderLine.getCupcake().getTopping().getName());
            sb.append("</span><span class='bot'>Bot: ");
            sb.append(orderLine.getCupcake().getBottom().getName());
            sb.append("</span><span class='amount'>Amount: ");
            sb.append(orderLine.getAmount());
            sb.append("</span><span class='price'>Price: ");
            sb.append(orderLine.getCupcake().getTopping().getPrice().add
                    (orderLine.getCupcake().getBottom().getPrice()));
            sb.append("</span></li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

}
