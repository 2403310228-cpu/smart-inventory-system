package view;

import javax.swing.JOptionPane;
import com.mycompany.aplikasiminimarket.dao.BarangDAO;
import com.mycompany.aplikasiminimarket.dao.SupplierDAO;
import com.mycompany.aplikasiminimarket.dao.PenjualanDAO;
import helper.FormatRupiah;
import java.awt.BorderLayout;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Dashboard extends javax.swing.JFrame {
    
    public Dashboard() {
    initComponents();
    setLocationRelativeTo(null);
    loadDashboard();
    tampilDashboardAwal();

}
    private void loadDashboard() {

    BarangDAO barangDAO = new BarangDAO();
    SupplierDAO supplierDAO = new SupplierDAO();
    PenjualanDAO penjualanDAO = new PenjualanDAO();

    lblJumlahBarang.setText(
            String.valueOf(barangDAO.getTotalBarang()));

    lblJumlahSupplier.setText(
            String.valueOf(supplierDAO.getTotalSupplier()));

   lblJumlahPenjualan.setText(
    FormatRupiah.formatRupiah(
        penjualanDAO.getTotalPenjualan()));

}
private void tampilGrafik() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    dataset.addValue(25, "Penjualan", "Jan");
    dataset.addValue(40, "Penjualan", "Feb");
    dataset.addValue(30, "Penjualan", "Mar");
    dataset.addValue(60, "Penjualan", "Apr");
    dataset.addValue(55, "Penjualan", "Mei");
    dataset.addValue(80, "Penjualan", "Jun");

    JFreeChart chart = ChartFactory.createBarChart(
            "Grafik Penjualan",
            "Bulan",
            "Jumlah",
            dataset
    );
    
    chart.setBackgroundPaint(Color.WHITE);
    chart.removeLegend();
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setOutlinePaint(null);
        plot.setRangeGridlinePaint(new Color(220, 220, 220));
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(52, 152, 219));
    ChartPanel cp = new ChartPanel(chart); 
    cp.setMouseWheelEnabled(true);
    cp.setPreferredSize(panelContent.getSize());
    panelContent.removeAll();
    panelContent.setLayout(new BorderLayout());
    panelContent.add(cp, BorderLayout.CENTER);
    panelContent.revalidate();
    panelContent.repaint();

}
private void tampilDashboardAwal() {

    loadDashboard();

    tampilGrafik();

}
private void tampilGrafikBarang() {

    BarangDAO dao = new BarangDAO();

    DefaultCategoryDataset dataset = dao.getDatasetBarang();

    JFreeChart chart = ChartFactory.createBarChart(

            "Data Barang",
            "Kategori",
            "Jumlah Barang",
            dataset

    );

    chart.setBackgroundPaint(Color.WHITE);

    CategoryPlot plot = chart.getCategoryPlot();

    plot.setBackgroundPaint(Color.WHITE);
    plot.setRangeGridlinePaint(new Color(220,220,220));
    plot.setOutlinePaint(null);

    BarRenderer renderer = (BarRenderer) plot.getRenderer();

    renderer.setSeriesPaint(0,new Color(52,152,219));

    chart.removeLegend();

    ChartPanel cp = new ChartPanel(chart);
    cp.setPreferredSize(panelContent.getSize());
    cp.setMaximumDrawWidth(Integer.MAX_VALUE);
    cp.setMaximumDrawHeight(Integer.MAX_VALUE);
    panelContent.removeAll();

    panelContent.setLayout(new BorderLayout());

    panelContent.add(cp,BorderLayout.CENTER);

    panelContent.revalidate();

    panelContent.repaint();

}
private void tampilGrafikSupplier() {

    SupplierDAO dao = new SupplierDAO();

    DefaultCategoryDataset dataset = dao.getDatasetSupplier();

    JFreeChart chart = ChartFactory.createBarChart(

            "Data Supplier",
            "Supplier",
            "Jumlah Barang",
            dataset

    );

    chart.setBackgroundPaint(Color.WHITE);
    chart.removeLegend();

    CategoryPlot plot = chart.getCategoryPlot();

    plot.setBackgroundPaint(Color.WHITE);
    plot.setOutlinePaint(null);
    plot.setRangeGridlinePaint(new Color(220,220,220));

    BarRenderer renderer = (BarRenderer) plot.getRenderer();

    renderer.setSeriesPaint(0,new Color(46,204,113));

    ChartPanel cp = new ChartPanel(chart);
cp.setPreferredSize(panelContent.getSize());
cp.setMaximumDrawWidth(Integer.MAX_VALUE);
cp.setMaximumDrawHeight(Integer.MAX_VALUE);
    panelContent.removeAll();

    panelContent.setLayout(new BorderLayout());

    panelContent.add(cp,BorderLayout.CENTER);

    panelContent.revalidate();

    panelContent.repaint();

}
private void tampilGrafikPenjualan() {

    PenjualanDAO dao = new PenjualanDAO();

    DefaultCategoryDataset dataset = dao.getDatasetPenjualan();

    JFreeChart chart = ChartFactory.createBarChart(

            "Grafik Penjualan Bulanan",
            "Bulan",
            "Total Penjualan",
            dataset

    );

    chart.setBackgroundPaint(Color.WHITE);
    chart.removeLegend();

    CategoryPlot plot = chart.getCategoryPlot();

    plot.setBackgroundPaint(Color.WHITE);
    plot.setOutlinePaint(null);
    plot.setRangeGridlinePaint(new Color(220,220,220));

    BarRenderer renderer = (BarRenderer) plot.getRenderer();

    renderer.setSeriesPaint(0,new Color(231,76,60));

    ChartPanel cp = new ChartPanel(chart);
cp.setPreferredSize(panelContent.getSize());
cp.setMaximumDrawWidth(Integer.MAX_VALUE);
cp.setMaximumDrawHeight(Integer.MAX_VALUE);
    panelContent.removeAll();

    panelContent.setLayout(new BorderLayout());

    panelContent.add(cp, BorderLayout.CENTER);

    panelContent.revalidate();

    panelContent.repaint();

}
    private void tampilGrafikReport() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    BarangDAO barangDAO = new BarangDAO();
    SupplierDAO supplierDAO = new SupplierDAO();
    PenjualanDAO penjualanDAO = new PenjualanDAO();

    dataset.addValue(
            barangDAO.getTotalBarang(),
            "Total",
            "Barang"
    );

    dataset.addValue(
            supplierDAO.getTotalSupplier(),
            "Total",
            "Supplier"
    );

    dataset.addValue(
            penjualanDAO.getJumlahTransaksi(),
            "Total",
            "Transaksi"
    );

    JFreeChart chart = ChartFactory.createBarChart(

            "Ringkasan Sistem",
            "Menu",
            "Jumlah",
            dataset

    );

    chart.setBackgroundPaint(Color.WHITE);
    chart.removeLegend();

    CategoryPlot plot = chart.getCategoryPlot();

    plot.setBackgroundPaint(Color.WHITE);
    plot.setOutlinePaint(null);
    plot.setRangeGridlinePaint(new Color(220,220,220));

    BarRenderer renderer = (BarRenderer) plot.getRenderer();

    renderer.setSeriesPaint(0,new Color(155,89,182));

    ChartPanel cp = new ChartPanel(chart);
