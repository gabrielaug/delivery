/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.util;

import javax.swing.JOptionPane;

/**
 *
 * @author gaugusto
 */
public class DAOException extends Exception {
    
    public DAOException(){
        
    }
    
    public DAOException(String x){
        JOptionPane.showMessageDialog(null, x);
    }
    
}
