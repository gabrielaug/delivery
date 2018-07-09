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
    
    public void inserir(Cliente cliente)throws Exception, SQLException;
    public void alterar(Cliente cliente)throws Exception, SQLException;
    public void excluir(Cliente cliente)throws Exception, SQLException;
    public ArrayList<Cliente> listar() throws Exception, SQLException;
    
}
