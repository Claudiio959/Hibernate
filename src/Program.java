import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Program {

	public static void main(String[] args) {
			
		Session session = HibernateUtilities.getSessionFactory().openSession();	
		session.beginTransaction();
		
		 Empresa e = new Empresa();
		 Item i = new Item();
		 Pedido p = new Pedido();
		 java.util.Date utilDate = new java.util.Date();
		 
		 i.setCantidad(12);
		 i.setId(1);
		 i.setNombre("uvue");
		 session.save(i);
		 
		 
		 p.setFecha(new java.sql.Date(utilDate.getTime()));
		 p.setId(1);
		 session.save(p);
		 
		 
		 e.setNombre("Claudi");
		 e.setCif("12");
		 e.setDireccion("Calle Claudio");
		 e.setEmpleados(200);
		 session.save(e);
		 
		session.getTransaction().commit();
		
		session.beginTransaction();
		Empresa eu = session.get(Empresa.class,"12");
		System.out.println("Hemos recuperado: "+eu.getNombre()+" "+eu.getCif());
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFactory().close();

	}

}
