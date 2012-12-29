/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantren.services;

import aplikasipesantren.Exception.UstadzException;
import aplikasipesantren.entity.Ustadz;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public interface UstadzDao extends Remote{
    public void insertUstadz(Ustadz ustadz)throws RemoteException, UstadzException;
    public void updateUstadz(int id, Ustadz ustadz)throws RemoteException, UstadzException;
    public void deleteUstadz(int id)throws RemoteException, UstadzException;
    public List<Ustadz> getAllUstadz()throws RemoteException, UstadzException;
}
