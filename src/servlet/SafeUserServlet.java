package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SafeUserBean;
import bean.SearchUserBean;
import model.User;

/**
 * Servlet implementation class SafeUserServlet
 */
@WebServlet("/SafeUserServlet")
public class SafeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SafeUserServlet() {
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
		
		String username=request.getParameter("Password1");
		//String password=request.getParameter("Password2");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(username+id);
		SafeUserBean SafeUserDao=new SafeUserBean();
		int i=SafeUserDao.SafeUser(username, id);
		if(i>0) {
			//SearchUserBean searchuserbean=new SearchUserBean();
			//User user=searchuserbean.SearchUser(id);
			//request.getSession().setAttribute(username, password);
			response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/safetip.jsp");
		}else {
			System.out.println("Ê§°Ü");
		}
	
	}

}

