package it.polito.tdp.parole.model;

import java.util.List;
import java.util.*;

public class Parole {
		
	private List<String> elencoParole;
	
	public Parole() {
		elencoParole = new LinkedList<String>();
		// elencoParole = new ArrayList<String>();		// PERFORMANCE? MIGLIORI
		/* 		***********************************		 */
		
		/*				   LINKEDLIST       ARRAYLIST    */
		/* INSERT			3.0E-6 s	>	 1.2E-6 s	 */
		/* RESET			5.3E-6 s	>	 3.6E-6 s    */
		/* CANCELLA			1.2E-5 s	>	 7.3E-6 s    */
		
		/* 		***********************************		 */
	}
	
	public void addParola(String p) {
		elencoParole.add(p);
	}
	
	// Ritorna elenco di parole finora inserite in ordine alfabetico
	public List<String> getElenco() {
		Collections.sort(elencoParole);	// sono stringhe. Ordinate naturalmente
		return elencoParole;
	}
	
	// Cancella la parola selezionata nell'area di testo. Cancellazione della SINGOLA parola
	public void cancellaParola(String parolaDaCancellare) {
	
		boolean trovatoParola = false;	// la parola e' sicuramente nell'elenco. Sto selezionando da TextArea
		int indiceParolaDaCancellare = 0;
		for(int i = 0; i < elencoParole.size() && !trovatoParola; i++)
			if(elencoParole.get(i).compareTo(parolaDaCancellare) == 0) {
				trovatoParola = true;
				indiceParolaDaCancellare = i;
			}
		elencoParole.remove(indiceParolaDaCancellare);
		/* Oppure semplicemente elencoParole.remove(parolaDaCancellare); */
		}
	
	public void reset() {
		elencoParole.clear();
	}

}
