/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Course;

import BLL.Course.CourseBLL;
import BLL.Course.DepartmentBLL;
import BLL.Course.OnlineCourseBLL;
import BLL.Course.OnsiteCourseBLL;
import BLL.Person.CourseInstructorBLL;
import DAL.Course.Course;
import DAL.Course.Department;
import DAL.Course.OnlineCourse;
import DAL.Course.OnsiteCourse;
import UI.CourseOnline.editOnlineCourse;
import UI.CourseOnline.inforOnlineCourseForm;
import UI.OnsiteCourse.OnsiteCourseFormDetail;
import UI.OnsiteCourse.editOnsiteCourseForm;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author trant
 */
public class CourseForm extends javax.swing.JPanel {

    DepartmentBLL deBLL = new DepartmentBLL();
    OnlineCourseBLL onlineBLL = new OnlineCourseBLL();
    CourseInstructorBLL courseInstructorBLL = new CourseInstructorBLL();
    CourseBLL courseBLL = new CourseBLL();
    OnsiteCourseBLL onsiteCourseBLL = new OnsiteCourseBLL();
    /**
     * Creates new form CourseForm
     */
    public CourseForm() {
        moreInits();
        initComponents();
        loadDataToTableCourses();
    }

     public void moreInits(){
       renderer = new DefaultTableCellRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
       
      tbCourse = new JTable();
      
       modelTbOnlCourse = new DefaultTableModel(){
        @Override
            public boolean isCellEditable(int row, int column){
               return false;
           }
       };
       
       tbCourse.setModel(modelTbOnlCourse);
       modelTbOnlCourse.addColumn("STT");
       modelTbOnlCourse.addColumn("ID of Course");
       modelTbOnlCourse.addColumn("Title of Course");
       modelTbOnlCourse.addColumn("Credits");
       modelTbOnlCourse.addColumn("Department");
       modelTbOnlCourse.addColumn("Administrator");
       modelTbOnlCourse.addColumn("No.Students");
       
       scrollpane = new JScrollPane();
       scrollpane.setViewportView(tbCourse);
       

       
       
    }
    public void getListOfCourse(ArrayList<Course> listCourse){
        modelTbOnlCourse.setRowCount(0);
        int stt = 0;
        for (Course item : listCourse) {
            int id = item.getCourseID();
            stt ++;
            String title = item.getTitle();
            int credits = item.getCredit();
            Department de = deBLL.findDepartmentByID(item.getDepartmentID());
            String department = de.getName();
            String administrator = deBLL.getAdministratorName(de.getAdministrator());
            Object[] data = {stt,id, title, credits , department, administrator};
            modelTbOnlCourse.addRow(data);
        }
         for(int i = 0; i < tbCourse.getColumnCount(); i++){
            tbCourse.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
    public void getListOfOnsiteCourse(ArrayList<OnsiteCourse> listCourse){
        modelTbOnlCourse.setRowCount(0);
        int stt = 0;
        for (OnsiteCourse item : listCourse) {
            int id = item.getCourseID();
            stt ++;
            String title = item.getTitle();
            int credit = item.getCredits();
            Department de = deBLL.findDepartmentByID(item.getDepartmentID());
            String department = de.getName();
            String administrator = deBLL.getAdministratorName(de.getAdministrator());
            Object[] data = {stt,id, title,credit,  department, administrator};
            modelTbOnlCourse.addRow(data);
        }
         for(int i = 0; i < tbCourse.getColumnCount(); i++){
            tbCourse.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
    public void getListOfOnlineCourse(ArrayList<OnlineCourse> listCourse){
        modelTbOnlCourse.setRowCount(0);
        int stt = 0;
        for (OnlineCourse item : listCourse) {
            int id = item.getCourseID();
            stt ++;
            String title = item.getTitle();
            int credits = item.getCredit();
            Department de = deBLL.findDepartmentByID(item.getDepartmentID());
            String department = de.getName();
            String administrator = deBLL.getAdministratorName(de.getAdministrator());
            Object[] data = {stt,id, title, credits , department, administrator};
            modelTbOnlCourse.addRow(data);
        }
         for(int i = 0; i < tbCourse.getColumnCount(); i++){
            tbCourse.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
    
    public void loadDataToTableCourses(){
        
        modelCbbCourses = (DefaultComboBoxModel) cbbCourses.getModel();
        
        
        String choice = modelCbbCourses.getSelectedItem().toString();
        switch (choice) {
            case "All Courses":
                ArrayList<Course> listCourse ;
                listCourse = courseBLL.readCourseBLL();
                getListOfCourse(listCourse);
                break;
            case "Online Courses":
                ArrayList<OnlineCourse> listOnlineCourse = onlineBLL.listOfOnlineCourse();
                getListOfOnlineCourse(listOnlineCourse);
                break;
            case "Onsite Courses":
                ArrayList<OnsiteCourse> listOnsiteCourse = onsiteCourseBLL.readOnsiteCourse();
                getListOfOnsiteCourse(listOnsiteCourse);
                break;
            default:
                System.out.println("Load table failed");
        }
       
        
       TableColumnModel columnModel = tbCourse.getColumnModel();
       
       columnModel.getColumn(0).setPreferredWidth(1);
       columnModel.getColumn(1).setPreferredWidth(30);
       columnModel.getColumn(2).setPreferredWidth(100);
       columnModel.getColumn(3).setPreferredWidth(50);
       columnModel.getColumn(4).setPreferredWidth(150);
       columnModel.getColumn(5).setPreferredWidth(30);

    }
    
    public void loadSearchDataToTable(){
        modelTbOnlCourse.setRowCount(0);
        String text = txtSearch.getText();
        
        int stt = 0;
        
        String choice = modelCbbCourses.getSelectedItem().toString();
        switch (choice) {
            case "All Courses":
                ArrayList<Course> listSearch = courseBLL.searchAllOnlCourses(text);
                getListOfCourse(listSearch);
                break;
            case "Online Courses":
                ArrayList<OnlineCourse> listOnlineCourse = onlineBLL.searchAllOnlCourses(text);
                getListOfOnlineCourse(listOnlineCourse);
                break;
            case "Onsite Courses":
                ArrayList<OnsiteCourse> listOnsiteCourse = onsiteCourseBLL.listOnsiteSearchBLL(text);
                getListOfOnsiteCourse(listOnsiteCourse);
                break;
            default:
                System.out.println("Load table failed");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        cbbCourses = new javax.swing.JComboBox<>();
        scrollpane = new javax.swing.JScrollPane();
        tbCourse = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 161, 255));
        jLabel1.setText(" COURSES");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Features"));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 161, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/plus_icon.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 161, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/pencil.png"))); // NOI18N
        btnEdit.setText(" EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 161, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/delete (2).png"))); // NOI18N
        btnDelete.setText(" DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbbCourses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Courses", "Onsite Courses", "Online Courses", " " }));
        cbbCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCoursesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbCourses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        tbCourse.setModel(modelTbOnlCourse);
        tbCourse.setCellSelectionEnabled(false);
        tbCourse.setRowSelectionAllowed(true);
        tbCourse.setSelectionBackground(java.awt.SystemColor.activeCaption);
        tbCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCourseMousePressed(evt);
            }
        });
        scrollpane.setViewportView(tbCourse);
        tbCourse.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(scrollpane)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 928, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        addCourseForm addOnl = new addCourseForm(this);
        addOnl.setVisible(true);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int row = tbCourse.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Please choose online course you want to edit in table!");
            return;
        }
        int id_course = Integer.parseInt(modelTbOnlCourse.getValueAt(row, 1).toString());
        if(onlineBLL.isOnlineCourse(id_course)){
            OnlineCourse onl = onlineBLL.findOnlCourseByID(id_course);
            editOnlineCourse edit = new editOnlineCourse(this, onl);
            edit.setVisible(true);
        } else {
            OnsiteCourse onsite=onsiteCourseBLL.getOnsiteCourseByID(id_course);
            editOnsiteCourseForm editOnsiteForm=new editOnsiteCourseForm(this, onsite);
            editOnsiteForm.setVisible(true);
            
        }
        
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tbCourse.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Please choose online course you want to delete in table!");
            return;
        }
        int id_course = Integer.parseInt(modelTbOnlCourse.getValueAt(row, 1).toString());
        boolean result = courseInstructorBLL.isCourseInstructed(id_course);
        if(result){
            JOptionPane.showMessageDialog(this, "This course has been instructed. Please do not delete!");
        } else {
            int output = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this course?","Delele online course",JOptionPane.YES_NO_OPTION );
            if (output == JOptionPane.YES_OPTION) {
                if(onlineBLL.isOnlineCourse(id_course)){
                     JOptionPane.showMessageDialog(this, onlineBLL.deleteOnlCourse(id_course));
                }else if(onsiteCourseBLL.isOnsiteCourse(id_course)){
                   if(onsiteCourseBLL.deleteonsiteCourse(id_course)){
                       JOptionPane.showMessageDialog(this, "Delete Successful!");
                }else{
                       JOptionPane.showConfirmDialog(this, "Delete Failed!");
                   }
                }
               
                loadDataToTableCourses();
            }

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        loadSearchDataToTable();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        loadSearchDataToTable();
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        loadSearchDataToTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        loadSearchDataToTable();
    }//GEN-LAST:event_txtSearchKeyTyped

    private void cbbCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCoursesActionPerformed
        // TODO add your handling code here:
        loadDataToTableCourses();
    }//GEN-LAST:event_cbbCoursesActionPerformed

    private void tbCourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCourseMousePressed
        // TODO add your handling code here:
        Point point = evt.getPoint();
                int row = tbCourse.rowAtPoint(point);
                if(evt.getClickCount() == 2 && row != -1 ){
                           int id = Integer.parseInt(modelTbOnlCourse.getValueAt(row, 1).toString());
                           if(onlineBLL.isOnlineCourse(id) == true){
                               OnlineCourse onl = onlineBLL.findOnlCourseByID(id);
                               inforOnlineCourseForm inf = new inforOnlineCourseForm(this, onl);
                               inf.setVisible(true);
                           }
                           if(onsiteCourseBLL.isOnsiteCourse(id)==true){
                             
                               OnsiteCourse onsite=onsiteCourseBLL.getOnsiteCourseByID(id);
                               OnsiteCourseFormDetail onsiteform=new OnsiteCourseFormDetail(this, onsite);
                               onsiteform.setVisible(true);
                           }
                           
                }
    }//GEN-LAST:event_tbCourseMousePressed


    private DefaultComboBoxModel modelCbbCourses ;
    private TableColumnModel modelColumnTbOnlCourse ;
    private DefaultTableCellRenderer renderer;
    private DefaultTableModel modelTbOnlCourse ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbbCourses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable tbCourse;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
