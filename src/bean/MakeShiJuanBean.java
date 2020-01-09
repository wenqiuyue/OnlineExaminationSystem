package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;

public class MakeShiJuanBean {
	public int MakeShiJuan(int id) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.MakeShiJuanDao(id);
	}

}
