/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.negocio;

import delivery.basica.Cliente;
import delivery.interfaces.InterfaceCliente;
import delivery.repositorio.DAOCliente;
import delivery.repositorio.DAOConfig;
import delivery.util.DAOException;
import delivery.util.ValidarCPF;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaugusto
 */
public class RNCliente implements InterfaceCliente{
    
    DAOCliente dao;
    DAOConfig config;
    
    /**
     * CONSTRUTOR
     */
    public RNCliente(){
        dao = new DAOCliente();
        config = new DAOConfig();
    }

    /**
     * METODO USADO PARA VALIDAR O CLIENTE ANTES DE INSERIR NO BANCO
     * @param cliente OBJETO A SER VALIDADO.
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void inserir(Cliente cliente) throws DAOException, SQLException {
        
        validarAtributos(cliente);
        
        if(config.verificarConfig().getSnCpf().equalsIgnoreCase("S")){
            try {
                obrigatorioCPF(cliente);
            } catch (Exception ex) {
                
            }
        }
        
        
        dao.inserir(cliente);
    }

    /**
     * METODO USADO PARA VALIDAR O OBJETO ANTES DE ALTERAR NO BANCO
     * @param cliente OBJETO A SER VALIDADO ANTES DE ALTERAR
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(Cliente cliente) throws DAOException, SQLException {
        
        if(!dao.consultarClienteExistente(cliente)){
            throw new DAOException("Cliente não existe");
        }
        else{
            
            if(config.verificarConfig().getSnCpf().equalsIgnoreCase("S")){
            try {
                obrigatorioCPF(cliente);
            } catch (Exception ex) {
                
            }
        }
            
          dao.alterar(cliente);  
        }
        
    }

    /**
     * METODO USADO PARA VALIDAR O OBJETO CLIENTE ANTES DE TENTAR EXCLUIR
     * @param cliente OBJETO A SER VALIDADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void excluir(Cliente cliente) throws DAOException, SQLException {
       
        if(!dao.consultarClienteExistente(cliente)){
            throw new DAOException("Cliente não existe");
        }
        else{
          dao.excluir(cliente);  
        }
 
    }

    /**
     * METODO USADO PARA VALIDAR ANTES DE CHAMAR A LISTA DE CLIENTES DO BANCO
     * @return RETORNA A LISTA CASO PASSE PELA VALIDAÇÃO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public ArrayList<Cliente> listar() throws DAOException, SQLException {
        
        return dao.listar();
    }
    
    
    /**
     * METODO USADO PARA VALIDAR OS ATRIBUTOS DO OBJETO CLIENTE
     * @param cliente OBJETO CUJO OS ATRIBUTOS VÃO SER VALIDADOS
     * @return RETORNA TRUE CASO TODOS OS "SE" SEJAM FALSOS
     * @throws DAOException
     * @throws SQLException 
     */
    public boolean validarAtributos(Cliente cliente) throws DAOException, SQLException{
     
        if(cliente.getNome().trim().isEmpty() || cliente.getNome().equalsIgnoreCase("")){
            throw new DAOException("Nome não pode ser branco ou nulo");
        }
        
        if(cliente.getNome().length() > 50){
            throw new DAOException("Quantidade de caracteres de Nome Excedido : 50");
        }
        
        if(cliente.getTelefone().trim().isEmpty() || cliente.getTelefone().equals("")){
            throw new DAOException ("Telefone não pode ser branco ou nulo");
        }
        
        if(cliente.getTelefone().length() > 12 ){
            throw new DAOException("Quantidade de caracteres de Telefone Excedido : 12");
        }
        
        //NÃO É OBRIGATORIO QUE SEJA COLOCADO O TELEFONE 2
        
        if(cliente.getTelefone2().length() > 12){
            throw new DAOException("Quantidade de caracteres de Telefone2 Excedido : 12");
        }
        
        //NÃO É OBRIGATORIO QUE SEJA COLOCADO O TELEFONE 3
        
        if(cliente.getTelefone3().length() > 12){
            throw new DAOException("Quantidade de caracteres de Telefone3 Excedido : 12");
        }
        
        if(cliente.getLogradouro().trim().isEmpty() || cliente.getLogradouro().equals("")){
            throw new DAOException("Logradouro não pode ser branco ou nulo");
        }
        
        if(cliente.getLogradouro().length() > 50){
            throw new DAOException("Quantidade de caracteres de Telefone3 Excedido : 50");
        }
        
        //O CLIENTE PODE NÃO SABER O CEP
        /*
        if(cliente.getCep().trim().isEmpty() || cliente.getCep().equals("")){
            throw new DAOException ("CEP não pode ser branca ou nulo");
        }*/
        
        if(cliente.getCep().length() > 8){
           throw new DAOException ("Quantidade de caracteres de CEP Excedido : 8");
        }
        
        if(cliente.getNumero().trim().isEmpty() || cliente.getNumero().equals("")){
            throw new DAOException("Numero não pode ser branco ou nulo");
        }
        
        if(cliente.getNumero().length() > 10 ){
            throw new DAOException ("Quantidade de caracteres de Telefone3 Excedido : 10");
        }
        
        if(cliente.getComplemento().trim().isEmpty() || cliente.getComplemento().equals("")){
            throw new DAOException("Complemento não pode ser branco ou nulo");
        }
        
        if(cliente.getComplemento().length() > 100){
            throw new DAOException("Quantidade de caracter de Complemento Excedido : 100");
        }
        
        //NÃO É OBRIGATORIO QUE SEJA COLOCADO A REFERENCIA
        
        if(cliente.getReferencia().length() > 255){
            throw new DAOException("Quantidade de caracteres de Referencia Excedido : 255");
        }
        
     return true;   
    }
    
    public boolean obrigatorioCPF(Cliente cliente) throws DAOException, Exception{
        
        ValidarCPF validar = new ValidarCPF();
        
        if(cliente.getCpf().trim().isEmpty() || cliente.getCpf().equalsIgnoreCase("")){
            throw new DAOException("CPF não pode ser nulo ou branco");
        }
        
        if(cliente.getCpf().length() > 11){
            throw new DAOException("Quantidade de caracteres de CPF Excedido : 11");
        }
        
        if(!validar.validar(cliente)){
            throw new DAOException("CPF não é valido");
        }
        
        return true;
    }
    
    
    
}
