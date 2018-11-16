/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.Pedido;
import delivery.util.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public interface InterfacePedido {
    
    
    public int inserir (Pedido pedido) throws DAOException, SQLException;
    
    public void alterar (Pedido pedido) throws DAOException, SQLException;
    
    public void excluir (Pedido pedido) throws DAOException, SQLException;
    
    public ArrayList<Pedido> listar() throws DAOException, SQLException;
    
    public Pedido rastrearCodigoPedido(Pedido pedido) throws DAOException, SQLException;
    
    
}
