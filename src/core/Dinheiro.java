/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Arrays;

/**
 * FormataDinheiro [TIPO] Descricao:
 *
 * @copyright (c) 21/08/2016, Joab Torres Alencar - Analista de Sistema
 */
class FormataDinheiro {

    private double valor;

    public void setValor(String valor) {
        String[] valorString = valor.split("R$");
        System.out.println(Arrays.toString(valorString));
        System.out.println(valorString.length);
    }

    public double getValor() {
        return valor;
    }
}

public class Dinheiro {

    public static void main(String[] args) {
        FormataDinheiro valor = new FormataDinheiro();
        valor.setValor("R$ 1500.545,00");
    }
}
