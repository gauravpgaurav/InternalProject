package com.training.entity;

public class Dish {

	private int dishId;
	private String dishName;
	private boolean isVeg;
	private int availability;
	private double cost;

	public Dish(int dishId, String dishName, boolean isVeg, int availability, double cost) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.isVeg = isVeg;
		this.availability = availability;
		this.cost = cost;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", isVeg=" + isVeg + ", availability="
				+ availability + ", cost=" + cost + "]";
	}

}
