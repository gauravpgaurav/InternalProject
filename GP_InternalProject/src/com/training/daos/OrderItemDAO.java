package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.entity.Orders;
import com.training.interfaces.DAO;
import com.training.utils.SqlConnection;

public class OrderItemDAO implements DAO<Orders> {

	private Connection con;
	private String tableName;

	public OrderItemDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public OrderItemDAO(String tableName) {
		super();
		con = SqlConnection.getOracleConnection();
		this.tableName = tableName;
	}

	public OrderItemDAO(Connection con, String tableName) {
		super();
		this.con = con;
		this.tableName = tableName;
	}

	@Override
	public int add(Orders t) {

		String sql = "insert into " + tableName + " values(?,?,?)";
		int rowAdded = 0;

		try {

			Set<Map.Entry<Integer, Integer>> orderList = t.getCollectionOfDishes().entrySet();
			for (Map.Entry<Integer, Integer> dish : orderList) {

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, t.getOrderId());
				pstmt.setInt(2, dish.getKey());
				pstmt.setInt(3, dish.getValue());
				rowAdded += pstmt.executeUpdate();
			}

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		System.out.println("Rows Added : " + rowAdded);
		return rowAdded;
	}

	@Override
	public Orders find(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int key, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int key) {
		String sql = "delete from " + tableName + " where orderId = " + key;
		int rowDeleted = 0;

		try {

			Statement stmt = con.createStatement();
			rowDeleted = stmt.executeUpdate(sql);
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowDeleted;
	}

}
