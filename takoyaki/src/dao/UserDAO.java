package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	private final String JDBC_URL =
			"jdbc:mysql://localhost/sukkiri_202208";
	private final String DB_USER = "root";
	private final String DB_PASS = "1234";

	public User findByLogin(User user){
		User userId = null;

		// データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			// SELECT文の準備
			String sql = "SELECT USER_ID FROM USER WHERE USER_ID=? AND PASSWORD=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPass());

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の結果をuserIdに格納
			if(rs.next()) {
				String id = rs.getString("USER_ID");
				userId = new User(id,null);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userId;
	}

}
