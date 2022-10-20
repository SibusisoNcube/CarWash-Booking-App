/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Sibusiso
 */
public class frmUpdate extends javax.swing.JFrame {

    /**
     * Creates new form frmUpdate
     */
    public frmUpdate() {
        initComponents();
        mLoadFirstName();
    }
    String strCustomer;
    String strTime;
    int intID;
    
    private void mClearVariables()
    {
        strCustomer="";
        strTime="";
        intID=0;        
    }
    
    private void mLoadFirstName()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/carwash";
        String strDBUser = "root";
        String strDBPassword = "password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs = null;
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "Select customer from bookings";
            stStatement.execute(strQuery);
            rs=stStatement.getResultSet();
            while(rs.next())
            {
                cboCustomer.addItem(rs.getString(1));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection String not closed" +""+ e);
            }
        }
    }
    
    private void mReadActorDetails()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/carwash";
        String strDBUser = "root";
        String strDBPassword = "password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs=null;
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "Select customer, time from bookings where customer='"+cboCustomer.getSelectedItem().toString()+"'";
            stStatement.execute(strQuery);
            rs=stStatement.getResultSet();
            while(rs.next())
            {
                strCustomer=rs.getString(1);
                strTime=rs.getString(2);
            }
        }
            catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null, e);
                    }
            finally
            {
                    try
                    {
                    stStatement.close();
                    }
                    catch(Exception e)
                    {
                    JOptionPane.showMessageDialog(null, "Connection String not closed" +""+ e);
                    }
                    }
        }
    private void mUpdateActor()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/carwash";
        String strDBUser="root";
        String strDBPassword="password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement=null;
        ResultSet rs=null;
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "UPDATE bookings SET customer = '"+strCustomer+"', time = '"+strTime+"' WHERE id = "+ intID;
            stStatement.executeUpdate(strQuery);
            rs=stStatement.getResultSet();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not closed" +""+ e);
            }
        }
    }
    
    private void mGetValuesFromGUI()
    {
        strCustomer=txtCustomer.getText();
        strTime=txtTime.getText();
    }
    private void mSetValuesToUpperCase()
    {
        strCustomer=strCustomer.toUpperCase();
        strTime=strTime.toUpperCase();
    }
    private void mSetValuesInGUI()
    {
        txtCustomer.setText(strCustomer);
        txtTime.setText(strTime);
    }
    private void mClearTextFields()
    {
        txtCustomer.setText("");
        txtTime.setText("");
    }
    private void mClearComboBox()
    {
        String[]arrArray=new String[0];
        javax.swing.DefaultComboBoxModel model=new javax.swing.DefaultComboBoxModel(arrArray);
        cboCustomer.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboCustomer = new javax.swing.JComboBox();
        txtCustomer = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustomerActionPerformed(evt);
            }
        });

        txtCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerActionPerformed(evt);
            }
        });

        lblFirstName.setText("Customer");

        lblLastName.setText("Time");

        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });

        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnSave.setText("Update");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel1.setText("CAR WASH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFirstName)
                            .addComponent(lblLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCustomer)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturn)
                    .addComponent(btnSave))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCustomerActionPerformed
mReadActorDetails();
mSetValuesInGUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCustomerActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
    frmMain frmM = new frmMain();    
    frmM.setVisible(true);
    this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

mGetValuesFromGUI();
mSetValuesToUpperCase();
mUpdateActor();
mClearComboBox();
mClearTextFields();
mClearVariables();
mLoadFirstName();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

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
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cboCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
