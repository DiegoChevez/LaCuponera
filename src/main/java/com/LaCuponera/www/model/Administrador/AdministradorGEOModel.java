package com.LaCuponera.www.model.Administrador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.LaCuponera.www.beans.Administrador.AdministradorGEO;
import com.LaCuponera.www.model.Conexion;

public class AdministradorGEOModel extends Conexion {

	public List<AdministradorGEO> listarCompanies() throws SQLException {
		try {
			List<AdministradorGEO> lista = new ArrayList<AdministradorGEO>();
			String sql = "CALL sp_companiesList()";
			this.conectar();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				AdministradorGEO administradorGEO = new AdministradorGEO();
				
				administradorGEO.setCodigoEmpresa(rs.getString("company_id"));
				administradorGEO.setNombreEmpresa(rs.getString("name"));
				administradorGEO.setDireccion(rs.getString("address"));
				administradorGEO.setNombreContacto(rs.getString("contact_name"));
				administradorGEO.setTelefono(rs.getString("phone"));
				administradorGEO.setCorreo(rs.getString("mail"));
				administradorGEO.setRubro(rs.getString("industry_id"));
				administradorGEO.setPorcentaje(rs.getString("commission_porcentage"));
				
				lista.add(administradorGEO);
				
			}
			this.desconectar();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGEOModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}
}

