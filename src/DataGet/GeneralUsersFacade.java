package DataGet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Model.User;

public class GeneralUsersFacade {
	private User user;
	private User loggedUser = null;

	private String FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/User.txt";
	ReadFromFile read = new ReadFromFile();
	public String fileContent = read.readAllText(FILE_NAME);

	public User getUserById(String id) throws Exception {
		String[] lines = fileContent.split("\\n");
		String[] line = lines[Integer.parseInt(id) - 1].split(Pattern.quote("*"));
		return user = new User(line[0], line[1], line[2], line[3], line[4], line[5]);
	}

	public User getLoggedUser() throws Exception {
		String FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/LoggedUser.txt";
		String fileContent = read.readAllText(FILE_NAME);
		String[] lines = fileContent.split("\\n");
		String[] line = lines[0].split(Pattern.quote("*"));
		return loggedUser = new User(line[0], line[1], line[2], line[3], line[4], line[5]);
	}

	public User getUserByEmail(String email) throws Exception {
		List<User> userList = new ArrayList<User>();
		String[] lines = fileContent.split("\\n");
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(Pattern.quote("*"));
			user = new User(line[0], line[1], line[2], line[3], line[4], line[5]);
			userList.add(user);
		}
		for (User temp : userList) {
			if (temp.getEmail().equals(email))
				return temp;
		}
		return null;

	}
	

	public boolean loginValidation(String userEmail, String userPassword) {

		String[] lines = fileContent.split("\\n");
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(Pattern.quote("*"));
			user = new User(line[0], line[1], line[2], line[3], line[4], line[5]);
			if (user.getEmail().equals(userEmail) && user.getPassword().equals(userPassword))
				return true;
		}
		return false;
	}
	public List<User> getAllUsers() throws Exception {
		List<User> userList = new ArrayList<User>();
		String[] lines = fileContent.split("\\n");
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(Pattern.quote("*"));
			user = new User(line[0], line[1], line[2], line[3], line[4], line[5]);
			userList.add(user);
		}
		return userList;
	}
	
	public List<String> getAllTeachers() throws Exception {
		List<String> userList = new ArrayList<String>();
		String[] lines = fileContent.split("\\n");
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(Pattern.quote("*"));
			user = new User(line[0], line[1], line[2], line[3], line[4], line[5]);
			if(user.getUserType().equals("T"))
			userList.add(user.getUserName());
		}
		return userList;
	}

	public void createUser(User user) {
		WriteToFile wr = new WriteToFile();
		try {
			wr.writeToFile(FILE_NAME, user.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setLoggedUser(User user) {
		this.loggedUser = user;
		String FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/LoggedUser.txt";
		WriteToFile wr = new WriteToFile();
		try {
			wr.writeToLoggedUserFile(FILE_NAME, loggedUser.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
