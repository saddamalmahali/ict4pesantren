/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.KamarException;
import aplikasipesantren.entity.Kamar;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface KamarDao extends Remote{
    public void insertKamar(Kamar kamar)throws RemoteException, KamarException;
    public void deleteKamar(int id)throws RemoteException, KamarException;
    public List<Kamar> getAllKamar()throws RemoteException, KamarException;
}
