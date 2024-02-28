/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.OnsiteCourse;

import BLL.Course.CourseBLL;
import BLL.Course.DepartmentBLL;
import BLL.Course.OnsiteCourseBLL;
import DAL.Course.DepartmentDAL;
import DAL.Course.OnsiteCourse;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import DAL.Course.Department;
import javax.swing.JOptionPane;
/**
 *
 * @author hp_pc
 */
public class OnsiteCourseForm extends javax.swing.JPanel {
    DefaultTableModel model;
   
    ArrayList<Department>listDepartment=new ArrayList<>();
    OnsiteCourseBLL onsiteCourseBLL;
    DepartmentBLL departmentBLL;
    ArrayList<OnsiteCourse>listOnsiteCourse=new ArrayList<>();
    CourseBLL courseBLL;
     
    int row =0;
    public OnsiteCourseForm() {
         initComponents();
        onsiteCourseBLL=new OnsiteCourseBLL();
        departmentBLL=new DepartmentBLL();
        courseBLL=new CourseBLL();
        displayDatatoTable();
        displayDatatoComboBox();
      
       
    }
       public void displayDatatoTable(){
        listOnsiteCourse=onsiteCourseBLL.readOnsiteCourse();
          model=(DefaultTableModel)jTableCourseOnsite.getModel();
         model.setRowCount(0);
         for(OnsiteCourse onsite:listOnsiteCourse){
             model.addRow(new Object[]{onsite.getCourseID(),onsite.getTitle(),onsite.getCredits(),onsite.getDepartmentID(),onsite.getLocation(),onsite.getDays(),onsite.getTime()});
         }
         
     }
       public void displayDatatoComboBox(){
          listDepartment=departmentBLL.readListDepartment();
         DefaultComboBoxModel comboModel=new DefaultComboBoxModel();
         for(Department department:listDepartment){
             comboModel.addElement(department);
         }
         jcomboDepartment.setModel(comboModel);
       }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jtxtSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtCourseID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtTitle = new javax.swing.JTextField();
        jtxtCredit = new javax.swing.JTextField();
        jtxtLocation = new javax.swing.JTextField();
        jtxtDay = new javax.swing.JTextField();
        jtxtTime = new javax.swing.JTextField();
        jcomboDepartment = new javax.swing.JComboBox<>();
        jbtAdd = new javax.swing.JButton();
        jbtedit = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jbtdelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCourseOnsite = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 161, 255));
        jLabel1.setText("ONSITE COURSE");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jtxtSearch.setText("Search here...");
        jtxtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtxtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtSearchFocusLost(evt);
            }
        });
        jtxtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSearchActionPerformed(evt);
            }
        });
        jtxtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("CourseID");

        jtxtCourseID.setEditable(false);

        jLabel3.setText("Title");

        jLabel4.setText("Credits");

        jLabel5.setText("DepartmentID");

        jLabel6.setText("Location");

        jLabel7.setText("Days");

        jLabel8.setText("Time");

        jcomboDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/add.png"))); // NOI18N
        jbtAdd.setText("ADD");
        jbtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddMouseClicked(evt);
            }
        });

        jbtedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/pencil.png"))); // NOI18N
        jbtedit.setText("EDIT");
        jbtedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbteditMouseClicked(evt);
            }
        });
        jbtedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbteditActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/reset.png"))); // NOI18N
        jButton4.setText("RESET");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jbtdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/delete (2).png"))); // NOI18N
        jbtdelete.setText("DELETE");
        jbtdelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtdeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jbtAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtedit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtDay)
                            .addComponent(jtxtLocation)
                            .addComponent(jcomboDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtTime, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtTitle)
                            .addComponent(jtxtCredit))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtAdd)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtedit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableCourseOnsite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CourseID", "Title", "Credits", "DepartmentID", "Location", "Days", "Time"
            }
        ));
        jTableCourseOnsite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCourseOnsiteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCourseOnsite);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSearchActionPerformed

    private void jbteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbteditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbteditActionPerformed

    private void jTableCourseOnsiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCourseOnsiteMouseClicked
    
        row=jTableCourseOnsite.getSelectedRow();
       if(row==-1)return ;
       OnsiteCourse onsite=listOnsiteCourse.get(row);
       int index=departmentBLL.indexOfIDdepartment(Integer.parseInt(model.getValueAt(row, 3).toString()));
       jcomboDepartment.setSelectedIndex(index);
       jtxtCourseID.setText(model.getValueAt(row, 0).toString());
       jtxtTitle.setText(model.getValueAt(row, 1).toString());
       jtxtCredit.setText(model.getValueAt(row, 2).toString());
       jtxtLocation.setText(model.getValueAt(row, 4).toString());
       jtxtDay.setText(model.getValueAt(row, 5).toString());
       jtxtTime.setText(model.getValueAt(row, 6).toString());
        System.out.print(onsite.getCourseID());
    }//GEN-LAST:event_jTableCourseOnsiteMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
       onsiteCourseBLL.reset(jtxtCourseID, jtxtTitle, jtxtCredit, jcomboDepartment, jtxtLocation, jtxtDay, jtxtTime);
