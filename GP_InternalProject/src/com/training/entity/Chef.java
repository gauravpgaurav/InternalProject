package com.training.entity;

import com.training.daos.OrdersDAO;

public class Chef extends Employee {

	public Chef(int employeeId, String employeeName, String employeeRole, String employeePassword) {
		super(employeeId, employeeName, employeeRole, employeePassword);
		
	}

	public void updateStatusToReady(int orderId) {
		OrdersDAO ordersDAO = new OrdersDAO("orders","orderitems");
		ordersDAO.update(orderId, Boolean.toString(true));
	}
}
