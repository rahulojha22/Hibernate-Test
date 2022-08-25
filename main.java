package Test;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.*;

public class main {
	public static void main(String[] args) {
	
	StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata metadata=new MetadataSources(registry).getMetadataBuilder().build();
	SessionFactory factory=metadata.getSessionFactoryBuilder().build();
	Session session=factory.openSession();
	
	studentData s1=new studentData();
	s1.setName("rahul");
	s1.setcont("ab");
	s1.setMail("rahu@gmail.com");
	
	Transaction tx=session.beginTransaction();
	session.save(s1);
	tx.commit();
		
	session.close();
	factory.close();
	
	System.out.println("data inserted");
		
	}
}
