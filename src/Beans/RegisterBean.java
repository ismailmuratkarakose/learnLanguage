package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DataGet.GeneralUsersFacade;
import Model.User;
import PageHandler.MessageBoxHandlerFacade;
import PageHandler.PageHandlerFacade;

@ManagedBean(name = "registerBean")
@SessionScoped
public class RegisterBean {

	GeneralUsersFacade generalUsersFacade = new GeneralUsersFacade();
	MessageBoxHandlerFacade messageBoxHandlerFacade = new MessageBoxHandlerFacade();
	PageHandlerFacade pageHandlerFacade = new PageHandlerFacade();
	private String firstName = null;
	private String lastName = null;
	private String email = null;
	private String password = null;
	private String type = null;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void register() {
		String[] list = generalUsersFacade.fileContent.split("\\n");
		int id = list.length;
		User user = new User(id + 1 + "", firstName + " " + lastName, email, password, type, "1");
		generalUsersFacade.createUser(user);
		messageBoxHandlerFacade.succesfulMessage(firstName, lastName);
		try {
			Thread.sleep(2000); // 1000 milliseconds is one second.
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		pageHandlerFacade.goToIndexPage();

	}

}
