package models;

import controllers.LDIController;
import java.util.List;

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
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LDIController> result() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LDIController> resulId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
