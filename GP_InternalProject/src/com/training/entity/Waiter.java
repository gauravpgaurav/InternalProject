package com.training.entity;

import java.util.*;
import java.util.Map.Entry;

import com.training.daos.DishDAO;

public class Waiter extends Employee {

	private Hashtable<Integer, OrderItem> tableOrderMap;
	private Hashtable<Integer, Integer> tempCollectionOfDishes;

	public Waiter(int employeeId, String employeeName, String employeeRole, String employeePassword) {
		super(employeeId, employeeName, employeeRole, employeePassword);

		tableOrderMap = new Hashtable<>();
		tempCollectionOfDishes = new Hashtable<>();
	}

	public boolean addToOrder(int dishId, int quantity) {

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

		//try {
			DishDAO dishDAO = new DishDAO("dish");
			Iterator<Entry<Integer, Integer>> entries = tempCollectionOfDishes.entrySet().iterator();
			while (entries.hasNext()) {

				Entry<Integer, Integer> entry = entries.next();
				
				Dish dishIns = dishDAO.find(entry.getKey());
				int availability = dishIns.getAvailability();
				int quantity = entry.getValue();
				dishDAO.update(entry.getKey(), (availability - quantity));

			}/*
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
	}

	public void enterOrderDetails(int orderId, int numberOfCustomers, int tableNumber) {

		updateCount();
		OrderItem orderIns = new OrderItem(orderId, getEmployeeId(), numberOfCustomers, tableNumber, false,
				tempCollectionOfDishes);
		tableOrderMap.put(tableNumber, orderIns);
		tempCollectionOfDishes = new Hashtable<>();
	}

	public Hashtable<Integer, OrderItem> getTableOrderMap() {
		return tableOrderMap;
	}

	public void setTableOrderMap(Hashtable<Integer, OrderItem> tableOrderMap) {
		this.tableOrderMap = tableOrderMap;
	}

	public Hashtable<Integer, Integer> getTempCollectionOfDishes() {
		return tempCollectionOfDishes;
	}

	public void setTempCollectionOfDishes(Hashtable<Integer, Integer> tempCollectionOfDishes) {
		this.tempCollectionOfDishes = tempCollectionOfDishes;
	}

}
