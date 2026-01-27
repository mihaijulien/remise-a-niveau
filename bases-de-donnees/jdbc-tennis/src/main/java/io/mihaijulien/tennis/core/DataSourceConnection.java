package io.mihaijulien.tennis.core;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConnection {

    public static void main(String [] args){
        Connection conn = null;

        try {
            MysqlDataSource dataSource = new MysqlDataSource();

            //dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("tennis");
            dataSource.setUseSSL(false);
            dataSource.setUser("root");
            dataSource.setPassword("root");
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
