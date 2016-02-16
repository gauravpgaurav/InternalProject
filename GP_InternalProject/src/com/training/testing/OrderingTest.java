package com.training.testing;

import static org.junit.Assert.*;

import java.util.*;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.training.entity.Dish;
import com.training.entity.OrderItem;
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

		// Dish dishIns1 = new Dish(201, "Roti", true, 45, 10);
		// Dish dishIns2 = new Dish(202, "Naan", true, 20, 25);
		// Dish dishIns3 = new Dish(203, "Chicken", false, 15, 350);

		Waiter w1 = new Waiter(303, "Walter", "Waiter", "patience");

		if (w1.addToOrder(201, 1) && (w1.addToOrder(202, 2)))
			w1.enterOrderDetails(901, 3, 1);

		else
			System.out.println("Not Available");

		if (w1.addToOrder(203, 3))
			w1.enterOrderDetails(902, 2, 3);
		else
			System.out.println("Not Available");

		Hashtable<Integer, OrderItem> waiterData = w1.getTableOrderMap();
		Iterator<Entry<Integer, OrderItem>> entries = waiterData.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<Integer, OrderItem> entry = entries.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

}
