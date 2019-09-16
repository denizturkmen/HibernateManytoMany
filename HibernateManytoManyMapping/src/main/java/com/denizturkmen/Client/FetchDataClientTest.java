package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
		getEmployeeAndAdressByEmployeeId();
	}

	private static void getEmployeeAndAdressByEmployeeId() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Employee employee = session.get(Employee.class, 1);
			System.out.println(employee);
			if (employee != null) {
				employee.getAddressList().forEach(System.out::println);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
