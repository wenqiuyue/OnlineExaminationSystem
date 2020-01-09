package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class ScoreShiJuanBean {
	public List<Question> ScoreShiJuan(int id){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.ScoreShiJuanDao(id);
	}
}
