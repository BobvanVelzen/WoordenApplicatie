package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.WoordenAction;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    private WoordenAction wa;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
        wa = new WoordenAction();
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
        int w = wa.aantal(taInput.getText(), false);
        int uw = wa.aantal(taInput.getText(), true);
        
        taOutput.setText("Totaal aantal woorden:  " + w + "\n" +
                         "Aantal verschillende woorden:  " + uw);
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        Set<String> words = wa.sorteer(taInput.getText(), false);
        StringBuilder sb = new StringBuilder();
        for(String word : words)
            sb.append(word).append("\n");
        taOutput.setText(sb.toString());
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        List<Map.Entry<String, Integer>> frequenty = wa.frequentie(taInput.getText());
        StringBuilder sb = new StringBuilder();
        for(Entry<String, Integer> e : frequenty)
            sb.append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        taOutput.setText(sb.toString());
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        TreeMap<String, LinkedList<Integer>> concordatie = wa.concordatie(taInput.getText());
        StringBuilder sb = new StringBuilder();
        for (Entry<String, LinkedList<Integer>> e : concordatie.entrySet())
            sb.append(e.getKey()).append(e.getValue().toString()).append("\n");
        taOutput.setText(sb.toString());
    }
}
