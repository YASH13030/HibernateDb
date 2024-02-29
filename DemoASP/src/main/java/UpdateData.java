import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
		
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();  //DB RUD operations.
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter id to Update: ");
		int id= sc.nextInt();
		Student_data student = session.get(Student_data.class, id);
		System.out.println("Enter Name: ");
		student.setName(sc.next());
		session.save(student);
		transaction.commit();
		session.close();
		System.out.println("Data Updated Sucessfully");
	}
}
