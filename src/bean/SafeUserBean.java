package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;

public class SafeUserBean {
	public int SafeUser(String password,int id) {
		OnlineExaminationSystemDao onlineExaminationSystemDao=new OnlineExaminationSystemDaoImp();
		return onlineExaminationSystemDao.SafeUserDao(password,id);
	}

}
