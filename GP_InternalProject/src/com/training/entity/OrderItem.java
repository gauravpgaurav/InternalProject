package com.training.entity;

import java.util.*;

public class OrderItem {

	private int waiterId;
	private int numberOfCustomers;
	private int tableNumber;
	private Hashtable<Integer, Integer> collectionOfDishes;

	public OrderItem(int waiterId, int numberOfCustomers, int tableNumber,
			Hashtable<Integer, Integer> collectionOfDishes) {
		super();
		this.waiterId = waiterId;
		this.numberOfCustomers = numberOfCustomers;
		this.tableNumber = tableNumber;
		this.collectionOfDishes = collectionOfDishes;
	}

	public int getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Hashtable<Integer, Integer> getCollectionOfDishes() {
		return collectionOfDishes;
	}

	public void setCollectionOfDishes(Hashtable<Integer, Integer> collectionOfDishes) {
		this.collectionOfDishes = collectionOfDishes;
	}

	@Override
	public String toString() {
		return "OrderItem [waiterId=" + waiterId + ", numberOfCustomers=" + numberOfCustomers + ", tableNumber="
				+ tableNumber + ", collectionOfDishes=" + collectionOfDishes + "]";
	}

}
