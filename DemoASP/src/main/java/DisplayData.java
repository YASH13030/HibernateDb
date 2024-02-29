import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DisplayData {
	
 public static void main(String[] args) {
	 Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();  //model class object
		
		//display data can be done only with help of a data structure.
		
		Query query = session.createQuery("FROM Student_data");
		List<Student_data> list = query.list();
		for(Student_data student: list) {
			System.out.println(student.getS_id()+"  "+student.getName());
		}
  }
}
