package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopDbutil {
	//��ʼ��
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		//�������췽��
		public ShopDbutil() throws ClassNotFoundException, SQLException {
			CreateUtil();
		}
		//�������������ͽ������ݿ�ķ���
		public void CreateUtil() throws ClassNotFoundException, SQLException {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			String url="jdbc:mysql://localhost:3306/online";
			String username="root";
			String userpass="123456";
			conn=DriverManager.getConnection(url,username,userpass);
			statement=conn.createStatement();
			
			
		}
		//ִ��sql���
		public PreparedStatement PrepareSt(String sql) {
			try {
				pst=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pst;
		}
		//���ݿ��������
		/*public int DoUpdate(String sql) {
			int i=-1;
			try {
				i=statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}*/
		public ResultSet DoQuery(String sql) {
			try {
				rs=statement.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		//�رշ���
		public void Close() {
			try {
				rs.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
