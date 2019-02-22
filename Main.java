package javaapplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author noxtla
 */
public class NewJFrame extends javax.swing.JFrame {

    ///public static final String URL ="jdbc:mysql://localhost:3306/ESCUELA";
    public static final String URL ="jdbc:mysql://localhost:3306/ESCUELA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     public static final String USER ="root";
      public static final String PASSWORD ="root";
      
              
    public NewJFrame() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        botonConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addComponent(botonConectar)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(botonConectar)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>                        

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {                                              
       Connection conexion = getConection();
        PreparedStatement ps; /// Guarda las diferentes consultas que se pueden hacer
        ResultSet rs; /// Obtener todo el contenido de labase de datos
        
        try {
            /// El objeto de prepared Statement
            ps = conexion.prepareStatement("SELECT * FROM PERSONA");
            /// Ejecutamos la consulta
            rs = ps.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Nombre " + rs.getString("nombre"));
            }
            else {
                JOptionPane.showMessageDialog(null, "No hay naiden");
            }
            conexion.close();
        }
        catch(Exception ex){
            System.err.println("Err " + ex);
        }
    }                                             
    
    public Connection getConection(){
        
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }
        catch (Exception ex) {
            System.err.println("Error, " + ex);
        }
        return conexion;
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botonConectar;
    // End of variables declaration                   
}
