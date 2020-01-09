package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Subject;

public class SearchSubjectBean {
	public Subject SearchSubject(int id) {
		OnlineExaminationSystemDao onlineExaminationSystemDao=new OnlineExaminationSystemDaoImp();
		return onlineExaminationSystemDao.SearchSubjectDao(id);
		
	}
}
