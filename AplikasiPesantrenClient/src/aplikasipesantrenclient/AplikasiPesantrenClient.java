/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.Exception.KamarException;
import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Gedung;
import aplikasipesantren.entity.Kamar;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.KamarDao;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenclient.model.GedungModel;
import aplikasipesantrenclient.model.KamarModel;
import aplikasipesantrenclient.model.PelajaranModel;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Saddam
 */

public class AplikasiPesantrenClient {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
             KamarModel model = new KamarModel();
             model.setHost("127.0.0.1");
             model.setPort(4444);
        try {
            int idGedung = model.getIdGedung("B").getId();
            System.out.println(idGedung);
        } catch (RemoteException ex) {
            Logger.getLogger(AplikasiPesantrenClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(AplikasiPesantrenClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GedungException ex) {
            Logger.getLogger(AplikasiPesantrenClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
