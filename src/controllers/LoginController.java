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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Niki on 2016-09-10.
 *
 * @author Niki
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login","/login/"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        PreparedStatement selUser = null;
        String selString = "SELECT `id`, `username`, `password` FROM `users` " +
                "WHERE `username` = ?";
        try {
            selUser = DB.getConnection().prepareStatement(selString);
            selUser.setString(1, username);
            ResultSet rs = selUser.getResultSet();
            if (rs.getFetchSize() == 1 && rs.next() &&
                    password.equals(rs.getString("password"))) {
                int id = rs.getInt("id");
                rd = request.getRequestDispatcher("/shop");
                User user = new User(id, username);
                request.setAttribute("user", user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rd == null)
            rd = request.getRequestDispatcher("/login");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

    }
}
