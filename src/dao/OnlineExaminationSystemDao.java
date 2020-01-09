package dao;

import java.util.List;

import model.Question;
import model.Score;
import model.Subject;
import model.User;

public interface OnlineExaminationSystemDao {
	//ע���û��ӿ�
	public int RegisterDao(User u);
	//�����¼�����ӿ�
	public User loginDao(String name,String password);
	//��ѯ�û���Ϣ����
	public User SearchUserDao(int id);
	//��ѯ��ʦ�û���Ϣ����
	public User SearchTeacherUserDao(int id);
	//�޸���Ϣ����
	public int UpdateUserDao(User u);
	//�޸Ľ�ʦ��Ϣ����
	public int UpdateTeacherDao(User u);
	//�޸��˻����뷽��
	public int SafeUserDao(User u);
	//��ӿ�Ŀ
	public int AddSubject(Subject s);
	//��ѯ��ʦ�û���Ϣ
	public List<User> AllUserDao();
	//��ѯѧ���û���Ϣ
	public List<User> AllStudentUserDao();
	//��ѯ���п�Ŀ��Ϣ
	public List<Subject> AllSubjectDao();
	//��ӽ�ʦ
	public int AddTeacherDao(User u);
	//ɾ���û�
	public int DeleteUserDao(int id);
	//ɾ����Ŀ
	public int DeleteSubjectDao(int id);
	//��ѯ��Ŀ��Ϣ����
	public Subject SearchSubjectDao(int id);
	//�������
	public int AddQuestionsDao(Question q);
	//��ѯ��������
	public List<Question> AllQuestionDao(int id);
	//�޸�������Ϣ����
	public int UpdateQuestionDao(Question q);
	//ɾ��������Ϣ����
	public int DeleteQuestionDao(int id);
	//��ѯ������Ϣ����
	public Question SearchQuestionDao(int id);
	//��ӿ�Ŀ
	public int AddSubjectDao(int user_id,String subject_name,String subject_xueyuan,String teacher_name);
	//��ѯѧ���γ��б���Ϣ
	public List<User> AllStudentSubjectDao(int id);
	//ɾ���ҵĿγ��б��Ŀ����
	public int DeleteMySubjectDao(int id);
	//��ѯ��ʦid
	public User SelectTeacherDao(String name);
	//��ѯѡ��������
	public List<Question> XuanZeTiQuestionDao(int id,String tixing);
	//��ѯ�����
	public List<Question> JianDaTiQuestionDao(int id,String tixing);
	//�����Ծ�
	public int MakeShiJuanDao(int id);
	//��ѯ�Ծ�
	public List<Question> ShiJuanDao(int id,String tixing);
	//�������
	public List<Question> ScoreShiJuanDao(int id);
	//���ɼ���ӵ����ݿ�
	public int AddScoreDao(int user_id,int project_id,int Ascore);
	//ɾ���Ծ�
	//public int DeleteShiJuanDao(int id);
	//��ѯ����
	public List<User> ScoreLieBiaogeDao(int s_id,int t_id);
	//��ʦ��ѯ����
	public List<User> TeacherScoreLieBiaogeDao(int t_id);
	//�޸��˻����뷽��
	public int SafeUserDao(String password,int id);
	//��ѯ�û����Ƿ����
	public boolean HaveUserNameDao(String name);

}
