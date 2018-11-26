/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.negocio;

import delivery.basica.Pedido;
import delivery.interfaces.InterfacePedido;
import delivery.repositorio.DAOPedido;
import delivery.util.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public class RNPedido implements InterfacePedido {
    
    DAOPedido dao;
    Pedido pedido;
    
    /**
     * CONSTRUTOR
     */
    public RNPedido(){
        dao = new DAOPedido(); 
        pedido = new Pedido();
    }
    
    
    /**
     * VÁLIDA SE O CLIENTE ESTÁ CADASTRADO NO BANCO DE DADOS ATRAVÉS DO SEU TELEFONE
     * @param pedido - OBJETO A SER REGISTRADO NO BANCO DE DADOS.
     * @return 
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public int inserir(Pedido pedido) throws DAOException, SQLException {
      int retorno = 0;  
      try{
        validacaoPedido(pedido);
        retorno = dao.inserir(pedido);
        if(retorno > 0){
           
          dao.inserirPedidoProduto(pedido);
        }
        
      }catch(DAOException ex){
          
      }
      
      
      
      
      return retorno;
    }

    @Override
    public void alterar(Pedido pedido) throws DAOException, SQLException {
     
        validacaoPedido(pedido);
        rastrearCodigoPedido(pedido);
        dao.alterar(pedido);
    }

    @Override
    public void excluir(Pedido pedido) throws DAOException, SQLException {
       
        rastrearCodigoPedido(pedido);
        dao.excluir(pedido);
    }

    @Override
    public ArrayList<Pedido> listar() throws DAOException, SQLException {
       
        return dao.listar();
    }
    
    public void validacaoPedido(Pedido pedido) throws DAOException{
    if(pedido.getCliente() == null){
        throw new DAOException("Cliente não Existe");
    }
    if(pedido.getValorTotal() < 0){
          throw new DAOException("O valor total não pode ser negativo!");
        }
    }

    @Override
    public Pedido rastrearCodigoPedido(Pedido pedido) throws DAOException, SQLException {
        if (dao.rastrearCodigoPedido(pedido) == null){
            throw new DAOException("Código de pedido não cadastrado!");
        }
        return pedido;
    }

    
}
