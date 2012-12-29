/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenserver;

import aplikasipesantren.Exception.KitabException;
import aplikasipesantren.Exception.OrangTuaException;
import aplikasipesantren.Exception.SantriException;
import aplikasipesantren.services.GedungDao;
import aplikasipesantren.services.KamarDao;
import aplikasipesantren.services.KelasDao;
import aplikasipesantren.services.KitabDao;
import aplikasipesantren.services.OrangTuaDao;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantren.services.SantriDao;
import aplikasipesantren.services.UstadzDao;
import aplikasipesantrenserver.exception.RegisterException;
import aplikasipesantrenserver.model.GedungDaoImpl;
import aplikasipesantrenserver.model.KamarDaoImpl;
import aplikasipesantrenserver.model.KelasDaoImpl;
import aplikasipesantrenserver.model.KitabDaoImpl;
import aplikasipesantrenserver.model.OrangTuaDaoImpl;
import aplikasipesantrenserver.model.PelajaranDaoImpl;
import aplikasipesantrenserver.model.SantriDaoImpl;
import aplikasipesantrenserver.model.UstadzDaoImpl;
import aplikasipesantrenserver.services.KoneksiServer;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Saddam
 */
public class AplikasiPesantrenServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, RemoteException, OrangTuaException, SantriException, SantriException, KitabException, RegisterException {
        KoneksiServer registry = new KoneksiServer();
        
        
        
        
        GedungDao gedungService = new GedungDaoImpl();
        KamarDao kamarService = new KamarDaoImpl();
        KelasDao kelasService = new KelasDaoImpl();
        KitabDao kitabService = new KitabDaoImpl();
        OrangTuaDao orangTuaService = new OrangTuaDaoImpl();
        PelajaranDao pelajaranService = new PelajaranDaoImpl();
        SantriDao santriService = new SantriDaoImpl();
        UstadzDao ustadzService = new UstadzDaoImpl();
        
        registry.getRegistry().rebind("gedung", gedungService);
        registry.getRegistry().rebind("kamar", kamarService);
        registry.getRegistry().rebind("kelas", kelasService);
        registry.getRegistry().rebind("kitab", kitabService);
        registry.getRegistry().rebind("orangtua", orangTuaService);
        registry.getRegistry().rebind("pelajaran", pelajaranService);
        registry.getRegistry().rebind("santri", santriService);
        registry.getRegistry().rebind("ustadz", ustadzService);
        
    }
}
