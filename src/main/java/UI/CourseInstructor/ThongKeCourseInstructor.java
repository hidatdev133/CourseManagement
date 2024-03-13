/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.CourseInstructor;

import BLL.Person.CourseInstructorBLL;
import BLL.Person.TeacherBLL;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Dat dep trai
 */
public class ThongKeCourseInstructor extends javax.swing.JFrame {

    CourseInstructorPanel parentPanel;
    CourseInstructorBLL courseInstructorBLL;
    TeacherBLL teacherBLL;
    public ThongKeCourseInstructor(CourseInstructorPanel parent) {
        this.parentPanel = parent;
        initComponents();
        this.courseInstructorBLL = new CourseInstructorBLL(); // Khởi tạo đối tượng CourseInstructorBLL
        this.teacherBLL = new TeacherBLL();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createBarChart();
    }
    
     private void createBarChart() {
        // Tạo dataset với dữ liệu mẫu
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Integer> idList = teacherBLL.readDSIDbyOrdered();
        for (int id : idList) {
            dataset.addValue(courseInstructorBLL.getAllcourseIDbypersonID(id), "Số lượng khóa học", String.valueOf(id));
        }
        
        //JFreeChart chart1 = ChartFactory.createBarChart("a", "b", "C", dataset, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        
        // Tạo biểu đồ cột từ dataset
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ phân công",
                "PersonID",
                "Số lượng khóa học",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true, true
        );
        
        // Tạo Panel để chứa biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);
        
        // Thêm biểu đồ vào JPanel
        jpn_thongke.setLayout(new BorderLayout());
        jpn_thongke.add(chartPanel, BorderLayout.CENTER);
        jpn_thongke.validate();
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn_thongke = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jpn_thongkeLayout = new javax.swing.GroupLayout(jpn_thongke);
        jpn_thongke.setLayout(jpn_thongkeLayout);
        jpn_thongkeLayout.setHorizontalGroup(
            jpn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        jpn_thongkeLayout.setVerticalGroup(
            jpn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jpn_thongke;
    // End of variables declaration//GEN-END:variables
}
