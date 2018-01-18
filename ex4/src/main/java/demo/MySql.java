package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class MySql {
	public void pickSql(ArrayList<String> database,String _ip,String _user,String _password) throws Exception {

		//String _ip = "5.29.193.52";
		String _url = "jdbc:mysql://" + _ip + ":3306/oop_course_ariel?autoReconnect=true&useSSL=false";
		//String _user = "oop1";
		//String _password = "Lambda1();";
		Connection _con = null;

		java.sql.Statement st = null;
		ResultSet rs = null;
		int max_id = -1;
		
		
	//	 Frequncy ,Signal
		String strall = "unitedcsv file oop -project , appRelease=2.25 , release=6.0.1 \r\n" + 
				"Time, ID, Lat, Lon, Alt,, SSID1, MAC1, Frequncy ,Signal, SSID2, MAC2, Frequncy ,Signal, SSID3, MAC3, Frequncy ,Signal, SSID4, MAC4, Frequncy ,Signal, SSID5, MAC5, Frequncy ,Signal, SSID6, MAC6, Frequncy ,Signal, SSID7, MAC7, Frequncy ,Signal, SSID8, MAC8,Frequncy ,Signal , SSID9, MAC9, Frequncy ,Signal, SSID10, MAC10, Frequncy ,Signal \n";
		try {
			_con = DriverManager.getConnection(_url, _user, _password);
			st = _con.createStatement();
			rs = ((java.sql.Statement) st).executeQuery(
					"SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
			if (rs.next()) {
				System.out.println("**** Update: " + rs.getString(1));
			}

			PreparedStatement pst = _con.prepareStatement("SELECT * FROM ex4_db");
			rs = pst.executeQuery();
			int ind = 0;
			while (rs.next()) {
				int size = rs.getInt(7);
				int len = 7 + 2 * size;
				String newLine = "";
				for (int i = 2; i <= len; i++) {
					if (i >=8)
					newLine += " ,";
					newLine += rs.getString(i) + ",";

				}
				newLine = newLine.substring(0, newLine.length() - 1);

				//System.out.print(newLine);
				strall += newLine+"\n";
				//System.out.println(newLine);
				database.add(newLine);
				//System.out.println();

				ind++;
			}
			
			
			FileWriter1 out= new FileWriter1(strall, "c:\\knew\\filters\\unitedCsv.csv");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "login failed!");
			System.out.println("1");
			//Logger lgr = Logger.getLogger(openFile.class.getName());
			//lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			//System.out.println("2");
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					(st).close();
				}
				if (_con != null) {
					_con.close();
				}
			} catch (SQLException ex) {
				
				System.out.println("3");

				//Logger lgr = Logger.getLogger(openFile.class.getName());
				//lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		// return max_id;

	}


}
