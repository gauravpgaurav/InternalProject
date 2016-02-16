package com.training.entity;

import java.util.*;

public class Orders {

	private int orderId;
	private int waiterId;
	private int numberOfCustomers;
	private int tableNumber;
	private boolean isReady;
	private Hashtable<Integer, Integer> collectionOfDishes;
	private String comments;

	public Orders(int orderId, int waiterId, int numberOfCustomers, int tableNumber, boolean isReady,
			Hashtable<Integer, Integer> collectionOfDishes, String comments) {
		super();
		this.orderId = orderId;
		this.isReady = isReady;
		this.waiterId = waiterId;
		this.numberOfCustomers = numberOfCustomers;
		this.tableNumber = tableNumber;
		this.collectionOfDishes = collectionOfDishes;
		this.comments = comments;

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", waiterId=" + waiterId + ", numberOfCustomers=" + numberOfCustomers
				+ ", tableNumber=" + tableNumber + ", isReady=" + isReady + ", collectionOfDishes=" + collectionOfDishes
				+ ", comments=" + comments + "]";
	}

}
