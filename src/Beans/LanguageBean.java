package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import DataGet.GeneralLanguageFacade;
import PageHandler.PageHandlerFacade;

@ManagedBean(name = "languageBean")
@SessionScoped

public class LanguageBean {
	PageHandlerFacade pageHandlerFacade = new PageHandlerFacade();
	GeneralLanguageFacade generalLanguageFacade = new GeneralLanguageFacade();

	public LanguageBean() {
		
	}

	public void chooseFrench() {
		generalLanguageFacade.writeLanguage("F");
		pageHandlerFacade.goToLanguageEducationPage();
	}

	public void chooseEnglish() {
		generalLanguageFacade.writeLanguage("E");
		pageHandlerFacade.goToLanguageEducationPage();
	}

}
