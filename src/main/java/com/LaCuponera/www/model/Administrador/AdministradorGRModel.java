package com.LaCuponera.www.model.Administrador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.LaCuponera.www.beans.Administrador.AdministradorGR;
import com.LaCuponera.www.model.Conexion;

public class AdministradorGRModel extends Conexion {

	public List<AdministradorGR> listarRubros() throws SQLException {
		try {
			List<AdministradorGR> lista = new ArrayList<AdministradorGR>();
			String sql = "SELECT * FROM industries";
			this.conectar();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				AdministradorGR administradorGR = new AdministradorGR();
				
				administradorGR.setId(rs.getString("industry_id"));
				administradorGR.setNombreRubro(rs.getString("industry"));
				administradorGR.setEstatusRubro(rs.getString("industry_status"));
				lista.add(administradorGR);
			}
			this.desconectar();
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(AdministradorGRModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}
	
	

	public int insertarRubro(AdministradorGR miGR) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "INSERT INTO industries (industry_id, industry, industry_status) VALUES (?, ?, ?)";
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
			String sql = "UPDATE industries SET industry_status = 'INACTIVA' WHERE industry_id = ?";
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
			String sql = "UPDATE industries SET industry = ?,industry_status = ? WHERE industry_id = ?";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, rubro.getNombreRubro());
			cs.setString(2, rubro.getEstatusRubro());
			cs.setString(3, rubro.getId());
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
			String sql = "SELECT * FROM industries WHERE industry_id = ?";
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
}