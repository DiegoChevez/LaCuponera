package com.LaCuponera.www.controllers.Login;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import com.LaCuponera.www.model.Login.*;



@WebServlet(name = "LoginController", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Llamar al modelo para autenticar al usuario
        LoginModel userModel = new LoginModel();
        String role = userModel.authenticateUser(email, password);

        if (role != null) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("role", role);

            // Redirigir a la página correspondiente según el rol
            if ("ADGRL-1586".equals(role)) {
                response.sendRedirect("administrador/indexadmin.jsp");
            } else if ("CLNTA-7841".equals(role)) {
                response.sendRedirect("cliente.jsp");
            } else if ("CMPNY-7841".equals(role)) {
                response.sendRedirect("compania.jsp");
            }
        } else {
            // Autenticación fallida, redirigir de nuevo al formulario de inicio de sesión
            response.sendRedirect("index.jsp?error=1");
        }
    }
}
