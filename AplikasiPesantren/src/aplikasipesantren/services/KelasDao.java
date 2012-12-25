/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.KelasException;
import aplikasipesantren.entity.Kelas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface KelasDao extends Remote{
    public void insertKelas(Kelas kelas)throws RemoteException, KelasException;
    public void updateKelas(int id, Kelas kelas)throws RemoteException, KelasException;
    public void deleteKelas(int id)throws RemoteException, KelasException;
    public List<Kelas> getAllKelas()throws RemoteException, KelasException;
}
