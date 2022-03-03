
package Controladores;


import Modelos.Clientes;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public class Controlador_Clientes {
    //creo tanto una  transaccion como una sesion
    private Transaction tx;
    private Session sesion;
    
    
    public void cargarSesion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();           
        }catch(HibernateException ex){
                
        }
    }
    
    
     public List cargarTablaClientes(){
        try{
            //conecto la sesion
            cargarSesion();
            //hago un criteria el cual almaceno en una lista, el criteria recojera los datos de la tabla Prestamo y estaran ordenado por el NPrestamo
            List <Clientes> lista = sesion.createCriteria(Clientes.class)
                    .addOrder(Order.asc("dnicif"))
                    .list();
            //devuelvo la lista
            return lista;
        }finally{
            //cierro la sesion
            sesion.close();
        }   
    }
     
     
      public int aniadirCliente(Clientes c){
        try{
            //conecto la sesion
           cargarSesion();
           //inicio la transaccion
           tx = sesion.beginTransaction();
           //con el objeto que he recibido de tipo Prestamo ejecuto un save, el cual me lo guarda en la base de datos
           sesion.save(c);
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
    
    
    public int borrarCliente(Clientes c) {
        try{
            //conecto a la sesion
            cargarSesion();
            //inicio un transaccion
            tx = sesion.beginTransaction();
            //borro el objeto seleccionado que he recogido
            sesion.delete(c);
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

    public int modificarClientes(Clientes c) {
        try{
            //me conecto a la sesion
            cargarSesion();
            //inicio una transaccion
            tx = sesion.beginTransaction();
            //con el objeto que he recibido actualizo la base de datos
            sesion.update(c);
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
