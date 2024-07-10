package Inputan;


import config.Koneksi;
import master.Produk;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class FromInputProduk extends javax.swing.JDialog {

    public FromInputProduk() {
       
        initComponents();
        comboKategori();
        reset();
        autoKode();
    }

    void reset() {

        tNamaProduk.setText(null);
        tHarga.setText(null);
        tKategori.setSelectedItem("Pilih Kategori");

    }

    void comboKategori() {
        try {
            String sql = "SELECT * FROM kategori";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tKategori.addItem(resultSet.getString("nama_kategori"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void autoKode() {
       
        try {
            String sql = "SELECT MAX(RIGHT(id_produk,4)) AS no_auto FROM produk";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String no_auto = Integer.toString(resultSet.getInt(1) + 1);
                String nol_puls = "";
                int p = no_auto.length();
                for (int i = 1; i < 5 - p; i++) {
                    nol_puls = nol_puls + "0";
                }
                tID.setText("P" + nol_puls + no_auto);
                tID.setEditable(false);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    String idKategori(String namaKategori) {
        try {
            String sql = "SELECT id_kategori FROM kategori WHERE nama_kategori = ?";
            java.sql.Connection conn = Koneksi.ConfigDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, namaKategori);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("id_kategori");
            }

        } catch (Exception e) {
            return "";
        }
        return "";
    }


    boolean validasi() {
        boolean valid = false;
        if (tNamaProduk.getText().trim().isEmpty() && tHarga.getText().trim().isEmpty() && tKategori.getSelectedItem().equals("Pilih Kategori")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        } else if (tNamaProduk.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Produk Tidak Boleh Kosong");
        } else if (tHarga.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harga Tidak Boleh Kosong");
        } else if (tKategori.getSelectedItem().equals("Pilih Kategori")) {
            JOptionPane.showMessageDialog(null, "Kategori Tidak Boleh Kosong");
        } else {
            valid = true;
        }
        return valid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lLabelAtas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tNamaProduk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tHarga = new javax.swing.JTextField();
        tKategori = new javax.swing.JComboBox<>();
        bTambah = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(252, 66, 123));

        lLabelAtas.setBackground(new java.awt.Color(255, 255, 255));
        lLabelAtas.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lLabelAtas.setForeground(new java.awt.Color(255, 255, 255));
        lLabelAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lLabelAtas.setText("TAMBAH DATA MENU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lLabelAtas, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lLabelAtas)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setText("Nama Produk");

        tNamaProduk.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tNamaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaProdukActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Kategori");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setText("Harga");

        tHarga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        tKategori.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kategori" }));

        bTambah.setBackground(new java.awt.Color(252, 66, 123));
        bTambah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bTambah.setForeground(new java.awt.Color(255, 255, 255));
        bTambah.setText("SIMPAN");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bBatal.setBackground(new java.awt.Color(252, 66, 123));
        bBatal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bBatal.setForeground(new java.awt.Color(255, 255, 255));
        bBatal.setText("BATAL");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Produk");

        tID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(bTambah)
                                .addGap(33, 33, 33)
                                .addComponent(bBatal)
                                .addGap(146, 146, 146))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tID)
                                    .addComponent(tHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNamaProduk)
                                    .addComponent(tKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bBatal))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIDActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed

        new Produk().setVisible(true);
        dispose();
    }//GEN-LAST:event_bBatalActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed

        if (validasi() == true) {

            String idProduk = tID.getText();
            String namaProduk = tNamaProduk.getText();
            String kategori = idKategori(tKategori.getSelectedItem().toString());
            long Harga = Long.parseLong(tHarga.getText());

            try {
                String sql = "INSERT INTO produk(id_produk,nama_produk,harga,id_kategori) VALUES(?,?,?,?)";
                java.sql.Connection conn = Koneksi.ConfigDB();
                java.sql.PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, idProduk);
                statement.setString(2, namaProduk);
                statement.setLong(3, Harga);
                statement.setString(4, kategori);
                statement.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

            reset();
            autoKode();
        }
    }//GEN-LAST:event_bTambahActionPerformed

    private void tNamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaProdukActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 5);
            UIManager.put("TextComponent.arc", 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lLabelAtas;
    public javax.swing.JTextField tHarga;
    public javax.swing.JTextField tID;
    public javax.swing.JComboBox<String> tKategori;
    public javax.swing.JTextField tNamaProduk;
    // End of variables declaration//GEN-END:variables
}
