package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.Question;

public class ShiJuanBean {
	public List<Question> ShiJuan(int id,String tixing){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.ShiJuanDao(id,tixing);
	}
}
