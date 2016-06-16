package DataGet;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Model.Question;

public class GeneralQuestionFacade {
	GeneralLanguageFacade generalLanguageFacade;
	Question quest;
	String FILE_NAME = "";
	ReadFromFile read = new ReadFromFile();
	String fileContent = "";

	public GeneralQuestionFacade() {
		generalLanguageFacade = new GeneralLanguageFacade();
		boolean language = generalLanguageFacade.readLanguage();
		if (language) {
			FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/EnglishQuestions.txt";
		} else {
			FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/FrenchQuestions.txt";
		}
		fileContent = read.readAllText(FILE_NAME);
	}

	public Question getQuestion(int indexOfQuestions) throws Exception {
		String[] lines = fileContent.split("\\n");
		String[] line = lines[indexOfQuestions].split(Pattern.quote("*"));
		return quest = new Question(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], line[5], line[6]);
	}

	public List<Question> getQuestions(String level) throws Exception {
		List<Question> resultList = new ArrayList<Question>();
		switch (Integer.parseInt(level)) {
		case 1:
			for (int i = 0; i < 5; i++) {
				Question q = getQuestion(i);
				resultList.add(q);
			}
			break;
		case 2:
			for (int i = 5; i < 10; i++) {
				Question q = getQuestion(i);
				resultList.add(q);
			}
			break;
		case 3:
			for (int i = 11; i < 16; i++) {
				Question q = getQuestion(i);
				resultList.add(q);
			}
			break;
		case 4:
			for (int i = 16; i < 21; i++) {
				Question q = getQuestion(i);
				resultList.add(q);
			}
			break;
		case 5:
			for (int i = 21; i < 26; i++) {
				Question q = getQuestion(i);
				resultList.add(q);
			}
			break;
		}

		return resultList;
	}

	public boolean checkAnswer(String option, Question q) {
		if (q.getCorrectAnswer().startsWith(option))
			return true;
		else
			return false;
	}

}
