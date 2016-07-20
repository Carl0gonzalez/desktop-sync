/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.openkm.okmsynchronize.view;

import com.openkm.okmsynchronize.controller.SynchronizeResolveConflictController;
import com.openkm.okmsynchronize.model.ConflictType;
import com.openkm.okmsynchronize.model.StateSynchronizeObject;
import com.openkm.okmsynchronize.model.SynchronizedObject;
import com.openkm.okmsynchronize.model.SynchronizedObjectConflict;
import com.openkm.okmsynchronize.utils.Utils;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author abujosa
 */
public class SynchronizeResolveConflictView extends javax.swing.JDialog {

    /**
     * Creates new form SynchronizeResolveConflictView
     */
    public SynchronizeResolveConflictView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /**
     * Creates new form SynchronizeResolveConflictView
     */
    public SynchronizeResolveConflictView(java.awt.Frame parent, SynchronizedObject model, SynchronizedObjectConflict[] listRenamedDocuments, boolean modal) {
        super(parent, modal);
        this.model = model;
        initComponents();
        
        /* Document name. */
        if (!Utils.isEmpty(model.getName())) {
            labelName.setText(model.getName());
        } else {
            labelName.setText("-");
        } 
        
        /* Document last modified local time. */
        if(model.getLocalTime() != null) {
            labelLastRepositoryModification.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(model.getLocalTime())));
        } else {
            labelLastRepositoryModification.setText("-");
        }
        
        /* Document last modified server time. */
        if(model.getServerTime() != null) {
            labelLastServerModification.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(model.getServerTime())));
        } else {
            labelLastServerModification.setText("-");
        }
        
        /* Document server version. */
        if (!Utils.isEmpty(model.getVersion())) {
            labelServerVersion.setText(model.getVersion());
        } else {
            labelServerVersion.setText("-");
        }
        
        /* Document conflict message. */
        if (StateSynchronizeObject.CONFLICT.equals(model.getState())){
            labelConflictMessage.setText(model.getConflictType().getMessage());
        } else {
            labelConflictMessage.setText("-");
        }       
        
        /* Initialize renamed document list */
        if(model.isPossibleToRename() && listRenamedDocuments != null) {
            comboBoxRenamed.setModel(new DefaultComboBoxModel(listRenamedDocuments));
        } else {
            comboBoxRenamed.setModel(new DefaultComboBoxModel());
        }

        /* Initialize acctions */
        comboBoxAction.setModel(new DefaultComboBoxModel(SynchronizeResolveConflictController.getResolveConflictActions(model.getConflictType())));
                
        comboBoxRenamed.setVisible(model.isPossibleToRename());
        labelRenamed.setVisible(model.isPossibleToRename());
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
        buttonCancel = new javax.swing.JButton();
        buttonResolve = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboBoxAction = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelLastRepositoryModification = new javax.swing.JLabel();
        labelServerVersion = new javax.swing.JLabel();
        labelLastServerModification = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelRenamed = new javax.swing.JLabel();
        comboBoxRenamed = new javax.swing.JComboBox();
        labelConflictMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resolve conflict");
        setMinimumSize(new java.awt.Dimension(600, 300));
        setPreferredSize(new java.awt.Dimension(600, 300));

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 40));

        buttonCancel.setText("Cancel");
        buttonCancel.setDisplayedMnemonicIndex(0);
        buttonCancel.setMaximumSize(new java.awt.Dimension(50, 27));
        buttonCancel.setMinimumSize(new java.awt.Dimension(50, 27));
        buttonCancel.setName(""); // NOI18N
        buttonCancel.setPreferredSize(new java.awt.Dimension(50, 27));

        buttonResolve.setText("Resolve");
        buttonResolve.setDisplayedMnemonicIndex(0);
        buttonResolve.setMaximumSize(new java.awt.Dimension(50, 27));
        buttonResolve.setMinimumSize(new java.awt.Dimension(50, 27));
        buttonResolve.setPreferredSize(new java.awt.Dimension(50, 27));

        jLabel5.setLabelFor(comboBoxAction);
        jLabel5.setText("Action:");

        comboBoxAction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(buttonResolve, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(comboBoxAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonResolve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setPreferredSize(new java.awt.Dimension(20, 200));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setPreferredSize(new java.awt.Dimension(20, 200));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

        jLabel1.setText("Last repository modification:");

        jLabel2.setText("Server version:");

        jLabel3.setText("Last server modification:");

        jLabel4.setText("Description conflict:");

        labelLastRepositoryModification.setText("jLabel6");

        labelServerVersion.setText("jLabel6");

        labelLastServerModification.setText("jLabel6");

        jLabel6.setText("Document:");

        labelName.setText("jLabel7");

        labelRenamed.setLabelFor(comboBoxRenamed);
        labelRenamed.setText("Renamed document:");

        comboBoxRenamed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelConflictMessage.setText("jLabel7");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLastRepositoryModification, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelServerVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLastServerModification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelConflictMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelRenamed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRenamed, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelName))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelLastRepositoryModification))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelServerVersion))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelLastServerModification))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelConflictMessage))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRenamed)
                    .addComponent(comboBoxRenamed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SynchronizeResolveConflictView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SynchronizeResolveConflictView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SynchronizeResolveConflictView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SynchronizeResolveConflictView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SynchronizeResolveConflictView dialog = new SynchronizeResolveConflictView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void addButtonCancelListener(ActionListener l) { buttonCancel.addActionListener(l); }
    public void addButtonResolveListener(ActionListener l) { buttonResolve.addActionListener(l); }
    
    public String getSelectedAction() { return (String)comboBoxAction.getSelectedItem(); }
    
    public SynchronizedObjectConflict getSelectedRenamedDocument() { return (SynchronizedObjectConflict)comboBoxRenamed.getSelectedItem(); }
    
    private SynchronizedObject model;
    private boolean rename;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonResolve;
    private javax.swing.JComboBox comboBoxAction;
    private javax.swing.JComboBox comboBoxRenamed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelConflictMessage;
    private javax.swing.JLabel labelLastRepositoryModification;
    private javax.swing.JLabel labelLastServerModification;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelRenamed;
    private javax.swing.JLabel labelServerVersion;
    // End of variables declaration//GEN-END:variables
}