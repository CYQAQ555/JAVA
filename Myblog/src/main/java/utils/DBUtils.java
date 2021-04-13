package utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    private static MysqlDataSource dataSource = null;

    /**
     * 得到 Connection 的通用方法
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        if(dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/blog?characterEncoding=utf-8");
            dataSource.setUser("root");
            dataSource.setPassword("12345678");
        }
        return (Connection) dataSource.getConnection();
    }

    /**
     * 通用的关闭方法
     * @param connection
     * @param statement
     * @param resultSet
     * @throws SQLException
     */
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        if(resultSet != null) resultSet.close();
        if(statement != null) statement.close();
        if(connection != null) connection.close();
    }
}
