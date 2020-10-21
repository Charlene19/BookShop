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
public class CategoryFXMLController implements Initializable {
    @FXML
    private ComboBox<?> catParSel;
    @FXML
    private TextField catChildInser;
    @FXML
    private Button cclButton;
    @FXML
    private Button valButton;
    @FXML
    private TextField catParInser;
    @FXML
    private ComboBox<?> catParUpd;
    @FXML
    private TextField catNameUpd;
    @FXML
    private Button cclBut;
    @FXML
    private Button valBut;
    @FXML
    private ComboBox<?> catParSrch;
    @FXML
    private TextField catName;
    @FXML
    private Button cclCat;
    @FXML
    private Button cclSub;
    @FXML
    private ComboBox<?> catParCB;
    @FXML
    private TextField catParDel;
    @FXML
    private Button cclCatDel;
    @FXML
    private Button cclCatSub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
