/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.Login;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public interface InterfaceLogin {
    
    
    public void inserir(Login login)throws Exception, SQLException;
    public void alterar(Login login)throws Exception, SQLException;
    public void excluir(Login login)throws Exception, SQLException;
    public ArrayList<Login> listar() throws Exception, SQLException;
 
}

