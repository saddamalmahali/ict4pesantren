/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;

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
        Registry r = LocateRegistry.getRegistry("127.0.0.1", 4444);
        
        
        PelajaranDao dao = (PelajaranDao) r.lookup("pelajaran");
        
        Pelajaran p = new Pelajaran();
        p.setId(101);
        p.setIdKelas(1001);
        p.setIdKitab(1002);
        
        dao.insertPelajaran(p);
        
    }
    
    
}
