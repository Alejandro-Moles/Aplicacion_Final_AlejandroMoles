package Modelos;
// Generated 01-dic-2021 12:09:45 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Clientes  implements java.io.Serializable {


     private String dnicif;
     private String nombrecli;
     private Set estadisticasClienteses = new HashSet(0);
     private Set facturasCabs = new HashSet(0);

    public Clientes() {
    }

    public Clientes(String dnicif) {
        this.dnicif = dnicif;
       
    }   
    
    public Clientes(String dnicif, String nombrecli) {
        this.dnicif = dnicif;
        this.nombrecli = nombrecli;
    }
    public Clientes(String dnicif, String nombrecli, Set estadisticasClienteses, Set facturasCabs) {
       this.dnicif = dnicif;
       this.nombrecli = nombrecli;
       this.estadisticasClienteses = estadisticasClienteses;
       this.facturasCabs = facturasCabs;
    }
   
    public String getDnicif() {
        return this.dnicif;
    }
    
    public void setDnicif(String dnicif) {
        this.dnicif = dnicif;
    }
    public String getNombrecli() {
        return this.nombrecli;
    }
    
    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }
    public Set getEstadisticasClienteses() {
        return this.estadisticasClienteses;
    }
    
    public void setEstadisticasClienteses(Set estadisticasClienteses) {
        this.estadisticasClienteses = estadisticasClienteses;
    }
    public Set getFacturasCabs() {
        return this.facturasCabs;
    }
    
    public void setFacturasCabs(Set facturasCabs) {
        this.facturasCabs = facturasCabs;
    }

    @Override
    public String toString() {
        return dnicif ;
    }




}


