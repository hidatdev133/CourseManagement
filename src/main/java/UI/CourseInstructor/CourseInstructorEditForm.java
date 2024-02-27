/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI.CourseInstructor;
import BLL.Course.CourseBLL;
import BLL.Person.CourseInstructorBLL;
import BLL.Person.TeacherBLL;
import DAL.Course.Course;
import DAL.CourseInstructor.CourseInstructor;
import DAL.Teacher.Teacher;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author dongt
 */
public class CourseInstructorEditForm extends javax.swing.JFrame {

    CourseInstructorBLL c = new CourseInstructorBLL();
    TeacherBLL t = new TeacherBLL();
    CourseBLL cbll = new CourseBLL();
    CourseInstructorForm home;

    public CourseInstructorEditForm(CourseInstructorForm parent, boolean modal) {

        initComponents();
        loadCombobox();
        home = parent;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(parent.DISPOSE_ON_CLOSE);
                parent.setVisible(!modal);
            }
        });
    }
    public CourseInstructorEditForm() {
        initComponents();
    }
    private void loadCombobox() {
        List<Teacher> listT;
        List<Course> listC;

        try {
            listT = t.LoadTeachers();
            listC = cbll.LoadCourses(1); 

            int CourseID = Integer.parseInt(IDS.split("\\|")[0]);

            int PersonID = Integer.parseInt(IDS.split("\\|")[1]);

            for (int i = 0; i < listT.size(); i++) {

                comboBoxSuggestion3.addItem(listT.get(i).getPersonID());
                comboBoxSuggestion4.addItem(listT.get(i).getFirstName() + listT.get(i).getLastName() + "");
                if (listT.get(i).getPersonID() == PersonID) {
                    comboBoxSuggestion3.setSelectedItem(listT.get(i).getPersonID());
                    comboBoxSuggestion4.setSelectedItem(listT.get(i).getFirstName()
                            + " " + listT.get(i).getLastName() + "");
                }
            }
            for (int i = 0; i < listC.size(); i++) {
                comboBoxSuggestion1.addItem(listC.get(i).getCourseID()+"");
                comboBoxSuggestion2.addItem(listC.get(i).getTitle()+"");
                if (listC.get(i).getCourseID() == CourseID) {
                    comboBoxSuggestion1.setSelectedItem(listC.get(i).getCourseID());
                    comboBoxSuggestion2.setSelectedItem(listC.get(i).getTitle());
                }
            }
            //fake
          
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorAddForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxSuggestion1 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        btnEdit = new UI.UI_Item.button.MyButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxSuggestion2 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxSuggestion3 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxSuggestion4 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxSuggestion5 = new UI.UI_Item.combobox.ComboBoxSuggestion();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Title ID");

        comboBoxSuggestion1.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        btnEdit.setBackground(new java.awt.Color(93, 212, 253));
        btnEdit.setForeground(new java.awt.Color(0, 0, 0));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/diskette.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.setToolTipText("COURSE INSTRUCTOR");

        jLabel1.setFont(new java.awt.Font("David", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 161, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT INSTRUCTOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Title ID");

        comboBoxSuggestion2.setEnabled(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 255));
        jLabel5.setText("Title Name");

        comboBoxSuggestion3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBoxSuggestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSuggestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 153, 255));
        jLabel6.setText("Person ID");

        comboBoxSuggestion4.setEnabled(false);
        comboBoxSuggestion4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion4ItemStateChanged(evt);
            }
        });
        comboBoxSuggestion4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboBoxSuggestion4MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboBoxSuggestion4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBoxSuggestion4, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSuggestion4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 255));
        jLabel7.setText("Teacher Name");

        comboBoxSuggestion5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSuggestion5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSuggestion5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxSuggestion5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(51, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("BACK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxSuggestion3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSuggestion3ItemStateChanged
        List<Course> listC = null;
        try {
            listC = cbll.LoadCourses(1);
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (comboBoxSuggestion2.getSelectedIndex() == -1) {
            System.out.println(comboBoxSuggestion2.getSelectedIndex());
        } else {
            int index = comboBoxSuggestion2.getSelectedIndex();
            for (int i = 0; i < listC.size(); i++) {
                if (i == index) {
                    comboBoxSuggestion1.setSelectedItem(listC.get(i).getCourseID());
                }
            }
        }
    }//GEN-LAST:event_comboBoxSuggestion3ItemStateChanged

    private void comboBoxSuggestion4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSuggestion4ItemStateChanged
        //        List<Teacher> listT = null;
        //        try {
            //            listT = t.LoadTeachers(1);
            //        } catch (SQLException ex) {
            //            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        //        int PersonID = Integer.parseInt(comboBoxSuggestion3.getSelectedItem().toString());
        //        for (int i = 0; i < listT.size(); i++) {
            //            if (listT.get(i).getPersonID() == PersonID) {
                //                comboBoxSuggestion4.setSelectedItem(listT.get(i).getFirstName()
                    //                        + " " + listT.get(i).getLastName() + "");
                //            }
            //        }
    }//GEN-LAST:event_comboBoxSuggestion4ItemStateChanged

    private void comboBoxSuggestion4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxSuggestion4MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion4MouseClicked

    private void comboBoxSuggestion4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboBoxSuggestion4MouseReleased

    }//GEN-LAST:event_comboBoxSuggestion4MouseReleased

    private void comboBoxSuggestion5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSuggestion5ItemStateChanged
        List<Teacher> listT = null;
        try {
            listT = t.LoadTeachers();
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        int index = comboBoxSuggestion4.getSelectedIndex();
        for (int i = 0; i < listT.size(); i++) {
            if (i == index) {
                comboBoxSuggestion3.setSelectedItem(listT.get(i).getPersonID());
            }
        }
    }//GEN-LAST:event_comboBoxSuggestion5ItemStateChanged

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        int result = -1;
        int CourseID = Integer.parseInt(IDS.split("\\|")[0]);
        int PersonID = Integer.parseInt(IDS.split("\\|")[1]);
        int newCourseID = Integer.parseInt(comboBoxSuggestion1.getSelectedItem().toString());
        int newPersonID = Integer.parseInt(comboBoxSuggestion3.getSelectedItem().toString());

        try {
            if (CourseID == newCourseID && PersonID == newPersonID) {
                JOptionPane.showMessageDialog(this,
                    "Old CourseInstruction", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (CourseID != newCourseID || PersonID != newCourseID) {
                try {

                    result = c.updateCourseInstructor(
                        new CourseInstructor(newCourseID, newPersonID),
                        new CourseInstructor(CourseID, PersonID)
                    );

                } catch (SQLException ex) {
                    Logger.getLogger(CourseInstructorAddForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (result > 0) {
                    IDS = newCourseID + "|" + newPersonID+ "";
                    JOptionPane.showMessageDialog(this,
                        "You have completed to edit Course Instrustor successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    home.listCourseInstructorForm();
                } else if (result == -2) {

                    JOptionPane.showMessageDialog(this,
                        "You haven't completed to edit Course Instrustion! foregin key", "Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Error different", "Message", JOptionPane.ERROR_MESSAGE);

                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseInstructorEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseInstructorEditForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UI.UI_Item.button.MyButton btnEdit;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion1;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion2;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion3;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion4;
    private UI.UI_Item.combobox.ComboBoxSuggestion comboBoxSuggestion5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
