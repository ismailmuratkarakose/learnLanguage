package Beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DataGet.GeneralUsersFacade;
import Model.User;
import PageHandler.PageHandlerFacade;

@ManagedBean(name = "templateBean")
@SessionScoped

public class TemplateBean {
	PageHandlerFacade pageHandlerFacade = new PageHandlerFacade();
	GeneralUsersFacade generalUsersFacade = new GeneralUsersFacade();
	User user;
	private boolean render = false;

	@PostConstruct
	public void init() {
		renderGirisYap();
	}

	public void renderGirisYap() {
		try {
			user = generalUsersFacade.getLoggedUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null)
			setRender(true);
	}

	public void gotoLanguagePage() {
		pageHandlerFacade.gotoTheLanguagePage();
	}

	public void gotoIndexPage() {
		pageHandlerFacade.goToIndexPage();
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

}
