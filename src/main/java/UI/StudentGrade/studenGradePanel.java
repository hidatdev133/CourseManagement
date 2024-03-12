package UI.StudentGrade;

import BLL.Course.CourseBLL;
import BLL.Person.StudentBLL;
import DAL.StudentGrade.StudentGrade;
import BLL.Person.StudentGradeBLL;
import DAL.CourseInstructor.CourseInstructor;
import DAL.StudentGrade.StudentGradeDAL;
import UI.CourseOnline.inforOnlineCourseForm;
import UI.Menu.menuForm;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class studenGradePanel extends javax.swing.JPanel {

    private Object[] stlistStu, stlistCour;
    DefaultTableModel dtm;
    StudentGradeBLL studentGradeBLL;
    private List<List<Object>> newRowsList = new ArrayList<>();

    public studenGradePanel() {
        initComponents();
        dtm = (DefaultTableModel) jtStudentGrade.getModel();
        studentGradeBLL = new StudentGradeBLL();

//        // Ẩn cột EnrollmentID trên bảng jtStudentGrade
//        jtStudentGrade.removeColumn(jtStudentGrade.getColumnModel().getColumn(0)); // Vị trí cột EnrollmentID là 0
        // Hiển thị dữ liệu
        displayStudentGrades();

    }

    /*--------------------------------------------------------------------------------*/
 /* Thiết lập bộ lắng nghe sự kiện để tự động điền Student Name và Course Name khi nhập Course ID và Student ID */
    private void addAutoCompletionListener() {
        // Thêm sự kiện người nghe cho cột Course ID
        jtStudentGrade.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JTextField() {
            public void actionPerformed(ActionEvent e) {
                // Khi giá trị của cột Course ID thay đổi
                updateCourseName();
            }
        }));

// Thêm sự kiện người nghe cho cột Student ID
        jtStudentGrade.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JTextField() {
            public void actionPerformed(ActionEvent e) {
                // Khi giá trị của cột Student ID thay đổi
                updateStudentName();
            }
        }));
    }

// Cập nhật tên sinh viên khi nhập Student ID
    private void updateStudentName() {
        int selectedRow = jtStudentGrade.getSelectedRow();
        int studentID = Integer.parseInt((String) jtStudentGrade.getValueAt(selectedRow, 2));
        String studentName = studentGradeBLL.getStudentName(studentID);
        dtm.setValueAt(studentName, selectedRow, 3); // Cập nhật tên sinh viên vào cột tương ứng trong bảng
    }

// Cập nhật tên khóa học khi nhập Course ID
    private void updateCourseName() {
        int selectedRow = jtStudentGrade.getSelectedRow();
        int courseID = Integer.parseInt((String) jtStudentGrade.getValueAt(selectedRow, 1));
        String courseName = studentGradeBLL.getTitle(courseID);
        dtm.setValueAt(courseName, selectedRow, 4); // Cập nhật tên khóa học vào cột tương ứng trong bảng
    }

// Không cần ghi đè mô hình bảng ngay khi khởi tạo
// Thiết lập cấu trúc và tính năng chỉnh sửa cho bảng sau khi hiển thị dữ liệu
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtStudentGrade = new javax.swing.JTable();
        btnInput = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        searchcb = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnSatistic = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(950, 513));

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
        jtStudentGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtStudentGradeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtStudentGrade);
        if (jtStudentGrade.getColumnModel().getColumnCount() > 0) {
            jtStudentGrade.getColumnModel().getColumn(3).setResizable(false);
            jtStudentGrade.getColumnModel().getColumn(4).setResizable(false);
        }

        btnInput.setBackground(new java.awt.Color(0, 161, 255));
        btnInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/reset.png"))); // NOI18N
        btnInput.setText("Input");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 161, 255));
        jLabel5.setText("STUDENT GRADE");

        searchcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CourseID", "StudentID", "Student Name", "Course Name", "Grade" }));

        btnSearch.setBackground(new java.awt.Color(0, 161, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/search (2).png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSatistic.setText("Satistic");
        btnSatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSatisticActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSatistic, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInput)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchcb, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel5)))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addComponent(btnSatistic))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnInput)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchcb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
