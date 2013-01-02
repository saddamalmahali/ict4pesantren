/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.registry;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Saddam
 */
public class RegisterKamar {
    static Registry r = null;
    
    public static Registry getRegistryKamar(){
        if(r==null){
            
        }
        return r;
    }
}
