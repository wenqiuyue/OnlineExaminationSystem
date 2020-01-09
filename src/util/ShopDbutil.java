package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopDbutil {
	//初始化
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;
		PreparedStatement pst=null;
		//创建构造方法
		public ShopDbutil() throws ClassNotFoundException, SQLException {
			CreateUtil();
		}
		//创建加载驱动和建立数据库的方法
		public void CreateUtil() throws ClassNotFoundException, SQLException {
			//加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			String url="jdbc:mysql://localhost:3306/online";
			String username="root";
			String userpass="123456";
			conn=DriverManager.getConnection(url,username,userpass);
			statement=conn.createStatement();
			
			
		}
		//执行sql语句
		public PreparedStatement PrepareSt(String sql) {
			try {
				pst=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pst;
		}
		//数据库操作方法
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
		//关闭方法
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
