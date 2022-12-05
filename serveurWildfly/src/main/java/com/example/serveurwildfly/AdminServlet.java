package com.example.serveurwildfly;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminServlet", urlPatterns = {"admin"}, value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        String nom = request.getParameter("nom");
        PrintWriter out = response.getWriter();
        out.println("<h1>"+nom + "</h1>");
        out.println(request.getProtocol());
        out.println(request.getRemoteAddr());
        response.sendRedirect("/admin.jsp?nom="+ request.getParameter("nom"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
