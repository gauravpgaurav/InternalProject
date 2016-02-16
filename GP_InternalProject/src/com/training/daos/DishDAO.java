package com.training.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Dish;
import com.training.interfaces.DAO;
import com.training.utils.SqlConnection;

public class DishDAO implements DAO<Dish> {

	private Connection con;
	private String tableName;

	public DishDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public DishDAO(String tableName) {
		super();
		con = SqlConnection.getOracleConnection();
		this.tableName = tableName;
	}

	public DishDAO(Connection con, String tableName) {
		super();
		this.con = con;
		this.tableName = tableName;
	}

	private Dish getDish(ResultSet rs) {

		Dish dish = null;
		try {

			dish = new Dish(rs.getInt("dishId"), rs.getString("dishName"), Boolean.getBoolean(rs.getString("isVeg")),
					rs.getInt("availability"), rs.getDouble("cost"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dish;
	}

	@Override
	public int add(Dish t) {
		String sql = "insert into " + tableName + " values(?,?,?,?,?)";
		int rowAdded = 0;

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getDishId());
			pstmt.setString(2, t.getDishName());
			pstmt.setString(3, Boolean.toString(t.isVeg()));
			pstmt.setInt(4, t.getAvailability());
			pstmt.setDouble(5, t.getCost());
			rowAdded = pstmt.executeUpdate();
		}

		catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return rowAdded;
	}

	@Override
	public Dish find(int key) {
		String sql = "select * from " + tableName + " where dishId =?";
		Dish resultDish = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				resultDish = getDish(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return resultDish;
	}

	@Override
	public List<Dish> findAll() {
		String sql = "select * from " + tableName;
		ArrayList<Dish> dishList = new ArrayList<Dish>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				dishList.add(getDish(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return dishList;
	}

	@Override
	public int update(int key, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(int key, int newAvailability) {
		Statement s;
		int rowUpdated = 0;

		try {
			s = (Statement) con.createStatement();
			rowUpdated = s.executeUpdate("update " + tableName + " set " + "availability='" + newAvailability
					+ "' where dishId='" + key + "'");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		return rowUpdated;
	}

	@Override
	public int delete(int key) {
		String sql = "delete from " + tableName + " where dishId = " + key;
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

	@Override
	public int deleteAll() {
		String sql = "delete from " + tableName;
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
