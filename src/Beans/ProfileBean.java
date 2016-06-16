package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DataGet.GeneralUsersFacade;
import Model.User;

@ManagedBean(name = "profileBean")
@ViewScoped

public class ProfileBean {
	private User user;
	private List<User> userList;
	GeneralUsersFacade generalUsersFacade = new GeneralUsersFacade();

	public ProfileBean() {
		try {
			getUserLevel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getUserLevel() throws Exception {
		user = generalUsersFacade.getLoggedUser();
		userList = new ArrayList<User>();
		userList.add(user);
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
