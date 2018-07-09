/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.repositorio;

import delivery.basica.Pedido;
import delivery.interfaces.InterfacePedido;
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
public class DAOPedido implements InterfacePedido{

    /**
     * INSERI O UM NOVO PEDIDO NO BANCO DE DADOS
     * @param pedido - OBJETO A SER INSERIDO
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void inserir(Pedido pedido) throws Exception, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "INSERT INTO Pedido (CPF,Valor_Total,Obs_Cliente,Dt_Pedido) VALUES (?,?,?,?)";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,pedido.getCpf());
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
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void alterar(Pedido pedido) throws Exception, SQLException {
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "UPDATE Pedido SET CPF = ?,"
                + "Valor_Total = ?,"
                + "Obs_Cliente =?,"
                + "Dt_Pedido =? WHERE Cod_Pedido = ?";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        pstm.setString(1,pedido.getCpf());
        pstm.setDouble(2,pedido.getValorTotal());
        pstm.setString(3,pedido.getObsCliente());
        pstm.setDate(4,pedido.getDtPedido());
        pstm.setInt(5,pedido.getCodPedido());
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
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public void excluir(Pedido pedido) throws Exception, SQLException {
    
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
     * @throws Exception
     * @throws SQLException 
     */
    @Override
    public ArrayList<Pedido> listar() throws Exception, SQLException {
     
        ArrayList<Pedido> lista = new ArrayList<>();
        Pedido pedido = new Pedido();
        
        Connection con = Conexao.getInstance().getConnection();
        
        String sql = "SELECT Cod_Pedido, CPF, Valor_Total, Obs_Clientem Dt_Pedido FROM Pedido";
        
        PreparedStatement pstm;
        pstm = con.prepareStatement(sql);
        ResultSet rs = null;
        
        try{
        rs = pstm.executeQuery();
        
        while(rs.next()){
            pedido.setCodPedido(rs.getInt("Cod_Pedido"));
            pedido.setCpf(rs.getString("CPF"));
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
    
   
    
}
