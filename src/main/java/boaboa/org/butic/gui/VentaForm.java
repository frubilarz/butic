/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boaboa.org.butic.gui;

import boaboa.org.butic.model.Producto;
import boaboa.org.butic.servicio.ServicioDB;
import boaboa.org.butic.utils.NumberUtils;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author frubilar
 */
public class VentaForm extends javax.swing.JFrame {

    /**
     * Creates new form VentaForm
     */
    public VentaForm() {
        initComponents();
    }

    private DefaultTableModel modelo = new DefaultTableModel();
    private JTable tabla = new JTable(modelo);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventaLabel = new javax.swing.JLabel();
        codigoLabel = new javax.swing.JLabel();
        codigoField = new javax.swing.JTextField();
        buscarButon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cantidadField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        precioField = new javax.swing.JTextField();
        agregarButon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aceptarButton = new javax.swing.JButton();
        cancelarButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ventaLabel.setText("VENTA");

        codigoLabel.setText("Codigo");

        buscarButon.setText("BUSCAR");
        buscarButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButonActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad");

        jLabel2.setText("Precio");

        agregarButon.setText("AGREGAR");
        agregarButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        aceptarButton.setText("GUARDAR");
        aceptarButton.setPreferredSize(new java.awt.Dimension(80, 40));
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        cancelarButon.setText("CANCELAR");
        cancelarButon.setPreferredSize(new java.awt.Dimension(80, 40));
        cancelarButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(ventaLabel)
                        .addGap(0, 287, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoLabel)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codigoField)
                            .addComponent(cantidadField, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                            .addComponent(precioField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregarButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarButon, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ventaLabel)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLabel)
                    .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cantidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(precioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregarButon)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 126, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed

    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void cancelarButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButonActionPerformed

        int reply = JOptionPane.showConfirmDialog(null, "Seguro de salir?", "CANCELAR VENTA", JOptionPane.YES_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            MenuPrinipal prinipal = new MenuPrinipal();
            prinipal.setVisible(true);
            prinipal.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_cancelarButonActionPerformed

    private void buscarButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButonActionPerformed

        ServicioDB servicioDB = new ServicioDB();
        Producto producto = new Producto();
        String codigo = this.codigoField.getText();
        if (StringUtils.isNotEmpty(codigo)) {
            producto = servicioDB.getProducto(codigo);
            if (producto != null) {

                modelo.addColumn("Codigo");
                modelo.addColumn("Producto");
                modelo.addColumn("Cantidad");
                modelo.addColumn("Total");
                jTable1.setModel(modelo);
                this.precioField.setText(producto.getValor().toString());
            }
        }
    }//GEN-LAST:event_buscarButonActionPerformed

    private void agregarButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButonActionPerformed
        Object[] fila = new Object[20];
        String codigo = this.codigoField.getText();
        String cantidad = this.cantidadField.getText();
        String precio = this.precioField.getText();
        if (codigo.length() * cantidad.length() * precio.length() != 0) {
            Integer cantidadInteger = NumberUtils.NumberUtils(cantidad);
            if (cantidadInteger != null) {
                Float precioFloat = NumberUtils.numberFloat(precio);
                if (precioFloat != null) {
                    ServicioDB servicioDB = new ServicioDB();
                    Producto producto = servicioDB.getProducto(codigo);
                    fila[0] = codigo;
                    fila[1] = producto.getNombre();
                    fila[2] = cantidad;
                    Float valor = (cantidadInteger * precioFloat);
                    fila[3] = valor;
                    modelo.addRow(fila);
                    jTable1.setModel(modelo);
                }
            }
        }
    }//GEN-LAST:event_agregarButonActionPerformed

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
            java.util.logging.Logger.getLogger(VentaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton agregarButon;
    private javax.swing.JButton buscarButon;
    private javax.swing.JButton cancelarButon;
    private javax.swing.JTextField cantidadField;
    private javax.swing.JTextField codigoField;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField precioField;
    private javax.swing.JLabel ventaLabel;
    // End of variables declaration//GEN-END:variables
}
