package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AddTeacherBean;
import model.User;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
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
		String zhanghao=request.getParameter("zhanghao");
		String Password=request.getParameter("Password");
		String name=request.getParameter("name");
		String yuanxi=request.getParameter("yuanxi");
		String kemu=request.getParameter("kemu");
		int Id=Integer.parseInt(kemu);
		
		User u=new User();
		u.setUsername(zhanghao);
		u.setPassword(Password);
		u.setReal_name(name);
		u.setYuan_xi(yuanxi);
		u.setSubject_id(Id);
		u.setUser_type("2");
		AddTeacherBean addTeacher=new AddTeacherBean();
		int i=addTeacher.AddTeacher(u);
		if(i>0) {
			System.out.println("教师添加成功");
			response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/TeacherLieBiao.jsp");
		}else {
			System.out.println("教师添加失败");
		}
		
		
		
		
		
	}

}
