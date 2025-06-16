package edu.jdc.formularuios;

import edu.jdc.clases.Rol;
import edu.jdc.clases.PermisoRol;
import edu.jdc.clases.Permiso;
import edu.jdc.daos.*;
import edu.jdc.daos.DaoPermisoRol;
import edu.jdc.daos.DaoRol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmPermisoRol extends javax.swing.JInternalFrame {

    private DaoPermisoRol objDaoPermisoRol;
    private DaoPermiso objDaoPermiso;
    private DaoRol objDaoRol;

    private List<PermisoRol> arregloPermisoRoles = new ArrayList<>();
    private List<Permiso> arregloPermisos = new ArrayList<>();
    private List<Rol> arregloRoles = new ArrayList<>();

    private DefaultComboBoxModel modelitoPermiso = new DefaultComboBoxModel();
    private DefaultComboBoxModel modelitorol = new DefaultComboBoxModel();

    private String[] textoColumnas = {"Rol", "Permiso", "Borrar"};

    private DefaultTableModel modeloTabla = new DefaultTableModel(textoColumnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 2) {
                return ImageIcon.class;
            }
            return Object.class;
        }

    };

    // guardar los codigos
    Map<String, Integer> codigosRol = new HashMap<>();
    Map<String, Integer> codigosPermiso = new HashMap<>();
    private String orden;

    public FrmPermisoRol() {
        initComponents();
        //inicializa los datos
        objDaoPermisoRol = new DaoPermisoRol();
        objDaoPermiso = new DaoPermiso();
        objDaoRol = new DaoRol();
        //cargar Modelos
        tablasalida.setModel(modeloTabla);
        cmbPermisos.setModel(modelitoPermiso);
        cmbRoles.setModel(modelitorol);
        orden = "p.cod_rol ASC";
        //metodoa llenar datos
        llenarComboPermisos();
        llenarComboRoles();
        llenarTabla();

    }

    private void llenarComboPermisos() {
        arregloPermisos = objDaoPermiso.consultar("");
        modelitoPermiso.addElement("Seleccione el permiso");

        for (int i = 0; i < arregloPermisos.size(); i++) {
            modelitoPermiso.addElement(arregloPermisos.get(i).getNombrePermiso());
        }

    }

    private void llenarComboRoles() {
        arregloRoles = objDaoRol.consultar("");
        modelitorol.addElement("Seleccione el rol");

        for (int i = 0; i < arregloRoles.size(); i++) {
            modelitorol.addElement(arregloRoles.get(i).getNombreRol());
        }

    }

    private void llenarTabla() {
        modeloTabla.setRowCount(0);
        arregloPermisoRoles = objDaoPermisoRol.consultar("");

        String nombreEliminar = "/edu/jdc/imagenes/borrar.png";
        String rutaIconoEliminar = this.getClass().getResource(nombreEliminar).getPath();
        ImageIcon iconEliminar = new ImageIcon(rutaIconoEliminar);

        for (PermisoRol objpermisoRol : arregloPermisoRoles) {
            Object[] miFilita = new Object[3];

            miFilita[0] = objpermisoRol.getCodRol().getNombreRol();
            miFilita[1] = objpermisoRol.getCodPermiso().getNombrePermiso();
            miFilita[2] = iconEliminar;

            modeloTabla.addRow(miFilita);
            codigosRol.put(objpermisoRol.getCodRol().getNombreRol(), objpermisoRol.getCodRol().getCodRol());
            codigosPermiso.put(objpermisoRol.getCodPermiso().getNombrePermiso(), objpermisoRol.getCodPermiso().getCodPermiso());

        }

    }

    private void LimpiarCombos() {
        cmbPermisos.setSelectedIndex(0);
        cmbRoles.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        Paneltitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablasalida = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        panelComboPermiso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbPermisos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbRoles = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRolAcendente = new javax.swing.JButton();
        btnRolDecendente = new javax.swing.JButton();
        btnPermisoAcendente = new javax.swing.JButton();
        btnPermisoDesendente = new javax.swing.JButton();

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Permiso Rol");

        javax.swing.GroupLayout PaneltituloLayout = new javax.swing.GroupLayout(Paneltitulo);
        Paneltitulo.setLayout(PaneltituloLayout);
        PaneltituloLayout.setHorizontalGroup(
            PaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltituloLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PaneltituloLayout.setVerticalGroup(
            PaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneltituloLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        tablasalida.setModel(new javax.swing.table.DefaultTableModel(
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
        tablasalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasalidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablasalida);

        btnSalir.setText("X");

        panelComboPermiso.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Permisos");

        cmbPermisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPermisosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelComboPermisoLayout = new javax.swing.GroupLayout(panelComboPermiso);
        panelComboPermiso.setLayout(panelComboPermisoLayout);
        panelComboPermisoLayout.setHorizontalGroup(
            panelComboPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComboPermisoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelComboPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComboPermisoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cmbPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        panelComboPermisoLayout.setVerticalGroup(
            panelComboPermisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComboPermisoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Roles");

        cmbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRolAcendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/jdc/imagenes/arriba.png"))); // NOI18N
        btnRolAcendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolAcendenteActionPerformed(evt);
            }
        });

        btnRolDecendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/jdc/imagenes/abajo.png"))); // NOI18N
        btnRolDecendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolDecendenteActionPerformed(evt);
            }
        });

        btnPermisoAcendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/jdc/imagenes/arriba.png"))); // NOI18N
        btnPermisoAcendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisoAcendenteActionPerformed(evt);
            }
        });

        btnPermisoDesendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/jdc/imagenes/abajo.png"))); // NOI18N
        btnPermisoDesendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisoDesendenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelComboPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addGap(24, 24, 24))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnRolAcendente)
                .addGap(30, 30, 30)
                .addComponent(btnRolDecendente)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnRegistrar)
                        .addGap(43, 43, 43)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnPermisoAcendente)
                        .addGap(26, 26, 26)
                        .addComponent(btnPermisoDesendente)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addComponent(panelComboPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar)
                            .addComponent(btnCancelar))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPermisoAcendente)
                            .addComponent(btnPermisoDesendente))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRolDecendente)
                            .addComponent(btnRolAcendente))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Paneltitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(Paneltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int indice_rol = cmbRoles.getSelectedIndex();
        int indice_permiso = cmbPermisos.getSelectedIndex();
        boolean registro = false;

        if (indice_rol <= 0 || indice_permiso <= 0) {
            JOptionPane.showMessageDialog(PanelPrincipal, "Seleccione rol y permiso para registrarlos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            PermisoRol objPermisorol = new PermisoRol();

            objPermisorol.setCodRol(arregloRoles.get(indice_rol - 1));
            objPermisorol.setCodPermiso(arregloPermisos.get(indice_permiso - 1));

            if (objDaoPermisoRol.VerificarPermisorol(objPermisorol)) {
                JOptionPane.showMessageDialog(PanelPrincipal, "El permiso si esta creado",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                registro = objDaoPermisoRol.registrar(objPermisorol);
                LimpiarCombos();
                llenarTabla();

                if (registro) {
                    JOptionPane.showMessageDialog(PanelPrincipal, "permiso creado", "Completado",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cmbPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPermisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPermisosActionPerformed

    private void tablasalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasalidaMouseClicked

        int columnaseleccionada = tablasalida.getSelectedColumn();
        if (columnaseleccionada == 2) { // si se da click en la columna 4 

            int filaSeleccionada = tablasalida.getSelectedRow();
            String nombreRol = modeloTabla.getValueAt(filaSeleccionada, 0).toString();
            String nombrePermiso = modeloTabla.getValueAt(filaSeleccionada, 1).toString();

            int codRol = codigosRol.get(nombreRol);
            int codPermiso = codigosPermiso.get(nombrePermiso);

            String[] textoBotones = {"Aceptar", "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(rootPane, "Estás seguro de eliminar el registro", "Eliminar Registro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, textoBotones, textoBotones[1]);
            if (opcion == JOptionPane.YES_OPTION) {
                boolean eliminado = false;

                eliminado= objDaoPermisoRol.eliminar(codRol, codPermiso);

                if (eliminado) {
                    JOptionPane.showMessageDialog(PanelPrincipal, "Se elimino permiso Rol ", "adevertencia", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(PanelPrincipal, "fallo al eliminarpermiso Rol ", "adevertencia", JOptionPane.ERROR_MESSAGE);

                }
                llenarTabla();

            }

        }


    }//GEN-LAST:event_tablasalidaMouseClicked

    private void btnRolDecendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolDecendenteActionPerformed
        orden = "p.cod_rol DESC";
        llenarTabla();
    }//GEN-LAST:event_btnRolDecendenteActionPerformed

    private void btnRolAcendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolAcendenteActionPerformed
        orden = "p.cod_rol  ASC";
        llenarTabla();
    }//GEN-LAST:event_btnRolAcendenteActionPerformed

    private void btnPermisoAcendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisoAcendenteActionPerformed
        orden = "p.cod_permiso  ASC";
        llenarTabla();
    }//GEN-LAST:event_btnPermisoAcendenteActionPerformed

    private void btnPermisoDesendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisoDesendenteActionPerformed
        orden = "p.cod_permiso DESC";
        llenarTabla();
    }//GEN-LAST:event_btnPermisoDesendenteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel Paneltitulo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPermisoAcendente;
    private javax.swing.JButton btnPermisoDesendente;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRolAcendente;
    private javax.swing.JButton btnRolDecendente;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbPermisos;
    private javax.swing.JComboBox<String> cmbRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelComboPermiso;
    private javax.swing.JTable tablasalida;
    // End of variables declaration//GEN-END:variables
}
