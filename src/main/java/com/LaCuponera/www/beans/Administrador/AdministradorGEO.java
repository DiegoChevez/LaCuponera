package com.LaCuponera.www.beans.Administrador;

public class AdministradorGEO {
	
	private String nombreEmpresa;
	private String codigoEmpresa;
	private String direccion;
	private String nombreContacto;
	private String telefono;
	private String correo;
	private String rubro;
	private String porcentaje;
	
	
	
	
	public AdministradorGEO(String nombreEmpresa, String codigoEmpresa, String direccion, String nombreContacto,
			String telefono, String correo, String rubro, String porcentaje) {
		this.nombreEmpresa = nombreEmpresa;
		this.codigoEmpresa = codigoEmpresa;
		this.direccion = direccion;
		this.nombreContacto = nombreContacto;
		this.telefono = telefono;
		this.correo = correo;
		this.rubro = rubro;
		this.porcentaje = porcentaje;
	}
	
	
	public AdministradorGEO(){
		 this.nombreEmpresa = "";
			this.codigoEmpresa = "";
			this.direccion = "";
			this.nombreContacto = "";
			this.telefono = "";
			this.correo = "";
			this.rubro = "";
			this.porcentaje = "";
		}
	
	public AdministradorGEO(String nombreAutor) {
		 this.nombreEmpresa = "";
		}

	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	public String getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
}
