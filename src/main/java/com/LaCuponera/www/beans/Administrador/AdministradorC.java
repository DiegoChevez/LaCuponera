package com.LaCuponera.www.beans.Administrador;

public class AdministradorC {

	String cuponId;
	String offerId;
	String customerId;
	String codeC;
	String transactionId;
	String couponStatus;
	
	
	public AdministradorC() {
		this.cuponId = "";
		this.offerId =  "";
		this.customerId = "";
		this.codeC = "";
		this.transactionId = "";
		this.couponStatus = "";
	}
	
	public AdministradorC(String cuponId, String offerId, String customerId, String codeC, String transactionId,
			String couponStatus) {
		this.cuponId = cuponId;
		this.offerId = offerId;
		this.customerId = customerId;
		this.codeC = codeC;
		this.transactionId = transactionId;
		this.couponStatus = couponStatus;
	}
	
	
	public String getCuponId() {
		return cuponId;
	}
	public void setCuponId(String cuponId) {
		this.cuponId = cuponId;
	}
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCodeC() {
		return codeC;
	}
	public void setCodeC(String codeC) {
		this.codeC = codeC;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getCouponStatus() {
		return couponStatus;
	}
	public void setCouponStatus(String couponStatus) {
		this.couponStatus = couponStatus;
	}
	
	
	

}
