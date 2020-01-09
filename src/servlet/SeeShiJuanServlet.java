package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ShiJuanBean;
import model.Question;

/**
 * Servlet implementation class SeeShiJuanServlet
 */
@WebServlet("/SeeShiJuanServlet")
public class SeeShiJuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeShiJuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userid");
		int t_Id=Integer.parseInt(id);
		//ͨ����ʦid��ѯ�Ծ�ѡ����
		ShiJuanBean shijuan=new ShiJuanBean();
		List<Question> xz_shijuan_list=shijuan.ShiJuan(t_Id,"ѡ����");
		request.getSession().setAttribute("xz_shijuan_list", xz_shijuan_list);
		//ͨ����ʦid��ѯ�Ծ��ж���
		ShiJuanBean shijuan1=new ShiJuanBean();
		List<Question> pd_shijuan_list=shijuan.ShiJuan(t_Id,"�ж���");
		request.getSession().setAttribute("pd_shijuan_list", pd_shijuan_list);
		//ͨ����ʦid��ѯ�Ծ�����
		ShiJuanBean shijuan2=new ShiJuanBean();
		List<Question> jd_shijuan_list=shijuan.ShiJuan(t_Id,"�����");
		request.getSession().setAttribute("jd_shijuan_list", jd_shijuan_list);
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/shijuan1.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
