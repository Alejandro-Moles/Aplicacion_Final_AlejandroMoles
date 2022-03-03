
package Controladores;

import Modelos.Articulos;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;


public class Controlador_Articulos {
    //creo tanto una  transaccion como una sesion
    private Transaction tx;
    private Session sesion;
    
    
    public void cargarSesion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();           
        }catch(HibernateException ex){
                
        }
    }
    
    
     public List cargarTablaArticulos(){
        try{
            //conecto la sesion
            cargarSesion();
            //hago un criteria el cual almaceno en una lista, el criteria recojera los datos de la tabla Prestamo y estaran ordenado por el NPrestamo
            List <Articulos> lista = sesion.createCriteria(Articulos.class)
                    .addOrder(Order.asc("referencia"))
                    .list();
            //devuelvo la lista
            return lista;
        }finally{
            //cierro la sesion
            sesion.close();
        }   
    }
     
     
    public int aniadirArticulo(Articulos a){
        try{
            //conecto la sesion
           cargarSesion();
           //inicio la transaccion
           tx = sesion.beginTransaction();
           //con el objeto que he recibido de tipo Prestamo ejecuto un save, el cual me lo guarda en la base de datos
           sesion.save(a);
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
    
    
    public int borrarArticulo(Articulos a) {
        try{
            //conecto a la sesion
            cargarSesion();
            //inicio un transaccion
            tx = sesion.beginTransaction();
            //borro el objeto seleccionado que he recogido
            sesion.delete(a);
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
}
