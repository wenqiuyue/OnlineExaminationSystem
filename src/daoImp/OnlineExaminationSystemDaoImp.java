package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OnlineExaminationSystemDao;
import model.Question;
import model.Score;
import model.Subject;
import model.User;
import util.ShopDbutil;

public class OnlineExaminationSystemDaoImp implements OnlineExaminationSystemDao{
	//连接数据库
		ShopDbutil shopdb=null;
		public OnlineExaminationSystemDaoImp() {
			try {
				shopdb=new ShopDbutil();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	//注册用户信息
	@Override
	public int RegisterDao(User u) {
		// TODO Auto-generated method stub
		//定义注册用户的sql语句
		String sql="insert into user(username,password,user_type) values(?,?,?)";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, u.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, u.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(3, u.getUser_type());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i=pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	//登录
	@Override
	public User loginDao(String name, String password) {
		//定义sql语句
		String sql="select * from user where username=? and password=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rel=null;
		try {
			rel=pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u=null;
		try {
			while(rel.next()) {
				u=new User();
				
				u.setUsername(rel.getString("username"));
				u.setPassword(rel.getString("password"));
				u.setUser_type(rel.getString("user_type"));
				u.setUsername(rel.getString("username"));
				u.setXuehao(rel.getString("xuehao"));
				u.setReal_name(rel.getString("real_name"));
				u.setYuan_xi(rel.getString("yuan_xi"));
				u.setMail(rel.getString("mail"));
				u.setZhuan_ye(rel.getString("zhuan_ye"));
				u.setPhone(rel.getString("phone"));
				u.setGrade(rel.getString("grade"));
				u.setUser_class(rel.getString("user_class"));
				u.setSex(rel.getString("sex"));	
				u.setId(rel.getInt("Id"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	//修改用户信息
	@Override
	public int UpdateUserDao(User u) {
		//定义sql语句
		String sql="update user set xuehao=?,real_name=?,yuan_xi=?,mail=?,zhuan_ye=?,phone=?,grade=?,user_class=?,sex=?,username=? where id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, u.getXuehao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, u.getReal_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(3, u.getYuan_xi());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(4, u.getMail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(5, u.getZhuan_ye());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(6, u.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(7, u.getGrade());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(8, u.getUser_class());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(9, u.getSex());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(10, u.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setInt(11, u.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i=-1;
		try {
			i=pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	//账户密码修改
	@Override
	public int SafeUserDao(User u) {
		//定义sql语句
		String sql="update user set password=? where id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, u.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, u.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i=pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	//查询用户信息
	@Override
	public User SearchUserDao(int id) {
		String sql="select * from user where id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u=null;
		try {
			while(re.next()) {
				u=new User();
				u.setUsername(re.getString("username"));
				u.setXuehao(re.getString("xuehao"));
				u.setReal_name(re.getString("real_name"));
				u.setYuan_xi(re.getString("yuan_xi"));
				u.setMail(re.getString("mail"));
				u.setZhuan_ye(re.getString("zhuan_ye"));
				u.setPhone(re.getString("phone"));
				u.setGrade(re.getString("grade"));
				u.setUser_class(re.getString("user_class"));
				u.setSex(re.getString("sex"));
				u.setId(re.getInt("Id"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public int AddSubject(Subject s) {
		//添加科目的sql语句
		String sql="insert into subject_type(subject_name,subject_xueyuan) values(?,?)";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, s.getSubject_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, s.getSubject_xueyuan());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	//查询所有用户信息
	@Override
	public List<User> AllUserDao() {
		String sql="select * from user join subject_type on user.subject_id=subject_type.Id";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u;
		List<User> userlist=new  ArrayList<User>();
		try {
			while(re.next()) {
				u=new User();
				u.setUsername(re.getString("username"));
				u.setXuehao(re.getString("xuehao"));
				u.setReal_name(re.getString("real_name"));
				u.setYuan_xi(re.getString("yuan_xi"));
				u.setMail(re.getString("mail"));
				u.setZhuan_ye(re.getString("zhuan_ye"));
				u.setPhone(re.getString("phone"));
				u.setGrade(re.getString("grade"));
				u.setUser_class(re.getString("user_class"));
				u.setSex(re.getString("sex"));
				u.setId(re.getInt("Id"));
				u.setSubject_id(re.getInt("subject_id"));
				u.setUser_type(re.getString("user_type"));
				u.setSubject_name(re.getString("subject_name"));
				u.setSubject_xueyuan(re.getString("subject_xueyuan"));
				
				userlist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}
	
	//查询所有科目信息
	@Override
	public List<Subject> AllSubjectDao() {
		String sql="select * from subject_type";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Subject subject;
		List<Subject> subjectlist=new  ArrayList<Subject>();
		try {
			while(re.next()) {
				subject=new Subject();
				subject.setId(re.getInt("Id"));
				subject.setSubject_name(re.getString("subject_name"));
				subject.setSubject_xueyuan(re.getString("subject_xueyuan"));
				subjectlist.add(subject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectlist;
	}
	
	//添加教师
	@Override
	public int AddTeacherDao(User u) {
		//添加教师信息的sql语句
		String sql="insert into user(username,password,user_type,real_name,yuan_xi,subject_id) values(?,?,?,?,?,?)";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, u.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, u.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(3, u.getUser_type());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(4, u.getReal_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(5, u.getYuan_xi());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setInt(6, u.getSubject_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	//删除用户
	@Override
	public int DeleteUserDao(int id) {
		String sql="delete from user where Id=?";
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//查询科目信息
	@Override
	public Subject SearchSubjectDao(int id) {
		String sql="select * from subject_type where id=?";
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rel=null;
		try {
			rel = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Subject sub=null;
		try {
			while(rel.next()) {
				sub=new Subject();
				sub.setSubject_name(rel.getString("subject_name"));
				sub.setSubject_xueyuan(rel.getString("subject_xueyuan"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sub;
	}
	
	//查询学生用户信息
	@Override
	public List<User> AllStudentUserDao() {
		String sql="select * from user";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		ResultSet re=null;
			try {
				re = pre.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User u;
			List<User> userlist=new  ArrayList<User>();
			try {
				while(re.next()) {
					u=new User();
					u.setUsername(re.getString("username"));
					u.setXuehao(re.getString("xuehao"));
					u.setReal_name(re.getString("real_name"));
					u.setYuan_xi(re.getString("yuan_xi"));
					u.setMail(re.getString("mail"));
					u.setZhuan_ye(re.getString("zhuan_ye"));
					u.setPhone(re.getString("phone"));
					u.setGrade(re.getString("grade"));
					u.setUser_class(re.getString("user_class"));
					u.setSex(re.getString("sex"));
					u.setId(re.getInt("Id"));
					u.setSubject_id(re.getInt("subject_id"));
					u.setUser_type(re.getString("user_type"));
					userlist.add(u);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return userlist;
	
	}

	//删除科目
	@Override
	public int DeleteSubjectDao(int id) {
		String sql="delete from subject_type where Id=?";
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//查询教师信息
	@Override
	public User SearchTeacherUserDao(int id) {
		String sql="select * from user join subject_type on user.subject_id=subject_type.Id where user.Id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u=null;
		try {
			while(re.next()) {
				u=new User();
				u.setUsername(re.getString("username"));
				u.setReal_name(re.getString("real_name"));
				u.setYuan_xi(re.getString("yuan_xi"));
				u.setMail(re.getString("mail"));
				u.setPhone(re.getString("phone"));
				u.setSex(re.getString("sex"));
				u.setId(re.getInt("Id"));
				u.setSubject_name(re.getString("subject_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	//修改教师用户信息
	@Override
	public int UpdateTeacherDao(User u) {
		//定义sql语句
		String sql="update user set username=?,real_name=?,yuan_xi=?,mail=?,phone=?,sex=? where Id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, u.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, u.getReal_name());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pre.setString(3, u.getYuan_xi());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(4, u.getMail());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			pre.setString(5, u.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(6, u.getSex());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setInt(7, u.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	//添加试题
	@Override
	public int AddQuestionsDao(Question q) {
		//添加教师信息的sql语句
		String sql="insert into questions(teacher_id,question,answer,score,tixing) values(?,?,?,?,?)";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, q.getTeacher_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, q.getQuestion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(3, q.getAnswer());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(4, q.getScore());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(5, q.getTixing());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//查询所有试题
	@Override
	public List<Question> AllQuestionDao(int id) {
		String sql="select * from questions where teacher_id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Question> li=new ArrayList<Question>();
		Question qu;
		try {
			while(re.next()) {
				qu=new Question();
				qu.setId(re.getInt("Id"));
				qu.setTeacher_id(re.getInt("teacher_id"));
				qu.setQuestion(re.getString("question"));
				qu.setAnswer(re.getString("answer"));
				qu.setScore(re.getString("score"));
				qu.setTixing(re.getString("tixing"));
				li.add(qu);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	//修改试题
	@Override
	public int UpdateQuestionDao(Question q) {
		String sql="update questions set question=?,answer=?,score=?,tixing=? where Id=?";
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, q.getQuestion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, q.getAnswer());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(3, q.getScore());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(4, q.getTixing());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setInt(5, q.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//查询试题信息
	@Override
	public Question SearchQuestionDao(int id) {
		String sql="select * from questions where id=?";
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Question que=null;
		try {
			while(re.next()) {
				que=new Question();
				que.setQuestion(re.getString("question"));
				que.setAnswer(re.getString("answer"));
				que.setScore(re.getString("score"));
				que.setTixing(re.getString("tixing"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return que;
	}

	//删除试题
	@Override
	public int DeleteQuestionDao(int id) {
		String sql="delete from questions where Id=?";
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//学生用户添加科目
	@Override
	public int AddSubjectDao(int user_id,String subject_name,String subject_xueyuan,String teacher_name) {
		//定义注册用户的sql语句
		String sql="insert into addsubject(user_id,subject_name,subject_xueyuan,teacher_name) values(?,?,?,?)";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, subject_name);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pre.setString(3, subject_xueyuan);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pre.setString(4, teacher_name);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//查询学生的课程列表
	@Override
	public List<User> AllStudentSubjectDao(int id) {
		String sql="select * from addsubject where user_id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u;
		List<User> user=new ArrayList<User>();
		try {
			while(re.next()) {
				u=new User();
				u.setSubject_name(re.getString("subject_name"));
				u.setSubject_xueyuan(re.getString("subject_xueyuan"));
				u.setReal_name(re.getString("teacher_name"));
				u.setMysubject_id(re.getInt("Id"));
				user.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	//删除我的课程里面的课程
	@Override
	public int DeleteMySubjectDao(int id) {
		String sql="delete from addsubject where Id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//通过名字查询老师id
	@Override
	public User SelectTeacherDao(String name) {
		//定义sql语句
		String sql="select * from user where real_name=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User u=null;
		try {
			while(re.next()) {
				u=new User();
				u.setId(re.getInt("Id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	//随机取出5到选择题和判断题
	@Override
	public List<Question> XuanZeTiQuestionDao(int id, String tixing) {
		String sql="select * from questions where teacher_id=? and tixing=? order by rand() limit 7";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, tixing);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Question> user=new ArrayList<Question>();
		Question q;
		try {
			while(re.next()) {
				q=new Question();
				q.setId(re.getInt("Id"));
				q.setTeacher_id(re.getInt("teacher_id"));
				q.setAnswer(re.getString("answer"));
				q.setQuestion(re.getString("question"));
				q.setScore(re.getString("score"));
				q.setTixing(re.getString("tixing"));
				user.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	//生成试卷
	@Override
	public int MakeShiJuanDao(int id) {
		String sql="insert into test_paper(question_id) values(?)";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//随机抽出3简答题
	@Override
	public List<Question> JianDaTiQuestionDao(int id, String tixing) {
		String sql="select * from questions where teacher_id=? and tixing=? order by rand() limit 3";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, tixing);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Question> user=new ArrayList<Question>();
		Question q;
		try {
			while(re.next()) {
				q=new Question();
				q.setId(re.getInt("Id"));
				q.setTeacher_id(re.getInt("teacher_id"));
				q.setAnswer(re.getString("answer"));
				q.setQuestion(re.getString("question"));
				q.setScore(re.getString("score"));
				q.setTixing(re.getString("tixing"));
				user.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	//查询试卷
	@Override
	public List<Question> ShiJuanDao(int id,String tixing) {
		String sql="select * from test_paper join questions on test_paper.question_id=questions.Id where questions.teacher_id=? and questions.tixing=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setString(2, tixing);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Question> list=new ArrayList<Question>();
		Question q;
		try {
			while(re.next()){
				q=new Question();
				q.setId(re.getInt("Id"));
				q.setTeacher_id(re.getInt("teacher_id"));
				q.setAnswer(re.getString("answer"));
				q.setQuestion(re.getString("question"));
				q.setScore(re.getString("score"));
				q.setTixing(re.getString("tixing"));
				list.add(q);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//计算分数
	@Override
	public List<Question> ScoreShiJuanDao(int id) {
		String sql="select * from test_paper join questions on test_paper.question_id=questions.Id where test_paper.question_id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Question> list=new ArrayList<Question>();
		Question q;
		try {
			while(re.next()){
				q=new Question();
				q.setId(re.getInt("Id"));
				q.setTeacher_id(re.getInt("teacher_id"));
				q.setAnswer(re.getString("answer"));
				q.setQuestion(re.getString("question"));
				q.setScore(re.getString("score"));
				q.setTixing(re.getString("tixing"));
				list.add(q);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//将成绩添加到数据库
	@Override
	public int AddScoreDao(int user_id, int project_id, int Ascore) {
		//定义注册用户的sql语句
		String sql="insert into report_card(user_id,teacher_id,Ascore) values(?,?,?)";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setInt(2, project_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setInt(3, Ascore);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=-1;
		try {
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//查询成绩
	@Override
	public List<User> ScoreLieBiaogeDao(int s_id, int t_id) {
		String sql="select * from (report_card left join user on report_card.teacher_id=user.id) left join subject_type on user.subject_id=subject_type.Id where report_card.user_id=? and report_card.teacher_id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, s_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pre.setInt(2, t_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> u=new ArrayList<User>();
		User us;
		try {
			while(re.next()) {
				us=new User();
				us.setSubject_name(re.getString("subject_name"));
				us.setReal_name(re.getString("real_name"));
				us.setScore(re.getInt("Ascore"));
				u.add(us);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	//教师查询学生分数
	@Override
	public List<User> TeacherScoreLieBiaogeDao(int t_id) {
		String sql="select * from report_card left join user on report_card.user_id=user.id where report_card.teacher_id=?";
		//执行sql语句
		PreparedStatement pre=shopdb.PrepareSt(sql);
		try {
			pre.setInt(1, t_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet re=null;
		try {
			re = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> u=new ArrayList<User>();
		User us;
		try {
			while(re.next()) {
				us=new User();
				us.setReal_name(re.getString("real_name"));
				us.setScore(re.getInt("Ascore"));
				u.add(us);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	//账户密码修改
		@Override
		public int SafeUserDao(String password,int id) {
			//定义sql语句
			String sql="update user set password=? where id=?";
			//执行sql语句
			PreparedStatement pre=shopdb.PrepareSt(sql);
			
				try {
					pre.setString(1, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				try {
					pre.setInt(2, id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			int i=-1;
			try {
				i=pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		}

		@Override
		public boolean HaveUserNameDao(String name) {
			//定义sql语句
			String sql="select * from user where username=?";
			//执行sql语句
			PreparedStatement pre=shopdb.PrepareSt(sql);
			try {
				pre.setString(1, name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet re=null;
			try {
				re = pre.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(re.next()) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
}
