package vn.ptit.model;

public class User {
	private int id;
	private String username;
	private String email;
	private String password;
	private String country;
	private String gender;
	public User() {
		super();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(int id, String username, String email, String password, String country, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.country = country;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
