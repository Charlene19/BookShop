/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        bookrb.setToggleGroup(group);
        authorrb.setToggleGroup(group);
        catrb.setToggleGroup(group);
        cusrb.setToggleGroup(group);
        ordrb.setToggleGroup(group);
        evtrb.setToggleGroup(group);

       group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                try {
                    Parent root = FXMLLoader.load(FXMLDocumentController.class.getResource("/views/mainFXML.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene); 
                   
                    
                    if (group.getSelectedToggle() != null) { 
                        RadioButton rb = (RadioButton)group.getSelectedToggle();
                        
                        String labelButton = rb.getText();
                        switch(labelButton){
                            
                            case "Author" :
                                try {
                                    stage.show(); 
                                    AnchorPane apStage = (AnchorPane) scene.lookup("#contenair");
                                    AnchorPane an = (AnchorPane) FXMLLoader.load(MainFXMLController.class.getResource("/views/authorFXML.fxml"));
                                    apStage.getChildren().add(an);
                                    
                                    // Do something here with the userData of newly selected radioButton
                                } catch (IOException ex) {
                                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                            case "Category" :
                                
                                try {
                                    
                                  
                                    stage.show();
                                    
                                    AnchorPane apStage = (AnchorPane) scene.lookup("#contenair");
                                    AnchorPane an = (AnchorPane) FXMLLoader.load(MainFXMLController.class.getResource("/views/categoryFXML.fxml"));
                                    apStage.getChildren().add(an);
                                    
                                    // Do something here with the userData of newly selected radioButton
                                } catch (IOException ex) {
                                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                                  case "Book" :
                                
                                try {
                                    
                                  
                                    stage.show();
                                    
                                    AnchorPane apStage = (AnchorPane) scene.lookup("#contenair");
                                    AnchorPane an = (AnchorPane) FXMLLoader.load(MainFXMLController.class.getResource("/views/bookFXML.fxml"));
                                    apStage.getChildren().add(an);
                                    
                                    // Do something here with the userData of newly selected radioButton
                                } catch (IOException ex) {
                                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                                 case "Order" :
                                
                                try {
                                    
                                  
                                    stage.show();
                                    
                                    AnchorPane apStage = (AnchorPane) scene.lookup("#contenair");
                                    AnchorPane an = (AnchorPane) FXMLLoader.load(MainFXMLController.class.getResource("/views/orderFXML.fxml"));
                                    apStage.getChildren().add(an);
                                    
                                    // Do something here with the userData of newly selected radioButton
                                } catch (IOException ex) {
                                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                
                                 case "Event" :
                                
                                try {
                                    
                                  
                                    stage.show();
                                    
                                    AnchorPane apStage = (AnchorPane) scene.lookup("#contenair");
                                    AnchorPane an = (AnchorPane) FXMLLoader.load(MainFXMLController.class.getResource("/views/eventFXML.fxml"));
                                    apStage.getChildren().add(an);
                                    
                                    // Do something here with the userData of newly selected radioButton
                                } catch (IOException ex) {
                                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                        }
                        
                    }   } catch (IOException ex) {
                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
       

                }  
                   });
                  
                  
                   // if(rb.getText() == "Author")//faire une méthode avec switch case + une méthode
                       
                   
    }
}
