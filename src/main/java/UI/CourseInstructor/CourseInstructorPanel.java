package UI.CourseInstructor;
import BLL.Person.TeacherBLL;
import BLL.Person.CourseInstructorBLL;
import DAL.CourseInstructor.CourseInstructor;
import DAL.CourseInstructor.CourseInstructorDAL;
import java.awt.Point;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CourseInstructorPanel extends javax.swing.JPanel {

    DefaultTableModel dtm;
    CourseInstructorBLL courseInstructorBLL;

    public CourseInstructorPanel(){
        initComponents();
        dtm = (DefaultTableModel) jtCourseInstructor.getModel();
        courseInstructorBLL = new CourseInstructorBLL();
        // Lắng nghe sự kiện khi combobox hoặc txtSearch thay đổi
        displayCourseInstructor();
        // Lấy dữ liệu cho combobox CourseID
        List<String> courseIDs = readCourseIDs();
        for (String courseID : courseIDs) {
            cbCourseID.addItem(courseID);
        }
        
    }

    private List<String> readCourseIDs() {
        CourseInstructorBLL courseinstructorBLL = new CourseInstructorBLL();
        return courseinstructorBLL.listcourseID();
    }

    private List<String> readTeacherIDs() {
        TeacherBLL teacherBLL = new TeacherBLL();
        return TeacherBLL.readDSID();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtGrade2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCourseInstructor = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbCourseID = new javax.swing.JComboBox<>();
        cbPersonID = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        cbSearch = new javax.swing.JComboBox<>();
        btnSatastic = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 513));

        jLabel2.setText("CourseID :");

        jtCourseInstructor.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jtCourseInstructor.setForeground(new java.awt.Color(102, 102, 102));
        jtCourseInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CourseID", "PersonID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCourseInstructor.setToolTipText("");
        jtCourseInstructor.setRowHeight(30);
        jtCourseInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCourseInstructorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCourseInstructor);

        btnReset.setBackground(new java.awt.Color(0, 161, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
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
        btnEdit.setText("Edit");
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

        txtSearch.setText("search here");
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSearchMouseReleased(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 161, 255));
        jLabel5.setText("COURSE INSTRUCTOR");

        jLabel6.setText("PersonID:");

        cbCourseID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCourseIDMouseClicked(evt);
            }
        });
        cbCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCourseIDActionPerformed(evt);
            }
        });

        cbPersonID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPersonIDMouseClicked(evt);
            }
        });
        cbPersonID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPersonIDActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(204, 204, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/search.png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CourseID", "PersonID" }));

        btnSatastic.setBackground(new java.awt.Color(153, 153, 255));
        btnSatastic.setText("Satastic");
        btnSatastic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSatasticMouseClicked(evt);
            }
        });
        btnSatastic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSatasticActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(47, 47, 47)
                                    .addComponent(cbPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(btnSatastic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPersonID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSatastic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtCourseInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCourseInstructorMouseClicked
        String selectCourseID = String.valueOf(jtCourseInstructor.getValueAt(jtCourseInstructor.getSelectedRow(), 0));
        String selectPersonID = String.valueOf(jtCourseInstructor.getValueAt(jtCourseInstructor.getSelectedRow(),1));
        int courseID = Integer.parseInt(selectCourseID);
        int personID = Integer.parseInt(selectPersonID);
        cbCourseID.setSelectedItem(selectCourseID); // Set selected item in the combobox
        cbPersonID.setSelectedItem(selectPersonID);
        Point point = evt.getPoint();
        CourseInstructor inforcourse;
        int row = jtCourseInstructor.rowAtPoint(point);
                if(evt.getClickCount() == 2 && row != -1 ){
                    inforcourse =  courseInstructorBLL.readCourseInstructorByIDs(courseID, personID);
                    inforCourseInstructorFrom detail = new inforCourseInstructorFrom(this, inforcourse);
                    detail.setVisible(true); 
                }
    }//GEN-LAST:event_jtCourseInstructorMouseClicked

    private void displayCourseInstructor(){
        dtm.setRowCount(0); // Xóa dữ liệu trước đó

        cbCourseID.setSelectedItem(null);
        cbPersonID.setSelectedItem(null);

        // Gọi phương thức từ DAL để lấy danh sách các thông tin của course instructor
        CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
        List<CourseInstructor> courseInstructorList = courseInstructorDAL.readCourseInstructor();

        // Duyệt qua danh sách và thêm dữ liệu vào bảng
        for (CourseInstructor courseInstructor : courseInstructorList) {
            dtm.addRow(new Object[]{
                courseInstructor.getCourseID(),
                courseInstructor.getPersonID(),
            });
        }
    }

   
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        displayCourseInstructor();
        cbCourseID.setSelectedItem(null);
        cbPersonID.setSelectedItem(null);
        txtSearch.setText("search here");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String courseIDStr = (String) cbCourseID.getSelectedItem();
        String personIDStr = (String) cbPersonID.getSelectedItem();

        // Chuyển đổi từ String sang int
        int courseID = Integer.parseInt(courseIDStr);
        int personID = Integer.parseInt(personIDStr);
        
        CourseInstructor newcourseinstructor = new CourseInstructor();
        newcourseinstructor.setCourseID(courseID);
        newcourseinstructor.setPersonID(personID);
        
        boolean success = courseInstructorBLL.addCourseInstructor(newcourseinstructor);
        if (success) {
        JOptionPane.showMessageDialog(this, "Thêm giảng viên vào khóa học thành công.");
        displayCourseInstructor();
    } else {
        JOptionPane.showMessageDialog(this, "Thêm giảng viên không thành công. Vui lòng thử lại.");
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String courseID = (String) cbCourseID.getSelectedItem();
        String oldPersonID = String.valueOf(jtCourseInstructor.getValueAt(jtCourseInstructor.getSelectedRow(),1));
        String newpersonID = (String) cbPersonID.getSelectedItem();
        boolean success = courseInstructorBLL.editCourseInstructor(courseID,oldPersonID,newpersonID);
        if(success){
            JOptionPane.showMessageDialog(this, "Sửa thành công.");
            displayCourseInstructor();
        } 
        else {
        JOptionPane.showMessageDialog(this, "Sửa không thành công. Vui lòng thử lại.");
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String selectCourseID = String.valueOf(jtCourseInstructor.getValueAt(jtCourseInstructor.getSelectedRow(), 0));
        String selectPersonID = String.valueOf(jtCourseInstructor.getValueAt(jtCourseInstructor.getSelectedRow(),1));
        int courseID = Integer.parseInt(selectCourseID);
        int personID = Integer.parseInt(selectPersonID);
        boolean success = courseInstructorBLL.deleteCourseInstructor(courseID, personID);
        if(success){
            JOptionPane.showMessageDialog(this, "Xóa thành công.");
            displayCourseInstructor();
        } 
        else {
        JOptionPane.showMessageDialog(this, "Xóa không thành công. Vui lòng thử lại.");
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCourseIDActionPerformed
       if (cbCourseID.getSelectedItem() != null) {
        String selectedCourseID = cbCourseID.getSelectedItem().toString();
        List<String> personIDs = courseInstructorBLL.getPersonIDsByCourseID(selectedCourseID);
        removeExistingPersonIDs(personIDs);
    } else {
        
        String selectedCourseID = "1050";
        List<String> personIDs = courseInstructorBLL.getPersonIDsByCourseID(selectedCourseID);
        removeExistingPersonIDs(personIDs);
    }
    }//GEN-LAST:event_cbCourseIDActionPerformed
    private void removeExistingPersonIDs(List<String> personIDs) {
    cbPersonID.removeAllItems(); // Xóa tất cả các items hiện có trong combobox

    // Lấy danh sách teacherIDs
    List<String> teacherIDs = readTeacherIDs();

    // Loại bỏ những teacherID đã có trong danh sách personIDs
    teacherIDs.removeAll(personIDs);

    // Thêm các teacherID còn lại vào combobox
    for (String teacherID : teacherIDs) {
        cbPersonID.addItem(teacherID);
    }
}


    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
            
    }//GEN-LAST:event_btnResetMouseClicked

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText(" ");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseReleased
        
    }//GEN-LAST:event_txtSearchMouseReleased

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed

    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbPersonIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPersonIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPersonIDActionPerformed

    private void cbCourseIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCourseIDMouseClicked
       
    }//GEN-LAST:event_cbCourseIDMouseClicked

    private void cbPersonIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPersonIDMouseClicked
        if (cbCourseID.getSelectedItem() != null) {
        String selectedCourseID = cbCourseID.getSelectedItem().toString();
        List<String> personIDs = courseInstructorBLL.getPersonIDsByCourseID(selectedCourseID);
        removeExistingPersonIDs(personIDs);
    } else {
        
        String selectedCourseID = "1050";
        List<String> personIDs = courseInstructorBLL.getPersonIDsByCourseID(selectedCourseID);
        removeExistingPersonIDs(personIDs);
    }

    }//GEN-LAST:event_cbPersonIDMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String type = (String) cbSearch.getSelectedItem();
        String searchText = txtSearch.getText().trim(); // Lấy từ khóa tìm kiếm từ JTextField
        if (searchText.isEmpty() || searchText.equals("search here")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm.");
            return;
        }
        List<CourseInstructor> searchResult = courseInstructorBLL.searchCourseByID(type,searchText);
        if (searchResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
        } else {
            // Hiển thị kết quả lên JTable
            DefaultTableModel model = (DefaultTableModel) jtCourseInstructor.getModel();
            model.setRowCount(0); // Xóa tất cả các dòng trong JTable

            // Điền dữ liệu từ kết quả tìm kiếm vào JTable
            if("CourseID".equals(type) ){
                for (CourseInstructor ID : searchResult) {
                    Object[] row = {ID.getCourseID(),ID.getPersonID()};
                    model.addRow(row);
                }
            }else{
                    for (CourseInstructor ID : searchResult) {
                    Object[] row = {ID.getCourseID(),ID.getPersonID()};
                    model.addRow(row);
                    }
            }
             jtCourseInstructor.getTableHeader().repaint();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSatasticMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSatasticMouseClicked
         ThongKeCourseInstructor Satastic = new ThongKeCourseInstructor(this);
         Satastic.setVisible(true); 
    }//GEN-LAST:event_btnSatasticMouseClicked

    private void btnSatasticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSatasticActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSatasticActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSatastic;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbCourseID;
    private javax.swing.JComboBox<String> cbPersonID;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtCourseInstructor;
    private javax.swing.JTextField txtGrade2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
