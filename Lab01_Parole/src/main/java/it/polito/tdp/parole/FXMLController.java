package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;	// oggetto di classe Parole su cui vengono richiamati i metodi 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;	// campo TextField in cui e' stata inserita una nuova parola

    @FXML
    private Button btnInserisci;	// bottone per confermare l'inserimento di una parola in elenco

    @FXML
    private TextArea txtResult;		// campo TextArea in cui viene stampato elenco alfabetico

    @FXML
    private Button btnReset;		// bottone per resettare, quindi eliminare tutte le parole finora inserite

    @FXML
    private Button btnCancella;		// bottone per cancellare da struttura dati la parola selezionata
    
    @FXML
    private TextArea txtTime;		// campo TextArea in cui visualizzare i tempi di esecuzione di ciascuna operazione
    
    @FXML
    void doInsert(ActionEvent event) {		// viene cliccato il bottone "Inserisci"
    	String parolaInserita = txtParola.getText();	// parola inserita dall'utente
    	
    	/* Operazione #1: INSERT */
    	double inizio = System.nanoTime();
    	elenco.addParola(parolaInserita); 	// aggiungo parola nella struttura dati
    	double fine = System.nanoTime();
    	txtTime.clear(); 	// pulisco da eventuali tempi di operazioni precedenti
    	txtTime.setText("Tempo impiegato INSERT: " + (fine-inizio)*1E-9 + " s");
    	/* Fine sezione calcolo tempo/performance azione "Inserisci" */
    	
    	txtParola.clear(); 		// siamo pronti per inserire una nuova parola
    	
    	String stringaCompleta = "";
    	for(String parola: elenco.getElenco())
    		stringaCompleta += parola + "\n";
    	txtResult.setText(stringaCompleta);
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	/* Operazione #2: RESET */
    	double inizio = System.nanoTime();
    	elenco.reset(); 		// elimino parole inserite dalla struttura dati
    	double fine = System.nanoTime();
    	txtTime.clear();
    	txtTime.setText("Tempo impiegato RESET: " + (fine-inizio)*1E-9 + " s");
    	/* Fine sezione calcolo tempo/performance azione "Reset" */
    	
    	txtResult.clear(); 		// pulisco la textArea da parole precedenti
    }

    @FXML
    void doCancella(ActionEvent action) {
    	String parolaDaCancellare = txtResult.getSelectedText();	// testo selezionato
    	
    	/* Operazione #3: DELETE */
    	double inizio = System.nanoTime();
    	elenco.cancellaParola(parolaDaCancellare);
    	double fine = System.nanoTime();
    	txtTime.clear();
    	txtTime.setText("Tempo impiegato CANCELLA :" + (fine-inizio)*1E-9 + " s");
    	/* Fine sezione calcolo tempo/performance azione "Cancella" */
    	
    	txtResult.clear(); 		// puliamo campo da eventuali precedenti parole
    	String stringaCompleta = "";
    	for(String parola: elenco.getElenco())
    		stringaCompleta += parola + "\n";
    	txtResult.setText(stringaCompleta);
    }
    
    @FXML
    void initialize() {
    	
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole();
    }
}
