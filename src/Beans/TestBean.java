package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import DataGet.GeneralQuestionFacade;
import DataGet.GeneralUsersFacade;
import Model.Question;
import Model.User;
import PageHandler.PageHandlerFacade;

@ManagedBean(name = "testBean")
@SessionScoped
public class TestBean {
	private List<Question> questionList;
	private ArrayList<String> resultList = new ArrayList<String>();
	private Question question;
	private int cntOfQuestion = 1;
	private User user;
	private String level = "";
	private boolean opt1 = false, opt2 = false, opt3 = false, opt4 = false, answer;
	GeneralUsersFacade generalUserFacade = new GeneralUsersFacade();
	GeneralQuestionFacade generalQuestionFacade = new GeneralQuestionFacade();
	PageHandlerFacade pageHandlerFacade = new PageHandlerFacade();
	private String message = "";

	public TestBean() {

	}

	@PostConstruct
	public void initialize() {
		init();
		getCurrentQuestion(cntOfQuestion);
		updateAreas();
		resultList.clear();
	}

	public String getUserLevel() throws Exception {
		return generalUserFacade.getLoggedUser().getLevel();

	}

	public void init() {
		try {
			level = getUserLevel();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			questionList = generalQuestionFacade.getQuestions(level);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getCurrentQuestion(int cntOfQuestion) {
		question = questionList.get(cntOfQuestion - 1);
	}

	public void firstOptionChoose() {
		opt1 = true;
		afterAnswerGiven();
	}

	public void secondOptionChoose() {
		opt2 = true;
		afterAnswerGiven();
	}

	public void thirdOptionChoose() {
		opt3 = true;
		afterAnswerGiven();
	}

	public void fourthOptionChoose() {
		opt4 = true;
		afterAnswerGiven();
	}

	public boolean checkNumberOfQuestions() {

		if (cntOfQuestion == 5) {
			checkAnswer();
			updateAreas();
			showNotificationBar();
			hideNotificationBar();
			showResultSchedule();
			return true;
		}
		return false;
	}

	public void continueButton() {
		int lev = 1;
		int newLevel = 1;
		int cnt = 0;
		for (String result : resultList) {
			if (result.contains("True"))
				cnt++;
		}
		System.out.println(level);
		if (cnt >= 3) {
			lev = Integer.parseInt(level);
			newLevel = lev + 1;
			level = newLevel + "";
			try {
				questionList = generalQuestionFacade.getQuestions(level);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cntOfQuestion = 1;
			getCurrentQuestion(cntOfQuestion);
			try {
				user = generalUserFacade.getLoggedUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setLevel(level);
			generalUserFacade.setLoggedUser(user);
			RequestContext.getCurrentInstance().execute("PF('resultDialog').hide()");
			pageHandlerFacade.goToLanguageEducationPage();

		} else {
			cntOfQuestion = 1;
			getCurrentQuestion(cntOfQuestion);
			pageHandlerFacade.gotoTheLanguagePage();
		}
	}

	public void showResultSchedule() {
		RequestContext.getCurrentInstance().update("form:resultDialog");
		RequestContext.getCurrentInstance().execute("PF('resultDialog').show()");

	}

	public void checkAnswer() {
		answer = generalQuestionFacade.checkAnswer(answerOfUser(), question);
		if (answer) {
			resultList.add(cntOfQuestion + ": True");
		} else {
			resultList.add(cntOfQuestion + ": False");
		}
	}

	public void afterAnswerGiven() {
		if (!checkNumberOfQuestions()) {
			checkAnswer();
			cntOfQuestion += 1;
			getCurrentQuestion(cntOfQuestion);
			setMessage();
			setAllFalse();
			updateAreas();
			showNotificationBar();
			hideNotificationBar();
		}
	}

	public String answerOfUser() {
		if (opt1)
			return "A";
		if (opt2)
			return "B";
		if (opt3)
			return "C";
		if (opt4)
			return "D";
		return "";
	}

	public void setAllFalse() {
		opt1 = false;
		opt3 = false;
		opt3 = false;
		opt4 = false;
		answer = false;
	}

	public void updateAreas() {
		RequestContext.getCurrentInstance().update("form:testGrid");
		RequestContext.getCurrentInstance().update("form:topBar");
	}

	public void showNotificationBar() {
		RequestContext.getCurrentInstance().execute("PF('bar').show()");
	}

	public void hideNotificationBar() {
		RequestContext.getCurrentInstance().execute("PF('bar').hide()");
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public ArrayList<String> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<String> resultList) {
		this.resultList = resultList;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public int getCntOfQuestion() {
		return cntOfQuestion;
	}

	public void setCntOfQuestion(int cntOfQuestion) {
		this.cntOfQuestion = cntOfQuestion;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage() {
		if (answer)
			message = "Well Done!";
		else
			message = "Keep your fade";
	}

}
