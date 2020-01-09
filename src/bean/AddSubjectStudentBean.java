package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;

public class AddSubjectStudentBean {
public int AddSubject(int user_id,String subject_name,String subject_xueyuan,String teacher_name) {
	OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
	return o.AddSubjectDao(user_id,subject_name,subject_xueyuan,teacher_name);
}
}
