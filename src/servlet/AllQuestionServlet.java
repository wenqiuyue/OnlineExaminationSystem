package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllQuestionBean;
import model.Question;

/**
 * Servlet implementation class AllQuestionServlet
 */
@WebServlet("/AllQuestionServlet")
public class AllQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userid");
		int Id=Integer.parseInt(id);
		AllQuestionBean allQuestion=new AllQuestionBean();
		List<Question> li=allQuestion.AllQuestion(Id);
		request.getSession().setAttribute("questionList", li);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/ShiTiLieBiao.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
