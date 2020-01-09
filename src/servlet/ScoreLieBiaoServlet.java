package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ScoreLieBiaoBean;
import bean.SelectTeacherBean;
import model.User;

/**
 * Servlet implementation class ScoreLieBiaoServlet
 */
@WebServlet("/ScoreLieBiaoServlet")
public class ScoreLieBiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreLieBiaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("t_name");
		SelectTeacherBean sel=new SelectTeacherBean();
		User u=sel.SelectTeacher(name);
		int t_id=u.getId();
		String s_id=request.getParameter("s_id");
		int s_Id=Integer.parseInt(s_id);
		ScoreLieBiaoBean s=new ScoreLieBiaoBean();
		List<User> uli=s.ScoreLieBiao(s_Id, t_id);
		request.getSession().setAttribute("uli", uli);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/ScoreLieBiao.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
