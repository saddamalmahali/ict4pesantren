/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.KitabException;
import aplikasipesantren.entity.Kitab;
import aplikasipesantren.services.KitabDao;
import aplikasipesantrenserver.util.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saddam
 */
public class KitabDaoImpl extends UnicastRemoteObject implements KitabDao{
    
    private Connection conn = null;
    private final String qInsert = "INSERT INTO kitab(id, nama_kitab) VALUES(?,?)";
    private final String qUpdate = "UPDATE KITAB SET nama=? WHERE id=?";
    private final String qDelete = "DELETE FROM kitab where id=?";
    private final String qGetAll = "SELECT * FROM KITAB";

    public KitabDaoImpl() throws RemoteException, SQLException{
        this.conn = Koneksi.getConn();
    }
    
    
    
    @Override
    public void insertKitab(Kitab kitab) throws RemoteException, KitabException {
        
        
        PreparedStatement pstat = null;
        
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, kitab.getId());
            pstat.setString(2, kitab.getNamaKitab());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal menambahkan kitab dengan pesan :"+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void updateKitab(int id, Kitab kitab) throws RemoteException, KitabException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setString(1, kitab.getNamaKitab());
            pstat.setInt(2, id);
            pstat.executeUpdate();
            conn.commit();
            
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal merubah kitab dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deleteKitab(int id) throws RemoteException, KitabException {
        
        PreparedStatement pstat = null;
        
        try{
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, id);
            pstat.executeUpdate();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal menghapus kitab dengan pesan : "+ex.getMessage());
        }finally{
            
        }
    }

    @Override
    public List<Kitab> getAllKitab() throws RemoteException, KitabException {
        
        
        Statement statement = null;
        List<Kitab> kitab = null;
        ResultSet rs = null;
        try{
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            kitab = new ArrayList<Kitab>();
            rs = statement.executeQuery(qGetAll);
            while(rs.next()){
                Kitab kitab1 = new Kitab();
                kitab1.setId(rs.getInt("id"));
                kitab1.setNamaKitab(rs.getString("nama_kitab"));
                kitab.add(kitab1);
            }
            statement.close();
            conn.commit();
            return kitab;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KitabException("Gagal mengambil list kitab dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                statement.close();
            } catch (SQLException ex) {
                
            }
            
        }
    }
    
}
