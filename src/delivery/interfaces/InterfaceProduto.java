/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.Produto;
import delivery.util.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public interface InterfaceProduto {
    
    public void inserir (Produto produto) throws DAOException, SQLException;
    
    public void alterar (Produto produto) throws DAOException, SQLException;
    
    public void excluir (Produto produto) throws DAOException, SQLException;
    
    public ArrayList<Produto> listar() throws DAOException, SQLException;
    
}
