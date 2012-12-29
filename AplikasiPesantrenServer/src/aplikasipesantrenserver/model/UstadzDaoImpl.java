/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.UstadzException;
import aplikasipesantren.entity.Ustadz;
import aplikasipesantren.services.UstadzDao;
import aplikasipesantrenserver.util.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
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

public class UstadzDaoImpl extends UnicastRemoteObject implements UstadzDao{
    private Connection conn;
    private String qInsert = "INSERT INTO USTADZ (id, id_kelas, gelar_dpn, gelar_blk, nama_depan, nama_belakang, jenis_kelamin,"
            + "tempat_lahir, tanggal_lahir, alamat, no_telp, no_hp, email, website) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String qUpdate = "UPDATE USTADZ SET id_kelas=?, gelar_dpd=?, gelar_blk=?, nama_depan=?, "
            + "nama_belakang=?, jenis_kelamin=?, tempat_lahir=?, tanggal_lahir=?, alamat=?, no_telp=?, "
            + "no_hp=?, email=?, website=? where id=?";
    private String qDelete = "DELETE FROM USTADZ where id=?";
    private String qGetAll = "SELECT * FROM USTADZ";
    
    public UstadzDaoImpl()throws RemoteException, SQLException{
        if(conn==null){
            this.conn=Koneksi.getConn();
        }else{
            return;
        }
        
    }
    
    @Override
    public void insertUstadz(Ustadz ustadz) throws RemoteException, UstadzException {
        
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, ustadz.getId());
            pstat.setInt(2, ustadz.getIdKelas());
            pstat.setString(3, ustadz.getGelarDepan());
            pstat.setString(4, ustadz.getGelarBelakang());
            pstat.setString(5, ustadz.getNamaDepan());
            pstat.setString(6, ustadz.getNamaBelakang());
            pstat.setBoolean(7, ustadz.isJenisKelamin());
            pstat.setString(8, ustadz.getTempatLahir());
            pstat.setDate(9, new Date(ustadz.getTanggalLahir().getDate()));
            pstat.setString(10, ustadz.getAlamat());
            pstat.setString(11, ustadz.getNoTelp());
            pstat.setString(12, ustadz.getNoHp());
            pstat.setString(13, ustadz.getEmail());
            pstat.setString(14, ustadz.getWebsite());
        
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal menambahkan Ustadz dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
            
        }
    }

    @Override
    public void updateUstadz(int id, Ustadz ustadz) throws RemoteException, UstadzException{
        
        PreparedStatement pstat = null;
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
        
            pstat.setInt(1, ustadz.getIdKelas());
            pstat.setString(2, ustadz.getGelarDepan());
            pstat.setString(3, ustadz.getGelarBelakang());
            pstat.setString(4, ustadz.getNamaDepan());
            pstat.setString(5, ustadz.getNamaBelakang());
            pstat.setBoolean(6, ustadz.isJenisKelamin());
            pstat.setString(7, ustadz.getTempatLahir());
            pstat.setDate(8, new Date(ustadz.getTanggalLahir().getDate()));
            pstat.setString(9, ustadz.getAlamat());
            pstat.setString(10, ustadz.getNoTelp());
            pstat.setString(11, ustadz.getNoHp());
            pstat.setString(12, ustadz.getEmail());
            pstat.setString(13, ustadz.getWebsite());
            pstat.setInt(14, ustadz.getId());
        
            pstat.executeUpdate();
            
            conn.commit(); 
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal merubah ustadz dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deleteUstadz(int id) throws RemoteException, UstadzException {
        
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
            throw new UstadzException("Gagal menghapus ustadz dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
        
    }

    @Override
    public List<Ustadz> getAllUstadz() throws RemoteException, UstadzException {
        
        Statement s = null;
        List<Ustadz> listUstadz = null;
        ResultSet rs = null;
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            listUstadz = new ArrayList<Ustadz>();
            rs = s.executeQuery(qGetAll);
            while(rs.next()){
                Ustadz ustadz = new Ustadz();
                ustadz.setId(rs.getInt("id"));
                ustadz.setIdKelas(rs.getInt("id_kelas"));
                ustadz.setGelarDepan(rs.getString("gelar_dpn"));
                ustadz.setGelarBelakang(rs.getString("gelar_blk"));
                ustadz.setNamaDepan(rs.getString("nama_depan"));
                ustadz.setNamaBelakang(rs.getString("nama_belakang"));
                ustadz.setJenisKelamin(rs.getBoolean("jenis_kelamin"));
                ustadz.setTempatLahir(rs.getString("tempat_lahir"));
                ustadz.setTanggalLahir(rs.getDate("tanggal_lahir"));
                ustadz.setAlamat(rs.getString("alamat"));
                ustadz.setNoTelp(rs.getString("no_telp"));
                ustadz.setNoHp(rs.getString("no_hp"));
                ustadz.setEmail(rs.getString("email"));
                ustadz.setWebsite(rs.getString("website"));
                listUstadz.add(ustadz);
                
                
        }
        
        
        conn.commit();
        return listUstadz;
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new UstadzException("Gagal mengambil list ustadz dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
            } catch (SQLException ex) {
                
            }
            
        }
    }
    
}
