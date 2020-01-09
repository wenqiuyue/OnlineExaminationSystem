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
import bean.ShiJuanBean;
import bean.XuanZeTiQuestionBean;
import model.Question;

/**
 * Servlet implementation class MakeShiJuanServlet
 */
@WebServlet("/MakeShiJuanServlet")
public class MakeShiJuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeShiJuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userid");
		int t_Id=Integer.parseInt(id);
		//通过教师id和题型 随机抽出题目
		XuanZeTiQuestionBean xz=new XuanZeTiQuestionBean();
		//通过教师id和题型 随机抽出简答题目
		JianDaTiQuestionBean jd=new JianDaTiQuestionBean();
		List<Question> xz_list=xz.XuanZeTiQuestion(t_Id, "选择题");
		List<Question> pd_list=xz.XuanZeTiQuestion(t_Id, "判断题");
		List<Question> jd_list=jd.JianDaTiQuestion(t_Id, "填空题");
		System.out.println("选择题数量"+xz_list.size());
		//生成试卷
		MakeShiJuanBean make=new MakeShiJuanBean();
		//遍历列表，得到选择试题id，将试题id添加到试卷表中
		for(int i=0;i<xz_list.size();i++) {
			Question q=xz_list.get(i);
				make.MakeShiJuan(q.getId());
		}//遍历列表，得到判断试题id，将试题id添加到试卷表中
		for(int i=0;i<pd_list.size();i++) {
			Question q=pd_list.get(i);
				make.MakeShiJuan(q.getId());
		}//遍历列表，得到简答题试题id，将试题id添加到试卷表中
		for(int i=0;i<jd_list.size();i++) {
			Question q=jd_list.get(i);
				make.MakeShiJuan(q.getId());
		}
		//通过教师id查询试卷选择题
		ShiJuanBean shijuan=new ShiJuanBean();
		List<Question> xz_shijuan_list=shijuan.ShiJuan(t_Id,"选择题");
		request.getSession().setAttribute("xz_shijuan_list", xz_shijuan_list);
		//通过教师id查询试卷判断题
		ShiJuanBean shijuan1=new ShiJuanBean();
		List<Question> pd_shijuan_list=shijuan.ShiJuan(t_Id,"判断题");
		request.getSession().setAttribute("pd_shijuan_list", pd_shijuan_list);
		//通过教师id查询试卷填空题
		ShiJuanBean shijuan2=new ShiJuanBean();
		List<Question> jd_shijuan_list=shijuan.ShiJuan(t_Id,"填空题");
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
