package pao.config;

import pao.exceptions.CustomConnectionError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class DatabaseConfiguration {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static Connection databaseConnection;

    private DatabaseConfiguration() {
    }

    public static Connection getDatabaseConnection() throws SQLException {
        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                System.out.println("-------------------------------- // --------------------------------\n");
                System.out.println("Establishing connection with the database...");
                TimeUnit.MILLISECONDS.sleep(100);
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                if (databaseConnection == null) {
                    throw new CustomConnectionError("connection error!");
                }
                System.out.println("Connected sucessfully\n");
                System.out.println("....................................................................\n\n\n");
            }
        } catch (SQLException | InterruptedException | CustomConnectionError e) {
            e.printStackTrace();
        }
        return databaseConnection;
    }



    public static void closeDatabaseConnection() {
        try {
            if(databaseConnection ==  null) {
                throw new CustomConnectionError("Invalid Connection!");
            }
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }

        } catch (SQLException | CustomConnectionError e) {
            e.printStackTrace();
        }
    }

}
