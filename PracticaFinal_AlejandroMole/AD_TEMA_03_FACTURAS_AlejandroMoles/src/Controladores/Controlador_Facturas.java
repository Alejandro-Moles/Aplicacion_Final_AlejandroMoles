
package Controladores;



import Modelos.Articulos;
import Modelos.Clientes;
import Modelos.FacturasCab;
import Modelos.FacturasLin;
import Modelos.FacturasLinId;
import Modelos.FacturasTot;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class Controlador_Facturas {
        //creo tanto una  transaccion como una sesion
    private Transaction tx;
    private Session sesion;
    
    
    public void cargarSesion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();           
        }catch(HibernateException ex){
                
        }
    }
    
    
    public Articulos obtenerArticulos(String refe){
        sesion = NewHibernateUtil.getSessionFactory().openSession();  
        Articulos articulo = (Articulos) sesion.get(Articulos.class,refe);
        sesion.close();
        return articulo;
        
    }
    
     public List cargarTablaFacturaCab(){
        try{
            //conecto la sesion
            cargarSesion();
            //hago un criteria el cual almaceno en una lista, el criteria recojera los datos de la tabla Prestamo y estaran ordenado por el NPrestamo
            List <FacturasCab> lista = sesion.createCriteria(FacturasCab.class)
                    .addOrder(Order.asc("numfac"))
                    .list();
            //devuelvo la lista
            return lista;
        }finally{
            //cierro la sesion  
            sesion.close();
        }   
    }
     
     
     public List cargarTablaFacturaCab2(Long numfac){
        try{
            //conecto la sesion
            cargarSesion();
            //hago un criteria el cual almaceno en una lista, el criteria recojera los datos de la tabla Prestamo y estaran ordenado por el NPrestamo
            List <FacturasCab> lista = sesion.createCriteria(FacturasCab.class)
                    .add( Restrictions.like("numfac", numfac))
                    .addOrder(Order.asc("numfac"))
                    .list();
            //devuelvo la lista
            return lista;
        }finally{
            //cierro la sesion  
            sesion.close();
        }   
    }
    
     
     
      public int aniadirFactura(FacturasCab f){
        try{
            //conecto la sesion
           cargarSesion();
           //inicio la transaccion
           tx = sesion.beginTransaction();
           //con el objeto que he recibido de tipo Prestamo ejecuto un save, el cual me lo guarda en la base de datos
           sesion.save(f);
           //realizo un commit
           tx.commit();
           //devuelvo un 0 si no se ha producodo ningun error
           return 0;
        }catch(HibernateException ex){
            //si se ha producido un error, hago un rollback y devuelvo un -1
            tx.rollback();
            System.out.println(ex);
            return -1;  
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    
    public int borrarFactura(FacturasCab f) {
        try{
            //conecto a la sesion
            cargarSesion();
            //inicio un transaccion
            tx = sesion.beginTransaction();
            //borro el objeto seleccionado que he recogido
            sesion.delete(f);
            //realizo un commit
            tx.commit();
            return 0;
        }catch(HibernateException ex){
            tx.rollback();
            return -1;               
        }finally{
            //cierro la sesion
            sesion.close();
        }
     
    }

    public int modificarFactura(FacturasCab f) {
        try{
            //me conecto a la sesion
            cargarSesion();
            //inicio una transaccion
            tx = sesion.beginTransaction();
            //con el objeto que he recibido actualizo la base de datos
            sesion.update(f);
            //hago un commit
            tx.commit();
            return 0;
        }catch(HibernateException ex){
            tx.rollback();
            return -1;
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
     public int modificarFacturaLin(FacturasLin f) {
        try{
            //me conecto a la sesion
            cargarSesion();
            //inicio una transaccion
            tx = sesion.beginTransaction();
            //con el objeto que he recibido actualizo la base de datos
            sesion.update(f);
            //hago un commit
            tx.commit();
            return 0;
        }catch(HibernateException ex){
            tx.rollback();
            return -1;
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    
    public int aniadirFacturaTot(FacturasTot f){
        try{
            //conecto la sesion
           cargarSesion();
           //inicio la transaccion
           tx = sesion.beginTransaction();
           //con el objeto que he recibido de tipo Prestamo ejecuto un save, el cual me lo guarda en la base de datos
           sesion.save(f);
           //realizo un commit
           tx.commit();
           //devuelvo un 0 si no se ha producodo ningun error
           return 0;
        }catch(HibernateException ex){
            //si se ha producido un error, hago un rollback y devuelvo un -1
            tx.rollback();
            return -1;  
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
     public int aniadirFacturaLin(FacturasLin f){
        try{
            //conecto la sesion
           cargarSesion();
           //inicio la transaccion
           tx = sesion.beginTransaction();
           //con el objeto que he recibido de tipo Prestamo ejecuto un save, el cual me lo guarda en la base de datos
           sesion.save(f);
           //realizo un commit
           tx.commit();
           //devuelvo un 0 si no se ha producodo ningun error
           return 0;
        }catch(HibernateException ex){
            //si se ha producido un error, hago un rollback y devuelvo un -1
            tx.rollback();
            System.out.println(ex);
            return -1;  
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    
    public int eliminarFacturaTot(FacturasTot f){
        try{
            //conecto la sesion
           cargarSesion();
           //inicio la transaccion
           tx = sesion.beginTransaction();
           //con el objeto que he recibido de tipo Prestamo ejecuto un save, el cual me lo guarda en la base de datos
           sesion.delete(f);
           //realizo un commit
           tx.commit();
           //devuelvo un 0 si no se ha producodo ningun error
           return 0;
        }catch(HibernateException ex){
            //si se ha producido un error, hago un rollback y devuelvo un -1
            tx.rollback();
            return -1;  
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    public int eliminarFacturaLin(FacturasLin f){
        try{
            //conecto la sesion
           cargarSesion();
           //inicio la transaccion
           tx = sesion.beginTransaction();
           //con el objeto que he recibido de tipo Prestamo ejecuto un save, el cual me lo guarda en la base de datos
           sesion.delete(f);
           //realizo un commit
           tx.commit();
           //devuelvo un 0 si no se ha producodo ningun error
           return 0;
        }catch(HibernateException ex){
            //si se ha producido un error, hago un rollback y devuelvo un -1
            tx.rollback();
            return -1;  
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    
    public List <Articulos> getReferencias(){
          try{
            //conecto la sesion
            cargarSesion();
            //hago una sentencia hql, la cual me devuelve todos los datos de la tabla FormaPago
            String hql = "FROM Articulos";
            Query query = sesion.createQuery(hql);
            //recojo los datos en una lista
            List results = query.list();
            //devuelvo la lista
            return results;
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    
    public List <Clientes> getClientes(){
          try{
            //conecto la sesion
            cargarSesion();
            //hago una sentencia hql, la cual me devuelve todos los datos de la tabla FormaPago
            String hql = "FROM Clientes";
            Query query = sesion.createQuery(hql);
            //recojo los datos en una lista
            List results = query.list();
            //devuelvo la lista
            return results;
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    public List<FacturasLin> getFacturaId(){
          try{
            //conecto la sesion
            cargarSesion();
            //hago una sentencia hql, la cual me devuelve todos los datos de la tabla FormaPago
            String hql = "FROM FacturasLin";
            Query query = sesion.createQuery(hql);
            //recojo los datos en una lista
            List results = query.list();
            //devuelvo la lista
            return results;
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
    
    
     public int modificarArticulo(Articulos art) {
        try{
            //me conecto a la sesion
            cargarSesion();
            //inicio una transaccion
            tx = sesion.beginTransaction();
            //con el objeto que he recibido actualizo la base de datos
            sesion.update(art);
            //hago un commit
            tx.commit();
            return 0;
        }catch(HibernateException ex){
            tx.rollback();
            return -1;
        }finally{
            //cierro la sesion
            sesion.close();
        }
    }
     
     public int modificarFacturaTot(FacturasTot f) {
        try{
            //me conecto a la sesion
            cargarSesion();
            //inicio una transaccion
            tx = sesion.beginTransaction();
            //con el objeto que he recibido actualizo la base de datos
            sesion.update(f);
            //hago un commit
            tx.commit();
            return 0;
        }finally{
            sesion.close();
        } 
    }
}
