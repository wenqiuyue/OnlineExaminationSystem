package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllSubjectBean;
import model.Subject;

/**
 * Servlet implementation class NewAddTeacherAervlet
 */
@WebServlet("/NewAddTeacherAervlet")
public class NewAddTeacherAervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAddTeacherAervlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ѯһ�ο�Ŀ
		AllSubjectBean allSubjectBean=new AllSubjectBean();
		//�����п�Ŀ��Ϣ����session
		List<Subject> subjectList=allSubjectBean.AllSubject();
		request.getSession().setAttribute("subjectLists", subjectList);
		response.sendRedirect("../OnlineExaminationSystem/Manager/AddTeacher.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
