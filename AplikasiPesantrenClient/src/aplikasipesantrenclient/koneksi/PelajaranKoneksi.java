/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.koneksi;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saddam
 */
public class PelajaranKoneksi {
    private Registry registry;

    public Registry getKoneksi(String host, int port){
        try {
            registry = LocateRegistry.getRegistry(host, port);
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(PelajaranKoneksi.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return registry;
    }
    
    
}
