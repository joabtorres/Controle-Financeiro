package models;

import controllers.Controller;
import controllers.UsuarioController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UsuarioModel responsável para inserir e buscar dados no Usuário;
 *
 * Descricao: Está classe tem como objetivo fazer insersão ou consultas no banco de dados de Usuários
 *
 * @copyright (c) 22/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class UsuarioModel {
    public static boolean salvar(UsuarioController usuarioController) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        boolean salvar = false;
        try {
            if (usuarioController.getN_codusuario() > 0) {
                preparedStatement = connection.prepareStatement("UPDATE fin_usuarios SET c_nomeusuario = ?, c_usuario = ? , c_senhausuario = ?, b_permissaousuario =? WHERE n_codusuario = ?");
                preparedStatement.setString(1, usuarioController.getC_nomeusuario());
                preparedStatement.setString(2, usuarioController.getC_usuario());
                preparedStatement.setString(3, usuarioController.getC_senhausuario());
                preparedStatement.setInt(4, usuarioController.getB_permissaousuario());
                preparedStatement.setInt(5, usuarioController.getN_codusuario());
                preparedStatement.executeUpdate();
                salvar = true;
            } else if (false == resultUsuario(usuarioController.getC_usuario())) {
                preparedStatement = connection.prepareStatement("INSERT INTO fin_usuarios (c_nomeusuario, c_usuario, c_senhausuario, d_cadastrousuario, b_permissaousuario) VALUES (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, usuarioController.getC_nomeusuario());
                preparedStatement.setString(2, usuarioController.getC_usuario());
                preparedStatement.setString(3, usuarioController.getC_senhausuario());
                preparedStatement.setString(4, usuarioController.getD_cadastrousuario());
                preparedStatement.setInt(5, usuarioController.getB_permissaousuario());
                preparedStatement.executeUpdate();
                salvar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement);
        }
        return salvar;
    }

    private static boolean resultUsuario(String usuario) {
        boolean result = false;
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM fin_usuarios WHERE c_usuario = ?");
            preparedStatement.setString(1, usuario);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            result = (count > 0);
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            result = false;
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement);
        }
        return result;
    }

    public static int verificarUsuario(UsuarioController usuarioController) {
        int n_codUsuario = 0;
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM fin_usuarios WHERE c_usuario = ? AND c_senhausuario = ?";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, usuarioController.getC_usuario());
            preparedStatement.setString(2, usuarioController.getC_senhausuario());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                n_codUsuario = resultSet.getInt("n_codusuario");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao verificar usuario: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement, resultSet);
        }

        return n_codUsuario;
    }

    public static boolean deletar(int cod) {
        boolean deletar = false;
        if (Controller.getN_codUsuario() != cod) {
            Connection connection = ConexaoModel.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareCall("DELETE FROM fin_usuarios WHERE n_codusuario =?");
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

    public static List<UsuarioController> result(String selecionado, String valor) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<UsuarioController> usuarios = new ArrayList<>();
        try {
            switch (selecionado) {
                case "Cod. Usuário":
                    preparedStatement = connection.prepareCall("SELECT * FROM fin_usuarios WHERE n_codusuario LIKE '%" + valor + "%'");
                    break;
                case "Usuário":
                    preparedStatement = connection.prepareCall("SELECT * FROM fin_usuarios WHERE c_usuario LIKE '%" + valor + "%'");
                    break;
                default:
                    preparedStatement = connection.prepareCall("SELECT * FROM fin_usuarios");
                    break;
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UsuarioController usuarioController = new UsuarioController();
                usuarioController.setN_codusuario(resultSet.getInt("n_codusuario"));
                usuarioController.setC_nomeusuario(resultSet.getString("c_nomeusuario"));
                usuarioController.setC_usuario(resultSet.getString("c_usuario"));
                usuarioController.setC_senhausuario(resultSet.getString("c_senhausuario"));
                usuarioController.setD_cadastrousuario(resultSet.getString("d_cadastrousuario"));
                usuarioController.setB_permissaousuario(resultSet.getInt("b_permissaousuario"));
                usuarios.add(usuarioController);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement, resultSet);
        }
        return usuarios;
    }

    public static List<UsuarioController> resultId(int cod) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<UsuarioController> usuarios = new ArrayList<>();
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM fin_usuarios WHERE n_codusuario = ?");
            preparedStatement.setInt(1, cod);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UsuarioController usuarioController = new UsuarioController();
                usuarioController.setN_codusuario(resultSet.getInt("n_codusuario"));
                usuarioController.setC_nomeusuario(resultSet.getString("c_nomeusuario"));
                usuarioController.setC_usuario(resultSet.getString("c_usuario"));
                usuarioController.setC_senhausuario(resultSet.getString("c_senhausuario"));
                usuarioController.setD_cadastrousuario(resultSet.getString("d_cadastrousuario"));
                usuarioController.setB_permissaousuario(resultSet.getInt("b_permissaousuario"));
                usuarios.add(usuarioController);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar usuario: " + ex.getMessage());
        } finally {
            ConexaoModel.closeConnection(connection, preparedStatement, resultSet);
        }
        return usuarios;
    }

}
