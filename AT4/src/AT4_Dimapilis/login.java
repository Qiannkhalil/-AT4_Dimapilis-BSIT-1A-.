
package AT4_Dimapilis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    
    private static String uname,password;
    
    private static String filepath ="C:\\Users\\User\\OneDrive\\Documents\\NetBeansProjects\\AT4\\src\\AT4_Dimapilis\\user.json" ;
    private static JSONParser jsonParser = new JSONParser();
    private static JSONObject record = new JSONObject();
    private static JSONArray userlist = new JSONArray();
    public login() {
        initComponents();
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
        LblUname = new javax.swing.JLabel();
        LblPswd = new javax.swing.JLabel();
        TFuname = new javax.swing.JTextField();
        Pswd = new javax.swing.JPasswordField();
        BtnLogin = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblUname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LblUname.setForeground(new java.awt.Color(255, 255, 255));
        LblUname.setText("Enter Username: ");
        jPanel1.add(LblUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 85, -1, -1));

        LblPswd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LblPswd.setForeground(new java.awt.Color(255, 255, 255));
        LblPswd.setText("Enter Password: ");
        jPanel1.add(LblPswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 145, 116, -1));

        TFuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFunameActionPerformed(evt);
            }
        });
        jPanel1.add(TFuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 80, 150, 32));

        Pswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PswdActionPerformed(evt);
            }
        });
        jPanel1.add(Pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 140, 150, 33));

        BtnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnLogin.setText("Login");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(BtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 218, 125, 37));

        BtnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });
        jPanel1.add(BtnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 218, 123, 37));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 21, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrnd.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        TFuname.setText("");
        Pswd.setText("");
    }//GEN-LAST:event_BtnClearActionPerformed

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        try {
            uname = TFuname.getText();
            password=Pswd.getText();

            filecheck();

            int checker=0;
            for(int a=0;a<userlist.size();a++)
            {
                JSONObject userobject = (JSONObject) userlist.get(a);
                String searcheduname = (String) userobject.get("username");
                String searchedpswd = (String) userobject.get("password");
                if(uname.equals(searcheduname)&& password.equals(searchedpswd))
                {
                    checker++;

                    break;
                }
            }

            if(checker==0){
                JOptionPane.showMessageDialog(this,"No account has been found.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
            else{
                this.dispose();
                welcome x = new welcome();
                x.setVisible(true);

            }
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void TFunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFunameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFunameActionPerformed

    private void PswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PswdActionPerformed

    }//GEN-LAST:event_PswdActionPerformed
 public static String getuname(){
    return uname;
}
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    
     public static void filecheck() throws FileNotFoundException, IOException, ParseException{
         FileReader reader = new FileReader(filepath);
        
        if(reader.ready())
        {
            
            Scanner sc = new Scanner(reader);
            String line="";
            
            while (sc.hasNext())
            {
                line = line + sc.nextLine();
            }
            
            if(!line.equals(""))
            {
            
                reader.close();
                FileReader reader2 = new FileReader(filepath);
                record = (JSONObject) jsonParser.parse(reader2);
                userlist = (JSONArray) record.get("users");
                reader2.close();
            }
            
        }
        
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JLabel LblPswd;
    private javax.swing.JLabel LblUname;
    private javax.swing.JPasswordField Pswd;
    private javax.swing.JTextField TFuname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
