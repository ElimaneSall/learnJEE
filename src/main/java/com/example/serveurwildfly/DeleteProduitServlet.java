package com.example.serveurwildfly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.ConnexionBDEcommece;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "DeleteProduitServlet", urlPatterns = {"supprimer"},value = "/DeleteProduitServlet")
public class DeleteProduitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = ConnexionBDEcommece.getConnection();
        Long id = Long.parseLong(request.getParameter("id"));
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from produit where idProduit=?");
            ps.setLong(1, id);
            ps.executeUpdate();
            response.sendRedirect("produit");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
