package com.sync.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public final class JdbcUtilsSing {

  private static String url = "jdbc:mysql://localhost:3306/jdbc";
  private static String user = "root";
  private static String password = "root";

  //private static JdbcUtilsSing instance = new JdbcUtilsSing();

  private static JdbcUtilsSing instance = null;

  private JdbcUtilsSing() {
    // no instance
  }

  public static JdbcUtilsSing getInstance() {
    if (instance == null) {
      synchronized (JdbcUtilsSing.class) {
        if (instance == null) {
          instance = new JdbcUtilsSing();
        }
      }
    }
    return instance;
  }

  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  public void free(ResultSet rs, Statement st, Connection conn) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (st != null) {
          st.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        if (conn != null) {
          try {
            conn.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
