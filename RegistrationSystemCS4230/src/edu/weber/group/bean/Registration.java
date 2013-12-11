package edu.weber.group.bean;

/**
 * 
 * The Registation class or otherwise known as the user object.
 * This is just a structure to hold the users information.
 * 
 * In website an object of this class is stored in the session as UserData attribute for convinience. 
 * 
 * 
 * @author 
 *
 */


public class Registration {
	
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean validate(){
		if (username != "" || password != ""){
			return true;
		}
		else return false;
	}
	
	
	

}
