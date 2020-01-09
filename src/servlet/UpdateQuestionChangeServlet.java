package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchQuestionBean;
import model.Question;

/**
 * Servlet implementation class UpdateQuestionChangeServlet
 */
@WebServlet("/UpdateQuestionChangeServlet")
public class UpdateQuestionChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestionChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("Id");
		int Id=Integer.parseInt(id);
		request.getSession().setAttribute("questionId", Id);
		SearchQuestionBean s=new SearchQuestionBean();
		Question q=s.SearchQuestion(Id);
		request.getSession().setAttribute("question", q);
		response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/UpdateQuestionForm.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
