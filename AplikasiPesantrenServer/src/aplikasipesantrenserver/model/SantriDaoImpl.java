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
import java.sql.SQLException;
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
            Blob image = (Blob) santri.getFoto().getImage();
            pstat.setBlob(16, image);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteSantri(int id) throws RemoteException, SantriException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Santri> getAllSantri() throws RemoteException, SantriException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
