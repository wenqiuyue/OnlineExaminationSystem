package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class AllQuestionBean {
	public List<Question> AllQuestion(int id){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.AllQuestionDao(id);
	}

}
