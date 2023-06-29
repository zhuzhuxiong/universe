package com.universe.mybatis.config;

import com.universe.mybatis.entity.User;

import java.sql.*;

/**
 * @author
 */
public class OldConnection {

    public static void connect() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
//            Class<?> name = Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://42.193.124.125:3306/test","username","password");

            String sql = "select * from user where id = ?";

            preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            preparedStatement.execute();
            ResultSet set = preparedStatement.getResultSet();

            set.next();
            User user = new User();
            user.setId(set.getLong("id"));
            user.setName(set.getString("name"));
            System.out.println(user.toString());

        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        connect();
    }
}
