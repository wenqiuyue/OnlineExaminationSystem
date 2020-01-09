package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class SelectTeacherBean {
	public User SelectTeacher(String name) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.SelectTeacherDao(name);
	}
}
