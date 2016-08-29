package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ConexaoModel [TIPO]
 *
 * Descricao:
 *
 * @copyright (c) 24/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class ConexaoModel {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/java_controle_financeiro";
    private static final String USER = "root";
    private static final String PASS = "";
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: " + ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement) {
        closeConnection(connection);
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet reulSet) {
        closeConnection(connection, preparedStatement);
        try {
            if (reulSet != null) {
                reulSet.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
