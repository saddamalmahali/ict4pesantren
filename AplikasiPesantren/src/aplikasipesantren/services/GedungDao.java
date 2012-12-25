/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.GedungException;
import aplikasipesantren.entity.Gedung;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface GedungDao extends Remote{
    public void insertGedung(Gedung gedung)throws RemoteException, GedungException;
    public void updateGedung(int id, Gedung gedung)throws RemoteException, GedungException;
    public void deleteGedung(int id)throws RemoteException, GedungException;
    public List<Gedung> getAllGedung()throws RemoteException, GedungException;
    
}
