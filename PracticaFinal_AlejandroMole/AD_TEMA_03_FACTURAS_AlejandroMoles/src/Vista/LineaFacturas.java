
package Vista;

import Controladores.Controlador_Facturas;
import Modelos.Articulos;
import Modelos.FacturasCab;
import Modelos.FacturasLin;
import Modelos.FacturasLinId;
import Modelos.FacturasTot;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class LineaFacturas extends javax.swing.JDialog {

    private Controlador_Facturas cr = new Controlador_Facturas();
    
    public LineaFacturas(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Lineas de Factura");
        cargarTabla();
        cargarcomboRefe();
        
       	text_NumFac.setText(Long.toString(GestionFacturas.objFacCab.getNumfac()));
        
        this.setLocationRelativeTo(null);
    }

  
    //metodo que me carga la tabala de linea de facturas
     private void cargarTabla(){
        LimpiarTabla(tabla_linfacturas);
        List<FacturasCab> fc = cr.cargarTablaFacturaCab2(GestionFacturas.objFacCab.getNumfac());
        Set <FacturasLin> lista = fc.get(0).getFacturasLins();
        DefaultTableModel tabla = (DefaultTableModel)tabla_linfacturas.getModel();
        for(FacturasLin fl : lista){
            tabla.addRow(new Object[]{fl.getFacturasCab(),fl,fl.getArticulos(),fl.getCantidad(),fl.getPrecio(),fl.getDtolinea(),fl.getIvalinea()});
        }
    }
    
     //metodo que me borra la tabla
     public void LimpiarTabla(JTable tabla){
        //mediante un bucle comprueba que la tabla esta vacia, y si no borra la columna 0
        while(tabla.getRowCount()!= 0){
            ((DefaultTableModel)tabla.getModel()).removeRow(0);
        }
    }
     
    //metoo que me carga un combo box con las referencia de los articulos que hay disponibles
    private void cargarcomboRefe(){
        combo_Referencia.removeAllItems();
        List<Articulos> lista = cr.getReferencias();
        
        for(Articulos a : lista){
            combo_Referencia.addItem(a);
        }
        combo_Referencia.setSelectedIndex(0);
    }
    
    
    
    //metodo que con los datos que he escrito , me añade la linea de factura
    private void aniadirLinFacturas() {
       FacturasLin fac = new FacturasLin();
       FacturasLinId id = new FacturasLinId(GestionFacturas.objFacCab.getNumfac(),Long.valueOf(text_linfac.getText()));
       
       fac.setFacturasCab(GestionFacturas.objFacCab);
       fac.setId(id);
       fac.setArticulos((Articulos) combo_Referencia.getSelectedItem());
       fac.setCantidad(BigDecimal.valueOf(Double.parseDouble(text_Cantidad.getText())));
       fac.setPrecio(BigDecimal.valueOf(Double.parseDouble(text_Precio.getText())));
       fac.setDtolinea(BigDecimal.valueOf(Double.parseDouble(text_DtoLin.getText())));
       fac.setIvalinea(BigDecimal.valueOf(Double.parseDouble(text_Iva.getText())));
       
       
       if(cr.aniadirFacturaLin(fac) == 0){
           JOptionPane.showMessageDialog(null, "Factura insertado correctamente");
           aniadirStockArticulos(fac);
           actualizarFacTot_Insert(fac);
       }else{
           JOptionPane.showMessageDialog(rootPane, "Error, factura no insertado correctamente");
       }
    }
    
    //metodo que seleccionando una fila de la tabla, me borra ese linafac
    private void eliminarLinFacturas(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_linfacturas.getModel();
        int indice =tabla_linfacturas.getSelectedRow();
        if(indice != -1){  
            FacturasLin fac = (FacturasLin) tabla.getValueAt(indice, 1);
            
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere borrar la factura seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                if(cr.eliminarFacturaLin(fac) == 0){
                    JOptionPane.showMessageDialog(null, "Factura borrado perfectamente");
                    eliminarStockArticulos(fac);
                    actualizarFacTot_Delete(fac);
                }else{
                    JOptionPane.showMessageDialog(null, "Error, la factura no de ha podido borrar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Factura no borrada");
            }  
        }
    }

    //metodo que seleccionando una fila de la tabla, me modifica ese linafac
    private void modificarLinFacturas(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_linfacturas.getModel();
        int indice =tabla_linfacturas.getSelectedRow();
        if(indice != -1){  
            FacturasLin fac = (FacturasLin) tabla.getValueAt(indice, 1);
            FacturasLin fac_modificar = new FacturasLin();
            
            fac_modificar.setId(fac.getId());
            fac_modificar.setArticulos((Articulos) combo_Referencia.getSelectedItem());
            fac_modificar.setCantidad(BigDecimal.valueOf(Double.parseDouble(text_Cantidad.getText())));
            fac_modificar.setPrecio(BigDecimal.valueOf(Double.parseDouble(text_Precio.getText())));
            fac_modificar.setDtolinea(BigDecimal.valueOf(Double.parseDouble(text_DtoLin.getText())));
            fac_modificar.setIvalinea(BigDecimal.valueOf(Double.parseDouble(text_Iva.getText())));

            
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere modificar la factura seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                if(cr.modificarFacturaLin(fac_modificar) == 0){
                    JOptionPane.showMessageDialog(null, "Factura modificado perfectamente");
                     modificarStockArticulos(fac);
                     actualizarFactTot_Update(fac,fac_modificar);
                }else{
                    JOptionPane.showMessageDialog(null, "Error, la factura no de ha podido modificar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Factura no modificado");
            }     
        }
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        aniFac_btn = new javax.swing.JButton();
        eliFac_btn = new javax.swing.JButton();
        modFac_btn = new javax.swing.JButton();
        panel_datos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_NumFac = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        text_Cantidad = new javax.swing.JTextField();
        text_Precio = new javax.swing.JTextField();
        text_DtoLin = new javax.swing.JTextField();
        combo_Referencia = new javax.swing.JComboBox<>();
        text_Iva = new javax.swing.JTextField();
        text_linfac = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_linfacturas = new javax.swing.JTable();
        panel_filtro = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        combo_Facturas = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        text_Valor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        aniFac_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        aniFac_btn.setText("Añadir");
        aniFac_btn.setFocusable(false);
        aniFac_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aniFac_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aniFac_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aniFac_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(aniFac_btn);

        eliFac_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        eliFac_btn.setText("Eliminar");
        eliFac_btn.setFocusable(false);
        eliFac_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliFac_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliFac_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliFac_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(eliFac_btn);

        modFac_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        modFac_btn.setText("Modificar");
        modFac_btn.setFocusable(false);
        modFac_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modFac_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modFac_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modFac_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(modFac_btn);

        panel_datos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Numero Factura :");

        text_NumFac.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_NumFac.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Linea Factura :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Cantidad :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Referencia :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Precio :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Datos Linea :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Iva Linea :");

        text_Cantidad.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        text_Cantidad.setToolTipText("");
        text_Cantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                text_CantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_CantidadFocusLost(evt);
            }
        });
        text_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_CantidadKeyTyped(evt);
            }
        });

        text_Precio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_Precio.setFocusable(false);

        text_DtoLin.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        combo_Referencia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo_Referencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_ReferenciaItemStateChanged(evt);
            }
        });

        text_Iva.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_Iva.setFocusable(false);

        text_linfac.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout panel_datosLayout = new javax.swing.GroupLayout(panel_datos);
        panel_datos.setLayout(panel_datosLayout);
        panel_datosLayout.setHorizontalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_Iva, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_DtoLin, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_Precio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_NumFac, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_linfac, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_Referencia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_datosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_Referencia, text_Cantidad, text_DtoLin, text_Iva, text_NumFac, text_Precio, text_linfac});

        panel_datosLayout.setVerticalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_NumFac, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_linfac, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_Referencia, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_Cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_DtoLin, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_Iva)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        panel_datosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7});

        panel_datosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Referencia, text_Cantidad, text_DtoLin, text_Iva, text_NumFac, text_Precio, text_linfac});

        tabla_linfacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Factura", "Linea Factura", "Referencia", "Cantidad", "Precio", "Descuentos Linea", "Iva Linea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_linfacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_linfacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_linfacturas);
        if (tabla_linfacturas.getColumnModel().getColumnCount() > 0) {
            tabla_linfacturas.getColumnModel().getColumn(0).setResizable(false);
            tabla_linfacturas.getColumnModel().getColumn(1).setResizable(false);
            tabla_linfacturas.getColumnModel().getColumn(2).setResizable(false);
            tabla_linfacturas.getColumnModel().getColumn(3).setResizable(false);
            tabla_linfacturas.getColumnModel().getColumn(4).setResizable(false);
            tabla_linfacturas.getColumnModel().getColumn(5).setResizable(false);
            tabla_linfacturas.getColumnModel().getColumn(6).setResizable(false);
        }

        panel_filtro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Valor :");

        combo_Facturas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo_Facturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linea Factura", "Referencia", "Cantidad", "Precio", "Datos Linea", "Iva Linea" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Campo :");

        text_Valor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_ValorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_filtroLayout = new javax.swing.GroupLayout(panel_filtro);
        panel_filtro.setLayout(panel_filtroLayout);
        panel_filtroLayout.setHorizontalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_Facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_filtroLayout.setVerticalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_Facturas)
                    .addComponent(text_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        panel_filtroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Facturas, text_Valor});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                    .addComponent(panel_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //cuando cambio de item el las referancias, se me ajusta el text_cantidad para mostrar la cantidad de articulos que tieene asociado esa referencia
    private void combo_ReferenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_ReferenciaItemStateChanged
        
        if(combo_Referencia.getSelectedIndex() != -1){
             Articulos a = (Articulos)combo_Referencia.getSelectedItem();
        
            text_Precio.setText(a.getPrecio().toString());  
            text_Iva.setText(a.getPorciva().toString());
            if(a.getStock().compareTo(BigDecimal.ZERO) == 0){
                text_Cantidad.setForeground(Color.red);
                text_Cantidad.setText("Cantidad Actual: " +a.getStock());
            }else{
                text_Cantidad.setForeground(Color.green);
                text_Cantidad.setText("Cantidad Actual: " +a.getStock());
            }
        }
  
    }//GEN-LAST:event_combo_ReferenciaItemStateChanged

    //un metodo que hace que cuando escriba en la cabtidad, automaticamente se seleccione un precio dependiendo de la cantidad que haya
    private void text_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_CantidadKeyTyped
        
         text_Cantidad.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyReleased(KeyEvent ke){
                Articulos a = (Articulos)combo_Referencia.getSelectedItem();
                if(text_Cantidad.getText().isEmpty()){
                    text_Precio.setText(a.getPrecio().toString());
                }else{
                    BigDecimal precio  = a.getPrecio().multiply(BigDecimal.valueOf(Double.parseDouble(text_Cantidad.getText()))); 
                    text_Precio.setText(precio.toString());
                }
            }
        });     
    }//GEN-LAST:event_text_CantidadKeyTyped

    //metodo que me añade una linea de factura, comprobando si quedan stock para el articulo seleccionado
    private void aniFac_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aniFac_btnActionPerformed
        Articulos a = (Articulos)combo_Referencia.getSelectedItem();
        
        if(a.getStock().compareTo(BigDecimal.valueOf(Double.parseDouble(text_Cantidad.getText()))) < 0){
            JOptionPane.showMessageDialog(rootPane, "Error, no quedan mas stocks para este articulos");
            
        }else{
            aniadirLinFacturas();
            cargarTabla();
            cargarcomboRefe();
        }
    }//GEN-LAST:event_aniFac_btnActionPerformed

    //metodo que elimina la kinea de factura
    private void eliFac_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliFac_btnActionPerformed
        eliminarLinFacturas();
        cargarTabla();
        cargarcomboRefe();
    }//GEN-LAST:event_eliFac_btnActionPerformed

    //metodo que modifica la linea de factura
    private void modFac_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modFac_btnActionPerformed
        modificarLinFacturas();
        cargarTabla();
        cargarcomboRefe();
    }//GEN-LAST:event_modFac_btnActionPerformed

    //metodo que pone todos los datos en sus respectivos campos al seleccionar una fila de la tabla
    private void tabla_linfacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_linfacturasMouseClicked
        DefaultTableModel tabla = (DefaultTableModel)tabla_linfacturas.getModel();
        int indice =tabla_linfacturas.getSelectedRow();
        if(indice != -1){  
            FacturasLin fac = (FacturasLin) tabla.getValueAt(indice, 1);
            text_NumFac.setText(fac.getFacturasCab().toString());
            text_linfac.setText(fac.getId().toString());
            text_Cantidad.setText(fac.getCantidad().toString());
            text_Precio.setText(fac.getPrecio().toString());
            text_DtoLin.setText(fac.getDtolinea().toString());
            text_Iva.setText(fac.getIvalinea().toString());

            int lonCombo = combo_Referencia.getItemCount();
            String textoCombo = (tabla_linfacturas.getValueAt(indice, 2)).toString();
        
            for(int i = 0; i<lonCombo; i++){
                 if(combo_Referencia.getItemAt(i).toString().equals(textoCombo)){
                    combo_Referencia.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tabla_linfacturasMouseClicked

    private void text_CantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_CantidadFocusLost
       
    }//GEN-LAST:event_text_CantidadFocusLost

    //metodo que filtra la tabla
    private void text_ValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_ValorKeyTyped
        DefaultTableModel tabla = (DefaultTableModel)tabla_linfacturas.getModel();
        TableRowSorter trs = new TableRowSorter(tabla);
        text_Valor.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyReleased(KeyEvent ke){
                int indice = combo_Facturas.getSelectedIndex();
                trs.setRowFilter(RowFilter.regexFilter(text_Valor.getText(), indice));
            }
        });  
        
        tabla_linfacturas.setRowSorter(trs);
    }//GEN-LAST:event_text_ValorKeyTyped

    
    private void text_CantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_CantidadFocusGained
        text_Cantidad.setForeground(Color.black);
        text_Cantidad.setText("");
    }//GEN-LAST:event_text_CantidadFocusGained

    
   //metodo que elimina los stocks de los articulos dependiendo de la cantidad hayas metido en la linea
   public void eliminarStockArticulos(FacturasLin fac){
       Articulos a = fac.getArticulos();
       BigDecimal stock = a.getStock(), cantidad = fac.getCantidad();
       a.setStock(stock.add(cantidad));
       cr.modificarArticulo(a);
   }
   
   //metodo que añade los stocks de los articulos dependiendo de la cantidad hayas eliminado en la linea
    public void aniadirStockArticulos(FacturasLin fac){
       Articulos a = fac.getArticulos();
       BigDecimal stock = a.getStock(), cantidad = fac.getCantidad();
       a.setStock(stock.subtract(cantidad));
       cr.modificarArticulo(a);   
   }
    
    //metodo que elimina o añade los stocks de los articulos dependiendo de la cantidad hayas metido o eliminado en la linea
    public void modificarStockArticulos(FacturasLin fac){
        fac.setArticulos((Articulos)combo_Referencia.getSelectedItem());
        Articulos a = fac.getArticulos();
        
        
        if(BigDecimal.valueOf(Double.parseDouble(text_Cantidad.getText())).compareTo(fac.getCantidad()) < 0){
            BigDecimal stock = a.getStock(), cantidad = fac.getCantidad();
            BigDecimal cantidadModi = BigDecimal.valueOf(Double.parseDouble(text_Cantidad.getText()));
            BigDecimal cantidadRestante = cantidad.subtract(cantidadModi);
            a.setStock(stock.add(cantidadRestante));
            cr.modificarArticulo(a);
        }else{
            BigDecimal stock = a.getStock(), cantidad = fac.getCantidad();
            BigDecimal cantidadModi = BigDecimal.valueOf(Double.parseDouble(text_Cantidad.getText()));
            BigDecimal cantidadRestante = cantidadModi.subtract(cantidad);
            a.setStock(stock.subtract(cantidadRestante));
            cr.modificarArticulo(a);
        }
   }
    
    
    //metodo que actualiza la tabla de tot facturas al insertar una linea de facturas
    public void actualizarFacTot_Insert(FacturasLin fac){
        BigDecimal Iva = fac.getIvalinea().multiply(fac.getDtolinea());
        
        BigDecimal BaseImp = fac.getPrecio();
        BigDecimal ImpDtos = fac.getPrecio().multiply(fac.getDtolinea());
        BigDecimal ImpIva = fac.getPrecio().subtract(Iva);
        BigDecimal ImpTot = BaseImp.add(ImpIva);
        
        
        FacturasTot factu = GestionFacturas.ft;
        factu.setBaseimp(factu.getBaseimp().add(BaseImp));
        factu.setImpDto(factu.getImpDto().add(ImpDtos));
        factu.setImpIva(factu.getImpIva().add(ImpIva));
        factu.setTotalfac(factu.getTotalfac().add(ImpTot));
        
        cr.modificarFacturaTot(factu);
          
    }
    
    //metodo que actualiza la tabla de tot facturas al borrar una linea de facturas
     public void actualizarFacTot_Delete(FacturasLin fac){
        BigDecimal Iva = fac.getIvalinea().multiply(fac.getDtolinea());
        BigDecimal BaseImp = fac.getPrecio();
        BigDecimal ImpDtos = fac.getPrecio().multiply(fac.getDtolinea());
        BigDecimal ImpIva = fac.getPrecio().subtract(Iva);
        BigDecimal ImpTot = BaseImp.add(ImpIva);
        
        
        FacturasTot factu = GestionFacturas.ft;
        factu.setBaseimp(factu.getBaseimp().subtract(BaseImp));
        factu.setImpDto(factu.getImpDto().subtract(ImpDtos));
        factu.setImpIva(factu.getImpIva().subtract(ImpIva));
        factu.setTotalfac(factu.getTotalfac().subtract(ImpTot));
        
        cr.modificarFacturaTot(factu);
          
    }
     
     //metodo que actualiza la tabla de tot facturas al actualizar una linea de facturas
     public void actualizarFactTot_Update(FacturasLin fac,FacturasLin fac_modificar){
        actualizarFacTot_Delete(fac);
        actualizarFacTot_Insert(fac_modificar);
     }
  
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LineaFacturas dialog = new LineaFacturas(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton aniFac_btn;
    private javax.swing.JComboBox<String> combo_Facturas;
    private javax.swing.JComboBox<Articulos> combo_Referencia;
    private javax.swing.JButton eliFac_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modFac_btn;
    private javax.swing.JPanel panel_datos;
    private javax.swing.JPanel panel_filtro;
    private javax.swing.JTable tabla_linfacturas;
    private javax.swing.JTextField text_Cantidad;
    private javax.swing.JTextField text_DtoLin;
    private javax.swing.JTextField text_Iva;
    private javax.swing.JTextField text_NumFac;
    private javax.swing.JTextField text_Precio;
    private javax.swing.JTextField text_Valor;
    private javax.swing.JTextField text_linfac;
    // End of variables declaration//GEN-END:variables
}
