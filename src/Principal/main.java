
package Principal;

import PojosClases.Atracciones;
import PojosClases.Cadena;
import PojosClases.Empleado;
import PojosClases.ParqueAtracciones;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {
    
    public static Configuration cfg= new Configuration().configure();
    public static SessionFactory sf= cfg.buildSessionFactory();
    public static Session ses=sf.openSession();
    public Transaction tx=ses.beginTransaction();
    public Scanner cint= new Scanner(System.in).useLocale(Locale.ENGLISH);
    public Scanner cstr= new Scanner(System.in).useLocale(Locale.ENGLISH);
    public Scanner cout= new Scanner(System.in).useLocale(Locale.ENGLISH);
    public boolean ejecutando = true;
    
    public static Query query;
    public static Scanner teclado= new Scanner (System.in);
    
    private static void menuOpciones(){
        
        
        System.out.println("___________________");
        System.out.println(" ");
        System.out.println("¡¡Bienvenido a la App de Gestión!!");
        System.out.println("¿Que quieres modificar?");
        System.out.println(" ");
        System.out.println("1- Las Cadenas");
        System.out.println("2-Los Parques de Atracciones");
        System.out.println("3-Las Atracciones");
        System.out.println("4-Los Empleados");
        System.out.println("0.Salir");
        
    }
    
    private static void menu2Opciones(){
        
        
        System.out.println("········");
        System.out.println("¡Hecho! ");
        System.out.println("········");
        System.out.println("--Elije de nuevo--");
        System.out.println("1- Las Cadenas");
        System.out.println("2-Los Parques de Atracciones");
        System.out.println("3-Las Atracciones");
        System.out.println("4-Los Empleados");
        System.out.println("0.Salir");
        
    }
    
    private static int menuCrud(int opcion){
        
        int segundaopcion = 0;
        
        
        return segundaopcion;
    }
    
    
    //Gets
    private static void getAllCadenas(){
        Session ses = sf.openSession();
        query = (Query) ses.createQuery("from Cadena ");
        
        Iterator it= query.iterate();
        
        while(it.hasNext()){
            
            Cadena cadena=(Cadena) it.next();
            System.out.println(cadena.getId()+" -> "+cadena.getNombre()+".");
        }
    }
    
    private static void getAllParques(){
        Session ses = sf.openSession();
        query = (Query) ses.createQuery("from ParqueAtracciones");
        
        Iterator it= query.iterate();
        
        while(it.hasNext()){
            
            ParqueAtracciones parque=(ParqueAtracciones) it.next();
            System.out.println(parque.getIdParque()+" -> "+parque.getNombreParque()+".");
        }
        
    }
    
    private static void getAllAtracciones( ){
        Session ses = sf.openSession();
        query = (Query) ses.createQuery("from Atracciones");
        
        Iterator it= query.iterate();
        
        while(it.hasNext()){
            
            Atracciones atracciones=(Atracciones) it.next();
            System.out.println(atracciones.getId()+" -> "+atracciones.getNombre()+".");
        }
        
    }
    
    private static void getAllTrabajadores( ){
        Session ses = sf.openSession();
        query = (Query) ses.createQuery("from Empleado ");
         
        Transaction tas = ses.beginTransaction();
        Iterator it= query.iterate();
        
        while(it.hasNext()){
            
            Empleado empleado=(Empleado) it.next();
            System.out.println(empleado.getId()+" -> "+empleado.getNombre()+" "+empleado.getApellidos()+".");
        }
       
        
       
    }
    
    
    //Creaciones.
    
    private static void crearTrabajador(String Nombre, String Apellidos, String Puesto,int idAtraccion,int sueldo){
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from Empleado where id=id");
        
        Empleado empleado= new Empleado(Nombre, Apellidos, Puesto, idAtraccion,sueldo);
        
        ses.save(empleado);
        tas.commit();
        ses.close();
        
    }
    
    private static void crearAtraccion(String nombre, int edad,int idParqueA){
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from Atracciones where id=id");
        
        Atracciones atraccion= new Atracciones(nombre, edad,idParqueA);
        
        ses.save(atraccion);
        tas.commit();
        ses.close();
        
    }
    
    private static void crearParquedeAtracciones(String nombreParque, String ciudadParque, int presupuesto, int idCadena){
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from ParqueAtracciones where idParque=idParque");
        
        ParqueAtracciones parque= new ParqueAtracciones(nombreParque, ciudadParque,presupuesto,idCadena);
        
        ses.save(parque);
        tas.commit();
        ses.close();
        
    }
    
    private static void crearCadena(String nombre, int capital){
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from Cadena where id=id");
        
        Cadena cadena= new Cadena(nombre, capital);
        
        ses.save(cadena);
        tas.commit();
        ses.close();
        
    }
    
    //Get Uno
    
    private static Empleado getUnEmpleado(int id){
        
        query = (Query) ses.createQuery("from Empleado where id="+id);
        
        Iterator it= query.iterate();
        
        Empleado empleado = (Empleado) it.next();;
        
        empleado.setId(empleado.getId());
        empleado.setNombre(empleado.getNombre());
        empleado.setApellidos(empleado.getApellidos());
        empleado.setPuesto(empleado.getPuesto());
        empleado.setSueldo(empleado.getSueldo());
        empleado.setIdAtraccion(empleado.getIdAtraccion());
        
        return empleado;
        
    }
    
    private static Atracciones getUnaAtraccion(int id){
        
        query = (Query) ses.createQuery("from Atracciones where id="+id);
        
        Iterator it= query.iterate();
        
        Atracciones atraccioncita = (Atracciones) it.next();;
        
        atraccioncita.setId(atraccioncita.getId());
        atraccioncita.setNombre(atraccioncita.getNombre());
        atraccioncita.setEdad(atraccioncita.getEdad());
        atraccioncita.setIdParqueA(atraccioncita.getIdParqueA());
        //Fijarse en: En Marcha,
        
        return atraccioncita;
        
    }
    
    private static ParqueAtracciones getUnParqueAtraccion(int id){
        
        query = (Query) ses.createQuery("from ParqueAtracciones where idParque="+id);
        
        Iterator it= query.iterate();
        
        ParqueAtracciones parquecito = (ParqueAtracciones) it.next();;
        
        parquecito.setIdParque(parquecito.getIdParque());
        parquecito.setNombreParque(parquecito.getNombreParque());
        parquecito.setCiudadParque(parquecito.getCiudadParque());
        parquecito.setPresupuesto(parquecito.getPresupuesto());
        parquecito.setIdCadena(parquecito.getIdCadena());
        
        
        
        return parquecito;
        
    }
    
       private static ParqueAtracciones getUnParquedeCadena(int idCadena){
        
        query = (Query) ses.createQuery("from ParqueAtracciones where idCadena="+idCadena);
        
        Iterator it= query.iterate();
        
        ParqueAtracciones parquecito = (ParqueAtracciones) it.next();;
        
        parquecito.setIdParque(parquecito.getIdParque());
        parquecito.setNombreParque(parquecito.getNombreParque());
        parquecito.setCiudadParque(parquecito.getCiudadParque());
        parquecito.setPresupuesto(parquecito.getPresupuesto());
        parquecito.setIdCadena(parquecito.getIdCadena());
        
        
        
        return parquecito;
        
    }
    
    private static Cadena getUnaCadena(int id){
        
        query = (Query) ses.createQuery("from Cadena where id="+id);
        
        Iterator it= query.iterate();
        
        Cadena cadena = (Cadena) it.next();;
        
        cadena.setId(cadena.getId());
        cadena.setCapital(cadena.getCapital());
        cadena.setNombre(cadena.getNombre());
        
        
        return cadena;
        
    }
    
    
    //Borrados
    
    private static void deleteTrabajador(int id){
        
        ses.beginTransaction();
        
        Empleado empleadito;
        empleadito=getUnEmpleado(id);
        
        ses.delete(empleadito);
        ses.getTransaction().commit();
        
    }
    
    private static void deleteAtraccion(int id){
        
        ses.beginTransaction();
        
        Atracciones atraccioncita;
        atraccioncita=getUnaAtraccion(id);
        
        ses.delete(atraccioncita);
        ses.getTransaction().commit();
        
    }
    
    private static void deleteParqueAtracciones(int id){
        
        ses.beginTransaction();
        
        ParqueAtracciones parquito;
        parquito=getUnParqueAtraccion(id);
        
        ses.delete(parquito);
        ses.getTransaction().commit();
        
    }
    
    private static void deleteCadena(int id){
        
        ses.beginTransaction();
        
        //Para borrar todos los parques de una cadena.
        ParqueAtracciones pequito = new ParqueAtracciones();
        pequito=getUnParquedeCadena(id);
        
        
        Cadena cadenita;
        cadenita=getUnaCadena(id);
        System.out.println(pequito.getNombreParque());
        if(pequito.getNombreParque()!=null){
         ses.delete(pequito);
        }
        ses.delete(cadenita);
       
        ses.getTransaction().commit();
        
    }
    
    //Actualizar
    
    private static void actualizarTrabajador(int id,String nombre, String apellidos, String puesto, int idAtraccion, int sueldo){
        
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from Empleado where id=id");
        
        Empleado empleadito= new Empleado(nombre,apellidos, puesto,idAtraccion, sueldo);
        empleadito.setId(id);
        
        ses.update(empleadito);
        ses.getTransaction().commit();
        
    }
    
    private static void actualizarAtraccion(int id,String nombre, int edad,int idParqueA){
        
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from Atracciones where id=id");
        
        Atracciones atraccion= new Atracciones(nombre,edad, idParqueA);
        atraccion.setId(id);
        
        ses.update(atraccion);
        tas.commit();
        ses.close();
        
    }
    
    private static void actualizarParqueAtraccion(int id,String nombreParque, String ciudadParque, int presupuesto, int idCadena){
        
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from ParqueAtracciones where idParque=idParque");
        
        ParqueAtracciones parquecito= new ParqueAtracciones(nombreParque, ciudadParque, presupuesto,idCadena);
        parquecito.setIdParque(id);
        
        ses.update(parquecito);
        tas.commit();
        ses.close();
        
    }
    
    private static void actualizarCadena(int id,String nombre, int capital){
        
        
        Session ses = sf.openSession();
        Transaction tas = ses.beginTransaction();
        
        query = (Query) ses.createQuery("from Cadena where id=id");
        
        Cadena cadenita= new Cadena(nombre, capital);
        cadenita.setId(id);
        
        ses.update(cadenita);
        tas.commit();
        ses.close();
        
    }
    
    
    
    
    
    public static void main(String[] args) {
  
        int opcion=1;
        
        menuOpciones();
        opcion=teclado.nextInt();
        String nombre = null;
        int capital,id = 0,sueldo;
        int idCadena;
        String ciudadParque,apellido,puesto;
        
        while(opcion!=0){
            switch (opcion) {
                case 1:
                    System.out.println("  ");
                    System.out.println("  ");
                    System.out.println("**************************");
                    System.out.println("Menu de CRUD sobre Cadenas");
                    System.out.println("**************************");
                    System.out.println("1.Ver Cadenas disponibles.");
                    System.out.println("2.Crear una Cadena.");
                    System.out.println("3.Borrar una Cadena.");
                    System.out.println("4.Modificar una Cadena.");
                    System.out.println("  ");
                    opcion=teclado.nextInt();
                    
                    if(opcion==1){
                        getAllCadenas();
                    }else if(opcion==2){
                        
                        System.out.println("Escribe el nombre de la nueva Cadena.");
                        nombre=teclado.next();
                        System.out.println("Escribe el capital de Cadena.");
                        capital=teclado.nextInt();
                        crearCadena(nombre,capital);
                        
                    }else if(opcion==3){
                        
                        System.out.println("Escribe la cadena que quieres borrar:");
                        getAllCadenas();
                        id=teclado.nextInt();
                        deleteCadena(id);
                        
                    }else if(opcion==4){
                        
                        System.out.println("Escribe el id cadena que quieres modificar:");
                        getAllCadenas();
                        id=teclado.nextInt();
                        System.out.println("Escribe el nombre de la nueva Cadena.");
                        nombre=teclado.next();
                        System.out.println("Escribe el capital de Cadena.");
                        capital=teclado.nextInt();
                        actualizarCadena(id,nombre,capital);
                        
                    }
                    
                    break;
                case 2:
                    System.out.println("  ");
                    System.out.println("  ");
                    System.out.println("**************************");
                    System.out.println("Menu de CRUD sobre Parque de Atracciones");
                    System.out.println("**************************");
                    System.out.println("1.Ver Parques disponibles.");
                    System.out.println("2.Crear una Parque.");
                    System.out.println("3.Borrar un Parque.");
                    System.out.println("4.Modificar un Parque.");
                    System.out.println("  ");
                    opcion=teclado.nextInt();
                    
                    if(opcion==1){
                        getAllParques();
                    }else if(opcion==2){
                        
                        System.out.println("Escribe el nombre de nuevo Parque.");
                        nombre=teclado.next();
                        System.out.println("Escribe el presupuesto.");
                        capital=teclado.nextInt();
                        System.out.println("¿En que ciudad está el Parque?");
                        ciudadParque=teclado.nextLine();
                        System.out.println("¿A que cadena pertenece?");
                        getAllCadenas();
                        idCadena=teclado.nextInt();
                        crearParquedeAtracciones(nombre,ciudadParque, capital, idCadena);
                        
                    }else if(opcion==3){
                        
                        System.out.println("Escribe el parque que quieras borrar:");
                        getAllParques();
                        id=teclado.nextInt();
                        deleteParqueAtracciones(id);
                        
                    }else if(opcion==4){
                        
                        System.out.println("Escribe el id del parque que quieres modificar:");
                        getAllParques();
                        id=teclado.nextInt();
                        System.out.println("Escribe el nombre de nuevo Parque.");
                        nombre=teclado.next();
                        System.out.println("Escribe el presupuesto.");
                        capital=teclado.nextInt();
                        System.out.println("¿En que ciudad está el Parque?");
                        ciudadParque=teclado.nextLine();
                        System.out.println("¿A que cadena pertenece?");
                        getAllCadenas();
                        idCadena=teclado.nextInt();
                        actualizarParqueAtraccion(id, nombre, ciudadParque, capital, idCadena);
                        
                    }
                    break;
                case 3:
                    System.out.println("  ");
                    System.out.println("  ");
                    System.out.println("**************************");
                    System.out.println("Menu de CRUD sobre Atracciones");
                    System.out.println("**************************");
                    System.out.println("1.Ver Atracciones disponibles.");
                    System.out.println("2.Crear una Atracción.");
                    System.out.println("3.Borrar una Atracción.");
                    System.out.println("4.Modificar una Atracción.");
                    System.out.println("  ");
                    opcion=teclado.nextInt();
                    
                     
                    if(opcion==1){
                        getAllAtracciones();
                    }else if(opcion==2){
                        
                        System.out.println("Escribe el nombre de la nueva Atracción.");
                        nombre=teclado.next();
                        System.out.println("¿Edad minima para montarse?.");
                        capital=teclado.nextInt();
                        System.out.println("¿En que parque está la atracción?");
                        getAllParques();
                        idCadena=teclado.nextInt();
                        crearAtraccion(nombre, capital,idCadena);
                        
                    }else if(opcion==3){
                        
                        System.out.println("Escribe la atracción que quieras borrar:");
                        getAllAtracciones();
                        id=teclado.nextInt();
                        deleteAtraccion(id);
                        
                    }else if(opcion==4){
                        
                        System.out.println("Escribe el id de la atracción que quieres modificar:");
                        getAllAtracciones();
                        id=teclado.nextInt();
                        System.out.println("Escribe el nombre de la nueva Atracción.");
                        nombre=teclado.next();
                        System.out.println("¿Edad minima para montarse?.");
                        capital=teclado.nextInt();
                        System.out.println("¿En que parque está la atracción?");
                        getAllParques();
                        idCadena=teclado.nextInt();
                       
                        actualizarAtraccion(id,nombre, capital,idCadena);
                        
                    }
                    break;
                case 4:
                    System.out.println("  ");
                    System.out.println("  ");
                    System.out.println("**************************");
                    System.out.println("Menu de CRUD sobre Empleados");
                    System.out.println("**************************");
                    System.out.println("1.Ver Empleados disponibles.");
                    System.out.println("2.Crear un/a Empleado.");
                    System.out.println("3.Borrar un/a Empleado.");
                    System.out.println("4.Modificar un/a Empleado.");
                    System.out.println("  ");
                    opcion=teclado.nextInt();
                    
                    if(opcion==1){
                        getAllTrabajadores();
                    }else if(opcion==2){
                        
                        System.out.println("Escribe el nombre del nuevo Empleado.");
                        nombre=teclado.next();
                       
                        System.out.println("Sus Apellidos.");
                        apellido=teclado.next();
                        System.out.println("Su puesto a desarrollar.");
                        puesto=teclado.next();
                        System.out.println("¿En que atracción trabajará?");
                        getAllAtracciones();
                        idCadena=teclado.nextInt();
                        System.out.println("¿Cuanto ganará?");
                        sueldo=teclado.nextInt();
                        crearTrabajador(nombre, apellido, puesto,idCadena,sueldo);
                        
                    }else if(opcion==3){
                        
                        System.out.println("Escribe el Empleado que quieres despedir:");
                        getAllTrabajadores();
                        id=teclado.nextInt();
                        deleteTrabajador(id);
                        
                    }else if(opcion==4){
                        
                        System.out.println("Escribe el id del Empleado que quieras modificar:");
                        getAllTrabajadores();
                        id=teclado.nextInt();
                        
                         System.out.println("Escribe su nombre.");
                        nombre=teclado.next();
                        System.out.println("Sus Apellidos.");
                        apellido=teclado.next();
                        System.out.println("Su puesto a desarrollar.");
                        puesto=teclado.next();
                        System.out.println("¿En que atracción trabajará?");
                        getAllAtracciones();
                        idCadena=teclado.nextInt();
                        System.out.println("¿Cuanto ganará?");
                        sueldo=teclado.nextInt();
                       
                        actualizarTrabajador(id, nombre, apellido, puesto, idCadena, sueldo);
                       
                        
                    }
                    
                    break;
                    
                    
                    
            }
            menu2Opciones();
            opcion=teclado.nextInt();
            
            
            
        }
    }
    
}
