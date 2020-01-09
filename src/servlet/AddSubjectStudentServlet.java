package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddSubjectStudentBean;

/**
 * Servlet implementation class AddSubjectStudentServlet
 */
@WebServlet("/AddSubjectStudentServlet")
public class AddSubjectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		int user_Id=Integer.parseInt(user_id);
		String subject_name=request.getParameter("subject_name");
		String subject_xueyuan=request.getParameter("subject_xueyuan");
		String teacher_name=request.getParameter("teacher_name");
		AddSubjectStudentBean add=new AddSubjectStudentBean();
		int i=add.AddSubject(user_Id,subject_name,subject_xueyuan,teacher_name);
		if(i>0) {
			response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/AddSubjectSuccess.jsp");
		}else {
			System.out.println("没有加入到我的课程列表");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
