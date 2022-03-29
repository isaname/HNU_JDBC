package My_JDBC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
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
        return DriverManager.getConnection(url,user,pwd);
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
    public static ArrayList<String> readFileByLines(String filePath) throws Exception {
        ArrayList<String> listStr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filePath), "UTF-8"));
            String tempString = null;
            int flag = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                // System.out.println("line " + line + ": " + tempString);
                if (tempString.trim().equals(""))
                    continue;
                if (tempString.substring(tempString.length() - 1).equals(";")) {
                    if (flag == 1) {
                        sb.append(tempString);
                        listStr.add(sb.toString());
                        sb.delete(0, sb.length());
                        flag = 0;
                    } else
                        listStr.add(tempString);
                } else {
                    flag = 1;
                    sb.append(tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return listStr;

    }

}
