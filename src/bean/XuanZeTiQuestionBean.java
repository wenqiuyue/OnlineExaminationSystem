package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class XuanZeTiQuestionBean {
	public List<Question> XuanZeTiQuestion(int id, String tixing){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.XuanZeTiQuestionDao(id, tixing);
	}
}
