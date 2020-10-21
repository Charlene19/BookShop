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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author cda611
 */
public class AuthorFXMLController implements Initializable {
    @FXML
    private TextField nameInser;
    @FXML
    private TextField FnameInser;
    @FXML
    private TextField postInser;
    @FXML
    private Button cancelButton;
    @FXML
    private Button valButton;
    @FXML
    private TextField nameUpd;
    @FXML
    private TextField FnameUpd;
    @FXML
    private TextField postUpd;
    @FXML
    private Button ccelButton;
    @FXML
    private Button vlButton;
    @FXML
    private TextField idSearch;
    @FXML
    private TextField nameSearch;
    @FXML
    private ComboBox<?> catCB;
    @FXML
    private Button cclButton;
    @FXML
    private Button flwButton;
    @FXML
    private TextField idDel;
    @FXML
    private TextField nameDel;
    @FXML
    private ComboBox<?> catCBDel;
    @FXML
    private Button cclButtonD;
    @FXML
    private Button flwButtonD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
