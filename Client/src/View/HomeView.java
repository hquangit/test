/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import model.Message;
import model.User;

/**
 *
 * @author Admin
 */
public class HomeView extends javax.swing.JFrame {

    /**
     * Creates new form HomeView
     */
    
     static ArrayList<User> listUserOnline = new ArrayList<>();
     static ArrayList<User> listRanking = new ArrayList<>();
    
    public HomeView() {
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

        jLabel1 = new javax.swing.JLabel();
        HomeView_btnInvite = new javax.swing.JButton();
        HomeView_btnRanking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Welcome to play game");

        HomeView_btnInvite.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HomeView_btnInvite.setText("Invite Friend");
        HomeView_btnInvite.setMaximumSize(new java.awt.Dimension(200, 50));
        HomeView_btnInvite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeView_btnInviteActionPerformed(evt);
            }
        });

        HomeView_btnRanking.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HomeView_btnRanking.setText("Ranking");
        HomeView_btnRanking.setMaximumSize(new java.awt.Dimension(200, 50));
        HomeView_btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeView_btnRankingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(HomeView_btnInvite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HomeView_btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HomeView_btnInvite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HomeView_btnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeView_btnInviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeView_btnInviteActionPerformed
 
        Message messageSendOnline = new Message(null, Message.Label.LIST_USERS);
        LoginView.clientController.sendData(messageSendOnline);
        System.out.println("Da gui yeu cau Invite");
        Message messageReceiOnline = (Message) LoginView.clientController.receiveData();
       
       listUserOnline = (ArrayList<User>)messageReceiOnline.getObject();
       System.out.println(listUserOnline);
       System.out.println(messageReceiOnline.getLabel());
        if(messageReceiOnline.getLabel().toString()=="lIST_FULL"){
             UserOnlineView onlineView = new UserOnlineView();
            onlineView.setVisible(true);
        }
         else{
             System.out.println("UserOnline view fail");
        }
        
              
    }//GEN-LAST:event_HomeView_btnInviteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Message message = new Message(null, Message.Label.LOGOUT);
        LoginView.clientController.sendData(message);
        String result = (String) LoginView.clientController.receiveData();
        if(result.equals("LOGOUT")){
            StartView startView = new StartView();
            startView.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void HomeView_btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeView_btnRankingActionPerformed
        // TODO add your handling code here:
        Message messageSendRank = new Message(null, Message.Label.GET_SCOREBOARD);
        LoginView.clientController.sendData(messageSendRank);
        System.out.println("Da gui yeu cau Ranking");
        Message messageReceiRanking = (Message) LoginView.clientController.receiveData();
        System.out.println("Da nhan ranking view");
      
        listRanking = (ArrayList<User>)messageReceiRanking.getObject();
        System.out.println(messageReceiRanking.getLabel());
         if(messageReceiRanking.getLabel().toString()== "REPLY_SCOREBOARD"){
            RankingView rankingView = new RankingView();
            rankingView.setVisible(true);
         }
         else{
             System.out.println("Ranking view fail");
         }
        
        
       
    }//GEN-LAST:event_HomeView_btnRankingActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeView_btnInvite;
    private javax.swing.JButton HomeView_btnRanking;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
