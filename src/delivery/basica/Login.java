/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.basica;

/**
 *
 * @author Gabriel Augusto
 */
public class Login {
    
    private String usuario;
    private String nome;
    private String senha;
    private NvAcesso nvAcesso = new NvAcesso();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public NvAcesso getNvAcesso() {
        return nvAcesso;
    }

    public void setNvAcesso(NvAcesso nvAcesso) {
        this.nvAcesso = nvAcesso;
    }
    
}
