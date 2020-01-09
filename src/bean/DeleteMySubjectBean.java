package bean;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;

public class DeleteMySubjectBean {
	public int DeleteMySubject(int id) {
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.DeleteMySubjectDao(id);
	} 
}
