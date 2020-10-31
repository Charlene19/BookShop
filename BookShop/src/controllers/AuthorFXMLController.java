/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bookshop.Author;
import bookshop.Category;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.T;
import javafx.stage.Stage;
import persistence.AuthorDAO;
import persistence.CategoryDAO;
import persistence.CrudOperation;
import persistence.DAOException;

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
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        List listPrep =(List) new CategoryDAO().getAll();
        ObservableList list = FXCollections.observableArrayList(listPrep);
        catCB.setItems((ObservableList) list);
        catCBDel.setItems((ObservableList) list);
        

        Button button = (Button) valButton;
        button.setOnAction((ActionEvent event) -> {

            String nom = nameInser.getText();
            String prenom = FnameInser.getText();
            String post = postInser.getText();

            Author a = new Author();
            a.setAuthorLName(prenom);
            a.setAuthorFName(nom);
            a.setAuthorPostIt(post);
            AuthorDAO ad = new AuthorDAO();
            ad.createObject(a);

        });

        Button but = (Button) flwButton;
        but.setOnAction((ActionEvent event) -> {

            String id = idSearch.getText();
            String nameS = nameSearch.getText();
            String cat = catCB.getPromptText(); 

            
            AuthorDAO ad = new AuthorDAO();
            if(id != null){
            ad.findObject(id);
            }else if(nameS != null){
                try { 
                    ad.findByName(nameS);
                } catch (DAOException ex) {
                    Logger.getLogger(AuthorFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                
            }
        });
    }

}
