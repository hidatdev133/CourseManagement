/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.Course;

import BLL.Course.CourseBLL;
import BLL.Course.DepartmentBLL;
import BLL.Course.OnlineCourseBLL;
import BLL.Course.OnsiteCourseBLL;
import DAL.Course.Department;
import DAL.Course.OnlineCourse;
import DAL.Course.OnsiteCourse;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trant
 */
public class addCourseForm extends javax.swing.JFrame {

    /**
     * Creates new form addCourseForm
     */
    private DepartmentBLL departmentBLL = new DepartmentBLL();
    private OnlineCourseBLL onlineCourseBLL = new OnlineCourseBLL();
    private CourseBLL courseBLL=new CourseBLL();
    private OnsiteCourseBLL onsiteCourseBLL=new OnsiteCourseBLL();
    CourseForm parent ; 
    
    public addCourseForm( CourseForm layout) {
        initComponents();
        loadCbbDepartment();
        loadCbbCredits();
        parent = layout;
        panelOnline.setVisible(false);
       
    }

        public void loadCbbDepartment(){
        modelCbbDepartment = new DefaultComboBoxModel();
        cbbDepartment.setModel(modelCbbDepartment);
        modelCbbDepartment.setSelectedItem("");
        ArrayList<Department> listDepartment = departmentBLL.readListDepartment();
        for(Department item : listDepartment){
            modelCbbDepartment.addElement(item.getName());
        }
    }
    
    public void loadCbbCredits(){
        modelCbbCredits = new DefaultComboBoxModel();
        cbbCredits.setModel(modelCbbCredits);
        modelCbbCredits.setSelectedItem("");
        for(int i = 1 ; i <= 10 ; i++){
            modelCbbCredits.addElement(i);
        }
    }
    public void loadInforOfDepartment(){
        String name = modelCbbDepartment.getSelectedItem().toString();
        ArrayList<Department> listBudget = departmentBLL.searchDepartmentsByName(name);
        for(Department item : listBudget){
            txtBudget.setText(item.getBudget().toString());
            txtAdministrator.setText(departmentBLL.getAdministratorName(item.getAdministrator()));
            txtStartDate.setText(item.getStartDate());
        }
    }
    
    public void addOnlineCourse(){
        if(txtURL.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter LINK OF COURSE!");
            return ;
        }
        
        ArrayList<OnlineCourse> listOnl = onlineCourseBLL.listOfOnlineCourse();
        for(OnlineCourse onlCourse : listOnl){
            if(txtTitle.getText().equals(onlCourse.getTitle())){
                JOptionPane.showMessageDialog(this, "The title of course existed!");
                return ;
            }
            if(txtURL.getText().equals(onlCourse.getURL())){
                JOptionPane.showMessageDialog(this, "The link of course existed!");
                return ;
            }
        }
            
        String departmentName = modelCbbDepartment.getSelectedItem().toString();
        double budget = Double.parseDouble(txtBudget.getText());
        String startDate = txtStartDate.getText();
        Department de = new Department();
        de.setName(departmentName);
        de.setBudget(budget);
        de.setStartDate(startDate);
        int departmentID = departmentBLL.findDepartmentIDByAllInfor(de).getDepartmentID();
        
        
        OnlineCourse onl = new OnlineCourse();
        onl.setTitle(txtTitle.getText());
        onl.setCredit(Integer.parseInt(modelCbbCredits.getSelectedItem().toString()));
        onl.setDepartmentID(departmentID);
        onl.setURL(txtURL.getText());
        JOptionPane.showMessageDialog(this, onlineCourseBLL.addOnlineCourse(onl) );
    }
    public void addOnsiteCourse(){
        if(txtLocation.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter LOCATION");
            return;
        }
        
        if(txtTime.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter TIME");
            return;
        }
     
        if(!checkBoxMonday.isSelected()&&!checkBoxTuesday.isSelected()&&!checkBoxWednesday.isSelected()
                &&!checkBoxThursday.isSelected()&&!checkBoxFriday.isSelected()&&!checkBoxSaturay.isSelected()){
            JOptionPane.showMessageDialog(this, "Please choose DAY");
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
        
        
        
        String departmentName = modelCbbDepartment.getSelectedItem().toString();
        double budget = Double.parseDouble(txtBudget.getText());
        String startDate = txtStartDate.getText();
        Department de = new Department();
        de.setName(departmentName);
        de.setBudget(budget);
        de.setStartDate(startDate);
        int departmentID = departmentBLL.findDepartmentIDByAllInfor(de).getDepartmentID();
        int credit=Integer.parseInt(modelCbbCredits.getSelectedItem().toString());
        
        String day=onsiteCourseBLL.getDay(checkBoxMonday, checkBoxTuesday, checkBoxWednesday, checkBoxThursday, checkBoxFriday, checkBoxSaturay);
        
        OnsiteCourse onsitecourse=new OnsiteCourse();
        onsitecourse.setTitle(txtTitle.getText());
        onsitecourse.setLocation(txtLocation.getText());
        onsitecourse.setDays(day);
        onsitecourse.setTime(txtTime.getText());
        String mess=onsiteCourseBLL.checkTimeInValid(onsitecourse);

        if(mess!=null){
            JOptionPane.showMessageDialog(this,mess);
            return;
            
        }
        
        int option=JOptionPane.showConfirmDialog(this, "Are You Sure Add This Course?", "Confirm Add Data", JOptionPane.YES_NO_OPTION);
        if(option==JOptionPane.YES_OPTION){
            int id=courseBLL.getCourseID();
           
            
            if(onsiteCourseBLL.addOnsiteCourseBLL(id,txtLocation.getText(),day,txtTime.getText() ,txtTitle.getText(),credit,departmentID)){
                JOptionPane.showMessageDialog(this, "Add Data Successful!");
                
            }else{
                JOptionPane.showMessageDialog(this,"Add Data Failed!");
            }
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
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbbCredits = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbDepartment = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAdministrator = new javax.swing.JTextField();
        txtBudget = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbTypeOfCourse = new javax.swing.JComboBox<>();
        panelOnsite = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        checkBoxMonday = new javax.swing.JCheckBox();
        checkBoxTuesday = new javax.swing.JCheckBox();
        checkBoxWednesday = new javax.swing.JCheckBox();
        checkBoxThursday = new javax.swing.JCheckBox();
        checkBoxFriday = new javax.swing.JCheckBox();
        checkBoxSaturay = new javax.swing.JCheckBox();
        txtTime = new javax.swing.JTextField();
        panelOnline = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add courses");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 161, 255));
        jLabel1.setText("ADD A  COURSE");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(314, 314, 314))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Title");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Credits");

        cbbCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbCreditsActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Department");

        cbbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDepartment.setSelectedIndex(-1);
        cbbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDepartmentActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Budget");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Start Date");

