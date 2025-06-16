/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package edu.jdc.formularuios;

import edu.jdc.clases.Bodega;
import edu.jdc.clases.Facturas;
import edu.jdc.clases.Ventas;
import edu.jdc.daos.DaoBodega;
import edu.jdc.daos.DaoFactura;
import edu.jdc.daos.DaoVentas;
import java.awt.Dimension;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FrmCrearVenta extends javax.swing.JInternalFrame {

    private Ventas objVentas;
    private DaoVentas objMiDao;
    private ArrayList<Bodega> listaBodegas = new ArrayList<>();
    private Facturas objFactura;
    private DaoFactura MiDaoFactura;
    private int codigoVenta;

    private LocalDate fechaVenta = null;

    public FrmCrearVenta() {
        initComponents();

        objVentas = new Ventas();
        objMiDao = new DaoVentas();
        MiDaoFactura = new DaoFactura();
        objFactura = new Facturas();

        listaBodegas = obtenerBodegas();

        initComboBox();
    }

    private void limpiarCajas() {

        cajaCantidadVenta.setText("");
        cajaFechaVenta.setText("");

        cajaCantidadVenta.requestFocus();
        cajaFechaVenta.requestFocus();

    }

    private void cerrarVentana() {
        int opcion = 0;
        String[] textoBotones = {"Aceptar", "Cancelar"};
        opcion = JOptionPane.showOptionDialog(rootPane, "Estas seguro de salir?", "cerrar ventana", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, textoBotones, EXIT_ON_CLOSE);

        if (opcion == JOptionPane.YES_OPTION) {
            this.dispose();
        }

    }

    private void initComboBox() {
        // Ordena la lista de bodegas por código
        Collections.sort(listaBodegas, Comparator.comparingInt(Bodega::getCodBodega));

        // Llena el ComboBox con los nombres de las bodegas ordenadas
        comboBoxBodegas.removeAllItems(); // Limpiar ComboBox antes de llenarlo
        for (Bodega bodega : listaBodegas) {
            comboBoxBodegas.addItem(bodega.getNombreBodega());
        }
    }

    private void comboBoxBodegasActionPerformed(java.awt.event.ActionEvent evt) {
        String nombreBodegaSeleccionada = comboBoxBodegas.getSelectedItem().toString();
        int codigoBodegaSeleccionada = -1; // Valor predeterminado si no se encuentra la bodega

        // Busca el código de la bodega seleccionada
        for (Bodega bodega : listaBodegas) {
            if (bodega.getNombreBodega().equals(nombreBodegaSeleccionada)) {
                codigoBodegaSeleccionada = bodega.getCodBodega();
                break;
            }
        }

        // Utiliza el código de la bodega seleccionada en el registro de la venta
        if (codigoBodegaSeleccionada != -1) {
            // Realiza el registro de la venta con el códigoBodegaSeleccionada
        } else {
            // Maneja el caso donde no se encuentra el código de la bodega seleccionada
        }
    }

    private ArrayList<Bodega> obtenerBodegas() {
        // Crea una instancia de DaoBodega
        DaoBodega daoBodega = new DaoBodega();
        // Llama al método obtenerBodegas() de DaoBodega
        return daoBodega.obtenerBodegas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxBodegas = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cajaCantidadVenta = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cajaFechaVenta = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnregistrarFactura = new javax.swing.JButton();
        jCalendarVenta = new com.toedter.calendar.JCalendar();

        setBackground(new java.awt.Color(255, 51, 51));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo Bodega");

        comboBoxBodegas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(61, 61, 61)
                .addComponent(comboBoxBodegas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxBodegas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad de Venta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(cajaCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de venta");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(cajaFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cajaFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        btnRegistrar.setBackground(new java.awt.Color(0, 204, 51));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        btnregistrarFactura.setText("Registrar Factura");
        btnregistrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegistrar)
                                    .addComponent(jButton2)
                                    .addComponent(btnSalir))
                                .addGap(101, 101, 101))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnregistrarFactura)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnregistrarFactura)
                        .addGap(24, 24, 24)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir))
                    .addComponent(jCalendarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCalendarVentaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarVentaPropertyChange
        if ("calendar".equals(evt.getPropertyName())) {
            Date selectedDate = jCalendarVenta.getDate();
            if (selectedDate != null) {
                LocalDate fechaSeleccionada = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String fechaFormateada = fechaSeleccionada.format(formatter);
                cajaFechaVenta.setText(fechaFormateada);
            }
        }
    }//GEN-LAST:event_jCalendarVentaPropertyChange


    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int cantidadVenta;

        boolean registro;

        // Se obtienen los valores ingresados por el usuario
        String nombreBodegaSeleccionada = comboBoxBodegas.getSelectedItem().toString();
        int codigoBodegaSeleccionada = -1; // Valor predeterminado si no se encuentra la bodega

        // Busca el código de la bodega seleccionada
        for (Bodega bodega : listaBodegas) {
            if (bodega.getNombreBodega().equals(nombreBodegaSeleccionada)) {
                codigoBodegaSeleccionada = bodega.getCodBodega();
                break;
            }
        }

        // Se obtienen los valores ingresados por el usuario
        cantidadVenta = Integer.parseInt(cajaCantidadVenta.getText()); // Asumo que este es el campo donde el usuario ingresa la cantidad de la venta
        fechaVenta = LocalDate.parse(cajaFechaVenta.getText());

        // Se valida que todos los campos estén completos
        if (codigoBodegaSeleccionada <= 0 || cantidadVenta <= 0 || fechaVenta == null) {
            JOptionPane.showMessageDialog(rootPane, "Faltan datos para completar el registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            // Se crea un objeto Bodega con el código proporcionado por el usuario
            Bodega bodega = new Bodega(codigoBodegaSeleccionada, "", 0.0, 0.0);

            // Se configuran los datos de la venta en el objeto objVentas
            objVentas.setCodBodega(bodega);
            objVentas.setCantidadVenta(cantidadVenta);
            objVentas.setFechaVenta(fechaVenta);

        }

        // Se intenta registrar la venta
        codigoVenta = objMiDao.registrarVenta(objVentas);
        System.out.println(codigoVenta);

        if (cantidadVenta != 0) {
            JOptionPane.showMessageDialog(rootPane, "Registro de venta " + " guardado en la base de datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Fallo en el registro de venta", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int opcion = 0;

        String[] textoBotones = {"Aceptar", "Cancelar"};

        opcion = JOptionPane.showOptionDialog(rootPane, "Estas seguro de cancelar el registro", "Cancelar Registro", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, textoBotones, textoBotones[1]);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.cerrarVentana();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnregistrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarFacturaActionPerformed
        boolean registro;
        System.out.println(fechaVenta);
        String valorFacturaText, fechaTexto;
        Double valorFactura = 0.0;
        if (codigoVenta > 0) {
            valorFacturaText = JOptionPane.showInputDialog("Digite el valor de la factura");
            valorFactura = Double.valueOf(valorFacturaText);
            if (valorFacturaText.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Falta el valor de la factura para registrarla"
                        + "para registar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                Ventas objVentas = new Ventas(codigoVenta, new Bodega(0, "", 0, 0), 0, LocalDate.now());
                System.out.println(fechaVenta);
                objFactura.setCodVenta(objVentas);
                objFactura.setFechaFactura(fechaVenta);
                objFactura.setValorFactura(valorFactura);
                registro = MiDaoFactura.registrar(objFactura);

                if (valorFactura != 0) {
                    JOptionPane.showMessageDialog(rootPane, "Registro de la factura " + " guardado en la base de datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Fallo en el registro de venta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }//GEN-LAST:event_btnregistrarFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnregistrarFactura;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cajaCantidadVenta;
    private javax.swing.JTextField cajaFechaVenta;
    private javax.swing.JComboBox<String> comboBoxBodegas;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JCalendar jCalendarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
