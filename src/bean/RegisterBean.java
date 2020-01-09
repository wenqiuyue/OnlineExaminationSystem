package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class RegisterBean {
	public int Register(User u) {
		OnlineExaminationSystemDao dao=new OnlineExaminationSystemDaoImp();
		return dao.RegisterDao(u);
	}
}
