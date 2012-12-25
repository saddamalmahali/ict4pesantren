/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver.model;

import aplikasipesantren.Exception.SantriException;
import aplikasipesantren.entity.Santri;
import aplikasipesantren.services.SantriDao;
import aplikasipesantrenserver.util.Koneksi;
import java.rmi.RemoteException;
import java.sql.Blob;
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
import javax.swing.ImageIcon;

/**
 *
 * @author Saddam
 */
public class SantriDaoImpl implements SantriDao{
    
    private Connection conn = null;
    private String qInsert = "INSERT INTO SANTRI (ID, ID_KELAS, NAMA_DEPAN, NAMA_BELAKANG, JENIS_KELAMIN, "
            + "TEMPAT_LAHIR, TANGGAL_LAHIR, ALAMAT, ID_ORANGTUA, NO_TELP, NO_HP, EMAIL, ID_KAMAR, ASAL_SEKOLAH, LULUSAN_TRK, FOTO) VALUES("
            + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String qUpdate = "UPDATE FROM SANTRI SET ID_KELAS=?, NAMA_DEPAN=?, NAMA_BELAKANG=?, JENIS_KELAMIN=?, "
            + "TEMPAT_LAHIR = ?, TANGGAL_LAHIR=?, ALAMAT=?, ID_ORANGTUA=?, NO_TELP=?, NO_HP=?, EMAIL=?, ID_KAMAR=?, ASAL_SEKOLAH=?, "
            + "LULUSAN_TRK=?, FOTO=? WHERE ID=?";
    private String qDelete = "DELETE FROM SANTRI WHERE ID = ?";
    
    private String qGetAll = "SELECT * FROM SANTRI";

    public SantriDaoImpl()throws RemoteException, SantriException{
        if(conn == null){
            try {
                conn = Koneksi.getConn();
            } catch (SQLException ex) {
                throw new SantriException("Gagal menyambung database dengan pesan : "+ex.getMessage());
            }
        }
        return ;
    }
    
    
    
    
    @Override
    public void insertSantri(Santri santri) throws RemoteException, SantriException {
        
        PreparedStatement pstat = null;
        
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qInsert);
            pstat.setInt(1, santri.getId());
            pstat.setInt(2, santri.getId_kelas());
            pstat.setString(3, santri.getNamaDepan());
            pstat.setString(4, santri.getNamaBelakang());
            pstat.setBoolean(5, santri.isJeniskelamin());
            pstat.setString(6, santri.getTempat_lahir());
            pstat.setDate(7, new Date(santri.getTanggalLahir().getDate()));
            pstat.setString(8, santri.getAlamat());
            pstat.setInt(9, santri.getIdOrangTua());
            pstat.setString(10, santri.getNoTelp());
            pstat.setString(11, santri.getNoHp());
            pstat.setString(12, santri.getEmail());
            pstat.setInt(13, santri.getIdKamar());
            pstat.setString(14, santri.getAsalSekolah());
            pstat.setString(15, santri.getLuluasanTerakhir());
            pstat.setBytes(16, santri.getFoto());
            pstat.executeUpdate();
            
            conn.commit();
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new SantriException("Gagal menambahkan santri dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void updateSantri(int id, Santri santri) throws RemoteException, SantriException {
        PreparedStatement pstat = null;
        
        try{
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(qUpdate);
            
            pstat.setInt(1, santri.getId_kelas());
            pstat.setString(2, santri.getNamaDepan());
            pstat.setString(3, santri.getNamaBelakang());
            pstat.setBoolean(4, santri.isJeniskelamin());
            pstat.setString(5, santri.getTempat_lahir());
            pstat.setDate(6, new Date(santri.getTanggalLahir().getDate()));
            pstat.setString(7, santri.getAlamat());
            pstat.setInt(8, santri.getIdOrangTua());
            pstat.setString(9, santri.getNoTelp());
            pstat.setString(10, santri.getNoHp());
            pstat.setString(11, santri.getEmail());
            pstat.setInt(12, santri.getIdKamar());
            pstat.setString(13, santri.getAsalSekolah());
            pstat.setString(14, santri.getLuluasanTerakhir());
            
            pstat.setBytes(15, santri.getFoto());
            pstat.setInt(16, santri.getId());
            pstat.executeUpdate();
            conn.commit();
            
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new SantriException("Gagal mengupdate santri dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                pstat.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    @Override
    public void deleteSantri(int id) throws RemoteException, SantriException {
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
            throw new SantriException("Gagal menghapus santri dengan pesan : "+ex.getMessage());
        }finally{
            
        }
    }

    @Override
    public List<Santri> getAllSantri() throws RemoteException, SantriException {
        Statement s = null;
        ResultSet rs = null;
        List<Santri> listSantri = null;
        
        try{
            conn.setAutoCommit(false);
            s = conn.createStatement();
            rs = s.executeQuery(qGetAll);
            listSantri = new ArrayList<Santri>();
            
            while(rs.next()){
                Santri santri = new Santri();
                santri.setId(rs.getInt("id"));
                santri.setId_kelas(rs.getInt("id_kelas"));
                santri.setNamaDepan(rs.getString("nama_depan"));
                santri.setNamaBelakang(rs.getString("nama_belakang"));
                santri.setJeniskelamin(rs.getBoolean("jenis_kelamin"));
                santri.setTempat_lahir(rs.getString("tempat_lahir"));
                santri.setTanggalLahir(rs.getDate("tanggal_lahir"));
                santri.setAlamat(rs.getString("alamat"));
                santri.setIdOrangTua(rs.getInt("id_orangtua"));
                santri.setNoTelp(rs.getString("no_telp"));
                santri.setNoHp(rs.getString("no_hp"));
                santri.setEmail(rs.getString("email"));
                santri.setIdKamar(rs.getInt("id_kamar"));
                santri.setAsalSekolah(rs.getString("asal_sekolah"));
                santri.setLuluasanTerakhir(rs.getString("lulusan_trk"));
                santri.setFoto(rs.getBytes("foto"));
                
                listSantri.add(santri);
            }
            
            conn.commit();
            
        }catch(SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                
            }
            throw new SantriException("Gagam mengambil list santri dengan pesan : "+ex.getMessage());
        }finally{
            try {
                conn.setAutoCommit(true);
                rs.close();
                s.close();
            } catch (SQLException ex) {
                
            }
        }
        return listSantri;
    }
    
}
