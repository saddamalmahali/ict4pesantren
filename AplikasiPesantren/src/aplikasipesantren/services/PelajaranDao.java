/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface PelajaranDao extends Remote{
    public void insertPelajaran(Pelajaran pelajaran)throws RemoteException, PelajaranException;
    public void updatePelajaran(int id, Pelajaran pelajaran)throws RemoteException, PelajaranException;
    public void deletePelajaran(int id)throws RemoteException, PelajaranException;
    public List<Pelajaran> getPelajaran()throws RemoteException, PelajaranException;
}
