/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author cda611
 */
public class MainFXMLController implements Initializable {
    @FXML
    private RadioButton bookrb;
    @FXML
    private RadioButton authorrb;
    @FXML
    private RadioButton catrb;
    @FXML
    private RadioButton cusrb;
    @FXML
    private RadioButton ordrb;
    @FXML
    private RadioButton evtrb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
