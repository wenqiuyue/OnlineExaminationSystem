package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Subject;

public class AddSubjectBean {
	public int AddSubject(Subject s) {
		OnlineExaminationSystemDao onlineExaminationSystemDao=new OnlineExaminationSystemDaoImp();
		return onlineExaminationSystemDao.AddSubject(s);
	}

}
