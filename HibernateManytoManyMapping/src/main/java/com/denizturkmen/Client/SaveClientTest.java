package com.denizturkmen.Client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Adress;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class SaveClientTest {

	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
	    	
	    	Employee employee1= new Employee();
			employee1.setEmployeeName("Deniz Türkmen");
			employee1.setEmail("turkmen@gmail.com");
			employee1.setSalary(50000.00);
			employee1.setDoj(new Date());
			
			Employee employee2= new Employee();
			employee2.setEmployeeName("Eren Türkmen");
			employee2.setEmail("eren@gmail.com");
			employee2.setSalary(70000.00);
			employee2.setDoj(new Date());
			
			Adress address1 = new Adress();
			address1.setCity("Ankara");
			address1.setPin_code(4324L);
			address1.setState("Ümitköy");
			address1.setStreet("Park Caddesi");
			
			Adress address2 = new Adress();
			address2.setCity("Istanbul");
			address2.setPin_code(54353L);
			address2.setState("Kadıköy");
			address2.setStreet("kadıköy caddesi");
			
			Adress address3 = new Adress();
			address3.setCity("Antalya");
			address3.setPin_code(9054327L);
			address3.setState("KonyaAltı");
			address3.setStreet("Hurma");
			
			employee1.getAddressList().add(address1);
			employee1.getAddressList().add(address2);
			employee1.getAddressList().add(address3);
			
			address1.getEmplist().add(employee1);
			address2.getEmplist().add(employee1);
			address3.getEmplist().add(employee1);
			
			employee2.getAddressList().add(address2);
			employee2.getAddressList().add(address3);
			
			address2.getEmplist().add(employee2);
			address3.getEmplist().add(employee2);
			
			session.persist(employee1);
			session.persist(employee2);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
}
