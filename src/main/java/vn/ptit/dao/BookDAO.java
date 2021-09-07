package vn.ptit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.ptit.model.User;
import vn.ptit.model.book.Book;
import vn.ptit.model.book.BookItem;

public class BookDAO extends DAO{
	
	public BookDAO() {
		super();
	}
	
	public List<BookItem> getAllBookItem() {
		String sql = "SELECT tbl_book.*, tbl_bookitem.* FROM tbl_book, tbl_bookitem WHERE tbl_book.id = tbl_bookitem.book_id";
		List<BookItem> listBookItem = new ArrayList<BookItem>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book(rs.getInt("tbl_book.id"), rs.getString("name"), rs.getString("author"), rs.getDate("datecreate"));
				BookItem bookItem = new BookItem(rs.getInt("tbl_bookitem.id"), book, rs.getDouble("price"), rs.getInt("quantity"));
				listBookItem.add(bookItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBookItem;
	}
	
	public BookItem getBookItemById(int id) {
		BookItem bookItem = null;
		String sql = "SELECT tbl_book.*, tbl_bookitem.* FROM tbl_book, tbl_bookitem WHERE tbl_bookitem.id = ? AND tbl_book.id = tbl_bookitem.book_id";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book(rs.getInt("tbl_book.id"), rs.getString("name"), rs.getString("author"), rs.getDate("datecreate"));
				bookItem = new BookItem(rs.getInt("tbl_bookitem.id"), book, rs.getDouble("price"), rs.getInt("quantity"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookItem;
	}
	
}
