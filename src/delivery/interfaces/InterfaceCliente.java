/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public interface InterfaceCliente {
    
    public void insert(Cliente cliente)throws Exception, SQLException;
    public void update(Cliente cliente)throws Exception, SQLException;
    public void delete(Cliente cliente)throws Exception, SQLException;
    public ArrayList<Cliente> list() throws Exception, SQLException;
    
}
