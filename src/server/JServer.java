package server;
import ServerInterface.Dictionary;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class JServer extends javax.swing.JFrame {
    int port;
    Dictionary_Imp dictionary=new Dictionary_Imp();   
    public JServer() throws RemoteException, ClassNotFoundException, 
                            SQLException, AlreadyBoundException {    
    initComponents();
    //............................. 
    port=Integer.parseInt(JOptionPane.showInputDialog(null,"Port of Server:"));  
    Registry  registry = LocateRegistry.createRegistry(port);     
    registry.bind(Dictionary.LOOKUPNAME, dictionary);
    RunningjLabel.setText("Definitions Dictionary Server is now Running");  
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JButton();
        RunningjLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exit.setText("Exit ");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(RunningjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(RunningjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(exit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
      try{
           dictionary.con.close();
           System.exit(port); // Close main GUI and  kill Process at backgroung
         } catch (SQLException ex) {
            Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_exitActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JServer().setVisible(true);
                }catch (NumberFormatException ex) {
                  Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (RemoteException ex) {
                    Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AlreadyBoundException ex) {
                    Logger.getLogger(JServer.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RunningjLabel;
    private javax.swing.JButton exit;
    // End of variables declaration//GEN-END:variables
}
