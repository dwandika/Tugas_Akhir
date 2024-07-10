package master;



import Inputan.FromInputKaryawan;
import config.Koneksi;
import Perbarui.FromPerbaruiKaryawan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Karyawan extends javax.swing.JPanel {

    public Karyawan() {
        initComponents();
        tampilTabelkaryawan();
    }
    String id, nama,user,alamat,tlp;
    int baris;

    void tampilTabelkaryawan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Karyawan");
        model.addColumn("Nama Karyawan");
        
       
        try {
            String sql = "SELECT * FROM karyawan";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_karyawan"), resultSet.getString("nama_karyawan")});

            }
            tbDataKaryawan.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
            }
void pencarianProduk(String cariProduk) {
        try {
            String sql = "SELECT * FROM karyawan WHERE nama_karyawan LIKE ?";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + cariProduk + "%");
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Karyawan");
            model.addColumn("Nama Karyawan");
            
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_karyawan"), resultSet.getString("nama_karyawan")});
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilTabelkaryawan();
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
        tbDataKaryawan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 66, 123));
        jLabel1.setText("DATA KARYAWAN");

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

        tbDataKaryawan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbDataKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDataKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDataKaryawan);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Waiter_1.png"))); // NOI18N

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bTambah)
                                .addGap(18, 18, 18)
                                .addComponent(bPerbarui)
                                .addGap(18, 18, 18)
                                .addComponent(bHapus))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)))
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
        tampilTabelkaryawan();
        new FromInputKaryawan().setVisible(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPerbaruiActionPerformed
        
        if (baris != -1) {

            tampilTabelkaryawan();
            FromPerbaruiKaryawan fI = new FromPerbaruiKaryawan();
            fI.tNamaKaryawan.setText(nama);
            fI.tId.setText(id);
           fI.tId.setEditable(false);
           
            fI.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Pilih Produk yang di Perbarui");
        }


    }//GEN-LAST:event_bPerbaruiActionPerformed

    private void tbDataKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataKaryawanMouseClicked
         baris = tbDataKaryawan.rowAtPoint(evt.getPoint());
        id = tbDataKaryawan.getValueAt(baris, 0).toString();
        nama = tbDataKaryawan.getValueAt(baris, 1).toString();
        
      
    }//GEN-LAST:event_tbDataKaryawanMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        try {
            String sql = "DELETE FROM karyawan WHERE id_karyawan = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Hapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilTabelkaryawan();
    }//GEN-LAST:event_bHapusActionPerformed

    private void tCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyReleased
        
        pencarianProduk(tCari.getText());
    }//GEN-LAST:event_tCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bPerbarui;
    private javax.swing.JButton bTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTable tbDataKaryawan;
    // End of variables declaration//GEN-END:variables
}
