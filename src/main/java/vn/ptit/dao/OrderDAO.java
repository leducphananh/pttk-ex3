package vn.ptit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vn.ptit.model.order.Order;
import vn.ptit.model.order.Cart;

public class OrderDAO extends DAO{
	
	public boolean insertOrder(Order order) {
		boolean isSuccess = true;
		String sqlOrder = "INSERT INTO tbl_order (user_id, payment_id) VALUES (?,?)";
		String sqlPayment = "INSERT INTO tbl_payment (paymentType, shipment_id) VALUES (?,?)";
		String sqlCart = "INSERT INTO tbl_cart (quantity, payment_id, bookitem_id) VALUES (?,?,?)";
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement ps = connection.prepareStatement(sqlPayment, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, order.getPayment().getPaymentType());
			ps.setInt(2, order.getPayment().getShipment().getId());
			ps.executeUpdate();
			ResultSet keys = ps.getGeneratedKeys();
			if(keys.next()) {
				for (Cart cart : order.getPayment().getCarts()) {
					ps = connection.prepareStatement(sqlCart, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, cart.getQuantity());
					ps.setInt(2, keys.getInt(1));
					ps.setInt(3, cart.getBookItem().getId());
					ps.executeUpdate();
				}
				
				ps = connection.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, order.getUser().getId());
				ps.setInt(2, keys.getInt(1));
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			isSuccess=false;
			try {
				connection.rollback();
				isSuccess=false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				isSuccess=false;
				e.printStackTrace();
			}
		}
		return isSuccess;
	}
	
}
