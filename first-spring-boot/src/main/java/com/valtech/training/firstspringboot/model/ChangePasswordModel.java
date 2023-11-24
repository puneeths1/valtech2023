package com.valtech.training.firstspringboot.model;

public class ChangePasswordModel {

		private String username;
		private String oldpassword;
		private String newpassword;
		private String confirmPassword;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getOldpassword() {
			return oldpassword;
		}
		public void setOldpassword(String oldpassword) {
			this.oldpassword = oldpassword;
		}
		public String getNewpassword() {
			return newpassword;
		}
		public void setNewpassword(String newpassword) {
			this.newpassword = newpassword;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
}
