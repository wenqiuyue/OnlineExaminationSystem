package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class UpdateQuestionBean {
	public int UpdateQuestion(Question q) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.UpdateQuestionDao(q);
	}

}
