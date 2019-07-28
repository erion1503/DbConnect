/**
 *
 */
package net.erion1107.main;

import net.erion1107.logic.DbConnectLogic;

/**
 * DB接続プロトタイプ
 * @author ERION1107
 *
 */
public class DbConnectMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DbConnectLogic logic = new DbConnectLogic();

		logic.execute();

	}

}
