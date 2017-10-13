import java.io.Serializable;

public class Question implements Serializable {
	
	
	/**
	 * 
	 * A class for the quiz game's questions. Each question has a a question in String form, and four
	 * answers (1 correct, 3 false).
	 * 
	 */
	
	private String question;
	private String correctAnswer;
	private String wrongAnswer1;
	private String wrongAnswer2;
	private String wrongAnswer3;
	
	public Question(String question, String correctAnswer, String wrongAnswer1,
			 String wrongAnswer2, String wrongAnswer3) {
		
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer1 = wrongAnswer1;
		this.wrongAnswer2 = wrongAnswer2;
		this.wrongAnswer3 = wrongAnswer3;
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(String wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(String wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer3() {
		return wrongAnswer3;
	}

	public void setWrongAnswer3(String wrongAnswer3) {
		this.wrongAnswer3 = wrongAnswer3;
	}
	
	@Override
	public String toString() {
		return "Question: " + this.question;
	}
	

}
