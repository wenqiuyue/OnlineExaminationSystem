package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class UpdateUserBean {
	public int UpdateUser(User u) {
		OnlineExaminationSystemDao Update=new OnlineExaminationSystemDaoImp();
		return Update.UpdateUserDao(u);
	}
}
