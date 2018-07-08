/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Gabriel Augusto
 */
public class Conexao {
    // DRIVER MYSQL (DRIVER - PORTA DE ENTRADA - USUARIO - SENHA)
    ResourceBundle rb = ResourceBundle.getBundle("delivery.util.config"); 
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = rb.getString("url");
    private final String USER = rb.getString("user");
    private final String PASSWD = rb.getString("passwd");
    private static Conexao instancia;
    
    
    public static Conexao getInstance(){
        
        if(instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }
    
    
    //--------------------------------------
    // VÊ O ESTADO DA CONEXÃO E FAZ O ACESSO VIA PARAMETROS
    //--------------------------------------
    public Connection getConnection(){
    
        try {
            
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWD);
           
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    
    //----------------------------------------
    // FECHA A CONEXÃO
    //----------------------------------------
    public static void closeConnection(Connection con){
  
        try {
            if(con != null){
                con.close();
            }
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao Fechar a Conexão",ex);
        }               
    } 
    
    //--------------------------------------------
    // FAZ A 1º SOBRECARGA 
    //--------------------------------------------
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
                stmt.close();
        }
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao Fechar a Conexão",ex);
        }       
    } 
           
    
    //--------------------------------------------
    // FAZ A 2º SOBRECARGA
    //--------------------------------------------
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs != null){
                rs.close();
        } 
        }catch (SQLException ex) {
            throw new RuntimeException("Erro ao Fechar a Conexão",ex);
        }       
    }
}
