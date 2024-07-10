/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

    public void cetakStruk(String idTransaksi) throws SQLException{
        try {
            // File laporan
            String fileJasper = "C:/Users/USER/Documents/NetBeansProjects/Project_app/src/report/report2.jasper"; // Ubah dengan path laporan .jasper Anda
            Connection conn = Koneksi.ConfigDB();

            // Parameter yang dikirim ke laporan
            Map<String, Object> param = new HashMap<>();
            param.put("kode", idTransaksi);

            // Mengeksekusi laporan
            JasperPrint print = JasperFillManager.fillReport(fileJasper, param, conn);

            // Menampilkan laporan dengan JasperViewer
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Gagal mencetak struk: " + ex.getMessage());
        }
    }

}
