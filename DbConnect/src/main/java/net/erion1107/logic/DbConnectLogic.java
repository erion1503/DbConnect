/**
 *
 */
package net.erion1107.logic;

import net.erion1107.util.DbConnect;

/**
 * @author ERION1107
 *
 */
public class DbConnectLogic {

	/**
	 *
	 */
	public void execute() {
		DbConnect connect = new DbConnect();
		connect.connect();
	}
}
