/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.OnsiteCourse;

import BLL.Course.CourseBLL;
import BLL.Course.DepartmentBLL;
import BLL.Course.OnlineCourseBLL;
import BLL.Course.OnsiteCourseBLL;
import DAL.Course.Department;
import DAL.Course.OnsiteCourse;
import UI.Course.CourseForm;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author hp_pc
 */
public class editOnsiteCourseForm extends javax.swing.JFrame {

    /**
     * Creates new form editOnsiteCourseForm
     */
   
    OnsiteCourseBLL onsiteBLL=new OnsiteCourseBLL();
    CourseBLL courseBLL=new CourseBLL();
    OnsiteCourse onsitecourse;
    DepartmentBLL departBLL=new DepartmentBLL();
    CourseForm parent;
    public editOnsiteCourseForm() {
        initComponents();
        
    }
    public editOnsiteCourseForm(CourseForm form, OnsiteCourse onsite){
        initComponents();
        parent=form;
        onsitecourse=onsite;
        loadInfortoForm();
        loadJComboCredits();
        loadJComboDepart();
    }
 public void loadJComboCredits(){
        modelComboCredit=new DefaultComboBoxModel();
        jComboCredit.setModel(modelComboCredit);
        modelComboCredit.setSelectedItem(onsitecourse.getCredits());
        for(int i = 1 ; i <= 10 ; i++){
            modelComboCredit.addElement(i);
        }
    }
 public void loadJComboDepart(){
     modelComboDepartment=new DefaultComboBoxModel();
     jcomboDepartment.setModel(modelComboDepartment);
     ArrayList <Department> departmentList=new ArrayList<>();
     departmentList=departBLL.readListDepartment();
     for(Department department:departmentList){
         modelComboDepartment.addElement(department.getName());
         if(department.getDepartmentID()==onsitecourse.getDepartmentID()){
             modelComboDepartment.setSelectedItem(department.getName());
         }
     }
     loadInforOfDepartment();
 }
 public void loadInforOfDepartment(){
        String name = modelComboDepartment.getSelectedItem().toString();
        ArrayList<Department> listBudget = departBLL.searchDepartmentsByName(name);
        for(Department item : listBudget){
            txtBudget.setText(item.getBudget().toString());
            txtAdmin.setText(departBLL.getAdministratorName(item.getAdministrator()));
            txtStartDate.setText(item.getStartDate());
        }
        
    }
 public void loadInfortoForm(){
     txtCourseID.setText(onsitecourse.getCourseID()+"");
     txtTitle.setText(onsitecourse.getTitle());
     txtLocation.setText(onsitecourse.getLocation());
     ArrayList <String> listday=onsiteBLL.cutDay(onsitecourse.getDays());
     onsiteBLL.loadDaytoCombo(listday, checkBoxMonday, checkBoxTuesday, checkBoxWednesday, checkBoxThursday, checkBoxFriday, checkBoxSaturay);
     txtTime.setText(onsitecourse.getTime());
     
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 private DefaultComboBoxModel modelComboCredit;
 private DefaultComboBoxModel modelComboDepartment;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCourseID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcomboDepartment = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBudget = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAdmin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboCredit = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        checkBoxMonday = new javax.swing.JCheckBox();
        checkBoxTuesday = new javax.swing.JCheckBox();
        checkBoxWednesday = new javax.swing.JCheckBox();
        checkBoxThursday = new javax.swing.JCheckBox();
        checkBoxFriday = new javax.swing.JCheckBox();
        checkBoxSaturay = new javax.swing.JCheckBox();
        labelgetTime = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btCancel = new javax.swing.JButton();
        jbtSave = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 161, 255));
        jLabel1.setText("EDIT ONSITE COURSE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Course ID");

        txtCourseID.setEditable(false);

        jLabel4.setText("Department");

        jcomboDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcomboDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcomboDepartmentMouseClicked(evt);
            }
        });
        jcomboDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboDepartmentActionPerformed(evt);
            }
        });

        jLabel5.setText("Start Date");

        txtStartDate.setEditable(false);
        txtStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartDateActionPerformed(evt);
            }
        });

        jLabel6.setText("Budget");

        txtBudget.setEditable(false);

        jLabel7.setText("Administrator");

        txtAdmin.setEditable(false);

        jLabel2.setText("Title");

        jLabel3.setText("Credit");

        jComboCredit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Location");

        jLabel11.setText("Time");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Days"));

        checkBoxMonday.setText("Monday");
        checkBoxMonday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxMondayActionPerformed(evt);
            }
        });

        checkBoxTuesday.setText("Tuesday");

        checkBoxWednesday.setText("Wednesday");

        checkBoxThursday.setText("Thursday");

        checkBoxFriday.setText("Friday");

        checkBoxSaturay.setText("Saturday");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkBoxFriday, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(checkBoxMonday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkBoxWednesday, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxThursday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxTuesday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxSaturay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxTuesday)
                    .addComponent(checkBoxMonday, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxWednesday)
                    .addComponent(checkBoxThursday))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxFriday)
                    .addComponent(checkBoxSaturay))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelgetTime, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTime)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCourseID)
                        .addComponent(jcomboDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBudget)
                        .addComponent(txtAdmin)
                        .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(538, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addComponent(labelgetTime)
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcomboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(111, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btCancel.setForeground(new java.awt.Color(255, 51, 51));
        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/previous.png"))); // NOI18N
        btCancel.setText("CANCEL");
        btCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelMouseClicked(evt);
            }
        });

        jbtSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtSave.setForeground(new java.awt.Color(0, 204, 51));
        jbtSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/online.png"))); // NOI18N
        jbtSave.setText("SAVE");
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(btCancel)
                .addGap(113, 113, 113)
                .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancel)
                    .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartDateActionPerformed

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
       if(txtTitle.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please enter TITLE");
           return;
       }
       if(txtLocation.getText().equals("")){
           JOptionPane.showMessageDialog(this, "please enter LOCATION");
           return;
       }
           if(!checkBoxMonday.isSelected()&&!checkBoxTuesday.isSelected()&&!checkBoxWednesday.isSelected()
                &&!checkBoxThursday.isSelected()&&!checkBoxFriday.isSelected()&&!checkBoxSaturay.isSelected()){
            JOptionPane.showMessageDialog(this, "Please choose DAY");
            return;
        }
       if(jComboCredit.getSelectedItem()==""){
           JOptionPane.showMessageDialog(this, "Please Choose CREDIT");
           return;
       }
       if(jcomboDepartment.getSelectedItem()==""){
           JOptionPane.showMessageDialog(this, "Please Choose DEPARTMENT");
           return;
       }
       if(txtTime.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Please choose TIME");
           return;
       }
       
       String expression="^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
        Pattern pattern =Pattern.compile(expression);
        Matcher matcher=pattern.matcher(txtTime.getText());
        if(matcher.matches()==false){
            JOptionPane.showMessageDialog(this, "TIME must be HH:MM:SS");
            return;
        }
        LocalTime StartTime=LocalTime.of(7,0, 0);
        LocalTime EndTime=LocalTime.of(17,30,0);
        String getTime=txtTime.getText().substring(0,txtTime.getText().indexOf(":") );
         LocalTime time=LocalTime.now();
        if(getTime.length()==2){
           time =LocalTime.parse(txtTime.getText());
        }else if(getTime.length()==1){
            time=LocalTime.parse(txtTime.getText(), DateTimeFormatter.ofPattern("H:mm:ss"));
        }
       
        if(time.isBefore(StartTime)||time.isAfter(EndTime)){
            JOptionPane.showMessageDialog(this, "TIME must be from 7:00:00 to 17:30:00");
            return ;
        }
        
        
        int idCourse=Integer.parseInt(txtCourseID.getText());
        int Credit=Integer.parseInt(jComboCredit.getSelectedItem().toString());
        Department department=new Department();
        department.setName(jcomboDepartment.getSelectedItem().toString());
        department.setStartDate(txtStartDate.getText());
        department.setBudget(Double.parseDouble(txtBudget.getText()));
       int departmentID=departBLL.findDepartmentIDByAllInfor(department).getDepartmentID();
       String day=onsiteBLL.getDay(checkBoxMonday, checkBoxTuesday, checkBoxWednesday, checkBoxThursday, checkBoxFriday, checkBoxSaturay);
       
      OnsiteCourse onsite=new OnsiteCourse();
      onsite.setCourseID(Integer.parseInt((txtCourseID.getText())));
      onsite.setTitle(txtTitle.getText());
      onsite.setDays(day);
      onsite.setLocation(txtLocation.getText());
      onsite.setTime(txtTime.getText());
       String mess=onsiteBLL.checkTimeInValid(onsite);
          if(onsitecourse.getLocation().equals(onsite.getLocation())){
        if(mess!=null){
          JOptionPane.showMessageDialog(this, mess);
          return;
      }
     }else if(onsiteBLL.Count(onsite)>1&&mess!=null&&!onsitecourse.getLocation().equals(onsite.getLocation())){
         JOptionPane.showMessageDialog(this, "Location full of shift, Please enter orther Location");
         return;
     }
     else if(mess!=null){
         
          JOptionPane.showMessageDialog(this, mess);
          return;
      }
    
       int option=JOptionPane.showConfirmDialog(this, "Are You Sure Edit This Course?", "Edit Onsite Course",JOptionPane.YES_NO_OPTION);
       if(option==JOptionPane.YES_OPTION){
           if(onsiteBLL.editOnsiteCourseBLL(idCourse, txtLocation.getText(),day,txtTime.getText(),txtTitle.getText(),Credit,departmentID)){
               JOptionPane.showMessageDialog(this,"Edit Data Successful!");
           }else{
               JOptionPane.showMessageDialog(this, "Edit Data Failed");
           }
       }
       parent.loadDataToTableCourses();
   
        
        
        
    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jcomboDepartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcomboDepartmentMouseClicked
       
    }//GEN-LAST:event_jcomboDepartmentMouseClicked

    private void jcomboDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboDepartmentActionPerformed
       loadInforOfDepartment();
    }//GEN-LAST:event_jcomboDepartmentActionPerformed

    private void btCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelMouseClicked
       this.setVisible(false);
    }//GEN-LAST:event_btCancelMouseClicked

    private void checkBoxMondayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxMondayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxMondayActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(editOnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(editOnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(editOnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(editOnsiteCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new editOnsiteCourseForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JCheckBox checkBoxFriday;
    private javax.swing.JCheckBox checkBoxMonday;
    private javax.swing.JCheckBox checkBoxSaturay;
    private javax.swing.JCheckBox checkBoxThursday;
    private javax.swing.JCheckBox checkBoxTuesday;
    private javax.swing.JCheckBox checkBoxWednesday;
    private javax.swing.JComboBox<String> jComboCredit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbtSave;
    private javax.swing.JComboBox<String> jcomboDepartment;
    private javax.swing.JLabel labelgetTime;
    private javax.swing.JTextField txtAdmin;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
