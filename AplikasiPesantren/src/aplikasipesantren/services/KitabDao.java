/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.KitabException;
import aplikasipesantren.entity.Kitab;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface KitabDao extends Remote{
    public void insertKitab(Kitab kitab)throws RemoteException, KitabException;
    public void updateKitab(int id, Kitab kitab)throws RemoteException, KitabException;
    public void deleteKitab(int id)throws RemoteException, KitabException;
    public List<Kitab> getAllKitab()throws RemoteException, KitabException;
}
