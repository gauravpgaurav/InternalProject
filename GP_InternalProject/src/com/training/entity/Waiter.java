package com.training.entity;

import java.util.*;

public class Waiter extends Employee {

	private Hashtable<Integer, OrderItem> tableOrderMap;
	private Hashtable<Integer, Integer> tempCollectionOfDishes;

	public Waiter(int employeeId, String employeeName, String employeeRole, String employeePassword) {
		super(employeeId, employeeName, employeeRole, employeePassword);

		tableOrderMap = new Hashtable<>();
		tempCollectionOfDishes = new Hashtable<>();
	}

	public void buildOrder(Dish dishIns, int quantity) {
		tempCollectionOfDishes.put(dishIns.getDishId(), quantity);

	}

	public void enterOrderDetails(int numberOfCustomers, int tableNumber) {

		OrderItem orderIns = new OrderItem(getEmployeeId(), numberOfCustomers, tableNumber, tempCollectionOfDishes);
		tableOrderMap.put(tableNumber, orderIns);
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
