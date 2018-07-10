/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.negocio;

import delivery.basica.Cliente;
import delivery.interfaces.InterfaceCliente;
import delivery.repositorio.DAOCliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gaugusto
 */
public class RNCliente implements InterfaceCliente{
    
    DAOCliente dao;
    
    /**
     * CONSTRUTOR
     */
    public RNCliente(){
        dao = new DAOCliente();
    }

    /**
     * METODO USADO PARA VALIDAR O CLIENTE ANTES DE INSERIR NO BANCO
     * @param cliente OBJETO A SER VALIDADO.
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void inserir(Cliente cliente) throws Exception, SQLException {
        
        validarAtributos(cliente);
    }

    @Override
    public void alterar(Cliente cliente) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Cliente cliente) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> listar() throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean validarAtributos(Cliente cliente) throws Exception, SQLException{
     
        if(cliente.getNome().trim().isEmpty() || cliente.getNome().equalsIgnoreCase("")){
            throw new Exception("Nome não pode ser branco ou nulo");
        }
        
        if(cliente.getNome().length() > 50){
            throw new Exception("Caracter de Nome Excedido : 50");
        }
        
        if(cliente.getCpf().trim().isEmpty() || cliente.getCpf().equalsIgnoreCase("")){
            throw new Exception("CPF não pode ser nulo ou branco");
        }
        
        if(cliente.getTelefone().trim().isEmpty() || cliente.getTelefone().equals("")){
            throw new Exception ("Telefone não pode ser branco ou nulo");
        }
        
        if(cliente.getTelefone().length() > 12 ){
            throw new Exception("Caracter de Telefone Excedido : 12");
        }
        
        //NÃO É OBRIGATORIO QUE SEJA COLOCADO O TELEFONE 2
        
        if(cliente.getTelefone2().length() > 12){
            throw new Exception("Caracter de Telefone2 Excedido : 12");
        }
        
        //NÃO É OBRIGATORIO QUE SEJA COLOCADO O TELEFONE 3
        
        if(cliente.getTelefone3().length() > 12){
            throw new Exception("Caracter de Telefone3 Excedido : 12");
        }
        
        if(cliente.getLogradouro().trim().isEmpty() || cliente.getLogradouro().equals("")){
            throw new Exception("Logradouro não pode ser branco ou nulo");
        }
        
        if(cliente.getLogradouro().length() > 50){
            throw new Exception("Caracter de Telefone3 Excedido : 50");
        }
        
        if(cliente.getCep().trim().isEmpty() || cliente.getCep().equals("")){
            throw new Exception ("CEP não pode ser branca ou nulo");
        }
        
        if(cliente.getCep().length() > 8){
           throw new Exception ("Caracter de CEP Excedido : 8");
        }
        
        if(cliente.getNumero().trim().isEmpty() || cliente.getNumero().equals("")){
            throw new Exception("Numero não pode ser branco ou nulo");
        }
        
        if(cliente.getNumero().length() > 10 ){
            throw new Exception ("Caracter de Telefone3 Excedido : 10");
        }
        
        if(cliente.getComplemento().trim().isEmpty() || cliente.getComplemento().equals("")){
            throw new Exception("Complemento não pode ser branco ou nulo");
        }
        
        if(cliente.getComplemento().length() > 100){
            throw new Exception("Caracter de Complemento Excedido : 100");
        }
        
        //NÃO É OBRIGATORIO QUE SEJA COLOCADO A REFERENCIA
        
        if(cliente.getReferencia().length() > 255){
            throw new Exception("Caracter de Referencia Excedido : 255");
        }
        
     return true;   
    }
    
}
