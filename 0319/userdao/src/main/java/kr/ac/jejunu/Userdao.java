package kr.ac.jejunu;

import java.sql.*;

public class Userdao {
    public User findById(Integer id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/portal",
                //"아이디"
                //"비밀번호"
        );
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select*from userinfo where id = ?"
        );
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return user;
    }
}
