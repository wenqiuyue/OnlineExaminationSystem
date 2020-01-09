package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class JianDaTiQuestionBean {
	public List<Question> JianDaTiQuestion(int id, String tixing){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.JianDaTiQuestionDao(id, tixing);
	}
}
