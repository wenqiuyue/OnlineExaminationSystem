package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class UpdateTeacherBean {
	public int UpdateTeacher(User u) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.UpdateTeacherDao(u);
	}
}
