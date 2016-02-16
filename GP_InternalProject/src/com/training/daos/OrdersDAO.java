package com.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.entity.Orders;
import com.training.interfaces.DAO;
import com.training.utils.SqlConnection;

public class OrdersDAO implements DAO<Orders> {

	private Connection con;
	private String tableName1, tableName2;

	public OrdersDAO(String tableName1, String tableName2) {
		super();
		con = SqlConnection.getOracleConnection();
		this.tableName1 = tableName1;
		this.tableName2 = tableName2;
	}

	public OrdersDAO(Connection con, String tableName1, String tableName2) {
		super();
		this.con = con;
		this.tableName1 = tableName1;
		this.tableName2 = tableName2;
	}

	private Orders getOrders(ResultSet rs) {

		Orders order = null;
		try {

			order = new Orders(rs.getInt("orderId"), rs.getInt("waiterId"), rs.getInt("numberofcustomers"),
					rs.getInt("tablenumber"), Boolean.getBoolean(rs.getString("isready")), rs.getString("commets"));

			String sql2 = "select * from " + tableName2 + " where orderId = ?";

			PreparedStatement pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, rs.getInt("orderId"));
			ResultSet rs2 = pstmt.executeQuery();
			Hashtable<Integer, Integer> collectionOfDishes = new Hashtable<>();

			while (rs2.next()) {

				collectionOfDishes.put(rs2.getInt("ITEMID"), rs2.getInt("QUANTITY"));
			}
			order.setCollectionOfDishes(collectionOfDishes);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return order;
	}

	@Override
	public int add(Orders t) {
		String sql1 = "insert into " + tableName1 + " values(?,?,?,?,?,?)";
		String sql2 = "insert into " + tableName2 + " values(?,?,?)";
		Set<Map.Entry<Integer, Integer>> orderList = t.getCollectionOfDishes().entrySet();
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, t.getOrderId());
			pstmt.setInt(2, t.getWaiterId());
			pstmt.setInt(3, t.getNumberOfCustomers());
			pstmt.setInt(4, t.getTableNumber());
			pstmt.setString(5, Boolean.toString(t.isReady()));
			pstmt.setString(6, t.getComments());
			pstmt.executeUpdate();

			for (Map.Entry<Integer, Integer> dish : orderList) {

				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, t.getOrderId());
				pstmt2.setInt(2, dish.getKey());
				pstmt2.setInt(3, dish.getValue());
				rowAdded += pstmt2.executeUpdate();
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

		// String sql = "select * from " + tableName1 + " join " + tableName2 +
		// " on " + tableName1 + ".orderId = "
		// + tableName2 + ".orderId where " + tableName1 + ".orderId = ?";

		String sql1 = "select * from " + tableName1 + " where orderId = ?";
		Orders resultOrder = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				resultOrder = getOrders(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return resultOrder;
	}

	@Override
	public List<Orders> findAll() {
		String sql = "select * from " + tableName1;
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				orderList.add(getOrders(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return orderList;
	}

	@Override
	public int update(int key, String newStatus) {
		Statement s;
		int rowUpdated = 0;

		try {
			s = (Statement) con.createStatement();
			rowUpdated = s.executeUpdate(
					"update " + tableName1 + " set " + "isReady='" + newStatus + "' where orderId='" + key + "'");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return rowUpdated;
	}

	@Override
	public int delete(int key) {
		String sql1 = "delete from " + tableName1 + " where orderId = " + key;
		String sql2 = "delete from " + tableName2 + " where orderId = " + key;
		int rowDeleted = 0;

		try {

			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql1);
			rowDeleted = stmt.executeUpdate(sql2);
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowDeleted;

	}

	@Override
	public int deleteAll() {
		String sql1 = "delete from " + tableName1;
		String sql2 = "delete from " + tableName2;
		int rowDeleted = 0;

		try {

			Statement stmt = con.createStatement();
			rowDeleted = stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql1);

		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowDeleted;
	}

}
