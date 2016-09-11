package controllers;

import data.DB;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login", "/login/"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PreparedStatement selUser = null;
        String selString = "SELECT id, username, password, balance FROM users" +
                " WHERE username = ?";
        try {
            selUser = DB.getConnection().prepareStatement(selString);
            selUser.setString(1, username);
            ResultSet rs = selUser.executeQuery();
            if (rs.next() && password.equals(rs.getString("password"))) {
                int id = rs.getInt("id");
                int balance = rs.getInt("balance");
                User user = new User(id, username, balance);
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/shop");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
}
