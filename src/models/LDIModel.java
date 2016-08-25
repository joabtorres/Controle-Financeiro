package models;

import controllers.LDIController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LDIModel responsável para inserir e buscar dados do SQL de Lucros, Despesas e Investimentos
 *
 * Descricao: Está classe tem como objetivo fazer insersão ou consultas no banco de dados de Lucros, Despesas e Investimentos;
 *
 * @copyright (c) 22/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class LDIModel implements Model {

    private static LDIModel instancia;

    private LDIModel() {
    }

    public static LDIModel getInstancia() {
        if (instancia == null) {
            instancia = new LDIModel();
        }
        return instancia;
    }

    @Override
    public boolean salvar(String sql) {
        Connection connection = ConexaoModel.getConnection();
        PreparedStatement preparedStatement = null;
        boolean salvar = false;
        try {
            preparedStatement = connection.prepareCall(sql);
            salvar = true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: "+ex.getMessage());
        }finally{
            ConexaoModel.closeConnection(connection, preparedStatement);
        }
        return salvar;
    }

    @Override
    public boolean deletar(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List result(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List resulId(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
