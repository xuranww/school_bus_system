package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtils {

    /**
     * 获取数据库连接
     * @return Connection对象
     */
    public static Connection getConnection(){
		//jdbc驱动
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentinfomanagement?&useSSL=false&serverTimezone=UTC";
		String user="root";
		String password="123456";
		Connection con = null;
    	try {
    		Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, password);
    	} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	return con;
    }

    /**
     * 关闭数据库连接
     * @param con Connection对象
     */
    public static void closeConnection(Connection con) {
		//判断conn是否为空
    	if(con != null){
    		try {
				con.close();//关闭数据库连接
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	}
	}
}
