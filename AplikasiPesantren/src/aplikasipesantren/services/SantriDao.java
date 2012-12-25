/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.SantriException;
import aplikasipesantren.entity.Santri;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface SantriDao extends Remote{
    public void insertSantri(Santri santri)throws RemoteException, SantriException;
    public void updateSantri(int id, Santri santri)throws RemoteException, SantriException;
    public void deleteSantri(int id)throws RemoteException, SantriException;
    public List<Santri> getAllSantri()throws RemoteException, SantriException;
}
