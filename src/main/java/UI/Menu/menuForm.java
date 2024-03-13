package UI.Menu;
import UI.Course.CourseForm;
import UI.CourseInstructor.CourseInstructorPanel;
import UI.Student.studentForm;
import UI.StudentGrade.studenGradePanel;
import UI.Teacher.teacherPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class menuForm extends javax.swing.JFrame {

    studenGradePanel sgp = new studenGradePanel();
    CourseForm courseForm = new CourseForm();
    studentForm stdf = new studentForm();
    teacherPanel teacherPanel = new teacherPanel();
    CourseInstructorPanel CIPanel = new CourseInstructorPanel();
    public menuForm() {
        initComponents();
        jPanel4.setLayout(new BorderLayout());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnHomePage = new javax.swing.JButton();
        btnTeacher = new javax.swing.JButton();
        btnStudentGrade = new javax.swing.JButton();
        btnCourseInstructor = new javax.swing.JButton();
        btnCourse = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/Admin-icon.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/online.png"))); // NOI18N
        jLabel2.setText("Online");

        jLabel3.setText("Welcome");

        jLabel4.setText("ADMINSTRATOR");

        btnHomePage.setBackground(new java.awt.Color(51, 204, 0));
        btnHomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/home-page.png"))); // NOI18N
        btnHomePage.setText("Home Page");
        btnHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomePageActionPerformed(evt);
            }
        });

        btnTeacher.setBackground(new java.awt.Color(51, 204, 0));
        btnTeacher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/teacher.png"))); // NOI18N
        btnTeacher.setText("Teacher");
        btnTeacher.setMaximumSize(new java.awt.Dimension(119, 38));
        btnTeacher.setMinimumSize(new java.awt.Dimension(119, 38));
        btnTeacher.setPreferredSize(new java.awt.Dimension(119, 38));
        btnTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherActionPerformed(evt);
            }
        });

        btnStudentGrade.setBackground(new java.awt.Color(51, 204, 0));
        btnStudentGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/student-grade.png"))); // NOI18N
        btnStudentGrade.setText("Student Grade");
        btnStudentGrade.setMaximumSize(new java.awt.Dimension(119, 38));
        btnStudentGrade.setMinimumSize(new java.awt.Dimension(119, 38));
        btnStudentGrade.setPreferredSize(new java.awt.Dimension(119, 38));
        btnStudentGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentGradeActionPerformed(evt);
            }
        });

        btnCourseInstructor.setBackground(new java.awt.Color(51, 204, 0));
        btnCourseInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/course-instructor.png"))); // NOI18N
        btnCourseInstructor.setText("Course Instructor");
        btnCourseInstructor.setMaximumSize(new java.awt.Dimension(119, 38));
        btnCourseInstructor.setMinimumSize(new java.awt.Dimension(119, 38));
        btnCourseInstructor.setPreferredSize(new java.awt.Dimension(119, 38));
        btnCourseInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseInstructorActionPerformed(evt);
            }
        });

        btnCourse.setBackground(new java.awt.Color(51, 204, 0));
        btnCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/onsite-course.png"))); // NOI18N
        btnCourse.setText("    Course");
        btnCourse.setMaximumSize(new java.awt.Dimension(119, 38));
        btnCourse.setMinimumSize(new java.awt.Dimension(119, 38));
        btnCourse.setPreferredSize(new java.awt.Dimension(119, 38));
        btnCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseActionPerformed(evt);
            }
        });

        btnStudent.setBackground(new java.awt.Color(51, 204, 0));
        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/icon/students.png"))); // NOI18N
        btnStudent.setText("Student");
        btnStudent.setMaximumSize(new java.awt.Dimension(128, 38));
        btnStudent.setMinimumSize(new java.awt.Dimension(128, 38));
        btnStudent.setPreferredSize(new java.awt.Dimension(119, 38));
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStudentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCourseInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(btnStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnStudentGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCourseInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(950, 513));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 51, 0));

        jLabel5.setText("COURSE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel5)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(26, 26, 26))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        jLabel6.setText("STUDENT");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(129, 129, 129))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(26, 26, 26))
        );

        jPanel6.setBackground(new java.awt.Color(0, 255, 0));

        jLabel8.setText("TEACHER");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(125, 125, 125))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(jPanel2, BorderLayout.SOUTH);

        jPanel4.add(jPanel3, BorderLayout.WEST);
