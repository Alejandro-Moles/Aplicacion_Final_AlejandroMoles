
package Controladores;

import Modelos.Clientes;
import Modelos.EstadisticasClientes;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;


public class ControladorEstadisticas {
    
    
    private Transaction tx;
    private Session sesion;
    
    
    public void cargarSesion(){
        try{
            sesion = NewHibernateUtil.getSessionFactory().openSession();           
        }catch(HibernateException ex){
                
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
       
        public List cargarTablaFacturaCab(){
        try{
            //conecto la sesion
            cargarSesion();
            //hago un criteria el cual almaceno en una lista, el criteria recojera los datos de la tabla Prestamo y estaran ordenado por el NPrestamo
            List <EstadisticasClientes> lista = sesion.createCriteria(EstadisticasClientes.class)
                    .addOrder(Order.asc("id"))
                    .list();
            //devuelvo la lista
            return lista;
        }finally{
            //cierro la sesion  
            sesion.close();
        }   
    }
        
        
    public int generarEstadisticas(String dni1, String dni2, Date fecha1, Date fecha2){
        try{
            //conecto la sesion
            cargarSesion();
            
            SQLQuery query = sesion.createSQLQuery("{call PR_ESTADISTICAS(?,?,?,?)}");
            
            query.setString(0, dni1);
            query.setString(1, dni2);
            query.setDate(2,fecha1);
            query.setDate(3, fecha2);
            
            query.executeUpdate();
            return 0;
        }catch(HibernateException ex){
            System.out.println(ex);
            return -1;
        }finally{
           //cierro la sesion  
           sesion.close();
        }
    }
}
