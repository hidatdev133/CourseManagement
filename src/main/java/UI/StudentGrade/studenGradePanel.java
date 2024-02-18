package UI.StudentGrade;

import DAL.StudentGrade.StudentGrade;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class studenGradePanel extends javax.swing.JPanel {
    DefaultTableModel dtm = new DefaultTableModel();
    
    public studenGradePanel() {
        initComponents();
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtEnrollmentID = new javax.swing.JTextField();
        jtStudentID = new javax.swing.JTextField();
        jtGrade = new javax.swing.JTextField();
        jtCourseID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtStudentGrade = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(950, 513));

        jLabel1.setText("EnrollmentID :");

        jLabel2.setText("CourseID :");

        jLabel3.setText("StudentID :");

        jLabel4.setText("Grade :");

        jtEnrollmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEnrollmentIDActionPerformed(evt);
            }
        });

        jtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtStudentIDActionPerformed(evt);
            }
        });

        jtGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtGradeActionPerformed(evt);
            }
        });

        jtCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCourseIDActionPerformed(evt);
            }
        });

        jtStudentGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EnrollmentID", "CourseID", "StudentID", "Grade"
            }
        ));
        jScrollPane1.setViewportView(jtStudentGrade);

        btnReset.setText("RESET");

        btnExit.setText("EXIT");

        btnAdd.setText("ADD");

        btnEdit.setText("EDIT");

        btnDelete.setText("DELETE");

        btnSearch.setText("SEARCH");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/student-grades-64px.png"))); // NOI18N
        jLabel5.setText("STUDENT GRADE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnReset)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtEnrollmentID)
                                .addComponent(jtCourseID)
                                .addComponent(jtStudentID)
                                .addComponent(jtGrade))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addGap(212, 212, 212)))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField5)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdd)
                            .addGap(100, 100, 100)
                            .addComponent(btnEdit)
                            .addGap(102, 102, 102)
                            .addComponent(btnDelete)
                            .addGap(98, 98, 98)
                            .addComponent(btnSearch)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(71, 71, 71)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtEnrollmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtEnrollmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEnrollmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEnrollmentIDActionPerformed

    private void jtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtStudentIDActionPerformed

    private void jtGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtGradeActionPerformed

    private void jtCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCourseIDActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jtCourseID;
    private javax.swing.JTextField jtEnrollmentID;
    private javax.swing.JTextField jtGrade;
    private javax.swing.JTable jtStudentGrade;
    private javax.swing.JTextField jtStudentID;
    // End of variables declaration//GEN-END:variables
}
