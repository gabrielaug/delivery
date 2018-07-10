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
    
    /**
     * CONSTRUTOR
     */
    public RNLogin(){
        dao = new DAOLogin();
        
    }
    
    /**
     * METEDO USADO PARA VALIDAR OS ATRIBUTOS DE LOGIN ANTES DE CHAMAR O DAO
     * @param login OBJETO A SER VALIDADO
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void inserir(Login login) throws Exception, SQLException {
       
        validarAtributos(login);
        dao.inserir(login);
    }

    /**
     * METODO USADO PARA VALIDAR OS ATRIBUTOS ANTES DE ALTERAR UM LOGIN NO BANCO
     * @param login OBJETO A SER VALIDADO
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void alterar(Login login) throws Exception, SQLException {
        
        validarAtributos(login);
        if(dao.consultarUsuExiste(login)){
         dao.alterar(login);   
        }
        else{
            throw new Exception ("Login não Existe");
        }
                
    }

    /**
     * METODO USADO PARA VALIDAR O OBJETO ANTES DE EXCLUIR
     * @param login OBJETO A SER VERIFICADO
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void excluir(Login login) throws Exception, SQLException {
        
        if(dao.consultarUsuExiste(login)){
            dao.excluir(login);
        }
        else{
            throw new Exception("Login não Existe");
        }
        
        
    }

    /**
     * METODO USADO PARA VALIDAR ANTES DE CHAMAR A LISTA NO DAO
     * @return
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public ArrayList<Login> listar() throws Exception, SQLException {
        
     return dao.listar();
    }
    
    /**
     * METODO USADO PARA VALIDAR TODOS OS ATRIBUTOS DO OBJETO LOGIN
     * @param login OBJETO A SER VALIDADO
     * @throws Exception 
     */
    public void validarAtributos(Login login) throws Exception{
       
        if(login.getUsuario().trim().isEmpty() || login.getUsuario().equalsIgnoreCase("")){
            throw new Exception("Usuário não pode ser nulo ou branco");
        }
        
        if(login.getUsuario().length() > 25){
            throw new Exception("Caracter de Usuario Excedido : 25");
        }
        
        if(login.getNome().trim().isEmpty() || login.getNome().equalsIgnoreCase("")){
            throw new Exception("Nome não pode ser branco ou nulo");
        }
        
        if(login.getNome().length() > 50){
            throw new Exception("Caracter de Nome Excedido : 50");
        }
        
        if(login.getSenha().trim().isEmpty() || login.getSenha().equalsIgnoreCase("")){
            throw new Exception("Senha não pode ser nulo ou branco");
        }
        
        if(login.getSenha().length() > 35){
            throw new Exception ("Erro Limite de Caracteres na Senha : 35");
        }
        
        if(login.getNvAcesso().getAcesso() == 0) {
        throw new Exception ("Nivel de Acesso não pode ser 0");    
        } 
        
    }
    
    
}
