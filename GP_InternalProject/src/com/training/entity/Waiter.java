package com.training.entity;

import java.util.*;

import com.training.daos.DishDAO;
import com.training.daos.OrdersDAO;

public class Waiter extends Employee {

	private Hashtable<Integer, Orders> tableOrderMap;
	private Hashtable<Integer, Integer> tempCollectionOfDishes;

	public Waiter(int employeeId, String employeeName, String employeeRole, String employeePassword) {
		super(employeeId, employeeName, employeeRole, employeePassword);

		tableOrderMap = new Hashtable<>();
		tempCollectionOfDishes = new Hashtable<>();
	}

	public Hashtable<Integer, Orders> getTableOrderMap() {
		return tableOrderMap;
	}

	public void setTableOrderMap(Hashtable<Integer, Orders> tableOrderMap) {
		this.tableOrderMap = tableOrderMap;
	}

	public Hashtable<Integer, Integer> getTempCollectionOfDishes() {
		return tempCollectionOfDishes;
	}

	public void setTempCollectionOfDishes(Hashtable<Integer, Integer> tempCollectionOfDishes) {
		this.tempCollectionOfDishes = tempCollectionOfDishes;
	}

	public boolean isDishAvailable(int dishId, int quantity) {

		DishDAO dishDAO = new DishDAO("dish");
		Dish dishIns = dishDAO.find(dishId);
		int availability = dishIns.getAvailability();
		if (availability >= quantity) {
			tempCollectionOfDishes.put(dishId, quantity);
			return true;

		} else
			return false;

	}

	private void updateCount() {

		DishDAO dishDAO = new DishDAO("dish");
		Set<Map.Entry<Integer, Integer>> orderList = tempCollectionOfDishes.entrySet();
		for (Map.Entry<Integer, Integer> dish : orderList) {
			Dish dishIns = dishDAO.find(dish.getKey());
			int availability = dishIns.getAvailability();
			int quantity = dish.getValue();
			dishDAO.update(dish.getKey(), (availability - quantity));
		}

	}

	public void confirmOrder(int orderId, int numberOfCustomers, int tableNumber, String comments) {

		updateCount();
		Orders orderIns = new Orders(orderId, getEmployeeId(), numberOfCustomers, tableNumber, false,
				tempCollectionOfDishes, comments);
		OrdersDAO ordersDAO = new OrdersDAO("orders", "orderitems");

		ordersDAO.add(orderIns);

		tableOrderMap.put(tableNumber, orderIns);
		tempCollectionOfDishes = new Hashtable<>();

	}

	public void displayBill(int orderId) {
		OrdersDAO ordersDAO = new OrdersDAO("orders", "orderitems");
		System.out.println("\nBill Amount : Rs." + ordersDAO.getBillAmount(orderId));
	}
}
