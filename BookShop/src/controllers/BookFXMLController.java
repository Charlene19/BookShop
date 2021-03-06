/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import persistence.AuthorDAO;
import persistence.CategoryDAO;

/**
 * FXML Controller class
 *
 * @author cda611
 */
public class BookFXMLController implements Initializable {
    @FXML
    private TextField isbnIns;
    @FXML
    private TextField titleInser;
    @FXML
    private TextField subInser;
    @FXML
    private TextField priceInser;
    @FXML
    private TextField coverInser;
    @FXML
    private TextField sumInser;
    @FXML
    private TextField stockInser;
    @FXML
    private TextField shelfInser;
    @FXML
    private TextField postitInser;
    @FXML
    private TextField isbnUpd;
    @FXML
    private TextField titleUpd;
    @FXML
    private TextField subUpd;
    @FXML
    private TextField priceUpd;
    @FXML
    private TextField coverUpd;
    @FXML
    private TextField sumUpd;
    @FXML
    private TextField stockUpd;
    @FXML
    private TextField shelfUpd;
    @FXML
    private TextField postitUpd;
    @FXML
    private TextField isbnSearch;
    @FXML
    private TextField titleSearch;
    @FXML
    private ComboBox<?> catCB;
    @FXML
    private ComboBox<?> autCB;
    @FXML
    private Button cclB;
    @FXML
    private Button flwB;
    @FXML
    private TextField isbnDel;
    @FXML
    private TextField titleDel;
    @FXML
    private ComboBox<?> catDelCB;
    @FXML
    private ComboBox<?> autDelCB;
    @FXML
    private Button cancel;
    @FXML
    private Button follow;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        List listPrep =(List) new CategoryDAO().getAll();
        ObservableList list = FXCollections.observableArrayList(listPrep);
        catCB.setItems((ObservableList) list);
        catDelCB.setItems((ObservableList) list);
        
        List listAPrep =(List) new AuthorDAO().getAll();
        ObservableList lista = FXCollections.observableArrayList(listAPrep);
        autCB.setItems((ObservableList) lista);
        autDelCB.setItems((ObservableList) lista);
    }    
    
}
