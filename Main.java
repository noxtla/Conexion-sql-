package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

	private static String URL ="jdbc:mysql://localhost/db?use unicode=true&usejdbccomplianttimezoneshift=true&uselegacydatetimecode=false server timezone=utc";
	private static String user ="root";
	private static String pass ="root";
	
	

			//Boton conectar
	 private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {                                              
	       Connection conexion = getConnection();
	        }
	       

	 	///Funcion para conectar
	public Connection getConnection () {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.driver");
			conn = DriverManager.getConnection(URL,user,pass);
			///Mesanje de exito;

		} catch (Exception e) {
			///Mensaje de error
			
		}
		return conn;
	}
}

