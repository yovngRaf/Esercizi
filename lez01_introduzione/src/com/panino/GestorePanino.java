package com.panino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.cj.jdbc.MysqlDataSource;

public class GestorePanino {

	private MysqlDataSource ds;
	
	public GestorePanino() throws SQLException{
		ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3308);
		ds.setUser("root");
		ds.setPassword("toor");
		ds.setDatabaseName("java_lez05_scuola");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
	}
	
	public ArrayList<InfoPanino> getAll() throws SQLException{
		Connection conn = ds.getConnection();
		ArrayList<InfoPanino> risultato = new ArrayList<InfoPanino>();
		
		String query = "SELECT paninoID, nome, codice, descrizione, prezzo, isVegan FROM Panino";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			InfoPanino pan = new InfoPanino(
									rs.getInt("paninoID"),
									rs.getString("nome"),
									rs.getString("codice"),
									rs.getString("descrizione"),
									rs.getFloat("prezzo"),
									rs.getBoolean("isVegan"));
			risultato.add(pan);
		}
		
		conn.close();
		return risultato;
		
		
		}

	public ArrayList<InfoPanino> getAllIsVegan(boolean varVegano) throws SQLException {
		
		Connection conn = ds.getConnection();
		ArrayList<InfoPanino> risultato = new ArrayList<InfoPanino>();
		
		String query = "SELECT paninoID, nome, codice, descrizione, prezzo, isvegan FROM Panino WHERE isvegan = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setBoolean(1, varVegano);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			InfoPanino pan = new InfoPanino(
					rs.getInt("paninoID"),
					rs.getString("nome"),
					rs.getString("codice"),
					rs.getString("descrizione"),
					rs.getFloat("prezzo"),
					rs.getBoolean("isvegan")
					);
			
			risultato.add(pan);
		}
		
		conn.close();
		return risultato;
	}

	public InfoPanino getByCode (String codice) throws SQLException {
		
		Connection conn = ds.getConnection();
		
		String query = "SELECT paninoID, nome, codice, descrizione, prezzo, isvegan FROM Panino WHERE codice = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, codice);
		
		ResultSet rs = ps.executeQuery();
			rs.next();
			InfoPanino pan = new InfoPanino(
					rs.getInt("paninoID"),
					rs.getString("nome"),
					rs.getString("codice"),
					rs.getString("descrizione"),
					rs.getFloat("prezzo"),
					rs.getBoolean("isvegan")
					);
			
			conn.close();
			return pan;
				
	}

		public double getAveragePrice() throws SQLException {
		Connection conn = ds.getConnection();
		
		String query = "SELECT AVG(prezzo) as media_prezzo FROM Panino";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
			double mediaPrezzo = rs.getDouble("media_prezzo");
			
			conn.close();
			return mediaPrezzo;
		
	}

		public int getCount() throws SQLException {
		Connection conn = ds.getConnection();
	
	String query = "SELECT COUNT(paninoID) as total FROM Panino";
	PreparedStatement ps = conn.prepareStatement(query);
	
	ResultSet rs = ps.executeQuery();
	rs.next();
		int total = rs.getInt("total");
		
		conn.close();
		return total;
}
 
}	