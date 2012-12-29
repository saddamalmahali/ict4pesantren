/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasipesantrenclient.view;

import aplikasipesantren.Exception.PelajaranException;
import aplikasipesantren.entity.Pelajaran;
import aplikasipesantren.services.PelajaranDao;
import aplikasipesantrenclient.controller.PelajaranController;
import aplikasipesantrenclient.entitas.Koneksi;
import aplikasipesantrenclient.model.PelajaranModel;
import aplikasipesantrenclient.model.TabelPelajaranModel;
import aplikasipesantrenclient.model.listener.PelajaranListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Saddam
 */
public class InternalPelajaran extends javax.swing.JInternalFrame implements PelajaranListener, ListSelectionListener{
    private TabelPelajaranModel model;
    private static Registry register;
    private PelajaranModel pModel;
    private PelajaranController controller;
    
    public InternalPelajaran(Registry r) {
        register = r;
    }
    
    
    /**
     * Creates new form InternalPelajaran
     */
    public InternalPelajaran() {
        model = new TabelPelajaranModel();
        initComponents();
        pModel = new PelajaranModel();
        pModel.setHost("localhost");
        pModel.setPort(4444);
        pModel.setListener(this);
        
        controller = new PelajaranController();
        controller.setModel(pModel);
        
        tabelPelajaran.getSelectionModel().addListSelectionListener(this);
        tabelPelajaran.setModel(model);
        loadDatabase();
    }

    public static Registry getRegister() {
        return register;
    }

    public static void setRegister(Registry register) {
        InternalPelajaran.register = register;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtKelasId() {
        return txtKelasId;
    }

    public JTextField getTxtKitab() {
        return txtKitab;
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnTambahKelas = new javax.swing.JButton();
        btnTambahKitab = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtKelasId = new javax.swing.JTextField();
        txtKitab = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPelajaran = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel4 = new javax.swing.JLabel();
        txtDataSeleksi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtJumlahPelajaran = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID :");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kelas :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Kitab :");

        btnTambahKelas.setText("+");
        btnTambahKelas.setToolTipText("Tambah Kelas");

        btnTambahKitab.setText("+");
        btnTambahKitab.setToolTipText("Tambah Kitab");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKelasId)
                    .addComponent(txtKitab, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambahKelas)
                    .addComponent(btnTambahKitab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnTambahKelas)
                    .addComponent(btnEdit)
                    .addComponent(txtKelasId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnTambahKitab)
                    .addComponent(btnHapus)
                    .addComponent(txtKitab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabelPelajaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelPelajaran);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel4.setText("Data Seleksi :");
        jToolBar1.add(jLabel4);

        txtDataSeleksi.setEditable(false);
        jToolBar1.add(txtDataSeleksi);

        jLabel5.setText("    Jumlah Pelajaran :");
        jToolBar1.add(jLabel5);

        txtJumlahPelajaran.setEditable(false);
        jToolBar1.add(txtJumlahPelajaran);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        controller.insertPelajaran(this);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        controller.updatePelajaran(this);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        controller.deletePelajaran(this);
    }//GEN-LAST:event_btnHapusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTambahKelas;
    private javax.swing.JButton btnTambahKitab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabelPelajaran;
    private javax.swing.JTextField txtDataSeleksi;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJumlahPelajaran;
    private javax.swing.JTextField txtKelasId;
    private javax.swing.JTextField txtKitab;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(PelajaranModel model) {
        txtId.setText(String.valueOf(model.getId()));
        txtKelasId.setText(String.valueOf(model.getIdKelas()));
        txtKitab.setText(String.valueOf(model.getIdKitab()));
    }

    @Override
    public void onInsert(Pelajaran pelajaran) {
        model.add(pelajaran);
    }

    @Override
    public void onUpdate(Pelajaran pelajaran) {
        int index = tabelPelajaran.getSelectedRow();
        model.set(index, pelajaran);
    }

    @Override
    public void onDelete() {
        int index = tabelPelajaran.getSelectedRow();
        model.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try{
            Pelajaran m = model.get(tabelPelajaran.getSelectedRow());
            txtId.setText(String.valueOf(m.getId()));
            txtKelasId.setText(String.valueOf(m.getIdKelas()));
            txtKitab.setText(String.valueOf(m.getIdKitab()));
        }catch(IndexOutOfBoundsException ex){
            
        }
    }
    
    public void loadDatabase(){
        try {
            List<Pelajaran> listpelajaran = new ArrayList<Pelajaran>();
            Registry r = LocateRegistry.getRegistry("localhost", 4444);
            PelajaranDao dao = (PelajaranDao) r.lookup("pelajaran");
            listpelajaran = dao.getPelajaran();
            model.setList(listpelajaran);
        } catch (RemoteException ex) {
            Logger.getLogger(InternalPelajaran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PelajaranException ex) {
            Logger.getLogger(InternalPelajaran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(InternalPelajaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
