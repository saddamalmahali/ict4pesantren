/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Gedung;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenclient.model.GedungModel;
import aplikasipesantrenclient.model.PelajaranModel;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Saddam
 */

public class AplikasiPesantrenClient {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, PelajaranException, AccessException, NotBoundException, GedungException {
             String host = "127.0.0.1";
             GedungModel model = new GedungModel();
             model.setHost("127.0.0.1");
             model.setPort(4444);
             
             
             
             
    }
    
    
}
