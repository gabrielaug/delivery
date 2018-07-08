/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.Login;
import delivery.interfaces.InterfaceLogin;
import delivery.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public class DAOLogin implements InterfaceLogin{
    
    
    
    /**
     * METODO USADO PARA INSERIR UM LOGIN NO BANCO DE DADOS
     * @param login OBJETO QUE SERA INSERIDO NO BANCO
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void insert(Login login) throws Exception, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "INSERT INTO Login (Usuario,Nome,Senha) VALUES (?,?,?)";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,login.getUsuario());
        pstm.setString(2,login.getNome());
        pstm.setString(3,login.getSenha());
        
        try{
         
        pstm.executeUpdate();
            
        }
        catch(SQLException ex){
            
        }
        finally{
           Conexao.closeConnection(con, pstm); 
        }
 
    }

    /**
     * METODO USADO PARA ATUALIZA DADOS DO OBJETO NO BANCO DE DADOS
     * @param login OBJETO COM AS ATUALIZAÇÕES A SEREM REALIZADAS NO BANCO
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void update(Login login) throws Exception, SQLException {
       
       Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Login SET Nome = ?,Senha = ? WHERE Usuario = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,login.getNome());
        pstm.setString(2,login.getSenha());
        pstm.setString(3,login.getUsuario());
        
        try{
            
        pstm.executeUpdate();
        
        }
        catch(SQLException ex){
            
        }
        finally{
          Conexao.closeConnection(con, pstm);  
        }
        
    }

    /**
     * METODO USADO PARA DELETA UM DETERMINADO LOGIN NO BANCO DE DADOS
     * @param login OBJETO A SER DELETADO
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void delete(Login login) throws Exception, SQLException {
     
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "DELETE FROM Login WHERE Usuario = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,login.getUsuario());
        
        try{
            
        pstm.execute();
        
        }
        catch(SQLException ex){
            
        }
        finally{   
            
        Conexao.closeConnection(con, pstm);
        
        }

    }

    /**
     * METODO USADO PARA LISTAR OS LOGIN'S NO BANCO DE DADOS
     * @return RETORNA A LISTA DE LOGIN'S
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public ArrayList<Login> list() throws Exception, SQLException {
        
        ArrayList<Login> lista = new ArrayList<>();
        Login login = new Login();
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Usuario,Nome,Senha FROM Login";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
        while(rs.next()){
            login.setUsuario(rs.getString("Usuario"));
            login.setNome(rs.getString("Nome"));
            login.setSenha(rs.getString("Senha"));
            lista.add(login);
        }
        }
        catch(SQLException ex){
            
        }
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return lista;
    }
    
}
