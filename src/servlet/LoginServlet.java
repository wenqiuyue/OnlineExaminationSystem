package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllSubjectBean;
import bean.LoginBean;
import bean.UserListBean;
import model.Subject;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginBean loginBean=new LoginBean();
		User u=loginBean.Login(username, password);
		//�����ѯ������
		if(u!=null) {
			System.out.println("��¼�ɹ�");
			request.getSession().setAttribute("user", u);
			//�����¼���û�������0����Ա
			if(u.getUser_type().equals("0")) {
				System.out.println("����Ա");

				UserListBean userListBean=new UserListBean();
				//�������û���Ϣ����session
				List<User> userList=userListBean.UserList();
				request.getSession().setAttribute("userList", userList);
				
				response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/GuanLiYuan.jsp");
			}
			//�����¼���û�������1ѧ��
			if(u.getUser_type().equals("1")) {
				response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/main.jsp");
			}
			//�����¼���û�������2��ʦ
			if(u.getUser_type().equals("2")) {
				//��ѯһ�ο�Ŀ
				AllSubjectBean allSubjectBean=new AllSubjectBean();
				//�����п�Ŀ��Ϣ����session
				List<Subject> subjectList=allSubjectBean.AllSubject();
				request.getSession().setAttribute("subjectList2", subjectList);
				System.out.println("��ʦ");
				response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/Teacher.jsp");
			}
		}else {
			System.out.println("��¼ʧ��");
			response.sendRedirect("Login.jsp");
		}
	}

}
