package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchUserBean;
import bean.UpdateUserBean;
import model.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		String xuehao=request.getParameter("xuehao");
		String real_name=request.getParameter("real_name");
		String yuan_xi=request.getParameter("yuan_xi");
		String sex=request.getParameter("sex");
		String zhuan_ye=request.getParameter("zhuan_ye");
		String phone=request.getParameter("phone");
		String grade=request.getParameter("grade");
		String mail=request.getParameter("mail");
		String user_class=request.getParameter("user_class");
		String id=request.getParameter("id");
		int Id=Integer.parseInt(id);
		User u=new User();
		u.setUsername(username);
		u.setXuehao(xuehao);
		u.setReal_name(real_name);
		u.setYuan_xi(yuan_xi);
		u.setSex(sex);
		u.setZhuan_ye(zhuan_ye);
		u.setPhone(phone);
		u.setGrade(grade);
		u.setMail(mail);
		u.setUser_class(user_class);
		u.setId(Id);
		UpdateUserBean Update=new UpdateUserBean();
		int i=Update.UpdateUser(u);
		if(i>0) {
			System.out.println("信息修改成功");
			SearchUserBean SearchUser=new SearchUserBean();
			SearchUser.SearchUser(Id);
			request.getSession().setAttribute("userinfo", u);
			response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/ShowUser.jsp");
		}else {
			System.out.println("信息修改失败");
		}
	}

}
