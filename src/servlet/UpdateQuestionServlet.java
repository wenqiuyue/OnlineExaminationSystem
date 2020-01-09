package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllQuestionBean;
import bean.UpdateQuestionBean;
import model.Question;

/**
 * Servlet implementation class UpdateQuestionServlet
 */
@WebServlet("/UpdateQuestionServlet")
public class UpdateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String answer=request.getParameter("answer");
		String score=request.getParameter("score");
		String tixing=request.getParameter("tixing");
		String question=request.getParameter("question");
		String tid=request.getParameter("userid");
		int tId=Integer.parseInt(tid);
		String id=request.getParameter("id");
		int Id=Integer.parseInt(id);
		System.out.println(Id);
		Question que=new Question();
		que.setAnswer(answer);
		que.setScore(score);
		que.setTixing(tixing);
		que.setQuestion(question);
		que.setId(Id);
		UpdateQuestionBean update=new UpdateQuestionBean();
		int i=update.UpdateQuestion(que);
		if(i>0) {
			System.out.println("修改试题成功");
			AllQuestionBean allQuestion=new AllQuestionBean();
			List<Question> li=allQuestion.AllQuestion(tId);
			request.getSession().setAttribute("questionList", li);
			response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/ShiTiLieBiao.jsp");
		}else {
			System.out.println("修改试题失败");
		}
	}

}
