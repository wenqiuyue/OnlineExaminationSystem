package model;

public class Question {
	public int Id;
	public int teacher_id;
	public String question;
	public String answer;
	public String score;
	public String tixing;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTixing() {
		return tixing;
	}
	public void setTixing(String tixing) {
		this.tixing = tixing;
	}
	

	
}
