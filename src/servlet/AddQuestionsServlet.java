package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddQuestionsBean;
import model.Question;

/**
 * Servlet implementation class AddQuestionsServlet
 */
@WebServlet("/AddQuestionsServlet")
public class AddQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionsServlet() {
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
		request.setCharacterEncoding("utf-8");
		String tec_id=request.getParameter("id");
		int tec_Id=Integer.parseInt(tec_id);
		String answer=request.getParameter("answer");
		String score=request.getParameter("score");
		String question=request.getParameter("question");
		String tixing=request.getParameter("tixing");
		Question q=new Question();
		q.setTeacher_id(tec_Id);
		q.setAnswer(answer);
		q.setScore(score);
		q.setQuestion(question);
		q.setTixing(tixing);
		AddQuestionsBean add = new AddQuestionsBean();
		int i=add.AddQuestions(q);
		if(i>0) {
			System.out.println("添加试题成功");
			response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/AddQuestionSuccess.jsp");
		}else {
			System.out.println("添加试题失败");
		}
	}

}
