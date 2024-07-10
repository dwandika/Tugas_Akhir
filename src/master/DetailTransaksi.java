package master;

import java.sql.Connection;
import config.Koneksi;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetailTransaksi extends javax.swing.JFrame {

    private String idPenjualan;

    public DetailTransaksi(String IdPenjualan) {
        this.idPenjualan = IdPenjualan;
        initComponents();
        tampilDetailTransaksi();
    }

    private BigDecimal getTotalSales(String idPenjualan) {
        BigDecimal totalSales = BigDecimal.ZERO;
        String sql = "SELECT SUM(subtotal) AS total FROM detail_penjualan WHERE id_penjualan = ?";
        try (Connection conn = Koneksi.ConfigDB(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, idPenjualan);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    totalSales = resultSet.getBigDecimal("total");
                    if (totalSales == null) {
                        totalSales = BigDecimal.ZERO;
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        return totalSales;
    }

    private void tampilDetailTransaksi() {
        try {
            String sql = "SELECT d.id_penjualan, d.jumlah, d.harga_satuan, d.subtotal, p.nama_produk FROM detail_penjualan d INNER JOIN produk p ON d.id_produk = p.id_produk WHERE d.id_penjualan = ?";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idPenjualan);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Penjualan");
            model.addColumn("Nama Produk");
            model.addColumn("Jumlah");
            model.addColumn("Harga Satuan");
            model.addColumn("Subtotal");
            model.addColumn("Total");

            String totalSales = getTotalSales(idPenjualan).toString();
            while (resultSet.next()) {
                

                model.addRow(new Object[]{
                    resultSet.getString("id_penjualan"),
                    resultSet.getString("nama_produk"),
                    resultSet.getInt("jumlah"),
                    resultSet.getBigDecimal("harga_satuan"),
                    resultSet.getBigDecimal("subtotal")

                });
            }
            model.addRow(new Object[]{"", "", "", "","", totalSales});
            tbDetailTransaksi.setModel(model);

        } catch (SQLException e) {
            Logger.getLogger(DetailTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void pencarianProduk(String cariProduk) {
        try {
            String sql = "SELECT * FROM produk WHERE nama_produk LIKE ?";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + cariProduk + "%");
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Produk");
            model.addColumn("Nama Produk");
            model.addColumn("Harga");
            model.addColumn("Kategori");
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_produk"), resultSet.getString("nama_produk"), resultSet.getBigDecimal("harga"), resultSet.getString("id_kategori")});
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetailTransaksi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbDetailTransaksi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbDetailTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetailTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetailTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetailTransaksi);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 66, 123));
        jLabel1.setText("DETAIL PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1158, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel1)
                            .addGap(889, 889, 889)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1142, 775));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbDetailTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetailTransaksiMouseClicked

    }//GEN-LAST:event_tbDetailTransaksiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDetailTransaksi;
    // End of variables declaration//GEN-END:variables
}
