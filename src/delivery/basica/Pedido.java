/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.basica;

import java.sql.Date;

/**
 *
 * @author Rafael Augusto
 */
public class Pedido {
    
    private int codPedido;
    private Cliente cliente;
    private Double valorTotal;
    private String obsCliente;
    private Date dtPedido;

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObsCliente() {
        return obsCliente;
    }

    public void setObsCliente(String obsCliente) {
        this.obsCliente = obsCliente;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }
    
    
    
}
