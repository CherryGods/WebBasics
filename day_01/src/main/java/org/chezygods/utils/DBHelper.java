package org.chezygods.utils;


import com.mysql.jdbc.Connection;
import org.chezygods.entity.User;

import javax.annotation.Resources;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    private static Properties getJdbcProperties(){
        Properties jdbcProperties = new Properties();
        try {
            jdbcProperties.load(Resources.class.getResourceAsStream("/resources/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jdbcProperties;
    }

    public static Connection getConnection(){
        try {
            Connection conn = (Connection) DriverManager.getConnection(getJdbcProperties().getProperty("jdbcURL")
                    ,getJdbcProperties().getProperty("jdbcUSER")
                    ,getJdbcProperties().getProperty("jdbcPASSWORD"));
            if(conn!=null){
                System.out.println("MySQL连接成功！");
                return conn;
            }
            System.out.println("MySQL连接失败！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void loadDriver() {
        try {
            Class.forName(getJdbcProperties().getProperty("jdbcDRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static User findUserById(int id){
        User user = new User();
        loadDriver();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT user,password FROM users WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user.setId(id);
                user.setUser(rs.getString("user"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public static boolean login(String username,String password){
        loadDriver();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM users WHERE user = ? and password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
