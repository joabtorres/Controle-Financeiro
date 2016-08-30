package controllers;

import java.util.Calendar;

public class Controller {

    private static int n_codUsuario;
    private static boolean b_permissao;

    public static boolean isB_permissao() {
        return b_permissao;
    }

    public static void setB_permissao(int num) {
        Controller.b_permissao = (num != 0);
    }

    public static int getN_codUsuario() {
        return n_codUsuario;
    }

    public static void setN_codUsuario(int n_codUsuario) {
        Controller.n_codUsuario = n_codUsuario;
    }

    /**
     * setMoedaSql()
     *
     * Descrição: Este método vai formatar um valor (R$ unidade,decimal) em String para valor double (unidade.decimal);
     *
     * @param moeda é uma String
     *
     * @return valor é um double;
     */
    public static double setMoedaSql(String moeda) {
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
    public static String setMoedaView(double moeda) {
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
            data += "/0" + (1 + calendar.get(Calendar.MONTH));
        } else {
            data += "/" + (1 + calendar.get(Calendar.MONTH));
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
            data += "-0" + (1 + calendar.get(Calendar.MONTH));
        } else {
            data += "-" + (1 + calendar.get(Calendar.MONTH));
        }
        data += "-" + calendar.get(Calendar.DAY_OF_MONTH);
        return data;
    }

    /**
     * setDataSQL() Transforma uma string padrão (dia/mes/ano ou dia-mes-ano) para padrão (ano-mes-dia);
     *
     * @param data é um objeto String para ser tratado.
     * @return dataFormatada uma string no formato ano-mes-dia
     */
    public static String setDataSQL(String data) {
        String dataFormatada = null;
        if (data.contains("/")) {
            String array[] = data.split("/");
            dataFormatada = array[2] + "-" + array[1] + "-" + array[0];
        } else {
            String array[] = data.split("-");
            dataFormatada = array[2] + "-" + array[1] + "-" + array[0];
        }
        return dataFormatada;
    }

    /**
     * setDataSQL() Transforma uma data SQL (ano/mes/dia ou ano-mes-dia) para padrão brasileiro (dia/mes/ano)
     *
     * @param data é um objeto String para ser tratado.
     * @return dataFormatada uma string no formato ano-mes-dia
     */
    public static String setDataView(String data) {
        String dataFormatada = null;
        if (data.contains("/")) {
            String array[] = data.split("/");
            dataFormatada = array[2] + "/" + array[1] + "/" + array[0];
        } else {
            String array[] = data.split("-");
            dataFormatada = array[2] + "/" + array[1] + "/" + array[0];
        }
        return dataFormatada;
    }
}
