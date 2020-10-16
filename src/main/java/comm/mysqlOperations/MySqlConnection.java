package comm.mysqlOperations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlConnection {
    private Connection conn = null;
    private String userName = "root";
    private String passWord = "123";
    private String SqlUrl = "jdbc:mysql://localhost:3306/mysql?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private Statement statement = null;
    private ResultSet resultSet = null;
    private MySqlConnection() {
        if (null == conn){
            getConnect();
        }
    }

    private static class MySqlConnectionHandle{
        private static MySqlConnection instance = new MySqlConnection();
    }

    public static MySqlConnection getInstance(){
        return MySqlConnectionHandle.instance;
    }

    /**
     * 查询user表中的Host、User
     * @return
     */
    public synchronized List<List<String>> listUsers() {
        List<List<String>> userList = null;
        try {
            if (null == conn) {
                getConnect();
            }
            statement = conn.createStatement();
            resultSet = statement.executeQuery("select Host, User from `user`");
            userList = new ArrayList<List<String>>();
            List<String> userInfo = null;
            while (resultSet.next()){
                userInfo = new ArrayList<String>();
                userInfo.add(resultSet.getString(1));
                userInfo.add(resultSet.getString(2));
                userList.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return userList;
    }

    private void getClassForName() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getConnect() {
        getClassForName();
        try {
            conn = DriverManager.getConnection(SqlUrl, userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接资源
     * resultSet
     * statement
     */
    private void close() {
        try {
            if (null != resultSet)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (null != statement)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
