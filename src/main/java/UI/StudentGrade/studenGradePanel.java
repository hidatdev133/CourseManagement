package UI.StudentGrade;

import BLL.Course.CourseBLL;
import BLL.Person.StudentBLL;
import DAL.StudentGrade.StudentGrade;
import BLL.Person.StudentGradeBLL;
import UI.Menu.menuForm;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class studenGradePanel extends javax.swing.JPanel {

    private Object[] stlistStu, stlistCour;
    DefaultTableModel dtm;
    StudentGradeBLL studentGradeBLL;

    public studenGradePanel() {
        initComponents();
        dtm = (DefaultTableModel) jtStudentGrade.getModel();
        studentGradeBLL = new StudentGradeBLL();
        displayStudentGrades();
        txtEnrollmentID.setEditable(false);
        txtStudentName.setEditable(false);
        txtCourseName.setEditable(false);

        // Lấy dữ liệu cho combobox CourseID
        List<String> courseIDs = readCourseIDs();
        for (String courseID : courseIDs) {
            cbCourseID.addItem(courseID);
        }

        // Lấy dữ liệu cho combobox StudentID
        List<String> studentIDs = readStudentIDs();
        for (String studentID : studentIDs) {
            cbStudentID.addItem(studentID);
        }

    }

    private List<String> readCourseIDs() {
        CourseBLL courseBLL = new CourseBLL();
        return courseBLL.readDSID();
    }

    private List<String> readStudentIDs() {
        StudentBLL studentBLL = new StudentBLL();
        return studentBLL.readDSID();
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
        txtGrade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtStudentGrade = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
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
        cbCourseID = new javax.swing.JComboBox<>();
        cbStudentID = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(950, 513));

        jLabel1.setText("EnrollmentID :");

        jLabel2.setText("CourseID :");

        jLabel3.setText("StudentID :");

        jLabel4.setText("Grade :");

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
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/reset.png"))); // NOI18N
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 161, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/add.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 161, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/edit-st.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 161, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/delete (3).png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 161, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/search (2).png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 161, 255));
        jLabel5.setText("STUDENT GRADE");

        jLabel6.setText("Student Name:");

        jLabel7.setText("Course Name");

        cbCourseID.setPreferredSize(new java.awt.Dimension(64, 22));
        cbCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCourseIDActionPerformed(evt);
            }
        });

        cbStudentID.setPreferredSize(new java.awt.Dimension(64, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtEnrollmentID, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(cbCourseID, 0, 130, Short.MAX_VALUE)
                                    .addComponent(cbStudentID, 0, 130, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addGap(82, 82, 82)
                                        .addComponent(btnEdit)
                                        .addGap(73, 73, 73)
                                        .addComponent(btnDelete)
                                        .addGap(74, 74, 74)
                                        .addComponent(btnSearch)))
                                .addGap(0, 114, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtEnrollmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtStudentGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStudentGradeMouseClicked
        int i = jtStudentGrade.getSelectedRow();
        if (i >= 0) {
            txtEnrollmentID.setText(dtm.getValueAt(i, 0).toString());
            cbCourseID.setSelectedItem(dtm.getValueAt(i, 1).toString());

            cbStudentID.setSelectedItem(dtm.getValueAt(i, 2).toString());
            txtGrade.setText(dtm.getValueAt(i, 3).toString());
            txtStudentName.setText(dtm.getValueAt(i, 4).toString());
            txtCourseName.setText(dtm.getValueAt(i, 5).toString());

        }
    }//GEN-LAST:event_jtStudentGradeMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtEnrollmentID.setText("");
        cbCourseID.setSelectedItem(null); // Đặt giá trị mặc định của combobox
        cbStudentID.setSelectedItem(null); // Đặt giá trị mặc định của combobox
        txtGrade.setText("");
        txtStudentName.setText("");
        txtCourseName.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String courseID = cbCourseID.getSelectedItem().toString();
        String studentID = cbStudentID.getSelectedItem().toString();
        String grade = txtGrade.getText();

        // Kiểm tra xem các trường dữ liệu có được nhập đủ không
        if (courseID.isEmpty() || studentID.isEmpty() || grade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields");
            return;
        }

        // Chuyển đổi dữ liệu từ String sang kiểu dữ liệu phù hợp
        int courseIDInt = Integer.parseInt(courseID);
        int studentIDInt = Integer.parseInt(studentID);
        float gradeFloat = Float.parseFloat(grade);

        // Thực hiện thêm dữ liệu mới vào cơ sở dữ liệu
        int enrollmentID = studentGradeBLL.insertStudentGrade(courseIDInt, studentIDInt, gradeFloat);

        if (enrollmentID > 0) {
            // Hiển thị thông báo khi thêm dữ liệu thành công
            JOptionPane.showMessageDialog(this, "Data added successfully. Enrollment ID: " + enrollmentID);

            // Cập nhật lại bảng hiển thị danh sách sinh viên
            displayStudentGrades();

            // Xóa các trường dữ liệu đã nhập sau khi thêm thành công
            txtEnrollmentID.setText("");
            cbCourseID.setSelectedIndex(0);
            cbStudentID.setSelectedIndex(0);
            txtGrade.setText("");
            txtStudentName.setText("");
            txtCourseName.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add data");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCourseIDActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int enrollmentID = Integer.parseInt(txtEnrollmentID.getText());
        int courseID = Integer.parseInt(cbCourseID.getSelectedItem().toString());
        int studentID = Integer.parseInt(cbStudentID.getSelectedItem().toString());
        float grade = Float.parseFloat(txtGrade.getText());

        // Gọi phương thức để sửa dữ liệu trong BLL
        boolean edited = studentGradeBLL.editStudentGrade(enrollmentID, courseID, studentID, grade);
        if (edited) {
            // Nếu sửa thành công, cập nhật lại bảng jtStudentGrade
            displayStudentGrades();
            JOptionPane.showMessageDialog(this, "Data updated successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update data!");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = jtStudentGrade.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có hàng được chọn không
            int enrollmentID = Integer.parseInt(jtStudentGrade.getValueAt(selectedRow, 0).toString());
            boolean success = studentGradeBLL.deleteStudentGrade(enrollmentID);
            if (success) {
                JOptionPane.showMessageDialog(this, "Data deleted successfully.");
                displayStudentGrades(); // Cập nhật lại bảng jtStudentGrade
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete data.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchQuery = txtSearch.getText().trim();
        if (!searchQuery.isEmpty()) {
            List<List<Object>> searchResult = studentGradeBLL.searchStudentGrade(searchQuery);
            // Xóa dữ liệu cũ trong bảng
            dtm.setRowCount(0);
            // Hiển thị kết quả tìm kiếm trên bảng
            for (List<Object> studentGradeInfo : searchResult) {
                dtm.addRow(studentGradeInfo.toArray());
            }
        } else {
            // Nếu trường tìm kiếm trống, hiển thị tất cả sinh viên
            displayStudentGrades();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbCourseID;
    private javax.swing.JComboBox<String> cbStudentID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtStudentGrade;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtEnrollmentID;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
