package com.training.testing;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;

import com.training.daos.EmployeeDAO;
import com.training.entity.Employee;
import com.training.utils.ValidateEmployee;

public class DAOtest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testAdd() {
		Employee emp1 = new Employee(102, "Suresh", "Chef", "stop");
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		int actual = empDAO.add(emp1);
		System.out.println(actual);
		assertEquals(1, actual, 0);
	}

	@Test
	public void testValidity() {

		Employee emp1 = new Employee(101, "Ramesh", "Waiter", "stop");
		ValidateEmployee valIns = new ValidateEmployee();
		boolean actual = valIns.validate(emp1);
		assertEquals(true, actual);
	}

	@Test
	public void testFind() {

		Employee expected = new Employee(101, "Ramesh", "Waiter", "stop");
		// ValidateUser valIns = new ValidateUser();
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		Employee actual = empDAO.find(101);
		assertEquals(expected, actual);
	}

	@Ignore
	public void testFindAll() {

		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		ArrayList<Employee> empList = (ArrayList<Employee>) empDAO.findAll();
		for (Employee e : empList) {
			System.out.println(e);
		}
		assertNotNull(empList);
	}

	@Test
	public void testUpdatePassword() {

		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		int actual = empDAO.update(102, "break");
		assertEquals(1, actual);
	}
}
