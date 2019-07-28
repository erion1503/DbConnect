/**
 *
 */
package net.erion1107.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ERION1107
 *
 */
public class DbConnect {

	public void connect() {
//		String uri = "jdbc:derby:memory:sample;create=true";
//		String uri = "jdbc:mysql://192.168.0.180/db_ut?" + "user=ut&password=password";
		String url = "jdbc:mysql://192.168.0.180/db_ut";
		String user = "ut";
		String password = "password";

		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();

			st.executeUpdate("create table sample(id integer primary key)");


            Long start = System.currentTimeMillis();
            Long delta = start;

			for (int i = 0; i < 10000; i++) {
	            st.executeUpdate("insert into sample values(" + i + ")");

	            // スプリットの計算
	            if (i % 1000 == 0) {
	                Long now = System.currentTimeMillis();
	                Long split = now - delta;
	                System.out.println("" + i + ": " + split + "ms.");
	                delta = now;
	            }
	        }
	        Long end = System.currentTimeMillis();
	        System.out.println("所要時間: " + (end - start) + "ms.");

		} catch (Exception e) {
			System.out.println(String.format("[%s]", e.toString()));
		} finally {
			if(conn != null) {
		        try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
