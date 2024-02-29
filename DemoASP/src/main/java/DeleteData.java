import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();  //DB RUD operations.
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter id to delete: ");
		int id= sc.nextInt();
		Student_data student = session.get(Student_data.class, id);
		session.delete(student);
		transaction.commit();
		session.close();
		System.out.println("Data Deleted Sucessfully");
	}
}
