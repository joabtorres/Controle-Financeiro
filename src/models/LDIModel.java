package models;

import controllers.Controller;
import controllers.LDIController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * LDIModel responsável para inserir e buscar dados do SQL de Lucros, Despesas e Investimentos
 *
 * Descricao: Está classe tem como objetivo fazer insersão ou consultas no banco de dados de Lucros, Despesas e Investimentos;
 *
 * @copyright (c) 22/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class LDIModel {

    public static boolean salvar(LDIController lDIController, String tabela) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        boolean salvar = false;
        try {
            System.out.println("LDIModel COD: " + lDIController.getN_cod());
            if (lDIController.getN_cod() > 0) {
                System.out.println("LDIModel: ENTROU NO UPDATE");
                preparedStatement = connection.prepareStatement("UPDATE " + tabela + " SET n_codusuario = ?, c_produto = ?, d_cadastro = ?, n_valor = ? WHERE n_cod = ?");
                preparedStatement.setInt(1, lDIController.getN_codusuario());
                preparedStatement.setString(2, lDIController.getC_produto());
                preparedStatement.setString(3, lDIController.getD_cadastro());
                preparedStatement.setDouble(4, lDIController.getN_valor());
                preparedStatement.setInt(5, lDIController.getN_cod());
                salvar = true;
            } else {
                System.out.println("LDIModel: ENTROU NO INSERT");
                String sql = "INSERT INTO " + tabela + " (n_codusuario, c_produto, d_cadastro, n_valor) VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, lDIController.getN_codusuario());
                preparedStatement.setString(2, lDIController.getC_produto());
                preparedStatement.setString(3, lDIController.getD_cadastro());
                preparedStatement.setDouble(4, lDIController.getN_valor());
                salvar = true;
            }
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement);
        }
        return salvar;
    }

    public static boolean deletar(String tabela, int cod) {
        boolean deletar = false;
        if (Controller.getN_codUsuario() != cod) {
            Connection connection = ConexaoModel.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareCall("DELETE FROM " + tabela + " WHERE n_cod =?");
                preparedStatement.setInt(1, cod);
                preparedStatement.executeUpdate();
                deletar = true;
            } catch (SQLException ex) {
                System.out.println("Erro ao deleta: " + ex.getMessage());
            } finally {
                ConexaoModel.closeConnection(connection, preparedStatement);
            }
        }

        return deletar;
    }

    public List<LDIController> result(String tabela, String selecionar, String valor) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LDIController> lDIControllers = new ArrayList<>();
        try {
            switch (selecionar) {
                case "Cod":
                    preparedStatement = connection.prepareCall("SELECT * FROM " + tabela + " WHERE n_codusuario = ? AND n_cod LIKE '%" + valor + "%'");
                    break;
                case "Produto":
                    preparedStatement = connection.prepareCall("SELECT * FROM " + tabela + " WHERE n_codusuario = ? AND c_produto LIKE '%" + valor + "%'");
                    break;
                default:
                    preparedStatement = connection.prepareCall("SELECT * FROM " + tabela + " WHERE n_codusuario = ?");
                    break;
            }
            preparedStatement.setInt(1, Controller.getN_codUsuario());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LDIController lDIController = new LDIController();
                lDIController.setN_cod(resultSet.getInt("n_cod"));
                lDIController.setC_produto(resultSet.getString("c_produto"));
                lDIController.setD_cadastro(resultSet.getString("d_cadastro"));
                lDIController.setN_valor(resultSet.getDouble("n_valor"));
                lDIControllers.add(lDIController);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement, resultSet);
        }
        return lDIControllers;
    }

    public static List<LDIController> resulId(String tabela, int cod) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<LDIController> lDIControllers = new ArrayList<>();
        String sql = "SELECT * FROM " + tabela + " WHERE n_cod = ?";

        try {
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setInt(1, cod);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LDIController lDIController = new LDIController();
                lDIController.setN_cod(resultSet.getInt("n_cod"));
                lDIController.setN_codusuario(resultSet.getInt("n_codusuario"));
                lDIController.setC_produto(resultSet.getString("c_produto"));
                lDIController.setD_cadastro(resultSet.getString("d_cadastro"));
                lDIController.setN_valor(resultSet.getDouble("n_valor"));
                lDIControllers.add(lDIController);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement, resultSet);
        }

        return lDIControllers;
    }

}
