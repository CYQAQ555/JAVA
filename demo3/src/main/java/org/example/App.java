package org.example;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        System.out.println( "Hello World!" );
        //1.获得DataSource
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/school?charactionEncoding=utf8&useSSL=true");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        Connection connection = (Connection) dataSource.getConnection();
        String sql = "select * from student where id = ?";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        statement.setInt(1,2);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            System.out.println("查询的数据name："+resultSet.getString("name"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
