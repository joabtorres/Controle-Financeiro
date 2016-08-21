/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 * Pessoa [TIPO] Descricao:
 *
 * @copyright (c) 20/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class Pessoa {

    private static Pessoa instancia;

    private Pessoa() {
    }

    public static Pessoa getIntancia() {
        if (instancia == null) {
            instancia = new Pessoa();
        }
        return instancia;
    }
}
