/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.StudentGrade;

import BLL.Person.StudentGradeBLL;
import DAL.StudentGrade.StudentGrade;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author MSI
 */
public class Satistic extends javax.swing.JFrame {

    private int scoreTB = 0;
    private int scoreKha = 0;
    private int scoreGioi = 0;
    private int scoreXS = 0;
    private int notExist = 0;
    StudentGradeBLL studentGradeBLL;

    DefaultTableModel dtm;
    List<List<Object>> studentGradeListObj;

    /**
     * Creates new form ThongKe
     */
    public Satistic() {
        initComponents();
        studentGradeBLL = new StudentGradeBLL();
        dataScore();
        dtm = (DefaultTableModel) jtStudentGrade.getModel();
        studentGradeListObj = studentGradeBLL.readStudent();

        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy selected item khi sự kiện Action được kích hoạt
                Object selectedObject = jComboBox1.getSelectedItem();

                // Thực hiện hành động dựa trên selected item
                if (selectedObject != null) {
                    String selectedValue = selectedObject.toString();
                    System.out.println("Selected Item: " + selectedValue);

                    // Xử lý dựa trên giá trị của selected item
                    if (selectedValue.equals("Tất cả")) {
                        studentGradeListObj = studentGradeBLL.readStudent();
                        jLabel7.setText("Số lượng: " + studentGradeListObj.size());
                        displayStudentGrades(studentGradeListObj);
                    } else if (selectedValue.equals("Điểm: 2.0 - 2.5")) {
                        System.out.println("hello");
                        studentGradeListObj = studentGradeBLL.searchStudentGradeByGradeRange(2.0f, 2.49f);
                        jLabel7.setText("Số lượng: " + studentGradeListObj.size());
                        displayStudentGrades(studentGradeListObj);
                    } else if (selectedValue.equals("Điểm: 2.5 - 3.2")) {
                        studentGradeListObj = studentGradeBLL.searchStudentGradeByGradeRange(2.5f, 3.19f);
                        jLabel7.setText("Số lượng: " + studentGradeListObj.size());
                        displayStudentGrades(studentGradeListObj);
                    } else if (selectedValue.equals("Điểm: 3.2 - 3.6")) {
                        studentGradeListObj = studentGradeBLL.searchStudentGradeByGradeRange(3.2f, 3.59f);
                        jLabel7.setText("Số lượng: " + studentGradeListObj.size());
                        displayStudentGrades(studentGradeListObj);
                    } else if (selectedValue.equals("Điểm: 3.6 - 4.0")) {
                        studentGradeListObj = studentGradeBLL.searchStudentGradeByGradeRange(3.6f, 4.0f);
                        jLabel7.setText("Số lượng: " + studentGradeListObj.size());
                        displayStudentGrades(studentGradeListObj);
                    } else {
                        studentGradeListObj = studentGradeBLL.searchStudentGradeByGradeRange(0.0f, 1.99f);
                        jLabel7.setText("Số lượng: " + studentGradeListObj.size());
                        displayStudentGrades(studentGradeListObj);
                    }
                } else {
                    System.out.println("No item selected");
                }
            }
        });
        jLabel7.setText("Số lượng: " + studentGradeListObj.size());
        // Hiển thị dữ liệu
        displayStudentGrades(studentGradeListObj);

        this.setVisible(true);
    }

    private void displayStudentGrades(List<List<Object>> studentGradeList) {
        dtm.setRowCount(0); // Xóa dữ liệu trước đó

        // Duyệt qua danh sách và thêm dữ liệu vào bảng
        for (List<Object> studentGradeInfo : studentGradeList) {
            dtm.addRow(studentGradeInfo.toArray());
        }
    }

public void dataScore() {
    // Gọi phương thức đọc sinh viên từ BLL
    List<StudentGrade> studentGradeList = studentGradeBLL.readSG();

    //Them
    for (StudentGrade st : studentGradeList) {
        float score = st.getGrade();

        if (score >= 0 && score <= 4.0) { // Kiểm tra xem điểm có nằm trong khoảng hợp lệ không
            if (score >= 2.0 && score < 2.5) {
                scoreTB++;
            } else if (score >= 2.5 && score < 3.2) {
                scoreKha++;
            } else if (score >= 3.2 && score < 3.6) {
                scoreGioi++;
            } else if (score >= 3.6 && score <= 4.0) {
                scoreXS++;
            }
        } else {
            notExist++;
        }
    }

    System.out.println(scoreTB + " " + scoreKha + " " + scoreGioi + " " + scoreXS + " " + notExist);

    setDataToChartCourse(jpn_thongke);
}


    public void setDataToChartCourse(JPanel jpnItem) {
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        double total = scoreTB + scoreKha + scoreGioi + scoreXS + notExist;
        BigDecimal rounded = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        double totalScore = rounded.doubleValue();

        pieDataset.setValue("Medium", (scoreTB * 100) / totalScore);
        pieDataset.setValue("Pretty", (scoreKha * 100) / totalScore);
        pieDataset.setValue("Good", (scoreGioi * 100) / totalScore);
        pieDataset.setValue("Excellent", (scoreXS * 100) / totalScore);
        pieDataset.setValue("Exeption", (notExist * 100) / totalScore);

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Tỉ lệ chênh lệch điểm".toUpperCase(),
                pieDataset, false, true, false);

        PiePlot piePlot = (PiePlot) pieChart.getPlot();

        // Set different colors for each section
        piePlot.setSectionPaint("Medium", new Color(255, 0, 0));       // Red
        piePlot.setSectionPaint("Pretty", new Color(0, 0, 255));       // Blue
        piePlot.setSectionPaint("Good", new Color(0, 255, 0));      // Green
        piePlot.setSectionPaint("Excellent", new Color(255, 255, 0));      // Yellow
        piePlot.setSectionPaint("Exeption", new Color(128, 0, 128));     // Purple

        piePlot.setBackgroundPaint(Color.white);

        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}%"));
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn_thongke = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtStudentGrade = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jpn_thongkeLayout = new javax.swing.GroupLayout(jpn_thongke);
        jpn_thongke.setLayout(jpn_thongkeLayout);
        jpn_thongkeLayout.setHorizontalGroup(
            jpn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        jpn_thongkeLayout.setVerticalGroup(
            jpn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 255, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(128, 0, 128));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jLabel1.setText("Điểm: 2.0 - 2.5");

        jLabel2.setText("Điểm: 2.5 - 3.2");

        jLabel3.setText("Điểm: 3.2 - 3.6");

        jLabel4.setText("Ngoại lệ");

        jLabel5.setText("Điểm: 3.6 - 4.0");

        jLabel6.setText("Điểm GPA");

        jtStudentGrade.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jtStudentGrade.setForeground(new java.awt.Color(102, 102, 102));
        jtStudentGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EnrollmentID", "CourseID", "StudentID", "Student Name", "Course Name", "Grade"
            }
        ));
        jtStudentGrade.setToolTipText("");
        jtStudentGrade.setRowHeight(30);
        jScrollPane1.setViewportView(jtStudentGrade);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Điểm: 2.0 - 2.5", "Điểm: 2.5 - 3.2", "Điểm: 3.2 - 3.6", "Điểm: 3.6 - 4.0", "Ngoại lệ" }));

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jpn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel6)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jpn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(70, 70, 70)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Satistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Satistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Satistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Satistic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Satistic a = new Satistic();
                a.setVisible(true);
                a.setLocationRelativeTo(null);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpn_thongke;
    private javax.swing.JTable jtStudentGrade;
    // End of variables declaration//GEN-END:variables
}
