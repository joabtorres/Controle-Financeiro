package controllers;


import java.util.Calendar;

public class Controller {

    /**
     * setMoedaSql()
     *
     * Descrição: Este método vai formatar um valor (R$ unidade,decimal) em String para valor double (unidade.decimal);
     *
     * @param moeda é uma String
     *
     * @return valor é um double;
     */
    protected static double setMoedaSql(String moeda) {
        double valor;
        moeda = moeda.replace("R$ ", "");
        moeda = moeda.replace(".", "");
        moeda = moeda.replace(",", ".");
        moeda = String.format("%.2f", Double.parseDouble(moeda));
        moeda = moeda.replace(",", ".");
        valor = Double.parseDouble(moeda);
        return valor;
    }

    /**
     * setMoedaSql()
     *
     * Descrição: Este método vai formatar um valor (unidade.decimal) em double para valor String (R$ unidade,decimal) ;
     *
     * @param moeda é uma double
     *
     * @return valor é uma String;
     */
    protected static String setMoedaView(double moeda) {
        String valor = String.format("%.2f", moeda);
        valor = valor.replace(".", ",");
        String arrayString[] = valor.split(",");
        String inteiroString = arrayString[0];
        String decimalString = arrayString[1];
        char array[] = inteiroString.toCharArray();
        inteiroString = "";
        int key = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            inteiroString += array[key];
            if (i % 3 == 0 && i != 0) {
                inteiroString += ".";
            }
            key++;
        }
        valor = "R$ " + inteiroString + "," + decimalString;
        return valor;
    }

    /**
     * getDataDefaultView() retorna valor padrão do brasileiro (dia/mes/ano);
     *
     * @return data uma string no formato dia/mes/ano
     */
    public static String getDataDefaultView() {
        Calendar calendar = Calendar.getInstance();
        String data = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        if (calendar.get(Calendar.MONTH) < 10) {
            data += "/0" + calendar.get(Calendar.MONTH);
        } else {
            data += "/" + calendar.get(Calendar.MONTH);
        }
        data += "/" + calendar.get(Calendar.YEAR);
        return data;
    }

    /**
     * getDataDefaultSQL() retorna valor padrão do SQL (ano-mes-dia);
     *
     * @return data uma string no formato ano-mes-dia
     */
    public static String getDataDefaultSQL() {
        Calendar calendar = Calendar.getInstance();
        String data = Integer.toString(calendar.get(Calendar.YEAR));
        if (calendar.get(Calendar.MONTH) < 10) {
            data += "-0" + calendar.get(Calendar.MONTH);
        } else {
            data += "-" + calendar.get(Calendar.MONTH);
        }
        data += "-" + calendar.get(Calendar.DAY_OF_MONTH);
        return data;
    }
}