        txtStartDate.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Administrator");

        txtAdministrator.setEditable(false);

        txtBudget.setEditable(false);
        txtBudget.setText(" ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Type Of Course");

        cbbTypeOfCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Onsite Course", "Online Course" }));
        cbbTypeOfCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTypeOfCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(405, 405, 405)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(cbbTypeOfCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(1, 1, 1))))
                                .addGap(105, 105, 105)
                                .addComponent(jLabel8)))))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbCredits, 0, 174, Short.MAX_VALUE)
                    .addComponent(txtBudget)
                    .addComponent(txtAdministrator))
                .addGap(92, 92, 92))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbbCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(txtAdministrator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbTypeOfCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panelOnsite.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Location");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText(" Time");

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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxFriday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkBoxMonday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkBoxWednesday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(checkBoxMonday)
                    .addComponent(checkBoxTuesday, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxWednesday)
                    .addComponent(checkBoxThursday))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxFriday)
                    .addComponent(checkBoxSaturay))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelOnsiteLayout = new javax.swing.GroupLayout(panelOnsite);
        panelOnsite.setLayout(panelOnsiteLayout);
        panelOnsiteLayout.setHorizontalGroup(
            panelOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOnsiteLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(panelOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLocation)
                    .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        panelOnsiteLayout.setVerticalGroup(
            panelOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOnsiteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelOnsiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelOnsiteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        panelOnline.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Link of Course");

        javax.swing.GroupLayout panelOnlineLayout = new javax.swing.GroupLayout(panelOnline);
        panelOnline.setLayout(panelOnlineLayout);
        panelOnlineLayout.setHorizontalGroup(
            panelOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOnlineLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        panelOnlineLayout.setVerticalGroup(
            panelOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOnlineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOnlineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/online.png"))); // NOI18N
        btnAdd.setText("SAVE");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/previous.png"))); // NOI18N
        btnCancel.setText(" CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOnsite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOnsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbCreditsActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbCreditsActionPerformed

    private void cbbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDepartmentActionPerformed
        // TODO add your handling code here:
        var department = modelCbbDepartment.getSelectedItem();
        int index = modelCbbDepartment.getIndexOf(department);
        if(index != -1){
            loadInforOfDepartment();
        }
    }//GEN-LAST:event_cbbDepartmentActionPerformed

    private void cbbTypeOfCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTypeOfCourseActionPerformed
        // TODO add your handling code here:
        modelCbbTypeOfCourse = (DefaultComboBoxModel) cbbTypeOfCourse.getModel();
        String item = modelCbbTypeOfCourse.getSelectedItem().toString();
  
        if(item == "Onsite Course"){
            panelOnline.setVisible(false);
            panelOnsite.setVisible(true);
        } else if(item=="Online Course") {
            panelOnline.setVisible(true);
            panelOnsite.setVisible(false);
        }
    }//GEN-LAST:event_cbbTypeOfCourseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(txtTitle.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter the TITLE!");
            return ;
        }
        if(modelCbbDepartment.getSelectedItem() == ""){
            JOptionPane.showMessageDialog(this, "Please choose DEPARTMENT");
            return;
        }
        if(modelCbbCredits.getSelectedItem() == ""){
            JOptionPane.showMessageDialog(this, "Please choose the number of CREDITS");
            return ;
        }  
                
                if(panelOnline.isVisible()){
                    addOnlineCourse();
                } else if(panelOnsite.isVisible()){
                 addOnsiteCourse();
                }
                
                    parent.loadDataToTableCourses();
          
       

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void checkBoxMondayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxMondayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxMondayActionPerformed

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
//            java.util.logging.Logger.getLogger(addCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(addCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(addCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(addCourseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new addCourseForm().setVisible(true);
//            }
//        });
//    }
 
     private DefaultComboBoxModel modelCbbDepartment ;
    private DefaultComboBoxModel modelCbbCredits  ;
    private DefaultComboBoxModel modelCbbTypeOfCourse ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cbbCredits;
    private javax.swing.JComboBox<String> cbbDepartment;
    private javax.swing.JComboBox<String> cbbTypeOfCourse;
    private javax.swing.JCheckBox checkBoxFriday;
    private javax.swing.JCheckBox checkBoxMonday;
    private javax.swing.JCheckBox checkBoxSaturay;
    private javax.swing.JCheckBox checkBoxThursday;
    private javax.swing.JCheckBox checkBoxTuesday;
    private javax.swing.JCheckBox checkBoxWednesday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panelOnline;
    private javax.swing.JPanel panelOnsite;
    private javax.swing.JTextField txtAdministrator;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables
}
