/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenclient.model.PelajaranModel;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;




/**
 *
 * @author Saddam
 */

public class AplikasiPesantrenClient {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, PelajaranException, AccessException, NotBoundException {
             String host = "127.0.0.1";
             PelajaranModel model = new PelajaranModel();
            
            
             Pelajaran p = new Pelajaran();
             model.setId(104);
             model.setIdKelas(1002);
             model.setIdKitab(1004);
             model.setHost(host);
             model.setPort(4444);
             model.getPelajaran();
    }
    
    
}
