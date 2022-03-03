
package Vista;

import Controladores.Controlador_Articulos;
import Modelos.Articulos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class GestionArticulos extends javax.swing.JDialog {

   Controlador_Articulos cr = new Controlador_Articulos();
    public GestionArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Gestion de Articulos");
        this.setLocationRelativeTo(null);
        cargarTabla();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        boton_art_aniadir = new javax.swing.JButton();
        boton_art_eliminar = new javax.swing.JButton();
        boton_art_modificar = new javax.swing.JButton();
        panel_datos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_Referencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text_Precio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        text_Descripcion = new javax.swing.JTextField();
        text_Stocks = new javax.swing.JTextField();
        text_Iva = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_articulos = new javax.swing.JTable();
        panel_filtro = new javax.swing.JPanel();
        text_Valor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        combo_opciones = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        boton_art_aniadir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        boton_art_aniadir.setText("Añadir");
        boton_art_aniadir.setFocusable(false);
        boton_art_aniadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_art_aniadir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_art_aniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_art_aniadirActionPerformed(evt);
            }
        });
        jToolBar1.add(boton_art_aniadir);

        boton_art_eliminar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        boton_art_eliminar.setText("Eliminar");
        boton_art_eliminar.setFocusable(false);
        boton_art_eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_art_eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_art_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_art_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(boton_art_eliminar);

        boton_art_modificar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        boton_art_modificar.setText("Modificar");
        boton_art_modificar.setFocusable(false);
        boton_art_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton_art_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton_art_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_art_modificarActionPerformed(evt);
            }
        });
        jToolBar1.add(boton_art_modificar);

        panel_datos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Referencias :");

        text_Referencia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Descripcion :");

        text_Precio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("IVA % :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Precio : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Stocks :");

        text_Descripcion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_Descripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                text_DescripcionFocusGained(evt);
            }
        });

        text_Stocks.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        text_Iva.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout panel_datosLayout = new javax.swing.GroupLayout(panel_datos);
        panel_datos.setLayout(panel_datosLayout);
        panel_datosLayout.setHorizontalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_Stocks, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_datosLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_Iva, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_datosLayout.createSequentialGroup()
                                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_datosLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(text_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_datosLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(text_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_datosLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(text_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        panel_datosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {text_Descripcion, text_Precio, text_Referencia, text_Stocks});

        panel_datosLayout.setVerticalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(text_Referencia)))
                .addGap(18, 18, 18)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(text_Iva, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Stocks, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        panel_datosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, text_Descripcion, text_Precio, text_Referencia, text_Stocks});

        tabla_articulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referencia", "Descripcion", "Precio", "IVA %", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_articulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_articulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_articulos);
        if (tabla_articulos.getColumnModel().getColumnCount() > 0) {
            tabla_articulos.getColumnModel().getColumn(0).setResizable(false);
            tabla_articulos.getColumnModel().getColumn(1).setResizable(false);
            tabla_articulos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_articulos.getColumnModel().getColumn(2).setResizable(false);
            tabla_articulos.getColumnModel().getColumn(3).setResizable(false);
            tabla_articulos.getColumnModel().getColumn(4).setResizable(false);
        }

        panel_filtro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        text_Valor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_ValorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_ValorKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Buscar por :");

        combo_opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Referencias", "Descripcion", "Precio", "IVA %", "Stock" }));

        javax.swing.GroupLayout panel_filtroLayout = new javax.swing.GroupLayout(panel_filtro);
        panel_filtro.setLayout(panel_filtroLayout);
        panel_filtroLayout.setHorizontalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(combo_opciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(text_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panel_filtroLayout.setVerticalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filtroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        panel_filtroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_opciones, text_Valor});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panel_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_art_aniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_art_aniadirActionPerformed
        aniadirArticulo();
        cargarTabla();
    }//GEN-LAST:event_boton_art_aniadirActionPerformed

    private void boton_art_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_art_modificarActionPerformed
        modificarArticulo();
        cargarTabla();
    }//GEN-LAST:event_boton_art_modificarActionPerformed

    //metodo que me recoge el objeto articulos que he seleccinado de la tabla
    private void tabla_articulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_articulosMouseClicked
        DefaultTableModel tabla = (DefaultTableModel)tabla_articulos.getModel();
        int indice =tabla_articulos.getSelectedRow();
        if(indice != -1){  
            Articulos art = (Articulos) tabla.getValueAt(indice, 0);
            text_Referencia.setText(art.toString());
            text_Descripcion.setText(art.getDescripcion());
            text_Precio.setText(art.getPrecio().toString());
            text_Iva.setText(art.getPorciva().toString());
            text_Stocks.setText(art.getStock().toString());
        }
    }//GEN-LAST:event_tabla_articulosMouseClicked

    //metodo que se ejecuya al ganar el focus de descripciom el cual me abre un dialog para que se escriba la descripcion
    private void text_DescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_DescripcionFocusGained
       text_Precio.requestFocus();
       String descripcion = JOptionPane.showInputDialog(null, "Escriba aqui la descripcion", text_Descripcion.getText());
       if(!descripcion.isEmpty()){
           text_Descripcion.setText(descripcion);
       }
       
       
    }//GEN-LAST:event_text_DescripcionFocusGained

    private void boton_art_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_art_eliminarActionPerformed
        eliminarArticulo();
        cargarTabla();
    }//GEN-LAST:event_boton_art_eliminarActionPerformed

    private void text_ValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_ValorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_text_ValorKeyReleased

    //metodo que se ejecuta para filtar la tabla *ya explicado*
    private void text_ValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_ValorKeyTyped
        DefaultTableModel tabla = (DefaultTableModel)tabla_articulos.getModel();
        TableRowSorter trs = new TableRowSorter(tabla);
        text_Valor.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyReleased(KeyEvent ke){
                int indice = combo_opciones.getSelectedIndex();
                trs.setRowFilter(RowFilter.regexFilter(text_Valor.getText(), indice));
            }
        });  
        
        tabla_articulos.setRowSorter(trs);
    }//GEN-LAST:event_text_ValorKeyTyped

  
    //metodo que me carga la tabla de articulos
    private void cargarTabla(){
        LimpiarTabla(tabla_articulos);
        List <Articulos> lista = cr.cargarTablaArticulos();
        DefaultTableModel tabla = (DefaultTableModel)tabla_articulos.getModel();
        //recorremos un bucle por cada objeto de la lista y vamos metiendo los datos en la tabla, metoendo en el primer indice el obheto entero, el cual se
        //mostrara como referencia por el toString que he hecho en la clase Articulos
        for(Articulos a : lista){
            tabla.addRow(new Object[]{a,a.getDescripcion(),a.getPrecio(),a.getPorciva(),a.getStock()});
        }
    }
    
    //metodo que recogiendo los datos que he escrito, me crea un articulo
    private void aniadirArticulo() {
       Articulos art = new Articulos();
       art.setReferencia(text_Referencia.getText());
       art.setDescripcion(text_Descripcion.getText());
       art.setPrecio(BigDecimal.valueOf(Double.parseDouble(text_Precio.getText())));
       art.setPorciva(BigDecimal.valueOf(Double.parseDouble(text_Iva.getText())));
       art.setStock(BigDecimal.valueOf(Double.parseDouble(text_Stocks.getText())));
       
       if(cr.aniadirArticulo(art) == 0){
           JOptionPane.showMessageDialog(null, "Articulo insertado correctamente");
       }else{
           JOptionPane.showMessageDialog(rootPane, "Error, articulo no insertado correctamente");
       }
    }
    
    //metodo que seleccionando una fila de la tabla, me borra ese articulo
    private void eliminarArticulo(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_articulos.getModel();
        int indice =tabla_articulos.getSelectedRow();
        if(indice != -1){  
            Articulos art = (Articulos) tabla.getValueAt(indice, 0);
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere borrar el articulo seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                if(cr.borrarArticulo(art) == 0){
                    JOptionPane.showMessageDialog(null, "Articulo borrado perfectamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error, el articulo no de ha podido borrar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Articulo no borrado");
            }
            
        }
    }
    
    //metodo que seleccionando una fila de la tabla, me modifica ese articulo
    private void modificarArticulo(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_articulos.getModel();
        int indice =tabla_articulos.getSelectedRow();
        if(indice != -1){  
            Articulos art = (Articulos) tabla.getValueAt(indice, 0);
            Articulos art_modificar = new Articulos();
            art_modificar.setReferencia(art.getReferencia());
            art_modificar.setDescripcion(text_Descripcion.getText());
            art_modificar.setPrecio(BigDecimal.valueOf(Double.parseDouble(text_Precio.getText())));
            art_modificar.setPorciva(BigDecimal.valueOf(Double.parseDouble(text_Iva.getText())));
            art_modificar.setStock(BigDecimal.valueOf(Double.parseDouble(text_Stocks.getText())));
            
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere modificar el articulo seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                if(cr.modificarArticulo(art_modificar) == 0){
                    JOptionPane.showMessageDialog(null, "Articulo modificado perfectamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error, el articulo no de ha podido modificar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Articulo no modificado");
            }
            
        }
    }
    
    //metodo que me limpia la tabla
    public void LimpiarTabla(JTable tabla){
        //mediante un bucle comprueba que la tabla esta vacia, y si no borra la columna 0
        while(tabla.getRowCount()!= 0){
            ((DefaultTableModel)tabla.getModel()).removeRow(0);
        }
    }
    
    
    
   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionArticulos dialog = new GestionArticulos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton boton_art_aniadir;
    private javax.swing.JButton boton_art_eliminar;
    private javax.swing.JButton boton_art_modificar;
    private javax.swing.JComboBox<String> combo_opciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panel_datos;
    private javax.swing.JPanel panel_filtro;
    private javax.swing.JTable tabla_articulos;
    private javax.swing.JTextField text_Descripcion;
    private javax.swing.JTextField text_Iva;
    private javax.swing.JTextField text_Precio;
    private javax.swing.JTextField text_Referencia;
    private javax.swing.JTextField text_Stocks;
    private javax.swing.JTextField text_Valor;
    // End of variables declaration//GEN-END:variables

   

   
}
