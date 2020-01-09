package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.JianDaTiQuestionBean;
import bean.MakeShiJuanBean;
import bean.SearchTeacherBean;
import bean.SelectTeacherBean;
import bean.ShiJuanBean;
import bean.XuanZeTiQuestionBean;
import model.Question;
import model.User;

/**
 * Servlet implementation class SelectTeacherServlet
 */
@WebServlet("/SelectTeacherServlet")
public class SelectTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTeacherServlet() {
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
		request.getSession().setAttribute("u", u);
		if(u!=null) {
		//通过教师姓名得到教师id
		int id=u.getId();
		
		
		System.out.println(id);
		//通过教师id将科目名称存入session
		SearchTeacherBean se=new SearchTeacherBean();
		User tu=se.SearchTeacher(id);
		
		//通过教师id查询试卷选择题
		ShiJuanBean shijuan=new ShiJuanBean();
		List<Question> xz_shijuan_list=shijuan.ShiJuan(id,"选择题");
		request.getSession().setAttribute("xz_shijuan_list", xz_shijuan_list);
		//通过教师id查询试卷判断题
		ShiJuanBean shijuan1=new ShiJuanBean();
		List<Question> pd_shijuan_list=shijuan.ShiJuan(id,"判断题");
		request.getSession().setAttribute("pd_shijuan_list", pd_shijuan_list);
		//通过教师id查询试卷填空题
		ShiJuanBean shijuan2=new ShiJuanBean();
		List<Question> jd_shijuan_list=shijuan.ShiJuan(id,"填空题");
		request.getSession().setAttribute("jd_shijuan_list", jd_shijuan_list);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/BeginTest.jsp");
		
		//request.getSession().setAttribute("t_s_name", tu);
		//response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/changeshijuan.jsp");
		}else {
			System.out.println("没有查找到老师id");
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
