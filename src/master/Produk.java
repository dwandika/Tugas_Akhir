package master;

import Perbarui.FromPerbaruiProduk;
import config.Koneksi;
import Inputan.FromInputProduk;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Produk extends javax.swing.JPanel {

    public Produk() {
        initComponents();
        tampilTabelproduk();

    }
    String id, nama, Kategori, harga;
    int baris;

    void tampilTabelproduk() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Harga");

        try {
            String sql = "SELECT * FROM produk";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_produk");
                String namaProduk = resultSet.getString("nama_produk");
                String idKategori = resultSet.getString("id_kategori");
                String harga = resultSet.getString("harga");
                Object[] rowdata = {idProduk, namaProduk, namaKategori(idKategori), harga};
                model.addRow(rowdata);
            }
            tbDataProduk.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String namaKategori(String idKategori) {
        try {
            String sql = "SELECT nama_kategori FROM kategori WHERE id_kategori = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idKategori);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("nama_kategori");
            }

        } catch (Exception e) {
            return "";
        }
        return "";
    }

    void cari() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Harga");

        String cari = tCari.getText();
        model.removeRow(0);

        try {
            String sql = "SELECT * FROM produk WHERE nama_produk LIKE ? ";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + cari + "%");
            statement.execute();
            java.sql.ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_produk");
                String namaProduk = resultSet.getString("nama_produk");
                String idKategori = resultSet.getString("id_kategori");
                String harga = resultSet.getString("harga");
                Object[] rowdata = {idProduk, namaProduk, namaKategori(idKategori), harga};
                model.addRow(rowdata);
            }
            tbDataProduk.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilTabelproduk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bTambah = new javax.swing.JButton();
        bPerbarui = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDataProduk = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 66, 123));
        jLabel1.setText("DATA MENU");

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
        tCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariActionPerformed(evt);
            }
        });
        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tCariKeyReleased(evt);
            }
        });

        tbDataProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDataProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataProdukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDataProduk);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Food_2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 499, Short.MAX_VALUE)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(bPerbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        tampilTabelproduk();
        new FromInputProduk().setVisible(true);

    }//GEN-LAST:event_bTambahActionPerformed

    private void bPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPerbaruiActionPerformed

        if (baris != -1) {

            FromPerbaruiProduk fI = new FromPerbaruiProduk();
            fI.tNamaProduk.setText(nama);
            fI.tHarga.setText(harga);
            fI.tKategori.setSelectedItem(Kategori);
            fI.tID.setText(id);
            fI.tID.setEditable(false);
            fI.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Pilih Produk yang di Perbarui");
        }
        tampilTabelproduk();

    }//GEN-LAST:event_bPerbaruiActionPerformed


    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed

        try {
            String sql = "DELETE FROM produk WHERE id_produk = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Hapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        tampilTabelproduk();
    }//GEN-LAST:event_bHapusActionPerformed

    private void tbDataProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataProdukMouseClicked
        baris = tbDataProduk.rowAtPoint(evt.getPoint());
        id = tbDataProduk.getValueAt(baris, 0).toString();
        nama = tbDataProduk.getValueAt(baris, 1).toString();
        Kategori = tbDataProduk.getValueAt(baris, 2).toString();
        harga = tbDataProduk.getValueAt(baris, 3).toString();
        
    }//GEN-LAST:event_tbDataProdukMouseClicked

    private void tCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyReleased

    }//GEN-LAST:event_tCariKeyReleased

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        cari();
    }//GEN-LAST:event_tCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bPerbarui;
    private javax.swing.JButton bTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tCari;
    public javax.swing.JTable tbDataProduk;
    // End of variables declaration//GEN-END:variables

}
