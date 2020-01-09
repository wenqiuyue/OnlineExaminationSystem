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
		//ͨ����ʦ�����õ���ʦid
		int id=u.getId();
		
		
		System.out.println(id);
		//ͨ����ʦid����Ŀ���ƴ���session
		SearchTeacherBean se=new SearchTeacherBean();
		User tu=se.SearchTeacher(id);
		
		//ͨ����ʦid��ѯ�Ծ�ѡ����
		ShiJuanBean shijuan=new ShiJuanBean();
		List<Question> xz_shijuan_list=shijuan.ShiJuan(id,"ѡ����");
		request.getSession().setAttribute("xz_shijuan_list", xz_shijuan_list);
		//ͨ����ʦid��ѯ�Ծ��ж���
		ShiJuanBean shijuan1=new ShiJuanBean();
		List<Question> pd_shijuan_list=shijuan.ShiJuan(id,"�ж���");
		request.getSession().setAttribute("pd_shijuan_list", pd_shijuan_list);
		//ͨ����ʦid��ѯ�Ծ������
		ShiJuanBean shijuan2=new ShiJuanBean();
		List<Question> jd_shijuan_list=shijuan.ShiJuan(id,"�����");
		request.getSession().setAttribute("jd_shijuan_list", jd_shijuan_list);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/BeginTest.jsp");
		
		//request.getSession().setAttribute("t_s_name", tu);
		//response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/changeshijuan.jsp");
		}else {
			System.out.println("û�в��ҵ���ʦid");
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
