package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private Dizionario modello;
	
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	    try{ 
    	    		String input=txtWord.getText().toLowerCase();
    	    		String arrayInput[] = input.split(" ");
    	    		if(arrayInput.length==1) {
    	    			if(arrayInput[0].contains("?"))
    	    				txtResult.appendText("\n--> "+ modello.paroleCompatibiliToString(arrayInput[0]));
    	    			else
    	    				txtResult.appendText("\n--> "+arrayInput[0]+" = "+modello.translateWord(arrayInput[0]));
    	    		
    	    		}
    	    		if(arrayInput.length>1) {
    	    			List<String> listaOutput = new LinkedList<String>();
    	    			for(int i=1; i<arrayInput.length; i++) {
    	    				listaOutput.add(arrayInput[i]);
    	    			}
    	    			
    	    			modello.addWord(arrayInput[0], listaOutput);
    	    			txtResult.appendText("\n--> aggiunta "+arrayInput[0] + " = ");
    	    			for(String s:listaOutput)
    	    				txtResult.appendText(s+" ");
    	    		}
    	    
    	    }catch(Exception e) {
    	    		txtResult.appendText("inserire min 1 parola max 2 parole");
    	    }
    		
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    		txtResult.clear();
    }


	public Dizionario getModello() {
		return modello;
	}


	public void setModello(Dizionario modello) {
		this.modello = modello;
	}
    
}
