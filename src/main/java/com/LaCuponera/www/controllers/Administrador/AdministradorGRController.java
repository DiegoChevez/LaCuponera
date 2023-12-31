/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.LaCuponera.www.controllers.Administrador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.LaCuponera.www.beans.Administrador.*;
import com.LaCuponera.www.model.Administrador.*;
import com.LaCuponera.www.utils.Validaciones;

/**
 *
 * @author Rafael Torres
 */
@SuppressWarnings("serial")
@WebServlet(name = "AdministradorGRController", urlPatterns = { "/administradorGR.do" })
public class AdministradorGRController extends HttpServlet {
	ArrayList<String> listaErrores = new ArrayList<>();
	AdministradorGRModel modelo = new AdministradorGRModel();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				listar(request, response);
				return;
			}
			String operacion = request.getParameter("op");
			switch (operacion) {
			case "listar":
				listar(request, response);
				break;
			case "nuevo":
				request.getRequestDispatcher("/administrador/nuevoRubro.jsp").forward(request, response);
				break;
			case "insertar":
				insertar(request, response);
				break;
			case "obtener":
				obtener(request, response);
				break;
			case "modificar":
				modificar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			}
		}
	}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listaRubros", modelo.listarRubros());
			request.getRequestDispatcher("/administrador/listaRubros.jsp").forward(request, response);
		} catch (SQLException | ServletException | IOException ex) {
			Logger.getLogger(AdministradorGRController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaErrores.clear();
			AdministradorGR miGR = new AdministradorGR();
			miGR.setId(request.getParameter("id"));
			miGR.setNombreRubro(request.getParameter("nombre"));
			miGR.setEstatusRubro(request.getParameter("estatus"));
			if (Validaciones.isEmpty(miGR.getId())) {
				listaErrores.add("El ID del Rubro es obligatorio");
			} else if (!Validaciones.esCodigoAutor(miGR.getId())) {
				listaErrores.add("El ID del Rubro debe tener el formato correcto AUT000");
			}
			if (Validaciones.isEmpty(miGR.getNombreRubro())) {
				listaErrores.add("El nombre del Rubro es obligatorio");
			}
			if (Validaciones.isEmpty(miGR.getEstatusRubro())) {
				listaErrores.add("La estado es obligatorio");
			}
			if (listaErrores.size() > 0) {
				request.setAttribute("listaErrores", listaErrores);
				request.setAttribute("autor", miGR);
				request.getRequestDispatcher("administradorGR.do?op=nuevo").forward(request, response);
			} else {
				if (modelo.insertarRubro(miGR) > 0) {
					request.getSession().setAttribute("exito", "autor registrado exitosamente");
					response.sendRedirect(request.getContextPath() + "/administradorGR.do?op=listar");
				} else {
					request.getSession().setAttribute("fracaso",
							"El autor no ha sido ingresado" + "ya hay un autor con este codigo");
					response.sendRedirect(request.getContextPath() + "/administradorGR.do?op=listar");
				}
			}
		} catch (IOException | SQLException | ServletException ex) {
			Logger.getLogger(AdministradorGRController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void obtener(HttpServletRequest request, HttpServletResponse response) {
		try {
			String codigo = request.getParameter("id");
			AdministradorGR miRubro = modelo.obtenerRubro(codigo);
			if (miRubro != null) {
				request.setAttribute("rubro", miRubro);
				request.getRequestDispatcher("/administrador/editarRubro.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}
		} catch (SQLException | IOException | ServletException ex) {
			Logger.getLogger(AdministradorGRController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	

	private void modificar(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaErrores.clear();
			AdministradorGR rubroAct = new AdministradorGR();
			rubroAct.setId(request.getParameter("codigo"));
			rubroAct.setNombreRubro(request.getParameter("nombre"));
			rubroAct.setEstatusRubro(request.getParameter("nacionalidad"));
			if (Validaciones.isEmpty(rubroAct.getId())) {
				listaErrores.add("El codigo del autor es obligatorio");
			} else if (!Validaciones.esCodigoAutor(rubroAct.getId())) {
				listaErrores.add("El codigo de la autor debe tener el formato correcto AUT000");
			}
			if (Validaciones.isEmpty(rubroAct.getNombreRubro())) {
				listaErrores.add("El nombre del autor es obligatorio");
			}
			if (Validaciones.isEmpty(rubroAct.getEstatusRubro())) {
				listaErrores.add("La nacionalidad es obligatoria");
			}
			if (listaErrores.size() > 0) {
				request.setAttribute("listaErrores", listaErrores);

				request.setAttribute("autor", rubroAct);

				request.getRequestDispatcher("administradorGR.do?op=obtener").forward(request,

						response);
			} else {
				if (modelo.modificarRubro(rubroAct) > 0) {

					request.getSession().setAttribute("exito", "autor modificado exitosamente");

					response.sendRedirect(request.getContextPath() + "/administradorGR.do?op=listar");
				}

				else {
					request.getSession().setAttribute("fracaso",
							"El autor no ha sido modificado" + "ya hay un autor con este codigo");

					response.sendRedirect(request.getContextPath() + "/administradorGR.do?op=listar");
				}
			}
		} catch (IOException | SQLException | ServletException ex) {
			Logger.getLogger(AdministradorGRController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {
			String codigo = request.getParameter("id");
			if (modelo.eliminarRubro(codigo) > 0) {
				request.setAttribute("exito", "Autor eliminado exitosamente");
			} else {
				request.setAttribute("fracaso", "No se puede eliminar este autor x");
			}
			request.getRequestDispatcher("/administradorGR.do?op=listar").forward(request, response);
		} catch (SQLException | ServletException | IOException ex) {
			Logger.getLogger(AdministradorGRController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
