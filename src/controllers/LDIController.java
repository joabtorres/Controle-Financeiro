package controllers;

/**
 * LDIController [TIPO]
 *
 * Descricao:
 *
 * @copyright (c) 22/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class LDIController extends Controller{

    private int n_cod;
    private String c_produto;
    private String d_cadastro;
    private double n_valor;

    public int getN_cod() {
        return n_cod;
    }

    public void setN_cod(int n_cod) {
        this.n_cod = n_cod;
    }

    public String getC_produto() {
        return c_produto;
    }

    public void setC_produto(String c_produto) {
        this.c_produto = c_produto;
    }

    public String getD_cadastro() {
        return d_cadastro;
    }

    public void setD_cadastro(String d_cadastro) {
        this.d_cadastro = d_cadastro;
    }

    public double getN_valor() {
        return n_valor;
    }

    public void setN_valor(double n_valor) {
        this.n_valor = n_valor;
    }

}
