/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenserver.util.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saddam
 */
public class PelajaranDaoImpl extends UnicastRemoteObject implements PelajaranDao {
    
    private Connection conn = null;
    private String qInsert = "INSERT INTO PELAJARAN (ID, ID_KELAS, ID_KITAB) VALUES(?,?,?)";
    private String qUpdate = "UPDATE FROM PELAJARAN SET ID_KELAS=?, ID_KITAB=?, WHERE ID=?";
    
    private String qDelete = "DELETE FROM PELAJARAN WHERE ID=?";
    private String qGetAll = "SELECT * FROM PELAJARAN";
    private String qGetPelajaran = "SELECT * FROM VIEWPELAJARAN";

    public PelajaranDaoImpl() throws RemoteException, SQLException{
        this.conn = Koneksi.getConn();
    }
    
    
    
    
    @Override
    public void insertPelajaran(Pelajaran pelajaran) throws RemoteException, PelajaranException {
        
        PreparedStatement pstat = null;
        
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, pelajaran.getId());
            pstat.setInt(2, pelajaran.getIdKelas());
            pstat.setInt(3, pelajaran.getIdKitab());
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Gagal menambahkan pelajaran dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void updatePelajaran(int id, Pelajaran pelajaran) throws RemoteException, PelajaranException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            pstat.setInt(1, pelajaran.getIdKelas());
            pstat.setInt(2, pelajaran.getIdKitab());
            pstat.setInt(3, id);
            pstat.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Gagal mengupdate pelajaran dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deletePelajaran(int id) throws RemoteException, PelajaranException {
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qDelete);
            pstat.setInt(1, id);
            pstat.executeUpdate();
            conn.commit();
            System.out.println("Berhasil Menghapus Pelajaran dengan id="+id);
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Tidak dapat menghapus pelajaran dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
            
        }
    }

    @Override
    public List<Pelajaran> getPelajaran() throws RemoteException, PelajaranException {
        Statement s = null;
        List<Pelajaran> listPelajaran = null;
        ResultSet rs = null;
        
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetAll);
            
            while(rs.next()){
                Pelajaran pelajaran = new Pelajaran();
                pelajaran.setId(rs.getInt("id"));
                pelajaran.setIdKelas(rs.getInt("id_kelas"));
                pelajaran.setIdKitab(rs.getInt("id_kitab"));
                listPelajaran.add(pelajaran);
            }
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Tidak dapat mengambil list pelajaran dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
            } catch (SQLException ex) {
                
            }
        }
        
        return listPelajaran;
    }

    @Override
    public List<Pelajaran> getPelajaranKelas() throws RemoteException, PelajaranException {
        Statement s = null;
        ResultSet rs = null;
        List<Pelajaran> listPelajaran = null;
        
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetPelajaran);
            
            while(rs.next()){
                Pelajaran pelajaran = new Pelajaran();
                pelajaran.setId(rs.getInt("id"));
                pelajaran.setNamaKelas(rs.getString("nama_kelas"));
                pelajaran.setNamakitab(rs.getString("nama_kitab"));
            }
            
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new PelajaranException("Tidak dapat mengambil list pelajaran dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
            } catch (SQLException ex) {
                
            }
            
        }
        return listPelajaran;
                
    }
    
}
