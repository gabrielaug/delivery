/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import delivery.basica.Cliente;
import delivery.basica.Produto;
import delivery.repositorio.DAOProduto;
import delivery.util.Conexao;
import delivery.util.DAOException;
import delivery.util.MD5;
import delivery.util.ValidarCPF;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Augusto
 */
public class MainTeste {
    
    public static void main(String[] args) throws Exception {
        try {
            //testeConexao();
            //testeInsert();
            //valicpf();
        } catch (Exception ex) {
           
        }
        
        
        
        //md();
        lista();
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
    
   /* public static void testeInsert(){
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
        
        
    }*/
    
    public static void valicpf() throws Exception{
        Cliente c = new Cliente();
        ValidarCPF va = new ValidarCPF();
        c.setCpf("11971071420");
        
        if(va.validar(c)){
            System.out.println("CPF Valido");
        }else{
            System.out.println("CPF Invalido");
        }
        
        
        
        
    }
    
    public static void md()throws Exception{
            MD5 md5 = new MD5();
            String  senha= "GABRIEL";
            System.out.println(md5.converter(senha));
            
            
            
            
        }
    
    
    public static void lista(){
        DAOProduto dao = new DAOProduto();
        Produto produto = new Produto();
        ArrayList<Produto> listar = new ArrayList();
        
        try {
            listar = dao.listar();
        } catch (DAOException | SQLException ex) {
           
        }
        
        for (Produto p : listar ){
            System.out.println(p.getDescricao());
            
        }
        
        
        
        
    }
    
}
