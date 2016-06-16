package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DataGet.GeneralUsersFacade;
import Model.User;
import PageHandler.MessageBoxHandlerFacade;
import PageHandler.PageHandlerFacade;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	GeneralUsersFacade generalUsersFacade = new GeneralUsersFacade();
	MessageBoxHandlerFacade messageBoxHandlerFacade = new MessageBoxHandlerFacade();
	PageHandlerFacade pageHandlerFacade = new PageHandlerFacade();
	private String userMail;
	private String password;

	private boolean Event = false;
	private User user;

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEvent() {
		return Event;
	}

	public void setEvent(boolean event) {
		Event = event;
	}

	public void login() {
		Event = generalUsersFacade.loginValidation(userMail, password);
		try {
			user = generalUsersFacade.getUserByEmail(userMail);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Event)
			generalUsersFacade.setLoggedUser(user);
		messageBoxHandlerFacade.showErrorMessage(Event, "/language.xhtml", "Invalid Email or Password!");
	}

	public void register() {
		pageHandlerFacade.goToRegisterPage();

	}

}
