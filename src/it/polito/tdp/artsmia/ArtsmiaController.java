/**
 * Sample Skeleton for 'Artsmia.fxml' Controller Class
 */

package it.polito.tdp.artsmia;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.artsmia.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ArtsmiaController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxAnno"
    private ChoiceBox<Integer> boxAnno; // Value injected by FXMLLoader

    @FXML // fx:id="txtFieldStudenti"
    private TextField txtFieldStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    /**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
		
		this.boxAnno.getItems().addAll(model.getTuttiAnni());
		
		
	}

	@FXML
    void handleCreaGrafo(ActionEvent event) {
		
		this.txtResult.clear();
		
		Integer anno = this.boxAnno.getValue();
		
		if(anno == null){
			
			this.txtResult.setText("Selezionare anno dal menù a tendina!");
			return;
		}
		
		model.creaGrafo(anno);
		
		txtResult.appendText("Grafo creato!\n");
		
		txtResult.appendText("Il grafo é fortemente connesso?\n");
		
		txtResult.appendText(model.isStronglyConnected() + "\n");
	
		txtResult.appendText("La mostra che ha il maggior numero di opere d'arte é:\n");
		
		txtResult.appendText( model.getMaxOpere(anno) + "\n");
		
    	
    	

    }

    @FXML
    void handleSimula(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxAnno != null : "fx:id=\"boxAnno\" was not injected: check your FXML file 'Artsmia.fxml'.";
        assert txtFieldStudenti != null : "fx:id=\"txtFieldStudenti\" was not injected: check your FXML file 'Artsmia.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Artsmia.fxml'.";

    }
}
