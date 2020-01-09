package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchTeacherBean;
import model.User;

/**
 * Servlet implementation class SearchTeacherServlet
 */
@WebServlet("/SearchTeacherServlet")
public class SearchTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchTeacherBean SearchTeacher=new SearchTeacherBean();
		int id=Integer.parseInt(request.getParameter("id"));
		User u=SearchTeacher.SearchTeacher(id);
		if(u!=null) {
			request.getSession().setAttribute("teacherinfo", u);
			response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/ShowTeacher.jsp");
		}else{
			System.out.println("ΩÃ ¶≤È’“ ß∞‹");
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
