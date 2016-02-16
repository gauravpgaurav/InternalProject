package com.training.testing;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.training.daos.EmployeeDAO;
import com.training.entity.Chef;
import com.training.entity.Dish;
import com.training.entity.Orders;
import com.training.entity.Waiter;

public class OrderingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void testDish() {

		Dish dishIns = new Dish(202, "Naan", true, 20, 25);
		System.out.println(dishIns);
		assertNotNull(dishIns);
	}

	@Ignore
	@Test
	public void testWaiter() {

		Waiter waiter1 = new Waiter(303, "Walter", "Waiter", "patience");
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		empDAO.add(waiter1);
		
		if (waiter1.isDishAvailable(201, 1) && (waiter1.isDishAvailable(202, 2)))
			waiter1.confirmOrder(901, 3, 1, "Less Spicy");

		else
			System.out.println("Not Available");

		if (waiter1.isDishAvailable(203, 3))
			waiter1.confirmOrder(902, 2, 3, null);
		else
			System.out.println("Not Available");

		Hashtable<Integer, Orders> waiterData = waiter1.getTableOrderMap();

		Set<Map.Entry<Integer, Orders>> list = waiterData.entrySet();
		System.out.println("All Orders");
		for (Map.Entry<Integer, Orders> words : list) {
			System.out.println("Table " + words.getKey() + "\t:=\t" + words.getValue());
		}
	}

	
	@Test
	public void testChief() {
		Chef chef1 = new Chef(301, "Hector", "Chef", "salt");
		EmployeeDAO empDAO = new EmployeeDAO("Employee");
		empDAO.add(chef1);
		chef1.updateStatusToReady(902);
	}

}
