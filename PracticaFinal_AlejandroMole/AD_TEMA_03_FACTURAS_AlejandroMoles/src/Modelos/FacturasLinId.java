package Modelos;
// Generated 01-dic-2021 12:09:45 by Hibernate Tools 4.3.1



/**
 * FacturasLinId generated by hbm2java
 */
public class FacturasLinId  implements java.io.Serializable {


     private long numfac;
     private long lineafac;

    public FacturasLinId() {
    }

    public FacturasLinId(long lineafac) {
        this.lineafac = lineafac;
    }

    
    
    public FacturasLinId(long numfac, long lineafac) {
       this.numfac = numfac;
       this.lineafac = lineafac;
    }
   
    public long getNumfac() {
        return this.numfac;
    }
    
    public void setNumfac(long numfac) {
        this.numfac = numfac;
    }
    public long getLineafac() {
        return this.lineafac;
    }
    
    public void setLineafac(long lineafac) {
        this.lineafac = lineafac;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FacturasLinId) ) return false;
		 FacturasLinId castOther = ( FacturasLinId ) other; 
         
		 return (this.getNumfac()==castOther.getNumfac())
 && (this.getLineafac()==castOther.getLineafac());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getNumfac();
         result = 37 * result + (int) this.getLineafac();
         return result;
   }   

    @Override
    public String toString() {
        return  this.getLineafac() + "";
    }


}


