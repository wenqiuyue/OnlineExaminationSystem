package dao;

import java.util.List;

import model.Question;
import model.Score;
import model.Subject;
import model.User;

public interface OnlineExaminationSystemDao {
	//注册用户接口
	public int RegisterDao(User u);
	//定义登录方法接口
	public User loginDao(String name,String password);
	//查询用户信息方法
	public User SearchUserDao(int id);
	//查询教师用户信息方法
	public User SearchTeacherUserDao(int id);
	//修改信息方法
	public int UpdateUserDao(User u);
	//修改教师信息方法
	public int UpdateTeacherDao(User u);
	//修改账户密码方法
	public int SafeUserDao(User u);
	//添加科目
	public int AddSubject(Subject s);
	//查询老师用户信息
	public List<User> AllUserDao();
	//查询学生用户信息
	public List<User> AllStudentUserDao();
	//查询所有科目信息
	public List<Subject> AllSubjectDao();
	//添加教师
	public int AddTeacherDao(User u);
	//删除用户
	public int DeleteUserDao(int id);
	//删除科目
	public int DeleteSubjectDao(int id);
	//查询科目信息方法
	public Subject SearchSubjectDao(int id);
	//添加试题
	public int AddQuestionsDao(Question q);
	//查询所有试题
	public List<Question> AllQuestionDao(int id);
	//修改试题信息方法
	public int UpdateQuestionDao(Question q);
	//删除试题信息方法
	public int DeleteQuestionDao(int id);
	//查询试题信息方法
	public Question SearchQuestionDao(int id);
	//添加科目
	public int AddSubjectDao(int user_id,String subject_name,String subject_xueyuan,String teacher_name);
	//查询学生课程列表信息
	public List<User> AllStudentSubjectDao(int id);
	//删除我的课程列表科目方法
	public int DeleteMySubjectDao(int id);
	//查询教师id
	public User SelectTeacherDao(String name);
	//查询选择题试题
	public List<Question> XuanZeTiQuestionDao(int id,String tixing);
	//查询简答题
	public List<Question> JianDaTiQuestionDao(int id,String tixing);
	//生成试卷
	public int MakeShiJuanDao(int id);
	//查询试卷
	public List<Question> ShiJuanDao(int id,String tixing);
	//计算分数
	public List<Question> ScoreShiJuanDao(int id);
	//将成绩添加到数据库
	public int AddScoreDao(int user_id,int project_id,int Ascore);
	//删除试卷
	//public int DeleteShiJuanDao(int id);
	//查询分数
	public List<User> ScoreLieBiaogeDao(int s_id,int t_id);
	//老师查询分数
	public List<User> TeacherScoreLieBiaogeDao(int t_id);
	//修改账户密码方法
	public int SafeUserDao(String password,int id);
	//查询用户名是否存在
	public boolean HaveUserNameDao(String name);

}
