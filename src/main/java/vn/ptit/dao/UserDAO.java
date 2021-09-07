package vn.ptit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.ptit.model.User;

public class UserDAO extends DAO{
	
	public UserDAO() {
		super();
	}
	
	public User getUser(String username, String password) {
		User user = null;
		String sql = "SELECT * FROM tbl_user WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("country"), rs.getString("gender"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		String sql = "SELECT * FROM tbl_user WHERE tbl_user.email = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("country"), rs.getString("gender"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public List<User> getAllUser() {
		User user = null;
		String sql = "SELECT * FROM tbl_user";
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("country"), rs.getString("gender"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public void insertUser(User user) {
		String sql = "INSERT INTO tbl_user (email,country,gender,username,password) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getCountry());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
