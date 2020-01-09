package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class AllStudentSubjectBean {
	public List<User> AllStudentSubject(int id){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.AllStudentSubjectDao(id);
	}
}
