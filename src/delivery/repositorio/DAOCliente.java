/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.Cliente;
import delivery.interfaces.InterfaceCliente;
import delivery.util.Conexao;
import delivery.util.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public class DAOCliente implements InterfaceCliente{

    /**
     * METODO USADO PARA INSERIR UM CLIENTE NO BANCO DE DADOS
     * @param cliente OBJETO A SER INSERIDO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void inserir(Cliente cliente) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "INSERT INTO Cliente (Nome,CPF,Telefone,Telefone2,Telefone3,Logradouro,CEP,Numero,Complemento,Referencia) VALUES (?,?,?,?,?,?,?,?,?,?,CURRENT_DATE)";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,cliente.getNome());
        pstm.setString(2,cliente.getCpf());
        pstm.setString(3,cliente.getTelefone());
        pstm.setString(4,cliente.getTelefone2());
        pstm.setString(5,cliente.getTelefone3());
        pstm.setString(6,cliente.getLogradouro());
        pstm.setString(7,cliente.getCep());
        pstm.setString(8,cliente.getNumero());
        pstm.setString(9,cliente.getComplemento());
        pstm.setString(10,cliente.getReferencia());
        
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
     * METODO USADO PARA ALTERAR UM DETERMINADO CLIENTE NO BANCO DE DADOS
     * @param cliente OBJETO A SER ALTERADO NO BANCO DE DADOS
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(Cliente cliente) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Cliente SET Nome = ?,CPF = ?,Telefone2 = ?,Telefone3 = ?"
                + ",Logradouro = ?,CEP = ?,Numero = ?,Complemento = ?,Referencia = ? WHERE Telefone = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,cliente.getNome());
        pstm.setString(2,cliente.getCpf());
        pstm.setString(3,cliente.getTelefone2());
        pstm.setString(4,cliente.getTelefone3());
        pstm.setString(5,cliente.getLogradouro());
        pstm.setString(6,cliente.getCep());
        pstm.setString(7,cliente.getNumero());
        pstm.setString(8,cliente.getComplemento());
        pstm.setString(9,cliente.getReferencia());
        pstm.setString(10,cliente.getTelefone());
        
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
     * METODO USADO PARA EXCLUIR UM DETERMINADO CLIENTE DO BANCO DE DADOS
     * @param cliente OBJETO A SER EXCLUIDO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void excluir(Cliente cliente) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "DELETE FROM Cliente WHERE Telefone = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,cliente.getTelefone());
        
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
     * METODO USADO PARA BUSCA UMA LISTA DE CLIENTE NO BANCO DE DADAOS
     * @return RETORNA UMA LISTA
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public ArrayList<Cliente> listar() throws DAOException, SQLException {
        
    ArrayList<Cliente> lista = new ArrayList<>();
        
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Nome,CPF,Telefone,Telefone2,Telefone3,Logradouro,CEP,Numero,Complemento,Referencia,Dt_Cadastro FROM Cliente";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setNome(rs.getString("Nome"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setTelefone(rs.getString("Telefone"));
            cliente.setTelefone2(rs.getString("Telefone2"));
            cliente.setTelefone3(rs.getString("Telefone3"));
            cliente.setLogradouro(rs.getString("Logradouro"));
            cliente.setCep(rs.getString("CEP"));
            cliente.setNumero(rs.getString("Numero"));
            cliente.setComplemento(rs.getString("Complemento"));
            cliente.setReferencia(rs.getString("Referencia"));
            cliente.setDtCadastro(rs.getDate("Dt_Cadastro"));
            lista.add(cliente);
        }
        }
        catch(SQLException ex ){
            
        } 
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return lista;
    }
    
    public boolean consultarClienteExistente(Cliente cliente) throws DAOException, SQLException {
        
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Nome,CPF,Telefone,Telefone2,Telefone3,Logradouro,CEP,Numero,Complemento,Referencia FROM Cliente WHERE Telefone = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,cliente.getTelefone());
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
    
    public Cliente consultarTelefone(Cliente cliente) throws DAOException, SQLException {
        
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Nome,CPF,Telefone,Telefone2,Telefone3,Logradouro,CEP,Numero,Complemento,Referencia,Dt_Cadastro FROM Cliente WHERE Telefone = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,cliente.getTelefone());
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
            if(rs.next()){
            Cliente retorno = new Cliente();
            retorno.setNome(rs.getString("Nome"));
            retorno.setCpf(rs.getString("CPF"));
            retorno.setTelefone(rs.getString("Telefone"));
            retorno.setTelefone2(rs.getString("Telefone2"));
            retorno.setTelefone3(rs.getString("Telefone3"));
            retorno.setLogradouro(rs.getString("Logradouro"));
            retorno.setCep(rs.getString("CEP"));
            retorno.setNumero(rs.getString("Numero"));
            retorno.setComplemento(rs.getString("Complemento"));
            retorno.setReferencia(rs.getString("Referencia"));
            cliente.setDtCadastro(rs.getDate("Dt_Cadastro"));
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
    
    public int QtdPedidoCliente(Cliente cliente) throws DAOException, SQLException {
     
        int total = 0;
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT COUNT(P.Cod_Pedido) AS TOTAL FROM Pedido as P\n" +
            "INNER JOIN Cliente AS C ON C.Telefone = P.Telefone WHERE P.Telefone = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,cliente.getTelefone());
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
        if(rs.next()){
            
            total = rs.getInt("TOTAL");

            return total;
        }
        }
        catch(SQLException ex){
            
        }
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return total;
    }
    
    
    
    
}
