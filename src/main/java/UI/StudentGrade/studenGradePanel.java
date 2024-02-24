package UI.StudentGrade;

import BLL.Course.CourseBLL;
import BLL.Person.StudentBLL;
import DAL.StudentGrade.StudentGrade;
import BLL.Person.StudentGradeBLL;
import UI.Menu.menuForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class studenGradePanel extends javax.swing.JPanel {

    private Object[] stlistStu, stlistCour;
    DefaultTableModel dtm;
    StudentGradeBLL studentGradeBLL;

    public studenGradePanel() {
        initComponents();
        dtm = (DefaultTableModel) jtStudentGrade.getModel();
        studentGradeBLL = new StudentGradeBLL();
        // Lắng nghe sự kiện khi combobox hoặc txtSearch thay đổi

        displayStudentGrades();

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

        cbCourseID.setSelectedItem(null);
        cbStudentID.setSelectedItem(null);
        txtGrade.setText("");

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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtStudentGrade = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbCourseID = new javax.swing.JComboBox<>();
        cbStudentID = new javax.swing.JComboBox<>();
        searchcb = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(950, 513));

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
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 161, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 161, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/edit-st.png"))); // NOI18N
        btnEdit.setText("Save");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 161, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/delete (3).png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 161, 255));
        jLabel5.setText("STUDENT GRADE");

        cbCourseID.setPreferredSize(new java.awt.Dimension(64, 22));
        cbCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCourseIDActionPerformed(evt);
            }
        });

        cbStudentID.setPreferredSize(new java.awt.Dimension(64, 22));

        searchcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CourseID", "StudentID", "Grade", "Student Name", "Course Name" }));

        btnSearch.setBackground(new java.awt.Color(0, 161, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/search (2).png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(cbCourseID, 0, 130, Short.MAX_VALUE)
                            .addComponent(cbStudentID, 0, 130, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchcb, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchcb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnReset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtStudentGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStudentGradeMouseClicked
        int i = jtStudentGrade.getSelectedRow();
        if (i >= 0) {

            cbCourseID.setSelectedItem(dtm.getValueAt(i, 1).toString());

            cbStudentID.setSelectedItem(dtm.getValueAt(i, 2).toString());
            txtGrade.setText(dtm.getValueAt(i, 3).toString());

        }
    }//GEN-LAST:event_jtStudentGradeMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        cbCourseID.setSelectedItem(null); // Đặt giá trị mặc định của combobox
        cbStudentID.setSelectedItem(null); // Đặt giá trị mặc định của combobox
        txtGrade.setText("");

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
            cbCourseID.setSelectedIndex(0);
            cbStudentID.setSelectedIndex(0);
            txtGrade.setText("");

        } else {
            JOptionPane.showMessageDialog(this, "Failed to add data");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCourseIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCourseIDActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Lấy dữ liệu được chọn từ bảng
        int selectedRow = jtStudentGrade.getSelectedRow();
        if (selectedRow >= 0) {
            // Lấy dữ liệu ban đầu
            int enrollmentID = Integer.parseInt(dtm.getValueAt(selectedRow, 0).toString());
            int courseID = Integer.parseInt(dtm.getValueAt(selectedRow, 1).toString());
            int studentID = Integer.parseInt(dtm.getValueAt(selectedRow, 2).toString());
            float grade = Float.parseFloat(dtm.getValueAt(selectedRow, 3).toString());

            // Lấy dữ liệu mới từ giao diện
            int newCourseID = Integer.parseInt(cbCourseID.getSelectedItem().toString());
            int newStudentID = Integer.parseInt(cbStudentID.getSelectedItem().toString());
            float newGrade = Float.parseFloat(txtGrade.getText().toString());

            // Kiểm tra xem có sự thay đổi không
            if (courseID != newCourseID || studentID != newStudentID || grade != newGrade) {
                // Nếu có sự thay đổi, thực hiện cập nhật dữ liệu
                boolean success = studentGradeBLL.editStudentGrade(enrollmentID, newCourseID, newStudentID, newGrade);
                if (success) {
                    JOptionPane.showMessageDialog(this, "Data updated successfully");
                    // Sau khi cập nhật thành công, làm mới bảng
                    displayStudentGrades();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update data");
                }
            } else {
                // Nếu không có sự thay đổi, hiển thị thông báo "No changes made"
                JOptionPane.showMessageDialog(this, "No changes made");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit");
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
        String selectedOption = searchcb.getSelectedItem().toString();

        if (!searchQuery.isEmpty()) {
            List<List<Object>> searchResult = null;

            switch (selectedOption) {
                case "CourseID":
                    searchResult = studentGradeBLL.searchStudentGradeByCourseID(searchQuery);
                    break;
                case "StudentID":
                    searchResult = studentGradeBLL.searchStudentGradeByStudentID(searchQuery);
                    break;
                case "Grade":
                    try {
                        float grade = Float.parseFloat(searchQuery);
                        searchResult = studentGradeBLL.searchStudentGradeByGrade(grade);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Invalid grade format");
                        }
                        break;
                case "Student Name":
                    searchResult = studentGradeBLL.searchStudentGradeByStudentName(searchQuery);
                    break;        
                case "Course Name":
                    searchResult = studentGradeBLL.searchStudentGradeByCourseName(searchQuery);
                    break;       
                default:
                    JOptionPane.showMessageDialog(this, "Invalid search option");
                    break;
            }

            if (searchResult != null) {
                // Xóa dữ liệu cũ trong bảng
                dtm.setRowCount(0);
                // Hiển thị kết quả tìm kiếm trên bảng
                for (List<Object> studentGradeInfo : searchResult) {
                    dtm.addRow(studentGradeInfo.toArray());
                }
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtStudentGrade;
    private javax.swing.JComboBox<String> searchcb;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
