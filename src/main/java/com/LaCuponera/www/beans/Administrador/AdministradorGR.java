package com.LaCuponera.www.beans.Administrador;

public class AdministradorGR {

	String id;
	String nombreRubro;
	String estatusRubro;

	public AdministradorGR() {
		this.id = "";
		this.nombreRubro = "";
		this.estatusRubro = "";
	}

	public AdministradorGR(String id, String nombreRubro, String estatusRubro) {
		this.id = id;
		this.nombreRubro = nombreRubro;
		this.estatusRubro = estatusRubro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreRubro() {
		return nombreRubro;
	}

	public void setNombreRubro(String nombreRubro) {
		this.nombreRubro = nombreRubro;
	}

	public String getEstatusRubro() {
		return estatusRubro;
	}

	public void setEstatusRubro(String estatusRubro) {
		this.estatusRubro = estatusRubro;
	}

}
