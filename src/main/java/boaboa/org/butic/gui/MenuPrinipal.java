/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boaboa.org.butic.gui;

import boaboa.org.butic.model.Usuario;
import boaboa.org.butic.servicio.ServicioDB;
import javax.swing.JOptionPane;

/**
 *
 * @author frubilar
 */
public class MenuPrinipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrinipal
     */
    public MenuPrinipal() {
        initComponents();
    }
    private Integer rut = null;

    MenuPrinipal(Integer rut) {
        initComponents();
        setRut(rut);
        ServicioDB servicioDB = new ServicioDB();
        Usuario usuario = servicioDB.getUsuario(getRut());
        this.nombreLabel.setText(usuario.getNombre());

    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

//    MenuPrinipal(Usuario usuario) {
//        initComponents();
//        
//        this.nombreLabel.setText(usuario.getNombre());
//        setRut(usuario.getRut());
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        clienteMenu = new javax.swing.JMenu();
        verificarMenu = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        productosMenu = new javax.swing.JMenu();
        agregarProductosMenu = new javax.swing.JMenu();
        agregarProductosMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        realizarVenta = new javax.swing.JMenu();
        usuarioMenu = new javax.swing.JMenu();
        realizarVenta1 = new javax.swing.JMenu();
        realizarVenta2 = new javax.swing.JMenu();
        crearUsuario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BIENVENIDO ");

        nombreLabel.setText("Nombre");

        clienteMenu.setText("Clientes");
        clienteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteMenuActionPerformed(evt);
            }
        });
        clienteMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clienteMenuKeyPressed(evt);
            }
        });

        verificarMenu.setText("Verificar Cliente");
        verificarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verificarMenuMouseClicked(evt);
            }
        });
        verificarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarMenuActionPerformed(evt);
            }
        });
        clienteMenu.add(verificarMenu);

        jMenu6.setText("Buscar");
        clienteMenu.add(jMenu6);

        jMenuBar1.add(clienteMenu);

        productosMenu.setText("Productos");

        agregarProductosMenu.setText("Verificar Codigo");
        agregarProductosMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarProductosMenuMouseClicked(evt);
            }
        });
        productosMenu.add(agregarProductosMenu);

        agregarProductosMenu1.setText("Mostrar Productos");
        productosMenu.add(agregarProductosMenu1);

        jMenuBar1.add(productosMenu);

        jMenu3.setText("Venta");

        realizarVenta.setText("Realizar Venta");
        realizarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realizarVentaMouseClicked(evt);
            }
        });
        realizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarVentaActionPerformed(evt);
            }
        });
        jMenu3.add(realizarVenta);

        jMenuBar1.add(jMenu3);

        usuarioMenu.setText("Usuarios");
        usuarioMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioMenuActionPerformed(evt);
            }
        });

        realizarVenta1.setText("Mostrar Usuarios");
        realizarVenta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realizarVenta1MouseClicked(evt);
            }
        });
        realizarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarVenta1ActionPerformed(evt);
            }
        });
        usuarioMenu.add(realizarVenta1);

        realizarVenta2.setText("Editar Usuarios");
        realizarVenta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realizarVenta2MouseClicked(evt);
            }
        });
        realizarVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarVenta2ActionPerformed(evt);
            }
        });
        usuarioMenu.add(realizarVenta2);

        crearUsuario.setText("Crear Usuarios");
        crearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearUsuarioMouseClicked(evt);
            }
        });
        crearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioActionPerformed(evt);
            }
        });
        usuarioMenu.add(crearUsuario);

        jMenuBar1.add(usuarioMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel)
                    .addComponent(jLabel1))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(nombreLabel)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clienteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteMenuActionPerformed

    }//GEN-LAST:event_clienteMenuActionPerformed

    private void clienteMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clienteMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteMenuKeyPressed

    private void verificarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verificarMenuActionPerformed

    private void verificarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verificarMenuMouseClicked
        RutCliente editar = new RutCliente(rut);
        editar.setVisible(true);
        editar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_verificarMenuMouseClicked

    private void agregarProductosMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarProductosMenuMouseClicked

        CodigoProducto codigoForm = new CodigoProducto();
        codigoForm.setVisible(true);
        codigoForm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_agregarProductosMenuMouseClicked

    private void realizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarVentaActionPerformed

    }//GEN-LAST:event_realizarVentaActionPerformed

    private void realizarVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realizarVentaMouseClicked
        VentaForm form = new VentaForm();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_realizarVentaMouseClicked

    private void realizarVenta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realizarVenta1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_realizarVenta1MouseClicked

    private void realizarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realizarVenta1ActionPerformed

    private void realizarVenta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realizarVenta2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_realizarVenta2MouseClicked

    private void realizarVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarVenta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realizarVenta2ActionPerformed

    private void crearUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearUsuarioMouseClicked

        crearUsuarioActionPerformed(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_crearUsuarioMouseClicked

    private void crearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioActionPerformed

        ServicioDB servicioDB = new ServicioDB();
        boolean consulta = servicioDB.verificarAdmin(rut);
        if (!consulta) {
            JOptionPane.showMessageDialog(clienteMenu, "Usuario No admin");
        } else {
            CrearUsuario form = new CrearUsuario(rut);
            form.setVisible(true);
            form.setLocationRelativeTo(null);
            this.dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_crearUsuarioActionPerformed

    private void usuarioMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioMenuActionPerformed
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
            java.util.logging.Logger.getLogger(MenuPrinipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrinipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrinipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrinipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrinipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu agregarProductosMenu;
    private javax.swing.JMenu agregarProductosMenu1;
    private javax.swing.JMenu clienteMenu;
    private javax.swing.JMenu crearUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JMenu productosMenu;
    private javax.swing.JMenu realizarVenta;
    private javax.swing.JMenu realizarVenta1;
    private javax.swing.JMenu realizarVenta2;
    private javax.swing.JMenu usuarioMenu;
    private javax.swing.JMenu verificarMenu;
    // End of variables declaration//GEN-END:variables
}
