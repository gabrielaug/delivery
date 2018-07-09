/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.NvAcesso;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public interface InterfaceNvAcesso {
    
    public void inserir (NvAcesso nvAcesso) throws Exception, SQLException;
    
    public void alterar (NvAcesso nvAcesso) throws Exception, SQLException;
    
    public void excluir (NvAcesso nvAcesso) throws Exception, SQLException;
    
    public ArrayList<NvAcesso> listar() throws Exception, SQLException;
    
}
