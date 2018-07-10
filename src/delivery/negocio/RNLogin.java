/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.negocio;

import delivery.basica.Login;
import delivery.interfaces.InterfaceLogin;
import delivery.repositorio.DAOLogin;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public class RNLogin implements InterfaceLogin{

    DAOLogin dao;
    
    public RNLogin(){
        dao = new DAOLogin();
        
    }
    
    @Override
    public void inserir(Login login) throws Exception, SQLException {
       
        validarAtributos(login);
        dao.inserir(login);
    }

    @Override
    public void alterar(Login login) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Login login) throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Login> listar() throws Exception, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void validarAtributos(Login login) throws Exception{
       
        if(login.getNome().trim().isEmpty() || login.getNome().equalsIgnoreCase("")){
            throw new Exception("Nome nao pode ser branco ou nulo");
        }
        
        if(login.getSenha().trim().isEmpty() || login.getSenha().equalsIgnoreCase("")){
            throw new Exception("");
        }
        
    }
    
    
}
