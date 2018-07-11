/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.NvAcesso;
import delivery.interfaces.InterfaceNvAcesso;
import delivery.util.Conexao;
import delivery.util.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public class DAONvAcesso implements InterfaceNvAcesso{

    /**
     * METODO USADO PARA INSERIR NvAcesso NO BANCO DE DADOS
     * @param nvAcesso OBJETO A SER INSERIDO NO BANCO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void inserir(NvAcesso nvAcesso) throws DAOException, SQLException {
        
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "INSERT INTO Nv_Acesso (Descricao) VALUES (?)";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,nvAcesso.getDescricao());
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
     * METODO USADO PARA ALTERAR UM NvAcesso NO BANCO DE DADOS
     * @param nvAcesso OBJETO A SER ALTERADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(NvAcesso nvAcesso) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Nv_Acesso SET Descricao = ? WHERE Acesso = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,nvAcesso.getDescricao());
        pstm.setInt(2,nvAcesso.getAcesso());
        
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
     * METODO USADO PARA EXCLUIR UM NvAcesso NO BANCO DE DADOS
     * @param nvAcesso
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void excluir(NvAcesso nvAcesso) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "DELETE FROM Nv_Acesso WHERE Acesso = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setInt(1,nvAcesso.getAcesso());
        
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
     * METODO USADO PARA LISTAR OS NvAcesso NO BANCO DE DADOS
     * @return RETORNA UMA LISTA COM OS NvAcesso
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public ArrayList<NvAcesso> listar() throws DAOException, SQLException {
        
        ArrayList<NvAcesso> lista = new ArrayList<>();
        NvAcesso nvAcesso = new NvAcesso();
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Acesso,Descricao FROM Nv_Acesso";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
        while(rs.next()){
            nvAcesso.setAcesso(rs.getInt("Acesso"));
            nvAcesso.setDescricao(rs.getString("Descricao"));
            lista.add(nvAcesso);
        }
        }
        catch(SQLException ex){
            
        }
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return lista;
    }
    
    public boolean consultarAcessoExiste(NvAcesso nvAcesso) throws DAOException, SQLException {
        
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Acesso,Descricao FROM Nv_Acesso WHERE Acesso = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setInt(1,nvAcesso.getAcesso());
        ResultSet rs = null;
        boolean retorno = false;
        try{
        rs = pstm.executeQuery();
        
            if(rs.next()){
                return retorno = true;
            }
        }
        catch(SQLException ex){
            
        }
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return retorno;
    }
        
}
    
