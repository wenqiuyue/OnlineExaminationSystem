package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TeacherScoreLieBiaoBean;
import model.User;

/**
 * Servlet implementation class TeacherScoreLieBiaoServlet
 */
@WebServlet("/TeacherScoreLieBiaoServlet")
public class TeacherScoreLieBiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherScoreLieBiaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t_id=request.getParameter("t_id");
		int t_Id=Integer.parseInt(t_id);
		TeacherScoreLieBiaoBean t=new TeacherScoreLieBiaoBean();
		List<User> t_u=t.TeacherScoreLieBiao(t_Id);
		request.getSession().setAttribute("t_u", t_u);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/TeacherScoreLieBiao.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
