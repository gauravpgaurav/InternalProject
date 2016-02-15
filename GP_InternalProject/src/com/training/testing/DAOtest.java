package com.training.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.training.daos.EmployeeDAO;
import com.training.entity.Employee;

public class DAOtest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		Employee emp1 = new Employee(102, "Suresh", "Chef", "stop");
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		int actual = empDAO.add(emp1);
		System.out.println(actual);
		assertEquals(1, actual, 0);
	}

}
