package client;

public class LogInCredentials {

	private String user_name;
	private String password;
	private int accessID;
	
	private Person person;
	
	public LogInCredentials() {}
	
	public LogInCredentials(String user_name, String password, int accessID) {
		this.user_name = user_name;
		this.password = password;
		this.accessID = accessID;
	}
	
	public Person getPersonLoggedIn() {
		return this.person;
	}
	
	public void setPersonLoggedIn(Person person) {
		this.person = person;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getPassword() {
		return password;
	}

	public int getAccessID() {
		return accessID;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccessID(int accessID) {
		this.accessID = accessID;
	}
	

	
	
}
