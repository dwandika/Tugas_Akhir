package master;

import config.Koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListProduk extends javax.swing.JDialog {

    private Penjualan penjualanForm;

    public ListProduk(Penjualan penjualanForm, DefaultTableModel model) {
        this.penjualanForm = penjualanForm;
        initComponents();
        tbDatapenjualan.setModel(model);
    }

    void tampilTabelproduk() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Produk");
        model.addColumn("Kategori");
        model.addColumn("Harga");

        try {
            String sql = "SELECT * FROM produk";
            Connection conn = Koneksi.ConfigDB();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_produk");
                String namaProduk = resultSet.getString("nama_produk");
                String idKategori = resultSet.getString("id_kategori");
                String harga = resultSet.getString("harga");
                Object[] rowdata = {idProduk, namaProduk, namaKategori(idKategori), harga};
                model.addRow(rowdata);
            }
            tbDatapenjualan.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String namaKategori(String idKategori) {
        try {
            String sql = "SELECT nama_kategori FROM kategori WHERE id_kategori = ?";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idKategori);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("nama_kategori");
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    private void pencarianProduk(String cariProduk) {
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
            tampilTabelproduk();
            JOptionPane.showMessageDialog(null, "Produk tidak ditemukan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatapenjualan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbDatapenjualanMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDatapenjualan);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 66, 123));
        jLabel1.setText("LIST MENU");

        tCari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tCariMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(993, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(680, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDatapenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatapenjualanMouseClicked
        int selectedRow = tbDatapenjualan.getSelectedRow();
        if (selectedRow >= 0) {
            String idProduk = tbDatapenjualan.getValueAt(selectedRow, 0).toString();
            String namaProduk = tbDatapenjualan.getValueAt(selectedRow, 1).toString();
            String hargaProduk = tbDatapenjualan.getValueAt(selectedRow, 2).toString();

            penjualanForm.setProduk(idProduk, namaProduk, hargaProduk);
            this.dispose(); // Close the ListProduk dialog
        }
    }//GEN-LAST:event_tbDatapenjualanMouseClicked

    private void tbDatapenjualanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatapenjualanMousePressed

    }//GEN-LAST:event_tbDatapenjualanMousePressed

    private void tCariMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCariMousePressed
        String cariProduk = tCari.getText();
        pencarianProduk(cariProduk);
    }//GEN-LAST:event_tCariMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProduk(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField tCari;
    public javax.swing.JTable tbDatapenjualan;
    // End of variables declaration//GEN-END:variables
}
