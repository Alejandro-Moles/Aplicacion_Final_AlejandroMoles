
package Vista;

import Controladores.Controlador_Clientes;
import Modelos.Clientes;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class GestionClientes extends javax.swing.JDialog {
    
    private Controlador_Clientes cr = new Controlador_Clientes();

    public GestionClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTabla();
        this.setTitle("Gestion de Clientes");
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        aniCli_btn = new javax.swing.JButton();
        eliCli_btn = new javax.swing.JButton();
        modCli_btn = new javax.swing.JButton();
        panel_datos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_DNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text_nombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        panel_filtro = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        combo_Clientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        text_Cli_valor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        aniCli_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        aniCli_btn.setText("Añadir");
        aniCli_btn.setFocusable(false);
        aniCli_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aniCli_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aniCli_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aniCli_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(aniCli_btn);

        eliCli_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        eliCli_btn.setText("Eliminar");
        eliCli_btn.setFocusable(false);
        eliCli_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliCli_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliCli_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliCli_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(eliCli_btn);

        modCli_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        modCli_btn.setText("Modificar");
        modCli_btn.setFocusable(false);
        modCli_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modCli_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modCli_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modCli_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(modCli_btn);

        panel_datos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("DNI Cliente :");

        text_DNI.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nombre Cliente :");

        text_nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout panel_datosLayout = new javax.swing.GroupLayout(panel_datos);
        panel_datos.setLayout(panel_datosLayout);
        panel_datosLayout.setHorizontalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(text_DNI))
                .addContainerGap())
        );
        panel_datosLayout.setVerticalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dni Cliente", "Nombre Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_clientes);
        if (tabla_clientes.getColumnModel().getColumnCount() > 0) {
            tabla_clientes.getColumnModel().getColumn(0).setResizable(false);
            tabla_clientes.getColumnModel().getColumn(1).setResizable(false);
        }

        panel_filtro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Campo");

        combo_Clientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_Clientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dni Cliente", "Nombre Cliente" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Valor ");

        text_Cli_valor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_Cli_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_Cli_valorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_filtroLayout = new javax.swing.GroupLayout(panel_filtro);
        panel_filtro.setLayout(panel_filtroLayout);
        panel_filtroLayout.setHorizontalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filtroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_Cli_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panel_filtroLayout.setVerticalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Cli_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        panel_filtroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Clientes, text_Cli_valor});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aniCli_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aniCli_btnActionPerformed
        aniadirClientes();
        cargarTabla();
    }//GEN-LAST:event_aniCli_btnActionPerformed

    //metodo que me coloca los valores del cliente selccionado de la tabla
    private void tabla_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMouseClicked
        DefaultTableModel tabla = (DefaultTableModel)tabla_clientes.getModel();
        int indice =tabla_clientes.getSelectedRow();
        if(indice != -1){  
            Clientes cli = (Clientes) tabla.getValueAt(indice, 0);
            
            text_DNI.setText(cli.toString());
            text_nombre.setText(cli.getNombrecli());
        }
    }//GEN-LAST:event_tabla_clientesMouseClicked

    //metodo que filtra la tabla 
    private void text_Cli_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_Cli_valorKeyTyped
        DefaultTableModel tabla = (DefaultTableModel)tabla_clientes.getModel();
        TableRowSorter trs = new TableRowSorter(tabla);
        text_Cli_valor.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyReleased(KeyEvent ke){
                int indice = combo_Clientes.getSelectedIndex();
                trs.setRowFilter(RowFilter.regexFilter(text_Cli_valor.getText(), indice));
            }
        });  
        
        tabla_clientes.setRowSorter(trs);
    }//GEN-LAST:event_text_Cli_valorKeyTyped

    private void eliCli_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliCli_btnActionPerformed
        eliminarClientes();
        cargarTabla();
    }//GEN-LAST:event_eliCli_btnActionPerformed

    private void modCli_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modCli_btnActionPerformed
        modificarClientes();
        cargarTabla();
    }//GEN-LAST:event_modCli_btnActionPerformed

    //metodo que me carga la tabla de clientes
    private void cargarTabla(){
        LimpiarTabla(tabla_clientes);
        List <Clientes> lista = cr.cargarTablaClientes();
        DefaultTableModel tabla = (DefaultTableModel)tabla_clientes.getModel();
        //recorremos un bucle por cada objeto de la lista y vamos metiendo los datos en la tabla, metoendo en el primer indice el obheto entero, el cual se
        //mostrara como dni por el toString que he hecho en la clase Cliente
        for(Clientes c : lista){
            tabla.addRow(new Object[]{c,c.getNombrecli()});
        }
    }
    
     public void LimpiarTabla(JTable tabla){
        //mediante un bucle comprueba que la tabla esta vacia, y si no borra la columna 0
        while(tabla.getRowCount()!= 0){
            ((DefaultTableModel)tabla.getModel()).removeRow(0);
        }
    }
    
    //metodo que pasandole los datos que he escrito, me añade un cliente
    private void aniadirClientes() {
       Clientes cli = new Clientes();
       cli.setDnicif(text_DNI.getText());
       cli.setNombrecli(text_nombre.getText());
       
       if(cr.aniadirCliente(cli) == 0){
           JOptionPane.showMessageDialog(null, "Articulo insertado correctamente");
       }else{
           JOptionPane.showMessageDialog(rootPane, "Error, articulo no insertado correctamente");
       }
    }
    
    //metodo que seleccionando una fila de la tabla, me borra ese cliente
    private void eliminarClientes(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_clientes.getModel();
        int indice =tabla_clientes.getSelectedRow();
        if(indice != -1){  
            Clientes cli = (Clientes) tabla.getValueAt(indice, 0);
            
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere borrar el cliente seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                if(cr.borrarCliente(cli) == 0){
                    JOptionPane.showMessageDialog(null, "Cliente borrado perfectamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error, el cliente no de ha podido borrar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Cliente no borrado");
            }  
        }
    }
    
    //metodo que seleccionando una fila de la tabla, me modifica ese cliente
    private void modificarClientes(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_clientes.getModel();
        int indice =tabla_clientes.getSelectedRow();
        if(indice != -1){  
            Clientes cli = (Clientes) tabla.getValueAt(indice, 0);
            Clientes cli_modificar = new Clientes();
            cli_modificar.setDnicif(cli.getDnicif());
            cli_modificar.setNombrecli(text_nombre.getText());
            
            
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere borrar el cliente seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                if(cr.modificarClientes(cli_modificar) == 0){
                    JOptionPane.showMessageDialog(null, "Articulo modificado perfectamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error, el articulo no de ha podido modificar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Cliente no modificado");
            }
            
            
        }
    }
     
     
     
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionClientes dialog = new GestionClientes(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aniCli_btn;
    private javax.swing.JComboBox<String> combo_Clientes;
    private javax.swing.JButton eliCli_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modCli_btn;
    private javax.swing.JPanel panel_datos;
    private javax.swing.JPanel panel_filtro;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField text_Cli_valor;
    private javax.swing.JTextField text_DNI;
    private javax.swing.JTextField text_nombre;
    // End of variables declaration//GEN-END:variables
}
