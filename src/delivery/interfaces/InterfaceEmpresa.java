/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.interfaces;

import delivery.basica.Empresa;
import delivery.util.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Augusto
 */
public interface InterfaceEmpresa {
    //public void inserir(Empresa empresa)throws DAOException, SQLException;
    public void alterar(Empresa empresa)throws DAOException, SQLException;
    //public void excluir(Empresa empresa)throws DAOException, SQLException;
    public ArrayList<Empresa> listar() throws DAOException, SQLException;
}
