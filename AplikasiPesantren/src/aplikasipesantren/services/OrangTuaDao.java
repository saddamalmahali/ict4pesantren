/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.OrangTuaException;
import aplikasipesantren.entity.OrangTua;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface OrangTuaDao extends Remote {
    public void insertOrangTua(OrangTua ortu)throws RemoteException, OrangTuaException;
    public void updateOrangTua(int id, OrangTua ortu)throws RemoteException, OrangTuaException;
    public void deleteOrangTua(int id)throws RemoteException, OrangTuaException;
    public List<OrangTua> getAllOrangTua()throws RemoteException, OrangTuaException;
}
