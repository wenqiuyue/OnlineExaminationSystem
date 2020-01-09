package model;

public class Subject {
	//科目id
	public int id;
	//科目名称
	public String subject_name;
	//开课学院
	public String subject_xueyuan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_xueyuan() {
		return subject_xueyuan;
	}
	public void setSubject_xueyuan(String subject_xueyuan) {
		this.subject_xueyuan = subject_xueyuan;
	}

	
}
