package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllSubjectBean;
import bean.SearchTeacherBean;
import bean.SearchUserBean;
import bean.UpdateTeacherBean;
import bean.UpdateUserBean;
import model.Subject;
import model.User;

/**
 * Servlet implementation class UpdateTeacherServlet
 */
@WebServlet("/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherServlet() {
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
		String username=request.getParameter("username");
		String real_name=request.getParameter("real_name");
		String yuan_xi=request.getParameter("yuan_xi");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String mail=request.getParameter("mail");
		String id=request.getParameter("id");
		int Id=Integer.parseInt(id);
		String kemuid=request.getParameter("kemu");
		int kemuId=Integer.parseInt(id);
		User u=new User();
		u.setUsername(username);
		u.setReal_name(real_name);
		u.setYuan_xi(yuan_xi);
		u.setSex(sex);
		u.setPhone(phone);
		u.setMail(mail);
		u.setId(Id);
		UpdateTeacherBean up=new UpdateTeacherBean();
		int i=up.UpdateTeacher(u);
		if(i>0) {
			System.out.println("信息修改成功");
			//查一次教师信息
			SearchTeacherBean SearchTeacher=new SearchTeacherBean();
			SearchTeacher.SearchTeacher(Id);
			request.getSession().setAttribute("teacherinfo", u);
			//查询一次科目
			AllSubjectBean allSubjectBean=new AllSubjectBean();
			//将所有科目信息存入session
			List<Subject> subjectList=allSubjectBean.AllSubject();
			request.getSession().setAttribute("subjectList2", subjectList);
			response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/ShowTeacher.jsp");
		}else {
			System.out.println("信息修改失败");
		}
	}

}