//        jPanel3.setPreferredSize(new Dimension(300, 130));

        jPanel4.add(jPanel6, BorderLayout.EAST);
//        jPanel3.setPreferredSize(new Dimension(302, 49));

        jPanel4.add(jPanel5, BorderLayout.CENTER);
//        jPanel3.setPreferredSize(new Dimension(312, 48));
        
        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display

        btnHomePage.setBackground(Color.blue);
        btnStudent.setBackground(new Color(51, 204, 0));
        btnTeacher.setBackground(new Color(51, 204, 0));
        btnStudentGrade.setBackground(new Color(51, 204, 0));
        btnCourseInstructor.setBackground(new Color(51, 204, 0));
        btnCourse.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_btnHomePageActionPerformed

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(teacherPanel);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display

        btnTeacher.setBackground(Color.blue);
        btnStudent.setBackground(new Color(51, 204, 0));
        btnStudentGrade.setBackground(new Color(51, 204, 0));
        btnHomePage.setBackground(new Color(51, 204, 0));
        btnCourse.setBackground(new Color(51, 204, 0));
        btnCourseInstructor.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_btnTeacherActionPerformed

    private void btnStudentGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentGradeActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(sgp);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display

        btnStudentGrade.setBackground(Color.blue);
        btnHomePage.setBackground(new Color(51, 204, 0));
        btnTeacher.setBackground(new Color(51, 204, 0));
        btnStudent.setBackground(new Color(51, 204, 0));
        btnCourseInstructor.setBackground(new Color(51, 204, 0));
        btnCourse.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_btnStudentGradeActionPerformed

    private void btnCourseInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseInstructorActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(CIPanel);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display

        btnCourseInstructor.setBackground(Color.blue);
        btnHomePage.setBackground(new Color(51, 204, 0));
        btnTeacher.setBackground(new Color(51, 204, 0));
        btnStudent.setBackground(new Color(51, 204, 0));
        btnStudentGrade.setBackground(new Color(51, 204, 0));
        btnCourse.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_btnCourseInstructorActionPerformed

    private void btnCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();

        jPanel4.add(courseForm);

        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display

        btnCourse.setBackground(Color.blue);
        btnHomePage.setBackground(new Color(51, 204, 0));
        btnTeacher.setBackground(new Color(51, 204, 0));
        btnStudent.setBackground(new Color(51, 204, 0));
        btnStudentGrade.setBackground(new Color(51, 204, 0));
        btnCourseInstructor.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_btnCourseActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // xóa tất cả những giao diện hiển thị trong jpanel4
        jPanel4.removeAll();
        jPanel4.add(stdf);
        jPanel4.revalidate(); // Revalidate to reflect the changes
        jPanel4.repaint();    // Repaint to refresh the display

        btnStudent.setBackground(Color.blue);
        btnHomePage.setBackground(new Color(51, 204, 0));
        btnTeacher.setBackground(new Color(51, 204, 0));
        btnStudentGrade.setBackground(new Color(51, 204, 0));
        btnCourseInstructor.setBackground(new Color(51, 204, 0));
        btnCourse.setBackground(new Color(51, 204, 0));
    }//GEN-LAST:event_btnStudentActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                menuForm menu = new menuForm();
                menu.setLocationRelativeTo(menu);
                menu.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCourse;
    private javax.swing.JButton btnCourseInstructor;
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnStudentGrade;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
