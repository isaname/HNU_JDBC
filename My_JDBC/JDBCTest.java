package My_JDBC;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        Statement stm=null;
        ResultSet rs=null;
        Scanner sc=null;//创建变量
        try{
            conn=util.init();//初始化,并获取数据库连接Connection
//            ps=conn.prepareStatement("select * from exer where name=?");
//            sc=new Scanner(System.in);
//            String exe=sc.next();
//            ps.setString(1,exe);
//            rs=ps.executeQuery();//可以防止SQL注入
            stm=conn.createStatement();
            //conn.setAutoCommit(false);
            sc=new Scanner(System.in);
//            String table=sc.next();
//            rs=stm.executeQuery("select * from "+table);
//            while (rs.next()){
//                System.out.println("id:"+rs.getInt(1)+" 姓名:"+rs.getString(2)+" 班级:"+rs.getString(3));
//            }
            //String Path=sc.next();
            rs=stm.executeQuery("select * from course");
            while(rs.next()){
                System.out.println("con:"+rs.getString(1)+" name:"+rs.getString(2)+" spno:"+rs.getString(3)
                +" ctno:"+rs.getString(4)+" hours:"+rs.getString(5)+" experiment:"+rs.getString(6));
            }
            //conn.commit();
        }catch(Exception e){
//            try {
//                if(conn!=null)
//                conn.rollback();
//            }
//            catch(SQLException a){a.printStackTrace();}
            e.printStackTrace();
        }finally{
            if(sc!=null){
                sc.close();
            }
            util.close(conn,rs,stm,ps);
        }
    }

}
