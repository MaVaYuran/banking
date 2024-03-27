package by.maria.data;

import by.mariayun.data.EBankingDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EBankingTestDataSource extends EBankingDataSource {

    private static EBankingTestDataSource dataSource;

    protected EBankingTestDataSource() throws ClassNotFoundException {
        super();
    }

    @Override
    protected Connection getEBankingConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/e_banking_test",
                "root",
                "root");
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (dataSource == null) {
            dataSource = new EBankingTestDataSource();
        }
        return dataSource.getEBankingConnection();
    }


}
