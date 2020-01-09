package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;

public class DeleteQuestionBean {
	public int DeleteQuestion(int id) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.DeleteQuestionDao(id);
	}

}
