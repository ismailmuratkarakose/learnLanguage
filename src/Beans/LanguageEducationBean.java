package Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import DataGet.GeneralUsersFacade;
import DataGet.GeneralWordFacade;
import Model.Word;
import PageHandler.PageHandlerFacade;

@ManagedBean(name = "languageEducationBean")
@ViewScoped

public class LanguageEducationBean {
	private List<Word> words;
	private Word selectedWord;
	GeneralWordFacade generalWordFacade;
	PageHandlerFacade pageHandlerFacade;
	GeneralUsersFacade generalUserFacade;

	public LanguageEducationBean() {

	}

	@PostConstruct
	public void initialize() {
		RequestContext.getCurrentInstance().update("form:carousel");
		getLevelWord();
	}

	public String getUserLevel() throws Exception {
		generalUserFacade = new GeneralUsersFacade();
		return generalUserFacade.getLoggedUser().getLevel();
	}

	private void getLevelWord() {
		generalWordFacade = new GeneralWordFacade();
		try {
			words = generalWordFacade.getWordsByLevel(getUserLevel());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("form:carousel");
	}

	public void gotoTheTestPage() {
		pageHandlerFacade = new PageHandlerFacade();
		pageHandlerFacade.gotoTheTestPage();
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public Word getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(Word selectedWord) {
		this.selectedWord = selectedWord;
	}
}
