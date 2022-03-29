package My_JDBC;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        Statement stm=null;
        ResultSet rs=null;
        try{
            conn=util.init();//初始化,并获取数据库连接Connection
            stm=conn.createStatement();
            ArrayList<String> creatS=util.readFileByLines("src/My_JDBC/create.sql");
            for(String subsql:creatS){
                stm.addBatch(subsql);
            }
            stm.executeBatch();
            ArrayList<String> insertS=util.readFileByLines("src/My_JDBC/insert.sql");
            for(String subsql:insertS){
                stm.addBatch(subsql);
            }
            stm.executeBatch();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            util.close(conn,rs,stm,ps);
        }
    }

}
