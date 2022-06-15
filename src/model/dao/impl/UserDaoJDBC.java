package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import db.DB;
import db.DbException;
import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;
import model.dao.UserDao;
import model.entities.User;

public class UserDaoJDBC implements UserDao {

	private Connection conn;

	public UserDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(User obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"INSERT INTO user " 
					+ "(Name, Email, Cpf, BirthDate, Balance, Password) " 
					+ "VALUES "
					+ "(?, ?, ?, STR_TO_DATE(?, '%d/%m/%Y'), 1800.00, ?)", 
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setString(3, obj.getCpf());
			st.setString(4, obj.getBirthDate());
			st.setString(5, obj.getPassword());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
					throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
				throw new DbException(e.getMessage());
		} finally {
				DB.closeStatement(st);
		}
	}

	@Override
	public User getLogin(String email, String password) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM user "
					+ "WHERE "
					+ "Email = ? and Password = ?");
			
			st.setString(1, email);
			st.setString(2, password);			
			rs = st.executeQuery();
			
			if (rs.next()) {
				User obj = new User();
				obj.setEmail(rs.getString("Email"));
				obj.setPassword(rs.getString("Password"));
				Main.changeScreen("interface");
				return obj;
			} else {
					Alerts.showAlert("Incorrect login", null, "Data not found in the database.\nCheck your email and password and try again.", AlertType.ERROR);
			}
			return null;
		} catch (SQLException e) {
				throw new DbException(e.getMessage());
		}	finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
		}
	}

}
