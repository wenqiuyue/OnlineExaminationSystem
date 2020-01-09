package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;

public class DeleteSubjectBean {
	public int DeleteSubject(int id) {
		OnlineExaminationSystemDao onlineExaminationSystemDao=new OnlineExaminationSystemDaoImp();
		return onlineExaminationSystemDao.DeleteSubjectDao(id);
	}
}
