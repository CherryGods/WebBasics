package org.cherrygods.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    public Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/linux_test","root","cherrygods");
            if(connection!=null){
                System.out.println("数据库连接成功！");
                return connection;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库连接失！");
        return null;
    }
}
