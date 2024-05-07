package com.connessione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connessione.classes.Studente;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {

	public static void main(String[] args) {
		
		try {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(3308);
		ds.setUser("root");
		ds.setPassword("toor");
		ds.setDatabaseName("java_lez01_scuola");
		ds.setUseSSL(false);
		ds.setAllowPublicKeyRetrieval(true);
		
		//--------------- INSERT
		
//		Connection conn = ds.getConnection();		//Apertura connessione
//		
//		String query = "INSERT INTO Studente(nome, cognome, matricola, crediti_cons) VALUES (?, ?, ?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setString(1, "Mario");
//		ps.setString(2, "Rossi");
//		ps.setString(3, "AB1236");
//		ps.setInt(4, 52);
//		
//		
//		int affRows = ps.executeUpdate();
//		if(affRows > 0)
//			System.out.println("OK");
//		else
//			System.out.println("Errore di inserimento.");
//		
//		conn.close();				// Chiudo la connessione
		
		
		//--------------- SELECT ALL
		
//		Connection conn = ds.getConnection();
//		
//		String query = "SELECT studenteID, nome, cognome, matricola, crediti_cons FROM STUDENTE";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			int stuId = rs.getInt("studenteID");
//			String nome = rs.getString("nome");
//			String cogn = rs.getString("cognome");
//			String matr = rs.getString("matricola");
//			int cred = rs.getInt("crediti_cons");
//			
//			Studente temp = new Studente(stuId, nome, cogn, matr, cred);
//			System.out.println(temp);
//		}
//		
//		conn.close();
		
		
		//----------------- SELECT BY ID
		
//		int idDaCercare = 3;
//		
//		Connection conn = ds.getConnection();
//		
//		String query = "SELECT studenteID, nome, cognome, matricola, crediti_cons FROM STUDENTE WHERE studenteID = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1, idDaCercare);
//		
//		ResultSet rs = ps.executeQuery();
//		rs.next();
//		
//		int stuId = rs.getInt("studenteID");
//		String nome = rs.getString("nome");
//		String cogn = rs.getString("cognome");
//		String matr = rs.getString("matricola");
//		int cred = rs.getInt("crediti_cons");
//		
//		Studente temp = new Studente(stuId, nome, cogn, matr, cred);
//		System.out.println(temp);
//		
//		conn.close();
		
		
		//------------- DELETE
		
		
//		int idDaEliminare = 2;
//		
//		Connection conn = ds.getConnection();
//		
//		String query = "DELETE FROM STUDENTE WHERE studenteID = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		ps.setInt(1, idDaEliminare);
//		
//		int affRows = ps.executeUpdate();
//		if(affRows > 0)
//			System.out.println("OK");
//		else
//			System.out.println("Errore di eliminazione.");
//		
//		conn.close();
		
		//------------- UPDATE
		
		String nuovoCognome = "Rossetti";
		int nuoviCrediti = 85;
		int studenteDaModificare = 2;
		
		Connection conn = ds.getConnection();
		String query = "UPDATE Studente SET cognome = ?, crediti_cons = ? WHERE studenteID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, nuovoCognome);
		ps.setInt(2, nuoviCrediti);
		ps.setInt(3, studenteDaModificare);
		
		
		int affRows = ps.executeUpdate();
		if(affRows > 0)
			System.out.println("OK");
		else
			System.out.println("Errore.");
		
		
		conn.close();
		
		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
		}
		
		 
		
		
		
		

	}

}
