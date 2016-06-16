package Model;

public class Question {
	private int numberOfQuestion;
	private String questionPart;
	private String questionOption1;
	private String questionOption2;
	private String questionOption3;
	private String questionOption4;
	private String correctAnswer;
	
	public Question() {

	}

	
	public Question(int numberOfQuestion, String questionPart, String questionOption1, String questionOption2,
			String questionOption3, String questionOption4, String correctAnswer) {
		this.numberOfQuestion = numberOfQuestion;
		this.questionPart = questionPart;
		this.questionOption1 = questionOption1;
		this.questionOption2 = questionOption2;
		this.questionOption3 = questionOption3;
		this.questionOption4 = questionOption4;
		this.correctAnswer = correctAnswer;
	}

	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	public String getQuestionPart() {
		return questionPart;
	}

	public void setQuestionPart(String questionPart) {
		this.questionPart = questionPart;
	}

	public String getQuestionOption1() {
		return questionOption1;
	}

	public void setQuestionOption1(String questionOption1) {
		this.questionOption1 = questionOption1;
	}

	public String getQuestionOption2() {
		return questionOption2;
	}

	public void setQuestionOption2(String questionOption2) {
		this.questionOption2 = questionOption2;
	}

	public String getQuestionOption3() {
		return questionOption3;
	}

	public void setQuestionOption3(String questionOption3) {
		this.questionOption3 = questionOption3;
	}

	public String getQuestionOption4() {
		return questionOption4;
	}

	public void setQuestionOption4(String questionOption4) {
		this.questionOption4 = questionOption4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [numberOfQuestion=" + numberOfQuestion + ", questionPart=" + questionPart
				+ ", questionOption1=" + questionOption1 + ", questionOption2=" + questionOption2 + ", questionOption3="
				+ questionOption3 + ", questionOption4=" + questionOption4 + ", correctAnswer=" + correctAnswer + "]";
	}
	

}
