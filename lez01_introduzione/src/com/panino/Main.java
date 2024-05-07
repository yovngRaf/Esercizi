package com.panino;

import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.panino.InfoPanino;
import com.panino.GestorePanino;

public class Main {

	public static void main(String[] args) {
		
		Scanner interceptor = new Scanner(System.in);
		boolean insAbi = true;
		
		while(insAbi) {
			System.out.println("Cosa vuoi fare?\n"
					+ "L - Lista panini con relativi dettagli\n"
					+ "P - Visualizzare panino tramite codice\n"
					+ "V - Lista panini vegani\n"
					+ "N - Lista panini non vegani\n"
					+ "M - Calcolo del prezzo medio dei panini\n"
					+ "C - Contare tutti gli elementi presenti\n"
					+ "Q - Uscita");
			
			String input = interceptor.nextLine();
			
			switch(input) {
			case "L":
				try {
					GestorePanino Gpanino = new GestorePanino();
					ArrayList<InfoPanino> elenco = Gpanino.getAll();
					
					System.out.println("--------------ELENCO PRODOTTI--------------");
					for(int i = 0; i<elenco.size(); i++) {
						System.out.println(elenco.get(i).stampaDettaglio());
					}
					System.out.println("-------------------------------------------\n");	
				} catch (Exception e) {
					System.out.println("Errore. " + e.getMessage());
				}
				break;
				
			case "P":
				try {
					System.out.println("Inserisci il codice del panino:");
					String codice = interceptor.nextLine();
					
					GestorePanino Gpanino = new GestorePanino();
					InfoPanino panino = Gpanino.getByCode(codice);
					 
					System.out.println("--------------ELENCO PRODOTTI--------------");
					System.out.println(panino.stampaDettaglio());
					System.out.println("-------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("Errore. " + e.getMessage());
				}
				break;
				
			case "V":
				try {
					GestorePanino Gpanino = new GestorePanino();
					ArrayList<InfoPanino> elenco = Gpanino.getAllIsVegan(true);
					
					System.out.println("--------------ELENCO PRODOTTI--------------");
					for(int i=0; i<elenco.size(); i++) {
						System.out.println(elenco.get(i).stampaDettaglio());
					}
					System.out.println("-------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("Errore. " + e.getMessage());
				}
				break;
				
			case "N":
				try {
					GestorePanino Gpanino = new GestorePanino();
					ArrayList<InfoPanino> elenco = Gpanino.getAllIsVegan(false);
					
					System.out.println("--------------ELENCO PRODOTTI--------------");
					for(int i=0; i<elenco.size(); i++) {
						System.out.println(elenco.get(i).stampaDettaglio());
					}
					System.out.println("-------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("Errore. " + e.getMessage());
				}
				break;
				
			case "C":
				try {
					GestorePanino Gpanino = new GestorePanino();
					int count = Gpanino.getCount();
					
					System.out.println("--------------ELENCO PRODOTTI--------------");
					System.out.println("Il totale è: " + count);
					System.out.println("-------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("Errore. " + e.getMessage());
				}
				break;
				
			case "M":
				try {
					GestorePanino Gpanino = new GestorePanino();
					double media = Gpanino.getAveragePrice();
					
					System.out.println("--------------ELENCO PRODOTTI--------------");
					System.out.println("Il prezzo medio dei panini è: " + media);
					System.out.println("-------------------------------------------\n");
				} catch (Exception e) {
					System.out.println("Errore. " + e.getMessage());
				}
				break;	
			
			case "Q":
				insAbi = false;
				break;
			default:
				System.out.println("Comando sconosciuto.");
				break;
			}
		}
				System.out.println("Programma terminato.");
	}

}
