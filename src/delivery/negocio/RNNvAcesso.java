/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.negocio;

import delivery.basica.NvAcesso;
import delivery.interfaces.InterfaceNvAcesso;
import delivery.repositorio.DAONvAcesso;
import delivery.util.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public class RNNvAcesso implements InterfaceNvAcesso{

    DAONvAcesso dao;
    
    /**
     * CONSTRUTOR
     */
    public RNNvAcesso(){
        dao = new DAONvAcesso();
        
    }
    
    /**
     * METODO USADO PARA VALIDAR ANTES ANTES DE INSERIR UM NVACESSO NO BANCO DE DADOS
     * @param nvAcesso OBJETO A SER VALIDADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void inserir(NvAcesso nvAcesso) throws DAOException, SQLException {
        
        validarAtributos(nvAcesso);
        
        dao.inserir(nvAcesso);
        
    }

    
    /**
     * METODO USADO PARA VALIDAR ANTES DE ALTERAR NVACESSO
     * @param nvAcesso OBJETO A SER VALIDADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void alterar(NvAcesso nvAcesso) throws DAOException, SQLException {
    
    if(!dao.consultarAcessoExiste(nvAcesso)){
        throw new DAOException("Nivel de Acesso não Existe");
    }    
    dao.alterar(nvAcesso);
        
    }

    /**
     * METODO USADO PARA VALIDAR EXISTENCIA ANTES DE EXCLUIR NVACESSO
     * @param nvAcesso OBJETO A SER VALIDADO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public void excluir(NvAcesso nvAcesso) throws DAOException, SQLException {
       
        if(!dao.consultarAcessoExiste(nvAcesso)){
            throw new DAOException("Nivel de Acesso não Existe");
        }
        dao.excluir(nvAcesso);
        
    }

    /**
     * METODO USADO PARA VALIDAR NVACESSO ANTES DE LISTAR
     * @return RETORNA A LISTA DE NVACESSO
     * @throws DAOException
     * @throws SQLException 
     */
    @Override
    public ArrayList<NvAcesso> listar() throws DAOException, SQLException {
        
        
        return dao.listar();
    }
    
    /**
     * METODO USADO PARA VALIDAR OS ATRIBUTOS DO OBJETO NVACESSO
     * @param nvAcesso OBJETO CUJO OS ATRIBUTOS VAO SER VALIDADOS
     * @return RETORNA TRUE SE FOR VALIDADO COM SUCESSO.
     * @throws DAOException 
     */
    public boolean validarAtributos(NvAcesso nvAcesso)throws DAOException{
        
        if(nvAcesso.getDescricao().trim().isEmpty() || nvAcesso.getDescricao().equals("")){
            throw new DAOException("Descrição não pode ser branco ou nulo");
        }
        
        
        return true;
    }
    
}