cp.setPreferredSize(panelContent.getSize());
cp.setMaximumDrawWidth(Integer.MAX_VALUE);
cp.setMaximumDrawHeight(Integer.MAX_VALUE);
    panelContent.removeAll();

    panelContent.setLayout(new BorderLayout());

    panelContent.add(cp, BorderLayout.CENTER);

    panelContent.revalidate();

    panelContent.repaint();

}
    private void tampilPanel(javax.swing.JPanel panel){

    panelContent.removeAll();

    panelContent.setLayout(new BorderLayout());

    panelContent.add(panel, BorderLayout.CENTER);

    panelContent.revalidate();

    panelContent.repaint();

}
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblTotalSupplier = new javax.swing.JLabel();
        lblJumlahSupplier = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTotalBarang = new javax.swing.JLabel();
        lblJumlahBarang = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblPenjualan = new javax.swing.JLabel();
        lblJumlahPenjualan = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnChartDashboard = new javax.swing.JButton();
        btnChartBarang = new javax.swing.JButton();
        btnChartSupplier = new javax.swing.JButton();
        btnChartPenjualan = new javax.swing.JButton();
        btnChartReport = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnBarang = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        btnPenjualan = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("CV. SERBA ADA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("SMART INVENTORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTotalSupplier.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalSupplier.setText("Total Supplier");

        lblJumlahSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahSupplier.setText("30");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblJumlahSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblTotalSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJumlahSupplier))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTotalBarang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalBarang.setText("Total Barang");

        lblJumlahBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahBarang.setText("150");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJumlahBarang))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPenjualan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPenjualan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenjualan.setText("Penjualan");

        lblJumlahPenjualan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJumlahPenjualan.setText("RP.15.000.000.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblJumlahPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPenjualan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJumlahPenjualan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(62, 62, 62))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnChartDashboard.setText("Dashboard");
        btnChartDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartDashboardActionPerformed(evt);
            }
        });

        btnChartBarang.setText("BARANG");
        btnChartBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartBarangActionPerformed(evt);
            }
        });

        btnChartSupplier.setText("SUPPLIER");
        btnChartSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartSupplierActionPerformed(evt);
            }
        });

        btnChartPenjualan.setText("PENJUALAN");
        btnChartPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartPenjualanActionPerformed(evt);
            }
        });

        btnChartReport.setText("REPORT");
        btnChartReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartReportActionPerformed(evt);
            }
        });

        jLabel4.setText("Data Chart");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChartSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChartReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChartBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChartDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnChartPenjualan)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnChartDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChartBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChartSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChartPenjualan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChartReport)
                .addContainerGap())
        );

        jPanel8.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel8.setText("JABATAN");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Admin | Kasir");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));

        btnDashboard.setBackground(new java.awt.Color(255, 255, 102));
        btnDashboard.setText("Dashboard");
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnBarang.setBackground(new java.awt.Color(255, 255, 102));
        btnBarang.setText("Barang");
        btnBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangActionPerformed(evt);
            }
        });

        btnSupplier.setBackground(new java.awt.Color(255, 255, 102));
        btnSupplier.setText("Supplier");
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });

        btnPenjualan.setBackground(new java.awt.Color(255, 255, 102));
        btnPenjualan.setText("Penjualan");
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });

        btnReport.setBackground(new java.awt.Color(255, 255, 102));
        btnReport.setText("Report");

        btnUser.setBackground(new java.awt.Color(255, 255, 51));
        btnUser.setText("User");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnDashboard)
                .addGap(40, 40, 40)
                .addComponent(btnBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSupplier)
                .addGap(18, 18, 18)
                .addComponent(btnPenjualan)
                .addGap(18, 18, 18)
                .addComponent(btnReport)
                .addGap(18, 18, 18)
                .addComponent(btnUser)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btnPenjualan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnLogout.setBackground(new java.awt.Color(204, 51, 0));
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChartBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartBarangActionPerformed
    tampilGrafikBarang();
    loadDashboard();
    }//GEN-LAST:event_btnChartBarangActionPerformed

    private void btnChartDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartDashboardActionPerformed
    tampilDashboardAwal();
    loadDashboard();
    }//GEN-LAST:event_btnChartDashboardActionPerformed

    private void btnChartSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartSupplierActionPerformed
     tampilGrafikSupplier();
    loadDashboard();
    }//GEN-LAST:event_btnChartSupplierActionPerformed

    private void btnChartPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartPenjualanActionPerformed
    tampilGrafikPenjualan();
    loadDashboard();
    }//GEN-LAST:event_btnChartPenjualanActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
 int pilih = JOptionPane.showConfirmDialog(
            this,
            "Apakah Anda yakin ingin logout?",
            "Konfirmasi Logout",
            JOptionPane.YES_NO_OPTION);

    if (pilih == JOptionPane.YES_OPTION) {

        Login login = new Login();
        login.setVisible(true);

        dispose();

    }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnChartReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartReportActionPerformed
    tampilGrafikReport();
    loadDashboard();
    }//GEN-LAST:event_btnChartReportActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
