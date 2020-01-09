package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddScoreBean;
import bean.ScoreShiJuanBean;
import model.Question;
import model.Score;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
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
		//用户id
		String userid=request.getParameter("userid");
		int userId=Integer.parseInt(userid);
		//教师id
		String t_id=request.getParameter("t_id");
		int t_Id=Integer.parseInt(t_id);
		int score=0;
		String [] xz_array=request.getParameterValues("xz_answer");
		request.getSession().setAttribute("xz_array", xz_array);
		String [] zq_xz_array=request.getParameterValues("T_xz_answer");
		//xz_list.add(request.getParameter("xz_answer"));
		for(int i=0;i<xz_array.length;i++) {
			if(xz_array[i].equals(zq_xz_array[i])) {
				score=score+5;
			}else {
				score=score;
			}
		}
		//System.out.println("答案数量"+xz_array.length);
		
		String [] pd_array=request.getParameterValues("pd_answer");
		request.getSession().setAttribute("pd_array", pd_array);
		String [] zq_pd_array=request.getParameterValues("T_pd_answer");
		//xz_list.add(request.getParameter("xz_answer"));
		for(int i=0;i<pd_array.length;i++) {
			if(pd_array[i].equals(zq_pd_array[i])) {
				score=score+5;
			}else {
				score=score;
			}
		}
		//System.out.println("答案数量"+pd_array.length);	
		String [] jd_array=request.getParameterValues("jd_answer");
		request.getSession().setAttribute("jd_array", jd_array);
		String [] zq_jd_array=request.getParameterValues("T_jd_answer");
		//xz_list.add(request.getParameter("xz_answer"));
		for(int i=0;i<jd_array.length;i++) {
			if(jd_array[i].equals(zq_jd_array[i])) {
				score=score+5;
			}else {
				score=score;
			}
		}
		//System.out.println("答案数量"+jd_array.length);
		System.out.println("分数"+score);
		Score s=new Score();
		s.setAscore(score);
		request.getSession().setAttribute("score", s);
		
		AddScoreBean addscore=new AddScoreBean();
		addscore.AddScore(userId, t_Id, score);
		
		
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/SeeTestScore.jsp");

	}

}
