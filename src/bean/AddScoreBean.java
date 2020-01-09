package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;

public class AddScoreBean {
	public int AddScore(int user_id, int project_id, int Ascore) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.AddScoreDao(user_id, project_id, Ascore);
	}

}
