package gg.cs.myapp.entity;

import java.io.Serializable;

public class Question implements Serializable{
	private int subject;
	private int user_id;
	private String quiz_name;
	private String question;
	private int answer;
	
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	

	/**
	 * @return the subject
	 */
	public int getSubject() {
		return subject;
	}


	/**
	 * @param subject the subject to set
	 */
	public void setSubject(int subject) {
		this.subject = subject;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}


	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	/**
	 * @return the quiz_name
	 */
	public String getQuiz_name() {
		return quiz_name;
	}


	/**
	 * @param quiz_name the quiz_name to set
	 */
	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}



	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}


	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}


	/**
	 * @return the answer
	 */
	public int getAnswer() {
		return answer;
	}


	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}


	/**
	 * @return the option1
	 */
	public String getOption1() {
		return option1;
	}


	/**
	 * @param option1 the option1 to set
	 */
	public void setOption1(String option1) {
		this.option1 = option1;
	}


	/**
	 * @return the option2
	 */
	public String getOption2() {
		return option2;
	}


	/**
	 * @param option2 the option2 to set
	 */
	public void setOption2(String option2) {
		this.option2 = option2;
	}


	/**
	 * @return the option3
	 */
	public String getOption3() {
		return option3;
	}


	/**
	 * @param option3 the option3 to set
	 */
	public void setOption3(String option3) {
		this.option3 = option3;
	}


	/**
	 * @return the option4
	 */
	public String getOption4() {
		return option4;
	}


	/**
	 * @param option4 the option4 to set
	 */
	public void setOption4(String option4) {
		this.option4 = option4;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [subject=" + subject + ", user_id=" + user_id + ", quiz_name=" + quiz_name + ", question="
				+ question + ", answer=" + answer + ", option1=" + option1 + ", option2=" + option2 + ", option3="
				+ option3 + ", option4=" + option4 + "]";
	}
	
}
