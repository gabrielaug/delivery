/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.negocio;

import delivery.basica.Produto;
import delivery.interfaces.InterfaceProduto;
import delivery.repositorio.DAOProduto;
import delivery.util.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public class RNProduto implements InterfaceProduto{

    DAOProduto dao;
    
    /**
     * CONSTRUTOR PADRÃO
     */
    public RNProduto(){
        
        dao = new DAOProduto();
        
    }
    
    /**
     * METODO USADO PARA VALIDAR O OBJETO ANTES DE INSERIR NO BANCO
     * @param produto OBJETO A SER VALIDADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void inserir(Produto produto) throws DAOException, SQLException {
        
        if(validarAtributos(produto)){
            
            dao.inserir(produto);
            
        }
           
    }

    /**
     * METODO USADO PARA ALTERAR UM OBJETO DO BANCO DE DADOS
     * @param produto OBJETO A SER VALIDADO ANTES DE SER ALTERADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(Produto produto) throws DAOException, SQLException {
        
        
        if(dao.consultarProdutoExiste(produto)){
            
        if(validarAtributos(produto)){
        
            dao.alterar(produto);
            
        }    
            
            
        }else{
            throw new DAOException("Produto Não Cadastrado");
        }
        
        
    }

    /**
     * METODO USADO PARA VALIDAR ANTES DE EXCLUIR O OBJETO NO BANCO
     * @param produto OBJETO A SER VALIDADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void excluir(Produto produto) throws DAOException, SQLException {
        
        if(dao.consultarProdutoExiste(produto)){
            
            dao.excluir(produto);
        }else{
            throw new DAOException("Produto Não Existe");
        }
        
        
    }

    /**
     * METODO USADO PARA VALIDAR ANTES DE LISTAR OS PRODUTOS
     * @return RETORNA A LISTA DE PRODUTOS
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public ArrayList<Produto> listar() throws DAOException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * METODO USADO PARA VALIDAR OS ATRIBUTOS DE PRODUTO
     * @param produto OBJETO A SER VALIDADO
     * @return RETORNA TRUE SE FOI VALIDADO COM SUCESSO
     * @throws DAOException 
     */
    public boolean validarAtributos(Produto produto) throws DAOException{
        
        if(produto.getDescricao().trim().isEmpty() || produto.getDescricao().equalsIgnoreCase("")){
            throw new DAOException("Nome do Produto não pode ser nulo ou branco"); 
        }
        
        if(produto.getDescricao().length() > 60){
            throw new DAOException("Caracter de Nome ddo Produto Excedido : 60");
        }
        
        if(produto.getValor() > 99999999.99){
            throw new DAOException("Valor maximo Excedido");
            
        }
        
        
        return true;
    }
    
    
    
}
