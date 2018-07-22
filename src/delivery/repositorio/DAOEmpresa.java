/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.Empresa;
import delivery.interfaces.InterfaceEmpresa;
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
public class DAOEmpresa implements InterfaceEmpresa{

    
    /**
     * METODO USADO PARA INSERIR EMPRESA NO BANCO DE DADOS   (NÃO UTILIZADO PARA ESTÁ VERSÃO DO SISTEMA)
     * @param empresa OBJETO A SER INSERIDO NO BANCO
     * @throws DAOException
     * @throws SQLException 
     */
   /* @Override
    public void inserir(Empresa empresa) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "INSERT INTO Empresa (RazaoSocial,CNPJ,Logradouro,Numero,Complemento,Telefone,Telefone2) VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,empresa.getRazaoSocial());
        pstm.setString(1,empresa.getCnpj());
        pstm.setString(1,empresa.getLogradouro());
        pstm.setString(1,empresa.getNumero());
        pstm.setString(1,empresa.getComplemento());
        pstm.setString(1,empresa.getTelefone());
        pstm.setString(1,empresa.getTelefone2());
        try{
         
        pstm.executeUpdate();
            
        }
        catch(SQLException ex){
            
        }
        finally{
           Conexao.closeConnection(con, pstm); 
        }
        
    }*/

    /**
     * METODO USADO PARA ALTERAR EMPRESA NO BANCO DE DADOS
     * @param empresa OBJETO A SER ALTERADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(Empresa empresa) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Empresa SET RazaoSocial = ?,CNPJ = ?,CEP = ?,Logradouro = ?,Numero = ?,Complemento = ?,Telefone = ?,Telefone2 = ? WHERE Cod_Empresa = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,empresa.getRazaoSocial());
        pstm.setString(2,empresa.getCnpj());
        pstm.setString(3, empresa.getCep());
        pstm.setString(4,empresa.getLogradouro());
        pstm.setString(5,empresa.getNumero());
        pstm.setString(6,empresa.getComplemento());
        pstm.setString(7,empresa.getTelefone());
        pstm.setString(8,empresa.getTelefone2());
        
        pstm.setInt(9,1);
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
     * METODO USADO PARA EXCLUIR EMPRESA  (NÃO UTILIZADO PARA ESTÁ VERSÃO DO SISTEMA)
     * @param empresa OBJETO A SER EXCLUIDO
     * @throws DAOException
     * @throws SQLException 
     */
   /* @Override
    public void excluir(Empresa empresa) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "DELETE FROM Empresa WHERE CNPJ = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,empresa.getCnpj());
        
        try{
            
        pstm.execute();
        
        }
        catch(SQLException ex){
            
        }
        finally{   
            
        Conexao.closeConnection(con, pstm);
        
        } 
        
        
    }*/

    /**
     * METODO USADO PARA LISTAR OS DADOS DA EMPRESA NO BANCO
     * @return RETORNA UMA LISTA DE EMPRESA
     * @throws DAOException
     * @throws SQLException 
     */
    
    public Empresa listar() throws DAOException, SQLException {
        
        Empresa empresa = new Empresa();
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT RazaoSocial,CNPJ,CEP,Logradouro,Numero,Complemento,Telefone,Telefone2 FROM Empresa";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
        if(rs.next()){
            empresa.setRazaoSocial(rs.getString("RazaoSocial"));
            empresa.setCnpj(rs.getString("CNPJ"));
            empresa.setCep(rs.getString("CEP"));
            empresa.setLogradouro(rs.getString("Logradouro"));
            empresa.setNumero(rs.getString("Numero"));
            empresa.setComplemento(rs.getString("Complemento"));
            empresa.setTelefone(rs.getString("Telefone"));
            empresa.setTelefone2(rs.getString("Telefone2"));
            
        }
        }
        catch(SQLException ex){
            
        }
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return empresa;
        
    }
    
}
