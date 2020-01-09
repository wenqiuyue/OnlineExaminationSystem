package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class UserListBean {
	public List<User> UserList(){
		OnlineExaminationSystemDao onlineExaminationSystemDao=new OnlineExaminationSystemDaoImp();
		return onlineExaminationSystemDao.AllUserDao();
	}

}
