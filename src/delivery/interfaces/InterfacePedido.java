/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public interface InterfacePedido {
    
    
    public void inserir (Pedido pedido) throws Exception, SQLException;
    
    public void alterar (Pedido pedido) throws Exception, SQLException;
    
    public void excluir (Pedido pedido) throws Exception, SQLException;
    
    public ArrayList<Pedido> listar() throws Exception, SQLException;
    
    
}
