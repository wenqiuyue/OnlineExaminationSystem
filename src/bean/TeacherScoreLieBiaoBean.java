package bean;

import java.util.List;

import dao.OnlineExaminationSystemDao;
import daoImp.OnlineExaminationSystemDaoImp;
import model.User;

public class TeacherScoreLieBiaoBean {
	public List<User> TeacherScoreLieBiao(int t_id){
		OnlineExaminationSystemDao o=new OnlineExaminationSystemDaoImp();
		return o.TeacherScoreLieBiaogeDao(t_id);
	}
}
