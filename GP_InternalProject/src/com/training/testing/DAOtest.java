package com.training.testing;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.*;

import com.training.daos.DishDAO;
import com.training.daos.EmployeeDAO;
import com.training.daos.OrdersDAO;
import com.training.entity.Dish;
import com.training.entity.Employee;
import com.training.utils.ValidateEmployee;

public class DAOtest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testUpdateDishAvailability() {

		DishDAO dishDAO = new DishDAO("Dish");
		dishDAO.update(201, 50);
		dishDAO.update(202, 50);
		dishDAO.update(203, 50);
	}

	
	@Test
	public void refreshDB() {
		OrdersDAO orderDAO = new OrdersDAO("orders", "orderitems");
		orderDAO.deleteAll();
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		empDAO.deleteAll();
	}
	
	
	
	@Ignore
	@Test
	public void testAdd() {
		Employee emp1 = new Employee(102, "Suresh", "Chef", "stop");
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		int actual = empDAO.add(emp1);
		System.out.println(actual);
		assertEquals(1, actual, 0);
	}

	@Ignore
	@Test
	public void testValidity() {

		Employee emp1 = new Employee(101, "Ramesh", "Waiter", "stop");
		ValidateEmployee valIns = new ValidateEmployee();
		boolean actual = valIns.validate(emp1);
		assertEquals(true, actual);
	}

	@Ignore
	@Test
	public void testFind() {

		Employee expected = new Employee(101, "Ramesh", "Waiter", "stop");
		// ValidateUser valIns = new ValidateUser();
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		Employee actual = empDAO.find(101);
		assertEquals(expected, actual);
	}

	@Ignore
	@Test
	public void testFindDish() {

		Dish expected = new Dish(203, "Chicken", false, 15, 350);
		DishDAO dishDAO = new DishDAO("Dish");
		Dish actual = dishDAO.find(203);
		assertEquals(expected, actual);
	}


	@Ignore
	@Test
	public void testFindAll() {

		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		ArrayList<Employee> empList = (ArrayList<Employee>) empDAO.findAll();
		for (Employee e : empList) {
			System.out.println(e);
		}
		assertNotNull(empList);
	}

	@Ignore
	@Test
	public void testUpdatePassword() {

		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		int actual = empDAO.update(102, "break");
		assertEquals(1, actual);
	}

	@Ignore
	@Test
	public void testFindOrders() {

		OrdersDAO ordDAO = new OrdersDAO("Orders", "Orderitems");
		//ArrayList<Orders> orderList = (ArrayList<Orders>) ordDAO.findAll();
		ArrayList<Integer> orderIdList = (ArrayList<Integer>) ordDAO.findAllPendingOrders();
		System.out.println("Pending Order Numbers : ");
		for (Iterator<Integer> iterator = orderIdList.iterator(); iterator.hasNext();) {
			Integer orderID = (Integer) iterator.next();
			System.out.println(orderID);
		}

	}
}
