package controllers;

/**
 * UsuarioController [TIPO]
 * Descricao: 
 * @copyright (c) 22/08/2016, Joab Torres Alencar - Analista de Sistema
 */
public class UsuarioController extends Controller{
    private int n_codusuario;
    private String c_nomeusuario;
    private String c_usuario;
    private String c_senhausuario;
    private String d_cadastrousuario;
    private boolean b_permissaousuario;

    public int getN_codusuario() {
        return n_codusuario;
    }

    public void setN_codusuario(int n_codusuario) {
        this.n_codusuario = n_codusuario;
    }

    public String getC_nomeusuario() {
        return c_nomeusuario;
    }

    public void setC_nomeusuario(String c_nomeusuario) {
        this.c_nomeusuario = c_nomeusuario;
    }

    public String getC_usuario() {
        return c_usuario;
    }

    public void setC_usuario(String c_usuario) {
        this.c_usuario = c_usuario;
    }

    public String getC_senhausuario() {
        return c_senhausuario;
    }

    public void setC_senhausuario(String c_senhausuario) {
        this.c_senhausuario = c_senhausuario;
    }

    public String getD_cadastrousuario() {
        return d_cadastrousuario;
    }

    public void setD_cadastrousuario(String d_cadastrousuario) {
        this.d_cadastrousuario = d_cadastrousuario;
    }

    public boolean isB_permissaousuario() {
        return b_permissaousuario;
    }

    public void setB_permissaousuario(boolean b_permissaousuario) {
        this.b_permissaousuario = b_permissaousuario;
    }
}
