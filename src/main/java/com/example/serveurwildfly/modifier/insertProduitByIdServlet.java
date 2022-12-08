package com.example.serveurwildfly.modifier;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.ConnexionBDEcommece;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "insertProduitByIdServlet", urlPatterns = {"insertProduitById"}, value = "/insertProduitByIdServlet")
public class insertProduitByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = ConnexionBDEcommece.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update produit SET nom=?, prix=? where idProduit=?");
            ps.setString(1, request.getParameter("nom"));
            ps.setDouble(2, Double.parseDouble(request.getParameter("prix")));
            ps.setLong(3, Long.parseLong(request.getParameter("id")));
            ps.executeUpdate();
            response.sendRedirect("produit");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
