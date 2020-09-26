package gg.cs.myapp.entity;

public class QuizName {
	private int value;
	private String userId;
	private String quizName;
	/**
	 * @return the quizName
	 */
	public String getQuizName() {
		return quizName;
	}
	/**
	 * @param quizName the quizName to set
	 */
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuizName [value=" + value + ", userId=" + userId + ", quizName=" + quizName + "]";
	}

	
}
