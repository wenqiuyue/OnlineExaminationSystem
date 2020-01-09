package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllSubjectBean;
import model.Subject;

/**
 * Servlet implementation class SubjectLieBiao
 */
@WebServlet("/SubjectLieBiao")
public class SubjectLieBiao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectLieBiao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询一次科目
		AllSubjectBean allSubjectBean=new AllSubjectBean();
		//将所有科目信息存入session
		List<Subject> subjectList=allSubjectBean.AllSubject();
		request.getSession().setAttribute("subjectList1", subjectList);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/SubjectLieBiao.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
