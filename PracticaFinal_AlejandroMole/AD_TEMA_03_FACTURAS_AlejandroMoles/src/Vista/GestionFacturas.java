
package Vista;


import Controladores.Controlador_Facturas;
import Modelos.Articulos;
import Modelos.Clientes;
import Modelos.FacturasCab;
import Modelos.FacturasLin;
import Modelos.FacturasLinId;
import Modelos.FacturasTot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class GestionFacturas extends javax.swing.JDialog {

    private Controlador_Facturas cr = new Controlador_Facturas();
    private File file_exportar, file_importar;
    public static FacturasCab objFacCab;
    public static FacturasLin fLin;
    public static FacturasTot ft;

    public GestionFacturas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Gestion de Facturas");
        cargarTabla();
        cargarcombo();
        this.setLocationRelativeTo(null);
    }

    private void cargarTabla(){
        LimpiarTabla(tabla_CabFac);
        List <FacturasCab> lista = cr.cargarTablaFacturaCab();
        DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
        //recorremos un bucle por cada objeto de la lista y vamos metiendo los datos en la tabla, metoendo en el primer indice el obheto entero, el cual se
        //mostrara como Numero factura por el toString que he hecho en la clase FacturasCab
        for(FacturasCab f : lista){
            tabla.addRow(new Object[]{f,f.getFechafac(),f.getClientes()});
        }
    }
    
     public void LimpiarTabla(JTable tabla){
        //mediante un bucle comprueba que la tabla esta vacia, y si no borra la columna 0
        while(tabla.getRowCount()!= 0){
            ((DefaultTableModel)tabla.getModel()).removeRow(0);
        }
    }
     
     
     public void cargarcombo(){
        List<Clientes> lista = cr.getClientes();
        for(Clientes c : lista){
            combo_cliente.addItem(c);
        } 
     }
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        ani_fac_btn = new javax.swing.JButton();
        eli_fac_btn = new javax.swing.JButton();
        mod_fac_btn = new javax.swing.JButton();
        panel_datos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_NFact = new javax.swing.JTextField();
        text_fecha = new com.toedter.calendar.JDateChooser();
        combo_cliente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_CabFac = new javax.swing.JTable();
        panel_filtro = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        combo_CabFac = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        text_valor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        combo_exportar = new javax.swing.JComboBox<>();
        exportar_btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        boton_oferta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        ani_fac_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ani_fac_btn.setText("Añadir");
        ani_fac_btn.setFocusable(false);
        ani_fac_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ani_fac_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ani_fac_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ani_fac_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(ani_fac_btn);

        eli_fac_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        eli_fac_btn.setText("Eliminar");
        eli_fac_btn.setFocusable(false);
        eli_fac_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eli_fac_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eli_fac_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eli_fac_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(eli_fac_btn);

        mod_fac_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        mod_fac_btn.setText("Modificar");
        mod_fac_btn.setFocusable(false);
        mod_fac_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mod_fac_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mod_fac_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod_fac_btnActionPerformed(evt);
            }
        });
        jToolBar1.add(mod_fac_btn);

        panel_datos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Numero Factura :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Fecha Factura :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Dni Cliente :");

        text_NFact.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        combo_cliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout panel_datosLayout = new javax.swing.GroupLayout(panel_datos);
        panel_datos.setLayout(panel_datosLayout);
        panel_datosLayout.setHorizontalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_NFact, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combo_cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panel_datosLayout.setVerticalGroup(
            panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_datosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_NFact, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(text_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_datosLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(panel_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_datosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {text_NFact, text_fecha});

        tabla_CabFac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Factura", "Fecha Factura", "Dni Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_CabFac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_CabFacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_CabFac);
        if (tabla_CabFac.getColumnModel().getColumnCount() > 0) {
            tabla_CabFac.getColumnModel().getColumn(0).setResizable(false);
            tabla_CabFac.getColumnModel().getColumn(1).setResizable(false);
            tabla_CabFac.getColumnModel().getColumn(2).setResizable(false);
        }

        panel_filtro.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "FILTRAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Campos:");

        combo_CabFac.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo_CabFac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero Factura", "Fecha Factura", "Dni Cliente" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Valor :");

        text_valor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_valorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_filtroLayout = new javax.swing.GroupLayout(panel_filtro);
        panel_filtro.setLayout(panel_filtroLayout);
        panel_filtroLayout.setHorizontalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_filtroLayout.createSequentialGroup()
                        .addComponent(combo_CabFac, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_valor))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_filtroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_filtroLayout.setVerticalGroup(
            panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_CabFac, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(text_valor))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Exportar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        combo_exportar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        combo_exportar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fichero XML", "Fichero JSON" }));

        exportar_btn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        exportar_btn.setText("EXPORTAR");
        exportar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo_exportar, 0, 198, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(exportar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ofertas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        boton_oferta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boton_oferta.setText("Generar Oferta");
        boton_oferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ofertaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(boton_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(boton_oferta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodo que se activa al seleccionar una fila de la tabla
    private void tabla_CabFacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_CabFacMouseClicked
        //compruebo el indice, si no es -1 quiere decir que he selccionado algo
        DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
        int indice =tabla_CabFac.getSelectedRow();
        if(indice != -1){
            //saco el objeto tipo FacturasCab que se encuientra en el indice 0 de la fila seleccionada
            FacturasCab fac = (FacturasCab) tabla.getValueAt(indice, 0);
            objFacCab = fac; //lo asigno a una variable estatica
            ft = fac.getFacturasTot();//asigno a la variable estatica de un objeto tipo facturastot mediante el objeto de la facturacab
            //pregunto si quiere ver todas las linea de factura
            int opcion = JOptionPane.showConfirmDialog(rootPane, "Quieres ver todas las lineas de facturas de esa factura?");
            if(opcion == JOptionPane.YES_OPTION){
                //abre el dialog de lineas de facturas
                LineaFacturas lf = new LineaFacturas(this, true);
                lf.setVisible(true);
            }else{
                //si le das a que no se te muestra los datos de la factura en los campos que hay a la izquierda
               text_NFact.setText(fac.toString());
               text_fecha.setDate(fac.getFechafac());
                 
                //pone el item del combo box que corresponde
                int lonCombo = combo_cliente.getItemCount();
                String textoCombo = (tabla_CabFac.getValueAt(indice, 2)).toString();
        
                for(int i = 0; i<lonCombo; i++){
                    if(combo_cliente.getItemAt(i).toString().equals(textoCombo)){
                        combo_cliente.setSelectedIndex(i);
                    }
                }  
            }  
        }
    }//GEN-LAST:event_tabla_CabFacMouseClicked

    //metodo que hace un filtro equivalente a un like en sql
    private void text_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_valorKeyTyped
        //me creo un modelo de la tabla y un rowsorter
        DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
        TableRowSorter trs = new TableRowSorter(tabla);
        
        //añado un keylistener al text_valor, donde se escrbiran los datos para filtrarlos
        text_valor.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyReleased(KeyEvent ke){
                //miro que indice tiene el combobox y a partir de ahi me filtra dependiendo de que haya seleccionado
                int indice = combo_CabFac.getSelectedIndex();
                trs.setRowFilter(RowFilter.regexFilter(text_valor.getText(), indice));
            }
        });  
        
        tabla_CabFac.setRowSorter(trs);
    }//GEN-LAST:event_text_valorKeyTyped

    private void ani_fac_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ani_fac_btnActionPerformed
        aniadirFacturasCab();
        cargarTabla();
    }//GEN-LAST:event_ani_fac_btnActionPerformed

    private void eli_fac_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eli_fac_btnActionPerformed
        eliminarFacturasCab();
        cargarTabla();
    }//GEN-LAST:event_eli_fac_btnActionPerformed

    private void mod_fac_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod_fac_btnActionPerformed
        modificarFacturasCab();
        cargarTabla();
    }//GEN-LAST:event_mod_fac_btnActionPerformed

    //metodo que se encarga de exportar los ficheros de la factura en xml o JSON
    private void exportar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportar_btnActionPerformed
        //si el indice que se ha seleccionado es 0 quiere decir que se ha seleccionado el xml
        String nombre;
        
        nombre = JOptionPane.showInputDialog(null, "Indique el nombre para el fichero", "Facturas");
        
        if(nombre == null){
             
        }else{
            
            if(combo_exportar.getSelectedIndex() == 0){
            //me creo un JFileChooser para que se selccione el lugar donde se quiere que se selccione el archivo
            JFileChooser selecArchivo = new JFileChooser();
            selecArchivo.setCurrentDirectory(new File("."));
            selecArchivo.setApproveButtonText("Guardar");
            selecArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //hago que solo se puedan seleccionar directorios
            selecArchivo.setAcceptAllFileFilterUsed(false);
            selecArchivo.showSaveDialog(null);
            
            //hago que la ruta sea la que se ha seleccionado mas el /Facturas.xml
            file_exportar = new File(selecArchivo.getSelectedFile() + "/"+nombre+".xml");
            
            generarXml();
        }else{
            JFileChooser selecArchivo = new JFileChooser();
            selecArchivo.setCurrentDirectory(new File("."));
            selecArchivo.setApproveButtonText("Guardar");
            selecArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            selecArchivo.setAcceptAllFileFilterUsed(false);
            selecArchivo.showSaveDialog(null);
            
            //hago que la ruta sea la que se ha seleccionado mas el /Facturas.JSON
            file_exportar = new File(selecArchivo.getSelectedFile() + "/"+nombre+"JSON");
            
            generarJson();
        }
        }
        
        
    }//GEN-LAST:event_exportar_btnActionPerformed

    private void boton_ofertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ofertaActionPerformed
      
      DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
      int indice =tabla_CabFac.getSelectedRow();
      if(indice != -1){//compruebo que el indice no es -1 para saber que se ha selecionado algo 
            //saco el objeto de la fila seleecionada
        FacturasCab fac = (FacturasCab) tabla.getValueAt(indice, 0);
        
        JFileChooser selecArchivo = new JFileChooser();
        selecArchivo.setCurrentDirectory(new File("."));
        selecArchivo.setApproveButtonText("Escoger Fichero");
        selecArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        selecArchivo.setAcceptAllFileFilterUsed(false);
        selecArchivo.showSaveDialog(null);
       
        file_importar =selecArchivo.getSelectedFile();
        
        if(file_importar == null){
            JOptionPane.showMessageDialog(rootPane, "No ha selccionado ningun archivo");
        }else{
            leerxml(fac);
            
        }
      }
    }//GEN-LAST:event_boton_ofertaActionPerformed

    
    
    //metodo que añade una cabecera de la factura
    private void aniadirFacturasCab() {
       FacturasCab fac = new FacturasCab();//me creo un nuevo objeto
       
       //le meto los valores que he escrito en los diferentes campos
       fac.setNumfac(Long.parseLong(text_NFact.getText()));
       fac.setFechafac(text_fecha.getDate());
       fac.setClientes((Clientes)combo_cliente.getSelectedItem());
       
       //llamo al metodo del controlador y me lo inserta, si no ha ahbidoninguna excepcion me manda un mensaje de exito
       if(cr.aniadirFactura(fac) == 0){
           JOptionPane.showMessageDialog(null, "Factura insertado correctamente");
           insertarFacturasTot(fac);
       }else{
           JOptionPane.showMessageDialog(rootPane, "Error, factura no insertado correctamente");
       }
    }
    
    //metodo que elimina la factura que se ha seleccionado
    private void eliminarFacturasCab(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
        int indice =tabla_CabFac.getSelectedRow();
        if(indice != -1){//compruebo que el indice no es -1 para saber que se ha selecionado algo
            //saco el objeto de la fila seleecionada
            FacturasCab fac = (FacturasCab) tabla.getValueAt(indice, 0);
            
            //pregunto si quiere borrarlo
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere borrar la factura seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                //lamo al metodo del controlador que pasandole el objeto me lo borra de la base de datos
                if(cr.borrarFactura(fac) == 0){
                    JOptionPane.showMessageDialog(null, "Factura borrado perfectamente");
                    eliminarFacturasTot(fac);
                }else{
                    JOptionPane.showMessageDialog(null, "Error, la factura no de ha podido borrar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Factura no borrada");
            }  
        }
    }
    
    
    //metodo que me modifica la cabecera de la factura que he seleccionado
    private void modificarFacturasCab(){
        DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
        int indice =tabla_CabFac.getSelectedRow();
        if(indice != -1){//compruebo que el indice no es -1 para saber que se ha selecionado algo 
            //saco el objeto de la fila seleecionada
            FacturasCab fac = (FacturasCab) tabla.getValueAt(indice, 0);
            //le meto los valores que quiero modificar
            FacturasCab fac_modificar = new FacturasCab();
            fac_modificar.setNumfac(fac.getNumfac());
            fac_modificar.setFechafac(text_fecha.getDate());
            fac_modificar.setClientes((Clientes)combo_cliente.getSelectedItem());
            
            //pregunto si quiere modificarlo
            int opcion = JOptionPane.showConfirmDialog(null, "Quiere modificar la factura seleccionado?");
            if(opcion == JOptionPane.YES_OPTION){
                //llamo al metodo del controlador que me lo modifica pasandole el objeto 
                if(cr.modificarFactura(fac_modificar) == 0){
                    JOptionPane.showMessageDialog(null, "Factura modificado perfectamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error, la factura no de ha podido modificar");
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Factura no modificado");
            }     
        }
    }
    
    //metodo que inserta en la tabla de facturas totales un registro. Este metodo se llama cuando se crea una factura
    private void insertarFacturasTot(FacturasCab fac){
        //me creo un objeto y del tipo facturas tot y inicializo los valores a 0
        ft = new FacturasTot();
        ft.setFacturasCab(fac);
        ft.setBaseimp(BigDecimal.ZERO);
        ft.setImpDto(BigDecimal.ZERO);
        ft.setImpIva(BigDecimal.ZERO);
        ft.setTotalfac(BigDecimal.ZERO);
        
        cr.aniadirFacturaTot(ft);
        
    }
    
    
    //metodo que borra la factura tot, el cual se llama cuando se borra una factura
     private void eliminarFacturasTot(FacturasCab fac){
        ft = new FacturasTot(fac);
        cr.eliminarFacturaTot(ft);
    }
     
     
     
   
    //metodo que genera el xml que se importara
    private void generarXml(){
        try {
            //saco el objeto de la fila seleccionada, comprobando primero que he selccionado una fila
            DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
            int indice =tabla_CabFac.getSelectedRow();
            if(indice != -1){
                FacturasCab fac = (FacturasCab) tabla.getValueAt(indice, 0);
               
                //me creo todos los objetos necesarios para escribir el xml
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
            
                
                Document documento = implementation.createDocument(null, "Facturas", null);
                documento.setXmlVersion("1.0");
            
                //creo el elemento principal
                Element Factura = documento.createElement("Factura");
                
                //creo los elementos que seran hijos el elemento principal, cogiendo los datos del objeto factura_cab que he seleccionad de la fila
                Element numeroFactura = documento.createElement("NumeroFactura");
                Text textNumFac = documento.createTextNode(fac.toString());
                numeroFactura.appendChild(textNumFac);
                Factura.appendChild(numeroFactura);
                
                Element fechaFac = documento.createElement("FechaFactura");
                Text textFecFac = documento.createTextNode(fac.getFechafac().toString());
                fechaFac.appendChild(textFecFac);
                Factura.appendChild(fechaFac);
                
                Element dniFac = documento.createElement("DniCiente");
                Text textDniFac = documento.createTextNode(fac.getClientes().getDnicif());
                dniFac.appendChild(textDniFac);
                Factura.appendChild(dniFac);
                
                Element nombreCli = documento.createElement("NombreCliente");
                Text textNombreFac = documento.createTextNode(fac.getClientes().getNombrecli());
                nombreCli.appendChild(textNombreFac);
                Factura.appendChild(nombreCli);
                
                Element LinFactura = documento.createElement("LineaFactura");
             
                //saco un set de la linea de facturas, para recorrerlo e ir metendo por cada linea de factura diferentes datos
                Set <FacturasLin> lista= fac.getFacturasLins();
                
                for(FacturasLin facLin : lista){
                    //me creo los elementos que seran hijos del numero de linea
                    Element numLin = documento.createElement("NumeroLinea");
                    Text textnumLin = documento.createTextNode(facLin.getId().toString());
                    numLin.appendChild(textnumLin);
                    LinFactura.appendChild(numLin);
                    
                    Element referencia = documento.createElement("Referencia");
                    Text textRefe = documento.createTextNode(facLin.getArticulos().getReferencia());
                    referencia.appendChild(textRefe);
                    numLin.appendChild(referencia);
                    
                    Element descripcion = documento.createElement("Descripcion");
                    Text textDescripcion = documento.createTextNode(facLin.getArticulos().getDescripcion());
                    descripcion.appendChild(textDescripcion);
                    numLin.appendChild(descripcion);
                    
                    Element precio = documento.createElement("PrecioTotal");
                    Text textPrecio = documento.createTextNode(facLin.getPrecio().toString());
                    precio.appendChild(textPrecio);
                    numLin.appendChild(precio);
                    
                    Element cantidad = documento.createElement("Cantidad");
                    Text textCantidad = documento.createTextNode(facLin.getCantidad().toString());
                    cantidad.appendChild(textCantidad);
                    numLin.appendChild(cantidad);
                    
                    Element descuento = documento.createElement("Descuento");
                    Text textDescuento = documento.createTextNode(facLin.getDtolinea().toString());
                    descuento.appendChild(textDescuento);
                    numLin.appendChild(descuento);
                    
                    
                    BigDecimal iva = facLin.getIvalinea().multiply(facLin.getDtolinea());
                    BigDecimal ImpIva = facLin.getPrecio().add(iva);
                    
                    Element total = documento.createElement("SubTotal");
                    Text textSubtotal = documento.createTextNode(ImpIva.toString());
                    total.appendChild(textSubtotal);
                    numLin.appendChild(total);
                }
                
                Factura.appendChild(LinFactura);
                
                Element total = documento.createElement("Total");
                Text textTotal = documento.createTextNode(fac.getFacturasTot().getTotalfac().toString());
                total.appendChild(textTotal);
                Factura.appendChild(total);
                
                
                documento.getDocumentElement().appendChild(Factura);
                Source source = new DOMSource(documento);
                Result result = new StreamResult(file_exportar);
                
                //lo transformo en un xml y lo creo en la ruta selecionada anteriormente
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);
                JOptionPane.showMessageDialog(rootPane, "Fichero Xml generado correctamente");
            }  
               
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error, a la hora de generar el fichero xml");
        } catch (TransformerConfigurationException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error, a la hora de generar el fichero xml");
        } catch (TransformerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error, a la hora de generar el fichero xml");
        }
    }
   
    
    
    
    //metodo que me genera el JSON
    private void generarJson(){
        //saco el objeto de la fila seleccionada, comprobando primero que he selccionado una fila
        DefaultTableModel tabla = (DefaultTableModel)tabla_CabFac.getModel();
        int indice =tabla_CabFac.getSelectedRow();
          if(indice != -1){
               FacturasCab fac = (FacturasCab) tabla.getValueAt(indice, 0);
               Set<FacturasLin> lineaFactura = fac.getFacturasLins();
               //me creo un nuevo objeto json
               JSONObject jsonObj = new JSONObject();
               
               //le meto a ese objeto json los valores que quiero que se muestren
               jsonObj.put("NumFac", String.valueOf(fac.getNumfac()));
               jsonObj.put("FechaFac", fac.getFechafac().toString());
               jsonObj.put("DniCli", fac.getClientes().getDnicif().toString());
               jsonObj.put("NombreCli", fac.getClientes().getNombrecli());
               
               //me creo un array para meer las lineas de factura 
               JSONArray jsonLista = new JSONArray();
               
               //recorro el set y voy metoendo en el array los datos que quiero
               for(FacturasLin f : lineaFactura){
                   jsonLista.put("LineaFactura :" +f.getId().getLineafac());
                   jsonLista.put("Referencia :" +f.getArticulos().getReferencia());
                   jsonLista.put("Precio :" +f.getPrecio().toString());
                   jsonLista.put("Descuento :" +f.getDtolinea());
                   jsonLista.put("Iva :" +f.getIvalinea());
               }
               //meto el arrayen el objeto json
               jsonObj.put("FacturasLinea", jsonLista);
               jsonObj.put("TotalFactura", fac.getFacturasTot().getTotalfac().toString());  
            try {
                //transformo el objeto para escribirlo en el fichero que he selecionado antes
                FileWriter fi = new FileWriter(file_exportar);
                fi.write(jsonObj.toString());
                fi.flush();
                fi.close();
                JOptionPane.showMessageDialog(rootPane, "Fichero JSON generado con  exito");
                
            } catch (IOException ex) {
               JOptionPane.showMessageDialog(rootPane, "Error al generar el fichero JSON");
            }
          }
    }
    
    
    
    
    
    private void leerxml(FacturasCab fCab) {

        try {
            //Creamos los objetos y el documento con la ruta del fichero a leer
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documentXml = builder.parse(file_importar);

            //Creamos una lista de nodos para los elementos lineaFactura
            NodeList listaLineas = documentXml.getElementsByTagName("LineaFactura");

           
           //nos metemos en el primer nodo
           for(int i = 0; i<listaLineas.getLength();i++){
               
               Node nodo = listaLineas.item(i);
               if(nodo.getNodeType() == Node.ELEMENT_NODE){
                   Element e = (Element) nodo;
                   NodeList hijos = e.getChildNodes();
                   
                   //nos metemos en el segundo nodo
                   for(int j = 0;j<hijos.getLength();j++){
                       ArrayList<String> listaContenido = new ArrayList<>();
                       Node nodo2 = hijos.item(j);
                       if(nodo2.getNodeType() == Node.ELEMENT_NODE){
                           Element e2 = (Element) nodo2;
                           NodeList hijos2 = e2.getChildNodes();
                           
                           //nos metemos en el tercer nodo, donde estan los datos que nos interesan
                           for(int x = 0;x<hijos2.getLength();x++){
                               Node nodo3 = hijos2.item(x);
                               if(nodo3.getNodeType() == Node.ELEMENT_NODE){
                                   Element ehijo = (Element) nodo3;
                                   //los meto en la lista
                                   listaContenido.add(ehijo.getTextContent());
                                   
                               }
                           }
                           //creo el objeto de facturasl linea y lo actualizo
                           //tambien actualizo el stock de articulos
                           FacturasLin facLin= new FacturasLin();
                           FacturasLinId id = new FacturasLinId(fCab.getNumfac(),j+1);
                           Articulos art = cr.obtenerArticulos(listaContenido.get(0));
                                   
                           facLin.setFacturasCab(fCab);
                           facLin.setId(id);
                           facLin.setArticulos(art);
                           
                           BigDecimal stock = art.getStock(), 
                           cantidad = BigDecimal.valueOf(Double.parseDouble(listaContenido.get(3).toString()));
                           art.setStock(stock.subtract(cantidad));
                           cr.modificarArticulo(art);
                           
                           facLin.setCantidad(BigDecimal.valueOf(Double.parseDouble(listaContenido.get(3).toString())));
                           facLin.setPrecio(BigDecimal.valueOf(Double.parseDouble(listaContenido.get(2).toString())));
                           facLin.setDtolinea(BigDecimal.valueOf(Double.parseDouble(listaContenido.get(4).toString())));
                           facLin.setIvalinea(BigDecimal.ONE);
                           
                           cr.aniadirFacturaLin(facLin);
                       }
                   }   
               }    
           }
           
           JOptionPane.showMessageDialog(rootPane, "Lineas de la factura adaptadas a la factura seleccionada");
                 
        } catch (SAXException ex) {
            JOptionPane.showMessageDialog(rootPane, "Error, no se ha podido generar las lineas");
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(rootPane, "Error, no se ha podido generar las lineas");
        } catch (ParserConfigurationException ex) {
           JOptionPane.showMessageDialog(rootPane, "Error, no se ha podido generar las lineas");
        }

    }
    
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionFacturas dialog = new GestionFacturas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton ani_fac_btn;
    private javax.swing.JButton boton_oferta;
    private javax.swing.JComboBox<String> combo_CabFac;
    private javax.swing.JComboBox<Clientes> combo_cliente;
    private javax.swing.JComboBox<String> combo_exportar;
    private javax.swing.JButton eli_fac_btn;
    private javax.swing.JButton exportar_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton mod_fac_btn;
    private javax.swing.JPanel panel_datos;
    private javax.swing.JPanel panel_filtro;
    private javax.swing.JTable tabla_CabFac;
    private javax.swing.JTextField text_NFact;
    private com.toedter.calendar.JDateChooser text_fecha;
    private javax.swing.JTextField text_valor;
    // End of variables declaration//GEN-END:variables
}
