package Datalar;

import DataGet.GeneralQuestionFacade;

public class Test {

	public static void main(String[] args) {
		GeneralQuestionFacade g=new GeneralQuestionFacade();
		try {
			g.getQuestions("5");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
