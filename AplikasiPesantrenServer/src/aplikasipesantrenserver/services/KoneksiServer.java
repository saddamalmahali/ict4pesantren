/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.services;

import aplikasipesantrenserver.exception.RegisterException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saddam
 */
public class KoneksiServer {
    private static Registry registry;

    public static Registry getRegistry()throws RegisterException{
        if(registry == null){
            try {
                registry = LocateRegistry.createRegistry(4444);
            } catch (RemoteException ex) {
                try {
                    throw new RegisterException("Tidak dapat terkoneksi dengan pesan : "+ex.getMessage());
                } catch (RegisterException ex1) {
                    
                }
            }
        }
        
        return registry;
    }
    
    
    
}
