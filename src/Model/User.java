package Model;

public class User {
	private String userId;
	private String userName;
	private String email;
	private String password;
	private String userType;
	private String level;

	public User(String userId, String userName, String email, String password, String userType, String level) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.level = level;
	}

	@Override
	public String toString() {
		return userId + "*" + userName + "*" + email + "*" + password + "*" + userType + "*" + level;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
