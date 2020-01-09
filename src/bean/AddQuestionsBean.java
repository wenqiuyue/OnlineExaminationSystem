package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class AddQuestionsBean {
	public int AddQuestions (Question q) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.AddQuestionsDao(q);
	}

}
