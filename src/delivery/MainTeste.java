/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import delivery.basica.Login;
import delivery.repositorio.DAOLogin;
import delivery.util.Conexao;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Augusto
 */
public class MainTeste {
    
    public static void main(String[] args) {
       //testeConexao(); 
       testeInsert();
    }
    
    
    public static void testeConexao(){
        Connection con = null;
        try{
        con = Conexao.getInstance().getConnection();
        System.out.println("Conectou"); 
        }
        catch(Exception ex){
            System.out.println("Pauuuuu "+ex);
        }
        finally{
            
            Conexao.closeConnection(con); 
            System.out.println("Conexao Fechada");
        }   
    }
    
    public static void testeInsert(){
        Login l = new Login();
        
        l.setUsuario("ADMIN");
        l.setNome("GABRIEL AUGUSTO DAS NEVES SILVA");
        l.setSenha("teste");
        
        DAOLogin dao = new DAOLogin();
        try {
            dao.insert(l);
            System.out.println("Sucesso");
        } catch (Exception ex) {
            Logger.getLogger(MainTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
