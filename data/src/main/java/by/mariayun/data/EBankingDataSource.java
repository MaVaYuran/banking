package by.mariayun.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EBankingDataSource {
    private static EBankingDataSource dataSource;
    protected EBankingDataSource() throws ClassNotFoundException {
        // Load JDBC driver for MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    protected Connection getEBankingConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/e_banking",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new EBankingDataSource();
        }
        return dataSource.getEBankingConnection();
    }
}
