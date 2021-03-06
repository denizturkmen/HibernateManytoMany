package com.denizturkmen.Entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="Employee_Table")
@DynamicUpdate
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee_id")
	private Integer employeeId;
	
	@Column(name = "Employee_name",length = 100,nullable = false)
	private String EmployeeName;
	
	@Column(name = "Email",unique = false)
	private String Email;
	
	@Column(name = "Date_of_Joining")
	private Date doj;
	
	@Column(name="Salary")
	private Double Salary;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER) // lazy olursa employee ait bilgileri gistermez
	@JoinTable(name = "Employee_Adress_Table",joinColumns = @JoinColumn(name="Employee_id"),inverseJoinColumns = @JoinColumn(name="adress_id"))
	private List<Adress> addressList = new ArrayList<>();

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public List<Adress> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Adress> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", EmployeeName=" + EmployeeName + ", Email=" + Email + ", doj="
				+ doj + ", Salary=" + Salary + "]";
	}
	
	
	
	
	
}
