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
public class Config {
    
    private String sysConfig = "SISTEMA";
    private String snCpf;
    private String snTelaPedido;

    public String getSysConfig() {
        return sysConfig;
    }

    public void setSysConfig(String sysConfig) {
        this.sysConfig = sysConfig;
    }

    public String getSnCpf() {
        return snCpf;
    }

    public void setSnCpf(String snCpf) {
        this.snCpf = snCpf;
    }

    public String getSnTelaPedido() {
        return snTelaPedido;
    }

    public void setSnTelaPedido(String snTelaPedido) {
        this.snTelaPedido = snTelaPedido;
    }
    
    
}
