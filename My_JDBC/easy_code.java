package My_JDBC;

import java.util.ArrayList;
import java.util.Scanner;

public class easy_code {
    public static void  main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入表名");
        String tableName=sc.next();
        System.out.println("请输入属性(输入0表示输入结束)");
        int ACount=0;//记录属性个数
        //List<String> att=new ArrayList<String>();
        String att[]=new String[20];
        String attribute="";
        while(true){
            attribute=sc.next();
            if(attribute.equals("0"))break;
            att[ACount]=attribute;
            ACount++;
            //att.add(attribute);
        }
        System.out.println("请输入行数");
        int hang=sc.nextInt();
        System.out.println("请输入数据");
        String data[][]=new String[hang][ACount];
        for (int han=0;han<hang;han++) {
            for (int i = 0; i < ACount; i++) {
                data[han][i]=sc.next();
            }
        }
        StringBuilder sb=new StringBuilder();
        //创建代码
        sb.append("INSERT INTO ").append(tableName).append("(");
        for(int i=0;i<ACount;i++){
            sb.append(att[i]);
            if(i!=ACount-1){
                sb.append(",");
            }else{
                sb.append(")\nVALUE\n");
            }
        }
        for(int han=0;han<hang;han++){
            sb.append("(");
            for(int i=0;i<ACount;i++){
                sb.append("'");
                sb.append(data[han][i]);
                sb.append("'");
                if(i!=ACount-1){
                    sb.append(",");
                }
            }
            sb.append(")");
            if(han!=hang-1)sb.append(",\n");
            else sb.append(";");
        }
        System.out.println(sb);
        sc.close();
    }
}
