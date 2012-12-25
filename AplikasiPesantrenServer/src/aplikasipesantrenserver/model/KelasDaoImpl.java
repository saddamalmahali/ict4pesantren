/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.KelasException;
import aplikasipesantren.entity.Kelas;
import aplikasipesantren.services.KelasDao;
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
public class KelasDaoImpl extends UnicastRemoteObject implements KelasDao{
    private Connection conn;
    private final String qInsert = "INSERT INTO KELAS (id, nama_kelas, id_kitab) VALUES(?,?,?)";
    private final String qUpdate = "UPDATE KELAS SET nama_kelas=?, id_kitab = ? WHERE id=?";
    private final String qDelete = "DELETE FROM KELAS WHERE id=?";
    private final String qGetAllKelas = "SELECT * FROM KELAS";
    
    public KelasDaoImpl()throws RemoteException, SQLException{
        conn = Koneksi.getConn();
    }
    
    @Override
    public void insertKelas(Kelas kelas) throws RemoteException, KelasException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, kelas.getId());
            pstat.setString(2, kelas.getNamaKelas());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal menambahkan kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            try {
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void updateKelas(int id, Kelas kelas) throws RemoteException, KelasException {
        
        
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setString(1, kelas.getNamaKelas());
            pstat.setInt(2, kelas.getId());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal mengupdate kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            try {
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deleteKelas(int id) throws RemoteException, KelasException {
        
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
        
            pstat.setInt(1, id);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new KelasException("Gagal menghapus kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            try {
                pstat.close();
            } catch (SQLException ex) {
                
            }
            
        }
    }

    @Override
    public List<Kelas> getAllKelas() throws RemoteException, KelasException {
        
        Statement s = null;
        List<Kelas> kelas1 =null;
        ResultSet rs = null;
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            kelas1 = new ArrayList<Kelas>();
            rs = s.executeQuery(qGetAllKelas);
        
            while(rs.next()){
                Kelas kelas = new Kelas();
                kelas.setId(rs.getInt("id"));
                kelas.setNamaKelas(rs.getString("nama_kelas"));
                kelas1.add(kelas);
            }        
            
            conn.commit();
            
        }catch(SQLException ex){
            try{
             conn.rollback();
            }catch(SQLException exc){
                
            }
            throw new KelasException("Gagal mengambil list kelas dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                
            }
            try{
                rs.close();
                s.close();
            }catch(SQLException ex){
                
            }
        }
        return kelas1;
    }
    
}
