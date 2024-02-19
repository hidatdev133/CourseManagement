package UI.StudentGrade;

import DAL.StudentGrade.StudentGrade;
import BLL.Person.StudentGradeBLL;
import UI.Menu.menuForm;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class studenGradePanel extends javax.swing.JPanel {

    DefaultTableModel dtm;
    StudentGradeBLL studentGradeBLL;

    public studenGradePanel() {
        initComponents();
        dtm = (DefaultTableModel) jtStudentGrade.getModel();
        studentGradeBLL = new StudentGradeBLL();
        displayStudentGrades();

    }

    private void displayStudentGrades() {
        dtm.setRowCount(0); // Xóa dữ liệu trước đó

        // Gọi phương thức đọc sinh viên từ BLL
        List<List<Object>> studentGradeList = studentGradeBLL.readStudent();

        // Duyệt qua danh sách và thêm dữ liệu vào bảng
        for (List<Object> studentGradeInfo : studentGradeList) {
            dtm.addRow(studentGradeInfo.toArray());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEnrollmentID = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        txtGrade = new javax.swing.JTextField();
        txtCourseID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtStudentGrade = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(950, 513));

        jLabel1.setText("EnrollmentID :");

        jLabel2.setText("CourseID :");

        jLabel3.setText("StudentID :");

        jLabel4.setText("Grade :");

        txtEnrollmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnrollmentIDActionPerformed(evt);
            }
        });

        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });

        txtGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradeActionPerformed(evt);
            }
        });

        txtCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseIDActionPerformed(evt);
            }
        });

        jtStudentGrade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtStudentGrade.setForeground(new java.awt.Color(102, 102, 102));
        jtStudentGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EnrollmentID", "CourseID", "StudentID", "Grade", "Student Name", "Course Name"
            }
        ));
        jtStudentGrade.setToolTipText("");
        jtStudentGrade.setRowHeight(30);
        jtStudentGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtStudentGradeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtStudentGrade);

        btnReset.setBackground(new java.awt.Color(0, 161, 255));
        btnReset.setText("RESET");

        btnExit.setBackground(new java.awt.Color(0, 161, 255));
        btnExit.setText("EXIT");

        btnAdd.setBackground(new java.awt.Color(0, 161, 255));
        btnAdd.setText("ADD");

        btnEdit.setBackground(new java.awt.Color(0, 161, 255));
        btnEdit.setText("EDIT");

        btnDelete.setBackground(new java.awt.Color(0, 161, 255));
        btnDelete.setText("DELETE");

        btnSearch.setBackground(new java.awt.Color(0, 161, 255));
        btnSearch.setText("SEARCH");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 161, 255));
        jLabel5.setText("STUDENT GRADE");

        jLabel6.setText("Student Name:");

        jLabel7.setText("Course Name");

        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });

        txtCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(349, 349, 349))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnReset)
                                            .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtStudentID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCourseID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEnrollmentID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(67, 67, 67)
                                .addComponent(btnEdit))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtEnrollmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnReset)
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnrollmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnrollmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnrollmentIDActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void txtGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradeActionPerformed

    private void txtCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseIDActionPerformed

    private void jtStudentGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStudentGradeMouseClicked
        int i = jtStudentGrade.getSelectedRow();
        if (i >= 0) {
            txtEnrollmentID.setText(dtm.getValueAt(i, 0).toString());
            txtCourseID.setText(dtm.getValueAt(i, 1).toString());

            txtStudentID.setText(dtm.getValueAt(i, 2).toString());
            txtGrade.setText(dtm.getValueAt(i, 3).toString());
            txtStudentName.setText(dtm.getValueAt(i, 4).toString());
            txtCourseName.setText(dtm.getValueAt(i, 5).toString());

        }
    }//GEN-LAST:event_jtStudentGradeMouseClicked

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void txtCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseNameActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studenGradePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtStudentGrade;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtEnrollmentID;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
