package edu.jdc.formularuios;

import edu.jdc.clases.Permiso;
import edu.jdc.daos.DaoPermiso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmAdministrarPermisos extends javax.swing.JInternalFrame {

    private String[] textoColumnas = {"Codigo", "Nombre", "Funcionalidad", "CAntidad", "Actualizar", "Borrar"};
    private DaoPermiso objMiDao;
    private List<Permiso> arregloPermisos;
    private Permiso objPermiso;

    private DefaultTableModel miModelito = new DefaultTableModel(textoColumnas, 0) {
        @Override

        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columIndex) {

            if (columIndex == 4) {
                return ImageIcon.class;
            }

            if (columIndex == 5) {
                return ImageIcon.class;
            }
            return Object.class;
        }

    };

    public FrmAdministrarPermisos() {
        initComponents();

        objMiDao = new DaoPermiso();
        arregloPermisos = new ArrayList<>();
        tablaSalida.setModel(miModelito);
        llenarTabla();
    }

    private void llenarTabla() {
        miModelito.setRowCount(0);
        arregloPermisos = objMiDao.consultar("");

        String nombreActualizar = "/edu/jdc/imagenes/editar.png";
        String nombreBorrar = "/edu/jdc/imagenes/borrar.png";

        String rutaOmagenActu = this.getClass().getResource(nombreActualizar).getPath();
        String rutaOmagenBorr = this.getClass().getResource(nombreBorrar).getPath();

        ImageIcon iconActualizar = new ImageIcon(rutaOmagenActu);
        ImageIcon iconBorrar = new ImageIcon(rutaOmagenBorr);

        for (Permiso objMiPermiso : arregloPermisos) {
            Object[] miFila = new Object[6];

            miFila[0] = objMiPermiso.getCodPermiso();
            miFila[1] = objMiPermiso.getNombrePermiso();
            miFila[2] = objMiPermiso.getFuncionalidadPermiso();
            miFila[3] = objMiPermiso.getCantidadPermisoRol();
            miFila[4] = iconActualizar;
            miFila[5] = iconBorrar;

            miModelito.addRow(miFila);

        }

    }

    private void cerrarVentana() {
        int opcion = 0;
        String[] textoBotones = {"Aceptar", "Cancelar"};
        opcion = JOptionPane.showOptionDialog(PanelPrincipal, "Estas seguro de salir?", "cerrar ventana", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, textoBotones, EXIT_ON_CLOSE);

        if (opcion == JOptionPane.YES_OPTION) {
            this.dispose();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSalida = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        panelNombrePermiso = new javax.swing.JPanel();
        jlNombrePermiso = new javax.swing.JLabel();
        cajaNombrePermiso = new javax.swing.JTextField();
        PanelFuncionalidadPermiso = new javax.swing.JPanel();
        lbFuncionalidadPermiso = new javax.swing.JLabel();
        cajaFuncionalidadPermiso = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        PanelTitulo.setBackground(new java.awt.Color(0, 0, 0));
        PanelTitulo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Permisos");

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(351, 351, 351))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTituloLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 51));

        tablaSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSalidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSalida);

        btnSalir.setText("X");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        panelNombrePermiso.setBackground(new java.awt.Color(0, 0, 0));

        jlNombrePermiso.setForeground(new java.awt.Color(255, 255, 255));
        jlNombrePermiso.setText("Nombre Permiso");

        cajaNombrePermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNombrePermisoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNombrePermisoLayout = new javax.swing.GroupLayout(panelNombrePermiso);
        panelNombrePermiso.setLayout(panelNombrePermisoLayout);
        panelNombrePermisoLayout.setHorizontalGroup(
            panelNombrePermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombrePermisoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelNombrePermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNombrePermiso)
                    .addComponent(cajaNombrePermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNombrePermisoLayout.setVerticalGroup(
            panelNombrePermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNombrePermisoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNombrePermiso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cajaNombrePermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        PanelFuncionalidadPermiso.setBackground(new java.awt.Color(0, 0, 0));

        lbFuncionalidadPermiso.setForeground(new java.awt.Color(255, 255, 255));
        lbFuncionalidadPermiso.setText("Funcionalidad Permiso");

        javax.swing.GroupLayout PanelFuncionalidadPermisoLayout = new javax.swing.GroupLayout(PanelFuncionalidadPermiso);
        PanelFuncionalidadPermiso.setLayout(PanelFuncionalidadPermisoLayout);
        PanelFuncionalidadPermisoLayout.setHorizontalGroup(
            PanelFuncionalidadPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFuncionalidadPermisoLayout.createSequentialGroup()
                .addGroup(PanelFuncionalidadPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFuncionalidadPermisoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lbFuncionalidadPermiso))
                    .addGroup(PanelFuncionalidadPermisoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cajaFuncionalidadPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        PanelFuncionalidadPermisoLayout.setVerticalGroup(
            PanelFuncionalidadPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFuncionalidadPermisoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFuncionalidadPermiso)
                .addGap(18, 18, 18)
                .addComponent(cajaFuncionalidadPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnActualizar.setBackground(new java.awt.Color(0, 255, 0));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(31, 31, 31))
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelNombrePermiso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelFuncionalidadPermiso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelNombrePermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PanelFuncionalidadPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaNombrePermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombrePermisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNombrePermisoActionPerformed

    private void tablaSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidaMouseClicked
        int columnaseleccionada = tablaSalida.getSelectedColumn();

        if (columnaseleccionada == 4) {
            int filaSeleccionada = tablaSalida.getSelectedRow();
            String codigoTexto = miModelito.getValueAt(filaSeleccionada, 0).toString();

            int codigo = Integer.parseInt(codigoTexto);

            objPermiso = objMiDao.buscar(codigo);

            if (objPermiso == null) {
                JOptionPane.showMessageDialog(PanelPrincipal, "Fallo al obtener los datos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                cajaNombrePermiso.setText(objPermiso.getNombrePermiso());
                cajaFuncionalidadPermiso.setText(objPermiso.getFuncionalidadPermiso());
            }

        } else if (columnaseleccionada == 5) {// si se daclick en la columna 4 
            int filaSeleccionada = tablaSalida.getSelectedRow();
            String codigoTexto = miModelito.getValueAt(filaSeleccionada, 0).toString();// Extrae el valor en la columna 0 (presumiblemente el código) de la fila seleccionada y lo convierte a una cadena de texto.
            int codigo = Integer.parseInt(codigoTexto);//  Convierte la cadena de texto a un entero, asumiendo que representa un valor numérico.
            
            objPermiso = objMiDao.buscar(codigo);
            if (objPermiso.getCantidadPermisoRol() > 0) {
                JOptionPane.showMessageDialog(rootPane, "No se puede eliminar Permiso", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {
                int opcion = 0;

                String[] textoBotones = {"Aceptar", "Cancelar"};

                opcion = JOptionPane.showOptionDialog(rootPane, "Estas seguro de eliminar" + objPermiso.getNombrePermiso() + "?", "Eliminar", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, textoBotones, textoBotones[1]);

                if (opcion == JOptionPane.YES_OPTION) {
                    boolean eliminado = objMiDao.eliminar(objPermiso.getCodPermiso());
                    if (eliminado) {
                        JOptionPane.showMessageDialog(rootPane, "Permiso" + objPermiso.getNombrePermiso(), "eliminado", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Fallo al eliminar" + objPermiso.getNombrePermiso(), "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
                llenarTabla();
            }

        }
    }//GEN-LAST:event_tablaSalidaMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String nombre, funcionalidad;

        nombre = cajaNombrePermiso.getText();
        funcionalidad = cajaFuncionalidadPermiso.getText();

        if (nombre.isEmpty() || funcionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(PanelPrincipal, "Faltan datos para realizar la acutalizacio", "Advertensia", JOptionPane.WARNING_MESSAGE);

        } else {
            objPermiso.setNombrePermiso(cajaNombrePermiso.getText());
            objPermiso.setFuncionalidadPermiso(cajaFuncionalidadPermiso.getText());

            boolean actualizado = objMiDao.actualizar(objPermiso);

            if (actualizado) {

                JOptionPane.showMessageDialog(PanelPrincipal, "Se actualizo el permiso " + nombre + " de forma correcta", "exito", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(PanelPrincipal, "fallo al actualizar el permiso ", "error", JOptionPane.ERROR_MESSAGE);

            }
            llenarTabla();

        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.cerrarVentana();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFuncionalidadPermiso;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField cajaFuncionalidadPermiso;
    private javax.swing.JTextField cajaNombrePermiso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlNombrePermiso;
    private javax.swing.JLabel lbFuncionalidadPermiso;
    private javax.swing.JPanel panelNombrePermiso;
    private javax.swing.JTable tablaSalida;
    // End of variables declaration//GEN-END:variables
}
