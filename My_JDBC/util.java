package My_JDBC;

import java.sql.*;
import java.util.ResourceBundle;

public class util {
    private util(){}//构造函数私有化
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动器
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection init() throws  SQLException{
        //绑定配置文件
        ResourceBundle rb=ResourceBundle.getBundle("jdbc");
        String url="jdbc:mysql://"+rb.getString("ip")+":3306/"+ rb.getString("database");
        String user=rb.getString("user");
        String pwd=rb.getString("pwd");
        Connection conn=DriverManager.getConnection(url,user,pwd);
        return conn;
    }
    public static void close(Connection conn, ResultSet rs, Statement stm, PreparedStatement ps){
        //关闭资源
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(stm!=null){
            try {
                stm.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
