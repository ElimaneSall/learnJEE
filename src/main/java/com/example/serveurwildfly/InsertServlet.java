package com.example.serveurwildfly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.ConnexionBDEcommece;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "InsertServlet", value = "/InsertServlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = ConnexionBDEcommece.getConnection();
        String nom = request.getParameter("nom");
        Double prix = Double.parseDouble(request.getParameter("prix"));
        try {
            PreparedStatement ps = conn.prepareStatement("insert into produit values(?,?,?) ");
            ps.setString(1,request.getParameter("idProduit"));
            ps.setString(2, nom);
            ps.setDouble(3,prix);
            ps.executeUpdate();
            response.sendRedirect("produit");
            System.out.println("-".repeat(100));
            System.out.println("succes".repeat(100));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
