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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author cda611
 */
public class ShippingFXMLController implements Initializable {
    @FXML
    private TextField nameShipInser;
    @FXML
    private TextField infoShipInser;
    @FXML
    private TextField condShipInser;
    @FXML
    private TextField nameShipUpd;
    @FXML
    private TextField infoShipUpd;
    @FXML
    private TextField condShipUpd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
