package io.mihaijulien.tennis.core;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnexionPool {
    public static void main(String [] args){
        Connection conn = null;

        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5);

            dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?allowPublicKeyRetrieval=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");

            dataSource.setUsername("root");
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
