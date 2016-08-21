/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Calendar;
import java.util.Date;

/**
 * TesteData [TIPO] Descricao:
 *
 * @copyright (c) 19/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class TesteData {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println("Data/Hora atual: " + c.getTime());
        System.out.println("Ano: " + c.get(Calendar.YEAR));
        System.out.println("Mês: " + c.get(Calendar.MONTH));
        System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
    }
}
