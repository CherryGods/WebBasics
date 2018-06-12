package org.cherrygods.utils;

import java.sql.*;

/**
 * 数据库连接帮助类
 * @author cherrygods
 * @since ２０１８－０６－１０　１７：３６：１１
 */
public class JdbcUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/addr?useUnicode=true&characterEncoding=utf8";
        final String USERNAME = "root";
        final String PASSWROD = "cherrygods";
        return DriverManager.getConnection(URL,USERNAME,PASSWROD);
    }
    public static void close(Statement stmt, Connection conn) throws SQLException {
        if(stmt==null){
            stmt.close();
        }else if(conn==null){
            conn.close();
        }
    }
}
