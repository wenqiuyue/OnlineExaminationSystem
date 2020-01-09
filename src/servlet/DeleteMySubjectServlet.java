package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DeleteMySubjectBean;

/**
 * Servlet implementation class DeleteMySubjectServlet
 */
@WebServlet("/DeleteMySubjectServlet")
public class DeleteMySubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMySubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("delid");
		int Id=Integer.parseInt(id);
		DeleteMySubjectBean del=new DeleteMySubjectBean();
		int i=del.DeleteMySubject(Id);
		if(i>0) {
			
			response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/MyAddSubjectLieBiao.jsp");
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
