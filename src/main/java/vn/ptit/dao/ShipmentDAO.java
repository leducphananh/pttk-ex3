package vn.ptit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.ptit.model.order.Shipment;

public class ShipmentDAO extends DAO{
	
	public ShipmentDAO() {
		super();
	}
	
	public List<Shipment> getAllShipment(){
		List<Shipment> list = new ArrayList<Shipment>();
		String sql = "SELECT * FROM tbl_shipment";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Shipment shipment = new Shipment(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
				list.add(shipment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Shipment findById(int id) {
		Shipment shipment = null;
		String sql = "SELECT * FROM tbl_shipment WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				shipment = new Shipment(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return shipment;
	}
	
}
