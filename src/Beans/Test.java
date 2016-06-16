package Beans;

import DataGet.GeneralQuestionFacade;
import Model.Question;

public class Test {
	static GeneralQuestionFacade facade =new GeneralQuestionFacade();
	static String FILE_NAME = "C:/eclipseworkspace/SEN302/src/Datalar/Questions.txt";

	public static void main(String[] args) throws Exception {
		Question soru=facade.getQuestion(1);
		System.out.println(soru.toString());
		//WriteToFile wrt= new WriteToFile();

	}

}
