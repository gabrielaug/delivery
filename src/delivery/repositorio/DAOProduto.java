/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.Produto;
import delivery.interfaces.InterfaceProduto;
import delivery.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public class DAOProduto implements InterfaceProduto {
    /**
     * INSERI UM PRODUTO NO BANCO DE DADOS.
     * @param produto - OBJETO A SER INSERIDO NO BANCO DE DADOS.
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void inserir(Produto produto) throws Exception, SQLException {
    
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "INSERT INTO Produto (Descricao, Valor) VALUES (?,?)";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,produto.getDescricao());
        pstm.setDouble(2,produto.getValor());
        
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
     * ALTERA O PRODUTO CADASTRADO NO BANCO DE DADOS.
     * @param produto - OBJETO A SER ALTERADO NO BANCO DE DADOS.
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void alterar(Produto produto) throws Exception, SQLException {
    
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Produto SET Descricao =?, Valor =? WHERE Cod_Produto =?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,produto.getDescricao());
        pstm.setDouble(2,produto.getValor());
        pstm.setInt(3,produto.getCodProduto());
        
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
     * EXCLUI O PRODUTO DO BANCO DE DADOS.
     * @param produto - OBJETO A SER EXCLUIDO DO BANCO DE DADOS.
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void excluir(Produto produto) throws Exception, SQLException {
    
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "DELETE FROM Produto WHERE Cod_Produto = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setInt(1,produto.getCodProduto());
        
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
     * LISTA OS PRODUTOS CADASTRADOS NO BANCO DE DADOS.
     * @return - RETORNA A LISTA DE INFORMAÇÕES DO PRODUTO CADASTRADO.
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public ArrayList<Produto> listar() throws Exception, SQLException {
        
        ArrayList<Produto> lista = new ArrayList<>();
        Produto produto = new Produto(); 
       
       Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Cod_Produto, Descricao, Valor FROM Produto";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
        while(rs.next()){
            produto.setCodProduto(rs.getInt("Cod_Produto"));
            produto.setDescricao(rs.getString("Descricao"));
            produto.setValor(rs.getDouble("Valor"));
            lista.add(produto);
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
