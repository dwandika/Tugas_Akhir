package master;

import config.Koneksi;
import Inputan.FromInputKategori;
import Perbarui.FromPerbaruiKategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Kategori extends javax.swing.JPanel {
    
    public Kategori() {
        initComponents();
        tampilTabelKategori();
        
    }
    String id, nama;
    int baris;
    
    void tampilTabelKategori() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Kategori");
        model.addColumn("Nama Kategori");
        try {
            String sql = "SELECT * FROM kategori";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_kategori"), resultSet.getString("nama_kategori")});
                
            }
            tbDataKategori.setModel(model);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void pencarianProduk(String cariProduk) {
        try {
            String sql = "SELECT * FROM kategori WHERE nama_kategori LIKE ?";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + cariProduk + "%");
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID kategori");
            model.addColumn("Nama kategori");
            
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_kategori"), resultSet.getString("nama_kategori")});
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilTabelKategori();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bTambah = new javax.swing.JButton();
        bPerbarui = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataKategori = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 66, 123));
        jLabel1.setText("DATA KATEGORI");

        bTambah.setBackground(new java.awt.Color(252, 66, 123));
        bTambah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bTambah.setForeground(new java.awt.Color(255, 255, 255));
        bTambah.setText("TAMBAH");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bPerbarui.setBackground(new java.awt.Color(252, 66, 123));
        bPerbarui.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bPerbarui.setForeground(new java.awt.Color(255, 255, 255));
        bPerbarui.setText("PERBARUI");
        bPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPerbaruiActionPerformed(evt);
            }
        });

        bHapus.setBackground(new java.awt.Color(252, 66, 123));
        bHapus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bHapus.setForeground(new java.awt.Color(255, 255, 255));
        bHapus.setText("HAPUS");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        tCari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tCariKeyReleased(evt);
            }
        });

        tbDataKategori.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbDataKategori.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDataKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDataKategori);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Restaurant Menu_2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bTambah)
                                .addGap(18, 18, 18)
                                .addComponent(bPerbarui)
                                .addGap(18, 18, 18)
                                .addComponent(bHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(bPerbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        new FromInputKategori().setVisible(true);
        tampilTabelKategori();
    }//GEN-LAST:event_bTambahActionPerformed

    private void bPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPerbaruiActionPerformed
        
        if (baris != 0) {
            
            tampilTabelKategori();
            FromPerbaruiKategori fI = new FromPerbaruiKategori();
            fI.tNamaKategori.setText(nama);
            fI.tId.setText(id);
            fI.tId.setEditable(false);
            fI.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "Pilih Produk yang di Perbarui");
        }
        

    }//GEN-LAST:event_bPerbaruiActionPerformed

    private void tbDataKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataKategoriMouseClicked
        baris = tbDataKategori.rowAtPoint(evt.getPoint());
        id = tbDataKategori.getValueAt(baris, 0).toString();
        nama = tbDataKategori.getValueAt(baris, 1).toString();
    }//GEN-LAST:event_tbDataKategoriMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        try {
            String sql = "DELETE FROM kategori WHERE id_kategori = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Hapus");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilTabelKategori();
    }//GEN-LAST:event_bHapusActionPerformed

    private void tCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyReleased
        String cari = tCari.getText();
        pencarianProduk(cari);
        tampilTabelKategori();
    }//GEN-LAST:event_tCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bPerbarui;
    private javax.swing.JButton bTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTable tbDataKategori;
    // End of variables declaration//GEN-END:variables
}
