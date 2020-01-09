package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class SearchQuestionBean {
	public Question SearchQuestion(int id) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.SearchQuestionDao(id);
	}
}
