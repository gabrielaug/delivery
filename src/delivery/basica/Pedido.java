/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.basica;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public class Pedido {
    
    private int codPedido;
    private ArrayList<Produto> produto = new ArrayList<>();
    private Cliente cliente = new Cliente();
    private Double valorTotal;
    private Timestamp dtPedido;
    private double valorFrete;
    private String pgto;

    public String getPgto() {
        return pgto;
    }

    public void setPgto(String pgto) {
        this.pgto = pgto;
    }
    

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }
    
     public ArrayList<Produto> getProduto() {
        return produto;
    }

    public void setProduto(ArrayList<Produto> produto) {
        this.produto = produto;
    }

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

    public Timestamp getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Timestamp dtPedido) {
        this.dtPedido = dtPedido;
    }

    
    
    
    
}
