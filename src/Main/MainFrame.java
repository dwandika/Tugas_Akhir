package Main;

import master.Produk;
import master.LaporanPenjualan;
import master.Penjualan;
import master.Karyawan;
import master.Kategori;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.UIManager;

public class MainFrame extends javax.swing.JFrame {

    private String namaKaryawan;

    public MainFrame(String namaKaryawan) {
        initComponents();
        wkt();
        showHome();
        this.namaKaryawan = namaKaryawan;
        lUser.setText(namaKaryawan);

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
        String tgl = sdf.format(now);
        lTanggal.setText(getNamaHari(now)+", "+tgl);
    }

    private String getNamaHari(Date date) {
        String[] days = {"Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        SimpleDateFormat sdf = new SimpleDateFormat("u");
        int dayIndex = Integer.parseInt(sdf.format(date)) - 0;
        return days[dayIndex];
    }
    Timer t;
    SimpleDateFormat st, jm;

    void wkt() {

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                jm = new SimpleDateFormat("HH:mm:ss");
                String jmt = jm.format(dt);
                lJam.setText(jmt);

            }
        });

        t.start();

    }

    public void showHome() {
        Conten.removeAll();
        Conten.add(new Dasboard());
        Conten.repaint();
        Conten.revalidate();
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainLayout = new javax.swing.JPanel();
        SlideBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MenuDashBord = new javax.swing.JPanel();
        bDashboard = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuProduk = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bProduk = new javax.swing.JLabel();
        MenuKategori = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bKategori = new javax.swing.JLabel();
        MenuKaryawan = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        bKaryawan = new javax.swing.JLabel();
        MenuLogout = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        bLogout = new javax.swing.JLabel();
        MenuPenjualan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bPenjualan = new javax.swing.JLabel();
        MenuLaporanPenjualan = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        bLaporanPen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Conten = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lUser = new javax.swing.JLabel();
        lTanggal = new javax.swing.JLabel();
        lJam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        SlideBar.setBackground(new java.awt.Color(252, 66, 123));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Main");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Master");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Laporan");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Transaksi");

        MenuDashBord.setBackground(new java.awt.Color(252, 66, 123));

        bDashboard.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bDashboard.setForeground(new java.awt.Color(255, 255, 255));
        bDashboard.setText("Dashboard");
        bDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bDashboardMouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home_1.png"))); // NOI18N

        javax.swing.GroupLayout MenuDashBordLayout = new javax.swing.GroupLayout(MenuDashBord);
        MenuDashBord.setLayout(MenuDashBordLayout);
        MenuDashBordLayout.setHorizontalGroup(
            MenuDashBordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuDashBordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuDashBordLayout.setVerticalGroup(
            MenuDashBordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuProduk.setBackground(new java.awt.Color(252, 66, 123));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Food.png"))); // NOI18N

        bProduk.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bProduk.setForeground(new java.awt.Color(255, 255, 255));
        bProduk.setText("Menu");
        bProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bProdukMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bProdukMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bProdukMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuProdukLayout = new javax.swing.GroupLayout(MenuProduk);
        MenuProduk.setLayout(MenuProdukLayout);
        MenuProdukLayout.setHorizontalGroup(
            MenuProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuProdukLayout.setVerticalGroup(
            MenuProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuKategori.setBackground(new java.awt.Color(252, 66, 123));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Restaurant Menu_1.png"))); // NOI18N

        bKategori.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bKategori.setForeground(new java.awt.Color(255, 255, 255));
        bKategori.setText("Kategori");
        bKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bKategoriMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bKategoriMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bKategoriMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuKategoriLayout = new javax.swing.GroupLayout(MenuKategori);
        MenuKategori.setLayout(MenuKategoriLayout);
        MenuKategoriLayout.setHorizontalGroup(
            MenuKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuKategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        MenuKategoriLayout.setVerticalGroup(
            MenuKategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuKaryawan.setBackground(new java.awt.Color(252, 66, 123));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Waiter.png"))); // NOI18N

        bKaryawan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        bKaryawan.setText("karyawan");
        bKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bKaryawanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bKaryawanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bKaryawanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuKaryawanLayout = new javax.swing.GroupLayout(MenuKaryawan);
        MenuKaryawan.setLayout(MenuKaryawanLayout);
        MenuKaryawanLayout.setHorizontalGroup(
            MenuKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuKaryawanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        MenuKaryawanLayout.setVerticalGroup(
            MenuKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuLogout.setBackground(new java.awt.Color(252, 66, 123));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logout.png"))); // NOI18N

        bLogout.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bLogout.setForeground(new java.awt.Color(255, 255, 255));
        bLogout.setText("Logout");
        bLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bLogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuLogoutLayout = new javax.swing.GroupLayout(MenuLogout);
        MenuLogout.setLayout(MenuLogoutLayout);
        MenuLogoutLayout.setHorizontalGroup(
            MenuLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLogoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuLogoutLayout.setVerticalGroup(
            MenuLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuPenjualan.setBackground(new java.awt.Color(252, 66, 123));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Checkout_1.png"))); // NOI18N

        bPenjualan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        bPenjualan.setText("Kasir");
        bPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bPenjualanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bPenjualanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bPenjualanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuPenjualanLayout = new javax.swing.GroupLayout(MenuPenjualan);
        MenuPenjualan.setLayout(MenuPenjualanLayout);
        MenuPenjualanLayout.setHorizontalGroup(
            MenuPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuPenjualanLayout.setVerticalGroup(
            MenuPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MenuLaporanPenjualan.setBackground(new java.awt.Color(252, 66, 123));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Health Graph.png"))); // NOI18N

        bLaporanPen.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        bLaporanPen.setForeground(new java.awt.Color(255, 255, 255));
        bLaporanPen.setText("Laporan Penjualan");
        bLaporanPen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLaporanPenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bLaporanPenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bLaporanPenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuLaporanPenjualanLayout = new javax.swing.GroupLayout(MenuLaporanPenjualan);
        MenuLaporanPenjualan.setLayout(MenuLaporanPenjualanLayout);
        MenuLaporanPenjualanLayout.setHorizontalGroup(
            MenuLaporanPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLaporanPenjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bLaporanPen, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        MenuLaporanPenjualanLayout.setVerticalGroup(
            MenuLaporanPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bLaporanPen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoWagdeBrebek.png"))); // NOI18N

        javax.swing.GroupLayout SlideBarLayout = new javax.swing.GroupLayout(SlideBar);
        SlideBar.setLayout(SlideBarLayout);
        SlideBarLayout.setHorizontalGroup(
            SlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SlideBarLayout.createSequentialGroup()
                .addComponent(MenuKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SlideBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MenuLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
            .addGroup(SlideBarLayout.createSequentialGroup()
                .addGroup(SlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuLaporanPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(SlideBarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(SlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(MenuProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MenuKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MenuDashBord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(MenuPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SlideBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)))
                    .addGroup(SlideBarLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SlideBarLayout.setVerticalGroup(
            SlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SlideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuDashBord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(MenuProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addComponent(MenuPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addComponent(MenuLaporanPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(MenuLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Conten.setBackground(new java.awt.Color(255, 255, 255));
        Conten.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(252, 66, 123));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User_5.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Selamat Datang");

        lUser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lUser.setForeground(new java.awt.Color(255, 255, 255));
        lUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lUser.setText("User");

        lTanggal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lTanggal.setForeground(new java.awt.Color(255, 255, 255));
        lTanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTanggal.setText("Tanggal");

        lJam.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lJam.setForeground(new java.awt.Color(255, 255, 255));
        lJam.setText("Jam");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lJam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 942, Short.MAX_VALUE)
                        .addComponent(lTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)
                        .addComponent(lUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTanggal)
                    .addComponent(lJam))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout MainLayoutLayout = new javax.swing.GroupLayout(MainLayout);
        MainLayout.setLayout(MainLayoutLayout);
        MainLayoutLayout.setHorizontalGroup(
            MainLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainLayoutLayout.createSequentialGroup()
                .addComponent(SlideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Conten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainLayoutLayout.setVerticalGroup(
            MainLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SlideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainLayoutLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Conten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(MainLayout, "card2");

        setSize(new java.awt.Dimension(1380, 775));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDashboardMouseClicked
        Conten.removeAll();
        Conten.add(new Dasboard());
        Conten.repaint();
        Conten.revalidate();
    }//GEN-LAST:event_bDashboardMouseClicked

    private void bProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bProdukMouseClicked
        Conten.removeAll();
        Conten.add(new Produk());
        Conten.repaint();
        Conten.revalidate();
    }//GEN-LAST:event_bProdukMouseClicked

    private void bKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseClicked
        Conten.removeAll();
        Conten.add(new Kategori());
        Conten.repaint();
        Conten.revalidate();
    }//GEN-LAST:event_bKategoriMouseClicked

    private void bKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKaryawanMouseClicked
        Conten.removeAll();
        Conten.add(new Karyawan());
        Conten.repaint();
        Conten.revalidate();
    }//GEN-LAST:event_bKaryawanMouseClicked

    private void bLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLogoutMouseClicked
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_bLogoutMouseClicked

    private void bDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDashboardMouseEntered
        MenuDashBord.setBackground(new Color(222, 36, 93));
    }//GEN-LAST:event_bDashboardMouseEntered

    private void bDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDashboardMouseExited
        MenuDashBord.setBackground(new Color(252,66,123));
    }//GEN-LAST:event_bDashboardMouseExited

    private void bProdukMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bProdukMouseEntered
        MenuProduk.setBackground(new Color(222, 36, 93));
    }//GEN-LAST:event_bProdukMouseEntered

    private void bProdukMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bProdukMouseExited
        MenuProduk.setBackground(new Color(252,66,123));
    }//GEN-LAST:event_bProdukMouseExited

    private void bKategoriMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseEntered
        MenuKategori.setBackground(new Color(222, 36, 93));
    }//GEN-LAST:event_bKategoriMouseEntered

    private void bKategoriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKategoriMouseExited
        MenuKategori.setBackground(new Color(252,66,123));
    }//GEN-LAST:event_bKategoriMouseExited

    private void bKaryawanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKaryawanMouseEntered
        MenuKaryawan.setBackground(new Color(222, 36, 93));
    }//GEN-LAST:event_bKaryawanMouseEntered

    private void bKaryawanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKaryawanMouseExited
        MenuKaryawan.setBackground(new Color(252,66,123));
    }//GEN-LAST:event_bKaryawanMouseExited

    private void bLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLogoutMouseEntered
        MenuLogout.setBackground(new Color(222, 36, 93));
    }//GEN-LAST:event_bLogoutMouseEntered

    private void bLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLogoutMouseExited
        MenuLogout.setBackground(new Color(252,66,123));
    }//GEN-LAST:event_bLogoutMouseExited

    private void bPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPenjualanMouseClicked
        Conten.removeAll();
        Conten.add(new Penjualan(namaKaryawan));
        Conten.repaint();
        Conten.revalidate();
    }//GEN-LAST:event_bPenjualanMouseClicked

    private void bPenjualanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPenjualanMouseEntered
        MenuPenjualan.setBackground(new Color(222, 36, 93));
    }//GEN-LAST:event_bPenjualanMouseEntered

    private void bPenjualanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPenjualanMouseExited
        MenuPenjualan.setBackground(new Color(252,66,123));
    }//GEN-LAST:event_bPenjualanMouseExited

    private void bLaporanPenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLaporanPenMouseClicked
        Conten.removeAll();
        Conten.add(new LaporanPenjualan());
        Conten.repaint();
        Conten.revalidate();
    }//GEN-LAST:event_bLaporanPenMouseClicked

    private void bLaporanPenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLaporanPenMouseEntered
        MenuLaporanPenjualan.setBackground(new Color(222, 36, 93));
    }//GEN-LAST:event_bLaporanPenMouseEntered

    private void bLaporanPenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLaporanPenMouseExited
        MenuLaporanPenjualan.setBackground(new Color(252,66,123));
    }//GEN-LAST:event_bLaporanPenMouseExited

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 10);
            UIManager.put("TextComponent.arc", 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new MainFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Conten;
    private javax.swing.JPanel MainLayout;
    private javax.swing.JPanel MenuDashBord;
    private javax.swing.JPanel MenuKaryawan;
    private javax.swing.JPanel MenuKategori;
    private javax.swing.JPanel MenuLaporanPenjualan;
    private javax.swing.JPanel MenuLogout;
    private javax.swing.JPanel MenuPenjualan;
    private javax.swing.JPanel MenuProduk;
    private javax.swing.JPanel SlideBar;
    private javax.swing.JLabel bDashboard;
    private javax.swing.JLabel bKaryawan;
    private javax.swing.JLabel bKategori;
    private javax.swing.JLabel bLaporanPen;
    private javax.swing.JLabel bLogout;
    private javax.swing.JLabel bPenjualan;
    private javax.swing.JLabel bProduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lJam;
    public javax.swing.JLabel lTanggal;
    public javax.swing.JLabel lUser;
    // End of variables declaration//GEN-END:variables
}
