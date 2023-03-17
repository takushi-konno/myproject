package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL =
      "jdbc:mysql://localhost/sukkiri_202208";
  private final String DB_USER = "root";
  private final String DB_PASS = "1234";

  public List<Mutter> findAll() {
    List<Mutter> mutterList = new ArrayList<Mutter>();

    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備
      String sql =
    		  "SELECT mutter_id, user_id, text FROM mutter2 ORDER BY mutter_id DESC";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        int id = rs.getInt("mutter_id");
        String userName = rs.getString("user_id");
        String text = rs.getString("TEXT");
        Mutter mutter = new Mutter(id, userName, text);
        mutterList.add(mutter);
      }
    } catch (SQLException e) {
    	
      e.printStackTrace();
      return null;
    }
    return mutterList;
  }
  public boolean create(Mutter mutter) {
    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // INSERT文の準備(idは自動連番なので指定しなくてよい）
      String sql = "INSERT INTO MUTTER2(USER_ID,text) VALUES(?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      // INSERT文中の「?」に使用する値を設定しSQLを完成
      pStmt.setString(1, mutter.getUserId());
      pStmt.setString(2, mutter.getText());

      // INSERT文を実行
      int result = pStmt.executeUpdate();

      if (result != 1) {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}