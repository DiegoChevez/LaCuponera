package com.LaCuponera.www.model.Administrador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.LaCuponera.www.beans.Administrador.AdministradorGC;
import com.LaCuponera.www.model.Conexion;
import com.mysql.jdbc.PreparedStatement;

public class AdministradorGCModel extends Conexion {

	
	public List<AdministradorGC> listarClientes() throws SQLException {
		try {
			List<AdministradorGC> lista = new ArrayList<AdministradorGC>();
			String sql = "SELECT * FROM customers WHERE customer_status ='ACTIVO' ";
			this.conectar();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				AdministradorGC administradorGC = new AdministradorGC();
				
				administradorGC.setCustomerId(rs.getString("customer_id"));
				administradorGC.setUserId(rs.getString("user_id"));
				administradorGC.setFirstName(rs.getString("first_name"));
				administradorGC.setLastName(rs.getString("last_name"));
				administradorGC.setPhoneC(rs.getString("phone"));
				administradorGC.setMailC(rs.getString("email"));
				administradorGC.setAddressC(rs.getString("address"));
				administradorGC.setDuiC(rs.getString("dui"));
				administradorGC.setStatusC(rs.getString("customer_status"));
				lista.add(administradorGC);
			}
			this.desconectar();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGCModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}
	
	public List<AdministradorGC> listinac() throws SQLException {
		try {
			List<AdministradorGC> lista = new ArrayList<AdministradorGC>();
			String sql = "SELECT * FROM customers WHERE customer_status ='INACTIVO' ";
			this.conectar();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				AdministradorGC administradorGC = new AdministradorGC();
				
				administradorGC.setCustomerId(rs.getString("customer_id"));
				administradorGC.setUserId(rs.getString("user_id"));
				administradorGC.setFirstName(rs.getString("first_name"));
				administradorGC.setLastName(rs.getString("last_name"));
				administradorGC.setPhoneC(rs.getString("phone"));
				administradorGC.setMailC(rs.getString("email"));
				administradorGC.setAddressC(rs.getString("address"));
				administradorGC.setDuiC(rs.getString("dui"));
				administradorGC.setStatusC(rs.getString("customer_status"));
				lista.add(administradorGC);
			}
			this.desconectar();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGCModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}
	
	
	public int eliminarRubro(String codigo) throws SQLException {
	    try {
	        int filasAfectadas = 0;
	        String sql = "UPDATE customers " +
                    "INNER JOIN users ON customers.user_id = users.user_id " +
                    "SET customers.customer_status = 'INACTIVO', users.user_status = 'INACTIVO' " +
                    "WHERE customers.customer_id = ?";
	        this.conectar();
	        cs = conexion.prepareCall(sql);
	        cs.setString(1, codigo);
	        filasAfectadas = cs.executeUpdate();
	        
	        this.desconectar();
	        return filasAfectadas;
	    } catch (SQLException ex) {
	        Logger.getLogger(AdministradorGRModel.class.getName()).log(Level.SEVERE, null, ex);
	        this.desconectar();
	        return 0;
	    }
	}
	
	
/*
	public int insertarRubro(AdministradorGR miGR) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL CreateIndustry(?,?,?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, miGR.getId());
			cs.setString(2, miGR.getNombreRubro());
			cs.setString(3, miGR.getEstatusRubro());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGRModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}
	

	public int eliminarRubro(String codigo) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL DeactivateIndustry(?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, codigo);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGRModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}

	}

	public int modificarRubro(AdministradorGR rubro) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL ModifyIndustry(?,?,?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, rubro.getId());
			cs.setString(2, rubro.getNombreRubro());
			cs.setString(3, rubro.getEstatusRubro());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGRModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}
	

	public AdministradorGR obtenerRubro(String codigo) throws SQLException {
		try {
			String sql = "CALL SelectIndustryById(?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, codigo);
			rs = cs.executeQuery();
			if (rs.next()) {
				AdministradorGR obtRubro = new AdministradorGR();
				
				obtRubro.setId(rs.getString("industry_id"));
				obtRubro.setNombreRubro(rs.getString("industry"));
				obtRubro.setEstatusRubro(rs.getString("industry_status"));
				this.desconectar();
				return obtRubro;
			}
			this.desconectar();
			return null;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGRModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}
*/
}