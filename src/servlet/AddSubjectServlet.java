package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddSubjectBean;
import bean.AllSubjectBean;
import model.Subject;

/**
 * Servlet implementation class AddSubjectServlet
 */
@WebServlet("/AddSubjectServlet")
public class AddSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectServlet() {
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
		String subjectname=request.getParameter("subjectname");
		String subjectxueyuan=request.getParameter("subjectxueyuan");
		Subject s=new Subject();
		s.setSubject_name(subjectname);
		s.setSubject_xueyuan(subjectxueyuan);
		AddSubjectBean addSubject=new AddSubjectBean();
		int i=addSubject.AddSubject(s);
		if(i>0) {
			System.out.println("科目添加成功");
			//查询一次科目
			AllSubjectBean allSubjectBean=new AllSubjectBean();
			//将所有科目信息存入session
			List<Subject> subjectList=allSubjectBean.AllSubject();
			request.getSession().setAttribute("subjectList", subjectList);
			response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/SubjectLieBiao.jsp");
			//response.sendRedirect("");
		}else {
			System.out.println("科目添加失败");
		}
		
	}

}
