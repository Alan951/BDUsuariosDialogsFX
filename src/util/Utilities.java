
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Jorge Alan Villalon Perez
 */
public class Utilities {
    public static String cifrarDatos(String dato){
        byte[] digest = null;
        byte[] buffer = dato.getBytes();
        
        try{
            MessageDigest mensajeDigest = MessageDigest.getInstance("MD5");
            mensajeDigest.reset();
            mensajeDigest.update(buffer);
            digest = mensajeDigest.digest();
        }catch(NoSuchAlgorithmException nsae){
            nsae.printStackTrace();
        }
        
        return aHexadecimal(digest);
    }
    
    //Este metodo es necesario para cifrarDatos
    public static String aHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest){
            int b = aux & 0xff;
            if(Integer.toHexString(b).length() == 1){
                hash += "0";
            } 
            hash += Integer.toHexString(b);
        }
        return hash;
    }
}
