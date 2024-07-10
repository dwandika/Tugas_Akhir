package master;

import config.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Penjualan extends javax.swing.JPanel {

    private String namaKaryawan;

    public Penjualan(String namaKaryawan) {
        initComponents();
        KodeTR();
        tampilTabelProduk();
        hitungTotalHarga();
        tNamaProduk.setEditable(true);
        bProduk.setEnabled(true);
        this.namaKaryawan = namaKaryawan;
        tNamaKasir.setText(namaKaryawan);
        tNamaKasir.setEditable(false);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        tTanggal.setText(sdf.format(now));
        tHari.setText(getNamaHari(now));
    }

    private String getNamaHari(Date date) {
        String[] days = {"Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        SimpleDateFormat sdf = new SimpleDateFormat("u");
        int dayIndex = Integer.parseInt(sdf.format(date)) - 0;
        return days[dayIndex];
    }

    void KodeTR() {
        Date tgl = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String newtgl = sdf.format(tgl);

        try {
            String sql = "SELECT MAX(RIGHT(id_penjualan,4)) AS no_auto FROM penjualan";
            Connection conn = Koneksi.ConfigDB();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String no_auto = Integer.toString(resultSet.getInt(1) + 1);
                String nol_puls = "";
                int p = no_auto.length();
                for (int i = 1; i < 5 - p; i++) {
                    nol_puls = nol_puls + "0";
                }
                tIdTransaksi.setText("TR" + newtgl + nol_puls + no_auto);
                tIdTransaksi.setEditable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void resetProduk() {
        tIdProduk.setText(null);
        tNamaProduk.setText(null);
        tJumlah.setText(null);
        tHarga.setText(null);
    }

    void resetPembayaran() {
        tTotalHarga.setText("0");
        tBayar.setText(null);
        tKembali.setText("0");
    }

    void tampilTabelProduk() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Subtotal");

        try {
            String sql = "SELECT * FROM trans_sementara";
            Connection conn = Koneksi.ConfigDB();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int no = 1;
            while (resultSet.next()) {
                model.addRow(new Object[]{no++, resultSet.getString("id_barang"), resultSet.getString("nama_brg"), resultSet.getInt("qty"), resultSet.getBigDecimal("harga"), resultSet.getBigDecimal("subtotal")});
            }
            tabSementara.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void hitungTotalHarga() {
        BigDecimal totalHarga = BigDecimal.ZERO;
        for (int i = 0; i < tabSementara.getRowCount(); i++) {
            BigDecimal subtotal = (BigDecimal) tabSementara.getValueAt(i, 5);
            totalHarga = totalHarga.add(subtotal);
        }
        tTotalHarga.setText(totalHarga.toString());
    }

    public void setProduk(String idProduk, String namaProduk, String hargaProduk) {
        tIdProduk.setText(idProduk);
        tNamaProduk.setText(namaProduk);
        tHarga.setText(hargaProduk);
        tJumlah.setText("1");
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
            ListProduk lP = new ListProduk(this, model);
            lP.tCari.setText(cariProduk);
            lP.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    String idKaryawan(String namaKaryawan) {
        try {
            String sql = "SELECT id_karyawan FROM karyawan WHERE nama_karyawan = ?";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, namaKaryawan);
            java.sql.ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("id_karyawan");
            }

        } catch (Exception e) {
            return "";
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tHari = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bProduk = new javax.swing.JButton();
        tNamaProduk = new javax.swing.JTextField();
        tHarga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabSementara = new javax.swing.JTable();
        bPerbarui = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tJumlah = new javax.swing.JTextField();
        bTambah = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tIdProduk = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tIdTransaksi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        tNamaKasir = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        tTotalSemua = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tBayar = new javax.swing.JTextField();
        bSimpan = new javax.swing.JButton();
        bBatalTR = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tTanggal = new javax.swing.JLabel();
        tTotalHarga = new javax.swing.JLabel();
        tKembali = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 66, 123));
        jLabel1.setText("KASIR");

        tHari.setBackground(new java.awt.Color(252, 66, 123));
        tHari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tHari.setForeground(new java.awt.Color(252, 66, 123));
        tHari.setText("Hari");

        jPanel2.setBackground(new java.awt.Color(252, 66, 123));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        bProduk.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bProduk.setText("...");
        bProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProdukActionPerformed(evt);
            }
        });

        tNamaProduk.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tNamaProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNamaProdukKeyReleased(evt);
            }
        });

        tHarga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        tabSementara.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tabSementara.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabSementara);

        bPerbarui.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bPerbarui.setForeground(new java.awt.Color(252, 66, 123));
        bPerbarui.setText("Perbarui");
        bPerbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPerbaruiActionPerformed(evt);
            }
        });

        bHapus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bHapus.setForeground(new java.awt.Color(252, 66, 123));
        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bBatal.setForeground(new java.awt.Color(252, 66, 123));
        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama Produk");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Harga");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Jumlah");

        tJumlah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        bTambah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bTambah.setText("...");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID Produk");

        tIdProduk.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tIdProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tIdProdukKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bPerbarui)
                .addGap(18, 18, 18)
                .addComponent(bHapus)
                .addGap(18, 18, 18)
                .addComponent(bBatal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(tIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bProduk)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bTambah)))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bProduk)
                            .addComponent(tNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bTambah)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bPerbarui)
                    .addComponent(bHapus)
                    .addComponent(bBatal))
                .addGap(50, 50, 50))
        );

        jPanel3.setBackground(new java.awt.Color(252, 66, 123));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tIdTransaksi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tIdTransaksi.setText("ID Transaksi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(252, 66, 123));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tNamaKasir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tNamaKasir.setText("Nama Karyawan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tNamaKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tNamaKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(252, 66, 123));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tTotalSemua.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        tTotalSemua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tTotalSemua.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tTotalSemua, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tTotalSemua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(252, 66, 123));
        jLabel7.setText("Total Harga");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(252, 66, 123));
        jLabel8.setText("Bayar");

        tBayar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tBayarKeyReleased(evt);
            }
        });

        bSimpan.setBackground(new java.awt.Color(252, 66, 123));
        bSimpan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bSimpan.setForeground(new java.awt.Color(255, 255, 255));
        bSimpan.setText("Simpan & Print");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bBatalTR.setBackground(new java.awt.Color(252, 66, 123));
        bBatalTR.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bBatalTR.setForeground(new java.awt.Color(255, 255, 255));
        bBatalTR.setText("Batal");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(252, 66, 123));
        jLabel9.setText("Kembali");

        tTanggal.setBackground(new java.awt.Color(252, 66, 123));
        tTanggal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tTanggal.setForeground(new java.awt.Color(252, 66, 123));
        tTanggal.setText("Tanggal");

        tTotalHarga.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tTotalHarga.setText("0");

        tKembali.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tKembali.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSimpan)
                        .addGap(50, 50, 50)
                        .addComponent(bBatalTR)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tHari, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(tTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tTanggal)
                            .addComponent(tHari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tTotalHarga))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tKembali)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bSimpan)
                            .addComponent(bBatalTR))))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tNamaProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNamaProdukKeyReleased
        String carip = tNamaProduk.getText();
        pencarianProduk(carip);

    }//GEN-LAST:event_tNamaProdukKeyReleased

    private void bProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProdukActionPerformed

        try {
            String sql = "SELECT * FROM produk ";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Produk");
            model.addColumn("Nama Produk");
            model.addColumn("Harga");
            model.addColumn("Kategori");
            while (resultSet.next()) {
                model.addRow(new Object[]{resultSet.getString("id_produk"), resultSet.getString("nama_produk"), resultSet.getBigDecimal("harga"), resultSet.getString("id_kategori")});
            }
            ListProduk lP = new ListProduk(this, model);
            lP.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bProdukActionPerformed

    private void bPerbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPerbaruiActionPerformed
        int selectedRow = tabSementara.getSelectedRow();
        if (selectedRow != -1) {
            String idBarang = (String) tabSementara.getValueAt(selectedRow, 1);
            String namaBarang = tNamaProduk.getText();
            int qty = Integer.parseInt(tJumlah.getText());
            BigDecimal harga = new BigDecimal(tHarga.getText());
            BigDecimal subtotal = harga.multiply(BigDecimal.valueOf(qty));

            try {
                String sql = "UPDATE trans_sementara SET nama_brg = ?, qty = ?, harga = ?, subtotal = ? WHERE id_barang = ?";
                Connection conn = Koneksi.ConfigDB();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, namaBarang);
                statement.setInt(2, qty);
                statement.setBigDecimal(3, harga);
                statement.setBigDecimal(4, subtotal);
                statement.setString(5, idBarang);
                statement.executeUpdate();
                tampilTabelProduk();
                resetProduk();
                hitungTotalHarga();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diperbarui");
        }
    }//GEN-LAST:event_bPerbaruiActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        int selectedRow = tabSementara.getSelectedRow();
        if (selectedRow != -1) {
            String idBarang = (String) tabSementara.getValueAt(selectedRow, 1);
            try {
                String sql = "DELETE FROM trans_sementara WHERE id_barang = ?";
                Connection conn = Koneksi.ConfigDB();
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, idBarang);
                statement.executeUpdate();
                tampilTabelProduk();
                resetProduk();
                hitungTotalHarga();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus");
        }
    }//GEN-LAST:event_bHapusActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        try {
            BigDecimal totalHarga = new BigDecimal(tTotalHarga.getText().replace("Rp", "").replace(",", ""));
            BigDecimal bayar = new BigDecimal(tBayar.getText().replace("Rp", "").replace(",", ""));
            BigDecimal kembali = bayar.subtract(totalHarga);

            if (bayar.compareTo(totalHarga) < 0) {
                JOptionPane.showMessageDialog(null, "Jumlah bayar kurang dari total harga");
                return;
            }

            String idTransaksi = tIdTransaksi.getText();
            Date tgl = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = sdf.format(tgl);

            // SQL untuk tabel penjualan
            String sqlPenjualan = "INSERT INTO penjualan (id_penjualan, id_karyawan, tanggal, total_harga, bayar, kembali, create_at, update_at) VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statementPenjualan = conn.prepareStatement(sqlPenjualan);
            statementPenjualan.setString(1, idTransaksi);
            statementPenjualan.setString(2, idKaryawan(namaKaryawan));
            statementPenjualan.setString(3, tanggal);
            statementPenjualan.setBigDecimal(4, totalHarga);
            statementPenjualan.setBigDecimal(5, bayar);
            statementPenjualan.setBigDecimal(6, kembali);
            statementPenjualan.executeUpdate();

            String sqlDetail = "INSERT INTO detail_penjualan (id_penjualan, id_produk, jumlah, harga_satuan, subtotal, create_at, update_at) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
            PreparedStatement statementDetail = conn.prepareStatement(sqlDetail);
            for (int i = 0; i < tabSementara.getRowCount(); i++) {
                statementDetail.setString(1, idTransaksi);
                statementDetail.setString(2, tabSementara.getValueAt(i, 1).toString()); // Assuming second column is id_produk
                statementDetail.setInt(3, Integer.parseInt(tabSementara.getValueAt(i, 3).toString())); // Assuming fourth column is quantity
                statementDetail.setBigDecimal(4, (BigDecimal) tabSementara.getValueAt(i, 4)); // Assuming fifth column is price
                statementDetail.setBigDecimal(5, (BigDecimal) tabSementara.getValueAt(i, 5)); // Assuming sixth column is subtotal
                statementDetail.executeUpdate();
            }

            String sqlHapus = "DELETE FROM trans_sementara";
            Statement statementHapus = conn.createStatement();
            statementHapus.executeUpdate(sqlHapus);

            resetPembayaran();
            resetProduk();
            tampilTabelProduk();
            hitungTotalHarga();
            //Report rp = new Report();
           // rp.cetakStruk(tIdTransaksi.getText());
            JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan dan struk dicetak");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_bSimpanActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        resetProduk();
        resetPembayaran();

    }//GEN-LAST:event_bBatalActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        if (tNamaProduk.getText().isEmpty() || tHarga.getText().isEmpty() || tJumlah.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lengkapi data produk!");
            return;
        }

        try {
            String idBarang = tIdProduk.getText();
            String namaBarang = tNamaProduk.getText();
            int qty = Integer.parseInt(tJumlah.getText());
            BigDecimal harga = new BigDecimal(tHarga.getText());
            BigDecimal subtotal = harga.multiply(BigDecimal.valueOf(qty));

            String sql = "INSERT INTO trans_sementara (id_barang, nama_brg, qty, harga, subtotal) VALUES (?, ?, ?, ?, ?)";
            Connection conn = Koneksi.ConfigDB();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, idBarang);
            statement.setString(2, namaBarang);
            statement.setInt(3, qty);
            statement.setBigDecimal(4, harga);
            statement.setBigDecimal(5, subtotal);
            statement.executeUpdate();
            tampilTabelProduk();
            resetProduk();
            hitungTotalHarga();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga atau Jumlah tidak valid. Harap masukkan angka yang benar.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_bTambahActionPerformed

    private void tIdProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tIdProdukKeyReleased
        String carip = tIdProduk.getText();
        pencarianProduk(carip);
    }//GEN-LAST:event_tIdProdukKeyReleased

    private void tBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBayarKeyReleased
        if (!tBayar.getText().isEmpty() && !tTotalHarga.getText().isEmpty()) {
            BigDecimal bayar = new BigDecimal(tBayar.getText());
            BigDecimal totalHarga = new BigDecimal(tTotalHarga.getText());
            if (bayar.compareTo(totalHarga) >= 0) {
                BigDecimal kembali = bayar.subtract(totalHarga);
                tKembali.setText(kembali.toString());
            } else {
                tKembali.setText("0");
            }
        }
    }//GEN-LAST:event_tBayarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bBatalTR;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bPerbarui;
    private javax.swing.JButton bProduk;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tBayar;
    public javax.swing.JTextField tHarga;
    private javax.swing.JLabel tHari;
    public javax.swing.JTextField tIdProduk;
    private javax.swing.JTextField tIdTransaksi;
    public javax.swing.JTextField tJumlah;
    private javax.swing.JLabel tKembali;
    public javax.swing.JTextField tNamaKasir;
    public javax.swing.JTextField tNamaProduk;
    private javax.swing.JLabel tTanggal;
    private javax.swing.JLabel tTotalHarga;
    private javax.swing.JLabel tTotalSemua;
    private javax.swing.JTable tabSementara;
    // End of variables declaration//GEN-END:variables

}
