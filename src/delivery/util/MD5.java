/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Gabriel Augusto
 */
public class MD5 {
    
    /**
     * METODO USADO PARA CONVERTER A SENHA EM MD5
     * @param senha SENHA A SER CONVERTIDA
     * @return RETORNA A SENHA CRIPTOGRAFADA
     * @throws NoSuchAlgorithmException 
     */
    public String converter(String senha) throws NoSuchAlgorithmException{
        String s= senha;
       MessageDigest m = MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length()); 
       return new BigInteger(1,m.digest()).toString(16);
    }
    
}
