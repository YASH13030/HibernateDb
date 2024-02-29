import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class InsertData {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();  //model class object
		Transaction transaction = session.beginTransaction();  //DB RUD operations.
		Student_data sd = new Student_data();
		System.out.println("enter id and name to insert:  ");
		Scanner sc =new Scanner(System.in);
		sd.setS_id(sc.nextInt());
		sd.setName(sc.next());
		session.save(sd);
		transaction.commit();
		session.close();
		System.out.println("data inserted succesfuly");
		}
}
