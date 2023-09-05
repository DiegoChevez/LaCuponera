package com.LaCuponera.www.beans.Administrador;

public class AdministradorGC {
	
		String customerId;
		String userId;
		String firstName;
		String lastName;
		String phoneC;
		String mailC;
		String addressC;
		String duiC;
		String statusC;
		
		
		
		public AdministradorGC() {
			this.customerId = "";
			this.userId = "";
			this.firstName = "";
			this.lastName = "";
			this.phoneC = "";
			this.mailC = "";
			this.addressC = "";
			this.duiC = "";
			this.statusC = "";
		}
		
		public AdministradorGC(String customerId, String userId, String firstName, String lastName, String phoneC,
				String mailC, String addressC, String duiC, String statusC) {
			this.customerId = customerId;
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneC = phoneC;
			this.mailC = mailC;
			this.addressC = addressC;
			this.duiC = duiC;
			this.statusC = statusC;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPhoneC() {
			return phoneC;
		}
		public void setPhoneC(String phoneC) {
			this.phoneC = phoneC;
		}
		public String getMailC() {
			return mailC;
		}
		public void setMailC(String mailC) {
			this.mailC = mailC;
		}
		public String getAddressC() {
			return addressC;
		}
		public void setAddressC(String addressC) {
			this.addressC = addressC;
		}
		public String getDuiC() {
			return duiC;
		}
		public void setDuiC(String duiC) {
			this.duiC = duiC;
		}
		public String getStatusC() {
			return statusC;
		}
		public void setStatusC(String statusC) {
			this.statusC = statusC;
		}
		
		
		
		
		
		
		
		
}
