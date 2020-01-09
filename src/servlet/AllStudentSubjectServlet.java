package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllStudentSubjectBean;
import model.User;

/**
 * Servlet implementation class AllStudentSubjectServlet
 */
@WebServlet("/AllStudentSubjectServlet")
public class AllStudentSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllStudentSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int Id=Integer.parseInt(id);
		AllStudentSubjectBean all=new AllStudentSubjectBean();
		List<User> li=all.AllStudentSubject(Id);
		request.getSession().setAttribute("mysubjectList", li);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/MyAddSubjectLieBiao.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
