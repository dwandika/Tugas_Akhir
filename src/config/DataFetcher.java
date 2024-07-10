
package config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class DataFetcher {

    private Connection conn;
    private JLabel vTotalTransaksi;
    private JLabel vPendapatan;
    private JLabel vJumlahMenu;

    public DataFetcher(Connection conn, JLabel vTotalTransaksi, JLabel vPendapatan, JLabel vJumlahMenu) {
        this.conn = conn;
        this.vTotalTransaksi = vTotalTransaksi;
        this.vPendapatan = vPendapatan;
        this.vJumlahMenu = vJumlahMenu;
    }

    public void getData() {
        try {
            // Menghitung total transaksi
            String sql = "SELECT COUNT(DISTINCT id_penjualan) AS TOTTRANSAKSI FROM penjualan WHERE tanggal = CURDATE()";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String totalTransaksi = rs.getString("TOTTRANSAKSI");
                    vTotalTransaksi.setText(totalTransaksi);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DataFetcher.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            // Menghitung total pendapatan
            String sql = "SELECT SUM(total_harga) AS TOTPENDAPATAN FROM penjualan WHERE tanggal = CURDATE()";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String pendapatan = rs.getString("TOTPENDAPATAN");
                    if (pendapatan != null) {
                        pendapatan = pendapatan.replaceAll("[^\\d]", "");             
                        double Rp = Double.parseDouble(pendapatan);
                        DecimalFormat df = new DecimalFormat();
                        vPendapatan.setText("Rp." + df.format(Rp));
                    } else {
                        vPendapatan.setText("Rp.0");
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DataFetcher.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            // Menghitung jumlah produk
            String sql = "SELECT COUNT(*) AS TOTPRODUK FROM produk";
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String jumlahMenu = rs.getString("TOTPRODUK");
                    vJumlahMenu.setText(jumlahMenu);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DataFetcher.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
