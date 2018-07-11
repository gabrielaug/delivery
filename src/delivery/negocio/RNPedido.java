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
    
    /**
     * CONSTRUTOR
     */
    public RNPedido(){
        
        dao = new DAOPedido();
        
        
    }
    
    

    @Override
    public void inserir(Pedido pedido) throws DAOException, SQLException {
       
    }

    @Override
    public void alterar(Pedido pedido) throws DAOException, SQLException {
        throw new UnsupportedOperationDAOException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Pedido pedido) throws DAOException, SQLException {
        throw new UnsupportedOperationDAOException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> listar() throws DAOException, SQLException {
        throw new UnsupportedOperationDAOException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