PenjualanForm penjualan = new PenjualanForm();
    penjualan.setVisible(true);

    dispose();
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void btnBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangActionPerformed
BarangForm barang = new BarangForm();
    barang.setVisible(true);

    dispose();
    }//GEN-LAST:event_btnBarangActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
 Dashboard d = new Dashboard();
    d.setVisible(true);

    dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed

    }//GEN-LAST:event_btnUserActionPerformed

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierActionPerformed
SupplierForm supplier = new SupplierForm();
    supplier.setVisible(true);

    dispose();
    }//GEN-LAST:event_btnSupplierActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarang;
    private javax.swing.JButton btnChartBarang;
    private javax.swing.JButton btnChartDashboard;
    private javax.swing.JButton btnChartPenjualan;
    private javax.swing.JButton btnChartReport;
    private javax.swing.JButton btnChartSupplier;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPenjualan;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblJumlahBarang;
    private javax.swing.JLabel lblJumlahPenjualan;
    private javax.swing.JLabel lblJumlahSupplier;
    private javax.swing.JLabel lblPenjualan;
    private javax.swing.JLabel lblTotalBarang;
    private javax.swing.JLabel lblTotalSupplier;
    private javax.swing.JPanel panelContent;
    // End of variables declaration//GEN-END:variables
}
