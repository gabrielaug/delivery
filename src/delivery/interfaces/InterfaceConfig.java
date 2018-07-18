/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.Config;
import delivery.util.DAOException;
import java.sql.SQLException;


/**
 *
 * @author Gabriel Augusto
 */
public interface InterfaceConfig {
    
    public void alterar(Config config)throws DAOException, SQLException;
    
}
