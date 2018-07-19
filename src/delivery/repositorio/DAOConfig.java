/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.Config;
import delivery.interfaces.InterfaceConfig;
import delivery.util.Conexao;
import delivery.util.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Augusto
 */
public class DAOConfig implements InterfaceConfig{
    
   
    /**
     * METODO USADO PARA ALTERAR AS CONFIGURAÇÕES DO SISTEMA
     * @param config OBJETO COM OS DADOS A SER ALTERADO.
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(Config config) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Config SET Sn_CPF = ?, Sn_TelaPedido = ? WHERE Sys_Config = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,config.getSnCpf());
        pstm.setString(2,config.getSnTelaPedido());
        pstm.setString(3,config.getSysConfig());
        try{
         
        pstm.executeUpdate();
            
        }
        catch(SQLException ex){
            
        }
        finally{
           Conexao.closeConnection(con, pstm); 
        }
        
    }
    
    
    public Config verificarConfig() throws DAOException, SQLException {
        
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Sn_CPF,Sn_TelaPedido FROM Config WHERE Sys_Config = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,"SISTEMA");
        ResultSet rs = null;
        Config retorno = new Config();
        try{
        rs = pstm.executeQuery();
        
            if(rs.next()){
            retorno.setSnCpf(rs.getString("Sn_CPF"));
            retorno.setSnTelaPedido(rs.getString("Sn_TelaPedido"));
                return retorno;
            }
        }
        catch(SQLException ex){
            
        }
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return null;
    }
    
    
    
}
