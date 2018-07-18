/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.Pedido;
import delivery.interfaces.InterfacePedido;
import delivery.util.Conexao;
import delivery.util.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rafael Augusto
 */
public class DAOPedido implements InterfacePedido{

    /**
     * INSERI O UM NOVO PEDIDO NO BANCO DE DADOS
     * @param pedido - OBJETO A SER INSERIDO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void inserir(Pedido pedido) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "INSERT INTO Pedido (Telefone,Valor_Total,Obs_Cliente,Dt_Pedido) VALUES (?,?,?,?)";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,pedido.getCliente().getTelefone());
        pstm.setDouble(2,pedido.getValorTotal());
        pstm.setString(3,pedido.getObsCliente());
        pstm.setDate(4,pedido.getDtPedido());
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
     * ALTERA O PEDIDO JÁ CADASTRADO NO BANCO DE DADOS
     * @param pedido - OBJETO A SER ALTERADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(Pedido pedido) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Pedido SET  Valor_Total = ?,"
                + "Obs_Cliente =?,"
                + " WHERE Cod_Pedido = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setDouble(1,pedido.getValorTotal());
        pstm.setString(2,pedido.getObsCliente());
        pstm.setInt(3,pedido.getCodPedido());
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
     * EXCLUI UM OBJETO CADASTRADO NO BANCO DE DADOS
     * @param pedido - OBJETO A SER EXCLUÍDO!
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void excluir(Pedido pedido) throws DAOException, SQLException {
    
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "DELETE FROM Pedido WHERE Cod_Pedido =?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setInt(1,pedido.getCodPedido());
        
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
     * LISTA OS ITENS CADASTRADOS NO BANCO DE DADOS.
     * @return - RETORNA A LISTA CARRAGADA DO BANCO DE DADOS.
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public ArrayList<Pedido> listar() throws DAOException, SQLException {
     
        ArrayList<Pedido> lista = new ArrayList<>();
        Pedido pedido = new Pedido();
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Cod_Pedido, Telefone, Valor_Total, Obs_Cliente, Dt_Pedido FROM Pedido";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
        while(rs.next()){
            pedido.setCodPedido(rs.getInt("Cod_Pedido"));
            pedido.getCliente().setTelefone(rs.getString("Telefone"));
            pedido.setValorTotal(rs.getDouble("Valor_Total"));
            pedido.setObsCliente(rs.getString("Obs_Cliente"));
            pedido.setDtPedido(rs.getDate("Dt_Pedido"));
            lista.add(pedido);
        }
        }
        catch(SQLException ex){
            
        }
        finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return lista;
    }
    /**
     * RASTREIA SE O CÓDIGO DO PEDIDO ESTÁ VÁLIDO!
     * @param pedido - OBJETO A SER CONSULTADO
     * @return - RETORNAR O OBJETO DE CONSULTA.
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public Pedido rastrearCodigoPedido(Pedido pedido) throws DAOException, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Cod_Pedido, Telefone, Valor_Total, Obs_Cliente, Dt_Pedido FROM Pedido WHERE Cod_Pedido = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setInt(1,pedido.getCodPedido());
        
        ResultSet rs = null;
        
        Pedido pedidoCod = new Pedido();
        
        try{
        rs = pstm.executeQuery();
        
        if(rs.next()){
            
            pedidoCod.setCodPedido(rs.getInt("Cod_Pedido"));
            pedidoCod.getCliente().setTelefone(rs.getString("Telefone"));
            pedidoCod.setValorTotal(rs.getDouble("Valor_Total"));
            pedidoCod.setObsCliente(rs.getString("Obs_Cliente"));
            pedidoCod.setDtPedido(rs.getDate("Dt_Pedido"));
            return pedidoCod;
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
