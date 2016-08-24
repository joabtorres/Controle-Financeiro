/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author Beck
 */
public interface Model {

    public void salvar();

    public void deletar();

    public List result();

    public List resulId();
}
