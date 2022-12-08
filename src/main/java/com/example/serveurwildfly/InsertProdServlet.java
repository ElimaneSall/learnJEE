package com.example.serveurwildfly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.ConnexionBDEcommece;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "InsertProdServlet", urlPatterns ={"insertProduit"}, value = "/InsertProdServlet")
public class InsertProdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = ConnexionBDEcommece.getConnection();
        String nom = request.getParameter("nom");
        Double prix = Double.parseDouble(request.getParameter("prix"));
        try {
            PreparedStatement ps = conn.prepareStatement("insert into produit(nom, prix) values(?,?) ");
           // ps.setString(1,request.getParameter("idProduit"));
            ps.setString(1, nom);
            ps.setDouble(2,prix);
            ps.executeUpdate();
            response.sendRedirect("produit");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