//        jcomboDepartment.setSelectedIndex(-1);
//       jtxtCourseID.setText("");
//       jtxtTitle.setText("");
//       jtxtCredit.setText("");
//       jtxtLocation.setText("");
//       jtxtDay.setText("");
//       jtxtTime.setText("");
    }//GEN-LAST:event_jButton4MouseClicked

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
      if(jtxtTitle.getText().isEmpty()||jtxtCredit.getText().isEmpty()||jtxtCredit.getText().isEmpty()||jcomboDepartment.getSelectedItem().equals(null)|
              jtxtLocation.getText().isEmpty()||jtxtDay.getText().isEmpty()||jtxtTime.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Add Data Invalid");
          return ;
      }
      else if(jtxtCourseID.getText().equals(model.getValueAt(row, 0).toString())){
          JOptionPane.showMessageDialog(null, "Onsite Course exist");
          return;
      }
      else{
          if(!jtxtCredit.getText().matches("\\d+")){
          JOptionPane.showMessageDialog(null, "Credit must be number");
          return;
      }
          int input=JOptionPane.showConfirmDialog(null, "Are you sure Add data?","Add Data", JOptionPane.YES_NO_OPTION);
          if(input==JOptionPane.YES_OPTION){
           
       String Title=jtxtTitle.getText();
        
      int credit=Integer.parseInt(jtxtCredit.getText());
     
      int department=Integer.parseInt(jcomboDepartment.getSelectedItem().toString());
      String location=jtxtLocation.getText();
      String Day=jtxtDay.getText();
      String Time=jtxtTime.getText();
      
      if(courseBLL.addCourseBLL( Title, credit, department)){
            int id=courseBLL.getCourseID();
          if(onsiteCourseBLL.addOnsiteCourseBLL(id, location, Day, Time)){
          JOptionPane.showMessageDialog(null, "Add Data Successful");
      }
      }else{
          JOptionPane.showMessageDialog(null, "Add Data Failed");
      } 
          }
        
      }
      displayDatatoTable();
       onsiteCourseBLL.reset(jtxtCourseID, jtxtTitle, jtxtCredit, jcomboDepartment, jtxtLocation, jtxtDay, jtxtTime);
      
    }//GEN-LAST:event_jbtAddMouseClicked

    private void jbteditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbteditMouseClicked
     if(jtxtTitle.getText().isEmpty()||jtxtCredit.getText().isEmpty()||jcomboDepartment.getSelectedItem().equals(null)||jtxtLocation.getText().isEmpty()||jtxtDay.getText().isEmpty()||jtxtTime.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Edit Data Invalid");
         return;
     }
      int id=Integer.parseInt(jtxtCourseID.getText());
      String Location=jtxtLocation.getText();
      String Day=jtxtDay.getText();
      String Time=jtxtTime.getText();
      String Title=jtxtTitle.getText();
       if(!jtxtCredit.getText().matches("\\d+")){
          JOptionPane.showMessageDialog(null, "Credit must be number");
          return;
      }
      int Credit=Integer.parseInt(jtxtCredit.getText());
     int Department=Integer.parseInt(jcomboDepartment.getSelectedItem().toString()) ;
      int input=JOptionPane.showConfirmDialog(null,"Are you sure edit this course", "Confirm Edit", JOptionPane.YES_NO_OPTION);
      if(input==JOptionPane.YES_OPTION){
           if(courseBLL.editCourseBLL(id, Title, Credit, Department)&&onsiteCourseBLL.editOnsiteCourseBLL(id, Location, Day, Time)){
          JOptionPane.showMessageDialog(null, "Edit Successful");
          displayDatatoTable();
        displayDatatoComboBox();
      }else{
          JOptionPane.showConfirmDialog(null, "Edit Data Failed");
      }
      }
     
        
    }//GEN-LAST:event_jbteditMouseClicked

    private void jtxtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchKeyReleased
      if(jtxtSearch.getText()!=""){
        ArrayList< OnsiteCourse> listSearchOnsiteCourse=new ArrayList<>();
        listSearchOnsiteCourse=onsiteCourseBLL.listOnsiteSearchBLL(jtxtSearch.getText());
        model.setRowCount(0);
         for(OnsiteCourse onsitesearch:listSearchOnsiteCourse){
             model.addRow(new Object[]{onsitesearch.getCourseID(),onsitesearch.getTitle(),onsitesearch.getCredits(),onsitesearch.getDepartmentID(),onsitesearch.getLocation(),onsitesearch.getDays(),onsitesearch.getTime()});
         }
      }
      else{
         
          displayDatatoTable();
      }
    }//GEN-LAST:event_jtxtSearchKeyReleased

    private void jbtdeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtdeleteMouseClicked
     
        System.out.println("kết quả"+jtxtCourseID.getText().isEmpty());
        if(jtxtCourseID.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Please select course to delete");
           return ;
       }
          int id=Integer.parseInt(jtxtCourseID.getText().toString());
        if(onsiteCourseBLL.courseIDcheckDelete(id)){
            int input=JOptionPane.showConfirmDialog(null, "Are you sure delete this course","Confirm Delete", JOptionPane.YES_NO_OPTION);
            if(input==JOptionPane.YES_OPTION){
                if(onsiteCourseBLL.deleteonsiteCourse(id)&&courseBLL.deletecoursonsite(id)){
                    JOptionPane.showMessageDialog(null, "Delete Successful!");
                }else{
                    JOptionPane.showMessageDialog(null, "Delete Failed!");
            }
       }
        }
       else{
           JOptionPane.showMessageDialog(null, "Can't Delete This Course");
       }
        displayDatatoTable();
         onsiteCourseBLL.reset(jtxtCourseID, jtxtTitle, jtxtCredit, jcomboDepartment, jtxtLocation, jtxtDay, jtxtTime);
        
    }//GEN-LAST:event_jbtdeleteMouseClicked

    private void jtxtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtSearchFocusLost
        if(jtxtSearch.getText().trim().equals("")){
            jtxtSearch.setText("Search here...");
        }
    }//GEN-LAST:event_jtxtSearchFocusLost

    private void jtxtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtSearchFocusGained
      if(jtxtSearch.getText().trim().equals("Search here...")){
          jtxtSearch.setText("");
      }
    }//GEN-LAST:event_jtxtSearchFocusGained

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCourseOnsite;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtdelete;
    private javax.swing.JButton jbtedit;
    private javax.swing.JComboBox<String> jcomboDepartment;
    private javax.swing.JTextField jtxtCourseID;
    private javax.swing.JTextField jtxtCredit;
    private javax.swing.JTextField jtxtDay;
    private javax.swing.JTextField jtxtLocation;
    private javax.swing.JTextField jtxtSearch;
    private javax.swing.JTextField jtxtTime;
    private javax.swing.JTextField jtxtTitle;
    // End of variables declaration//GEN-END:variables
}