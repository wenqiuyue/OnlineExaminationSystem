package model;

public class Score {
public int Id;
public int user_id;
public int teacher_id;
public int Ascore;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}
public int getAscore() {
	return Ascore;
}
public void setAscore(int ascore) {
	Ascore = ascore;
}

}
