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
        Map<String, String> userAttributes = userModel.authenticateUser(email, password);

        if (userAttributes != null) {
            HttpSession session = request.getSession();
            
            // Guardar role_id y user_id en la sesión
            String role_id = userAttributes.get("role_id");
            String user_id = userAttributes.get("user_id");
            String user_status = userAttributes.get("user_status");
            
            session.setAttribute("role_id", role_id);
            session.setAttribute("user_id", user_id);
            session.setAttribute("user_status", user_status);
            
            // Redirigir a la página correspondiente según el rol
        	if("INACTIVO".equals(user_status)) {
        		response.sendRedirect("index.jsp");
        	}else if ("ADMIN-7874".equals(role_id)) {
                response.sendRedirect("administrador/indexadmin.jsp");
            } else if ("CLNTE-4095".equals(role_id)) {
                response.sendRedirect("cliente/indexcliente.jsp");
            } else if ("COMPY-2436".equals(role_id)) {
                response.sendRedirect("administradorEmpresaOfertante/indexAdminEO.jsp");
            }
        } else {
            // Autenticación fallida, redirigir de nuevo al formulario de inicio de sesión
            response.sendRedirect("index.jsp?error=1");
        }
    }
}