// Hiển thị hộp thoại để nhập số lượng dòng
        String input = JOptionPane.showInputDialog("Enter the number of rows:");
        try {
            int numRows = Integer.parseInt(input);
            // Kiểm tra xem số lượng dòng làm sao
            if (numRows > 0) {
                // Thêm số lượng dòng được nhập vào bảng
                for (int i = 0; i < numRows; i++) {
                    int nextEnrollmentID = getNextEnrollmentID(); // Lấy EnrollmentID tiếp theo
                    dtm.addRow(new Object[]{nextEnrollmentID, null, null, null, null, null});
                    newRowsList.add(new ArrayList<>()); // Thêm dòng mới vào danh sách
                }

                // Cập nhật dòng hiện tại
                int currentRow = dtm.getRowCount() - numRows;

                // Chọn dòng đầu tiên
                jtStudentGrade.setRowSelectionInterval(currentRow, currentRow + numRows - 1);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a positive integer.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer.");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // Phương thức để lấy EnrollmentID tiếp theo
    private int getNextEnrollmentID() {
        int maxEnrollmentID = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            int currentEnrollmentID = (int) dtm.getValueAt(i, 0);
            if (currentEnrollmentID > maxEnrollmentID) {
                maxEnrollmentID = currentEnrollmentID;
            }
        }
        return maxEnrollmentID + 1; // Trả về EnrollmentID tiếp theo
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = jtStudentGrade.getSelectedRow();
        if (selectedRow != -1) {
            int enrollmentID = (int) jtStudentGrade.getValueAt(selectedRow, 0);
            int courseID = (int) jtStudentGrade.getValueAt(selectedRow, 1);
            int studentID = (int) jtStudentGrade.getValueAt(selectedRow, 2);
            Object gradeObj = jtStudentGrade.getValueAt(selectedRow, 5);

            // Chuyển đổi từ kiểu String sang kiểu BigDecimal
            BigDecimal grade = null;
            if (gradeObj != null && !gradeObj.toString().isEmpty()) {
                try {
                    grade = new BigDecimal(gradeObj.toString());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid grade format");
                    return;
                }
            }

            // Tiếp tục xử lý với giá trị grade đã chuyển đổi
            boolean success = studentGradeBLL.editStudentGrade(enrollmentID, courseID, studentID, grade);
            if (success) {
                JOptionPane.showMessageDialog(this, "Data updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update data.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
        }
    }//GEN-LAST:event_btnEditActionPerformed

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
                case "Student Name":
                    searchResult = studentGradeBLL.searchStudentGradeByStudentName(searchQuery);
                    break;
                case "Course Name":
                    searchResult = studentGradeBLL.searchStudentGradeByCourseName(searchQuery);
                    break;
                case "Grade":
                    try {
                    float grade = Float.parseFloat(searchQuery);
                    searchResult = studentGradeBLL.searchStudentGradeByGrade(grade);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid grade format");
                }
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

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        int courseID;
        int studentID;
        BigDecimal grade;
        for (int i = dtm.getRowCount() - newRowsList.size(); i < dtm.getRowCount(); i++) {
            if (jtStudentGrade.isRowSelected(i)) {
                courseID = 0;
                studentID = 0;
                grade = null;

                // Kiểm tra giá trị của cột CourseID
                Object courseIDValue = dtm.getValueAt(i, 1);
                if (courseIDValue != null) {
                    JOptionPane.showMessageDialog(this, "Course ID cannot be empty.");
                    return;
                } else {
                    try {
                        courseID = Integer.parseInt(courseIDValue.toString());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid Course ID format.");
                        return;
                    }
                }

                // Kiểm tra giá trị của cột StudentID
                Object studentIDValue = dtm.getValueAt(i, 2);
                if (studentIDValue == null || studentIDValue.toString().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Student ID cannot be empty.");
                    return;
                } else {
                    try {
                        studentID = Integer.parseInt(studentIDValue.toString());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid Student ID format.");
                        return;
                    }
                }

                // Kiểm tra giá trị của cột Grade (nếu có)
                Object gradeValue = dtm.getValueAt(i, 5);
                if (gradeValue != null && !gradeValue.toString().isEmpty()) {
                    try {
                        grade = new BigDecimal(gradeValue.toString());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid grade format");
                        return;
                    }
                }

                // Kiểm tra tính hợp lệ của CourseID và StudentID
                if (!isValidCourseAndStudent(i)) {
                    JOptionPane.showMessageDialog(this, "Course ID and Student ID combination already exists.");
                    return;
                }

                // Kiểm tra tính hợp lệ của dữ liệu và tiến hành lưu trữ vào cơ sở dữ liệu
                int success = studentGradeBLL.insertStudentGrade(courseID, studentID, grade != null ? grade.floatValue() : 0);
                if (success != 0) {
                    JOptionPane.showMessageDialog(this, "Data inserted successfully.");
                    displayStudentGrades();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to insert data.");
                }
            }
            // Xóa toàn bộ dữ liệu từ ArrayList sau khi đã lưu trữ thành công
            newRowsList.clear();
        }

    }//GEN-LAST:event_btnInputActionPerformed

    private void btnSatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSatisticActionPerformed
        Satistic tk = new Satistic();
        tk.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSatisticActionPerformed

    private void jtStudentGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStudentGradeMouseClicked
        if (evt.getClickCount() == 2) { // Kiểm tra xem double click đã xảy ra hay không
            int selectedRow = jtStudentGrade.getSelectedRow();
            if (selectedRow != -1) { // Kiểm tra xem đã chọn một dòng hay chưa
                int courseID = (int) jtStudentGrade.getValueAt(selectedRow, 1);
                int studentID = (int) jtStudentGrade.getValueAt(selectedRow, 2);

                // Tạo một đối tượng StudentGrade từ courseID và studentID
                StudentGrade selectedStudentGrade = new StudentGrade(); // Thay bằng cách lấy dữ liệu từ cơ sở dữ liệu hoặc bất kỳ nguồn dữ liệu nào khác
                selectedStudentGrade.setCourseID(courseID);
                selectedStudentGrade.setStudentID(studentID);

                // Hiển thị thông tin chi tiết của sinh viên
                inforStudentGrade detail = new inforStudentGrade(this, selectedStudentGrade);
                detail.setVisible(true);
            }
        }
    }//GEN-LAST:event_jtStudentGradeMouseClicked

    private boolean isValidCourseAndStudent(int row) {
        try {
            int currentCourseID = Integer.parseInt(dtm.getValueAt(row, 1).toString());
            int currentStudentID = Integer.parseInt(dtm.getValueAt(row, 2).toString());

            for (int i = 0; i < dtm.getRowCount(); i++) {
                if (i != row) { // Không so sánh hàng hiện tại với chính nó
                    int compareCourseID = Integer.parseInt(dtm.getValueAt(i, 1).toString());
                    int compareStudentID = Integer.parseInt(dtm.getValueAt(i, 2).toString());
                    if (currentCourseID == compareCourseID && currentStudentID == compareStudentID) {
                        return false;
                    }
                }
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Course ID or Student ID format.");
            return false;
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studenGradePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnSatistic;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtStudentGrade;
    private javax.swing.JComboBox<String> searchcb;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
