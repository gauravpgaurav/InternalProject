package com.training.testing;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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

	@Test
	public void testWaiter() {

		Waiter w1 = new Waiter(303, "Walter", "Waiter", "patience");

		if (w1.isAvailable(201, 1) && (w1.isAvailable(202, 2)))
			w1.confirmOrder(901, 3, 1, "Less Spicy");

		else
			System.out.println("Not Available");

		if (w1.isAvailable(203, 3))
			w1.confirmOrder(902, 2, 3, null);
		else
			System.out.println("Not Available");

		Hashtable<Integer, Orders> waiterData = w1.getTableOrderMap();

		Set<Map.Entry<Integer, Orders>> list = waiterData.entrySet();
		System.out.println("All Orders");
		for (Map.Entry<Integer, Orders> words : list) {
			System.out.println("Table " + words.getKey() + "\t:=\t" + words.getValue());
		}
	}

	
}
