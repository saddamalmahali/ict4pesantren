/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.entity.OrangTua;
import aplikasipesantren.services.OrangTuaDao;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Saddam
 */
public class OrangTuaDaoImpl implements OrangTuaDao{

    @Override
    public void insertOrangTua(OrangTua ortu) throws RemoteException, SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateOrangTua(int id, OrangTua ortu) throws RemoteException, SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteOrangTua(int id) throws RemoteException, SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<OrangTua> getAllOrangTua() throws RemoteException, SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
