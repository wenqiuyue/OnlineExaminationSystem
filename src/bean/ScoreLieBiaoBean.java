package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class ScoreLieBiaoBean {
	public List<User> ScoreLieBiao(int id1,int id2){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.ScoreLieBiaogeDao(id1, id2);
	}
}
