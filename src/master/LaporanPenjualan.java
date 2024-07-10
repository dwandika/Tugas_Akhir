package master;

import config.Koneksi;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LaporanPenjualan extends javax.swing.JPanel {

    public LaporanPenjualan() {
        initComponents();
        tampilTabelPenjualan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bTDetail = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatapenjualan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 66, 123));
        jLabel1.setText("DATA PENJUALAN");

        bTDetail.setBackground(new java.awt.Color(252, 66, 123));
        bTDetail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bTDetail.setForeground(new java.awt.Color(255, 255, 255));
        bTDetail.setText("DETAIL");
        bTDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTDetailActionPerformed(evt);
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

        tbDatapenjualan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbDatapenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDatapenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatapenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDatapenjualan);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Health Graph_1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bTDetail)
                                .addGap(32, 32, 32)
                                .addComponent(bHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 557, Short.MAX_VALUE)
                                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bTDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTDetailActionPerformed
        int selectedRow = tbDatapenjualan.getSelectedRow();
        if (selectedRow != -1) {
            String idPenjualan = tbDatapenjualan.getValueAt(selectedRow, 0).toString();
            new DetailTransaksi(idPenjualan).setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu");
        }
    }//GEN-LAST:event_bTDetailActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        int selectedRow = tbDatapenjualan.getSelectedRow();
        if (selectedRow >= 0) {
            String idPenjualan = tbDatapenjualan.getValueAt(selectedRow, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus transaksi ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    String sql = "DELETE FROM penjualan WHERE id_penjualan = ?";
                    Connection conn = Koneksi.ConfigDB();
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, idPenjualan);
                    statement.executeUpdate();
                    tampilTabelPenjualan();
                    JOptionPane.showMessageDialog(null, "Transaksi berhasil dihapus");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Gagal menghapus transaksi");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus");
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void tbDatapenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatapenjualanMouseClicked
        if (evt.getClickCount() == 2) {
            int selectedRow = tbDatapenjualan.getSelectedRow();
            String idPenjualan = tbDatapenjualan.getValueAt(selectedRow, 0).toString();
            DetailTransaksi detailDialog = new DetailTransaksi( idPenjualan);
            detailDialog.setVisible(true);
        }
    }//GEN-LAST:event_tbDatapenjualanMouseClicked

    private void tCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyReleased
        String cari = tCari.getText();
        pencarianPenjualan(cari);
    }//GEN-LAST:event_tCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTable tbDatapenjualan;
    // End of variables declaration//GEN-END:variables
void tampilTabelPenjualan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Penjualan");
        model.addColumn("Tanggal");
        model.addColumn("Total Harga");
        model.addColumn("ID Karyawan");

        try {
            String sql = "SELECT * FROM penjualan";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_penjualan"), resultSet.getString("tanggal"), resultSet.getBigDecimal("total_harga"), resultSet.getString("id_karyawan")});
            }
            tbDatapenjualan.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data penjualan");
        }
    }

    void pencarianPenjualan(String cari) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Penjualan");
        model.addColumn("Tanggal");
        model.addColumn("Total Harga");
        model.addColumn("ID Karyawan");

        try {
            String sql = "SELECT * FROM penjualan WHERE id_penjualan LIKE ? OR tanggal LIKE ? OR id_karyawan LIKE ?";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + cari + "%");
            statement.setString(2, "%" + cari + "%");
            statement.setString(3, "%" + cari + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_penjualan"), resultSet.getString("tanggal"), resultSet.getBigDecimal("total_harga"), resultSet.getString("id_karyawan")});
            }
            tbDatapenjualan.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal melakukan pencarian data penjualan");
        }
    }
}
