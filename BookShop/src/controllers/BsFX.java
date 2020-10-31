/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import com.aquafx_project.AquaFx;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 *
 * @author Charlène
 */
public class BsFX extends Application {

 
    @Override
    public void start(Stage stage) throws Exception {
        AquaFx.style(); 
        Parent root = FXMLLoader.load(BsFX.class.getResource("/views/FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        Button button = (Button) scene.lookup("#submit");
        button.setOnAction((ActionEvent event) -> {
            try {
                Parent rootd = FXMLLoader.load(FXMLDocumentController.class.getResource("/views/mainFXML.fxml"));
                Stage staged = new Stage();
                Scene scened = new Scene(rootd);
                staged.setScene(scened);
                staged.show();

            } catch (IOException ex) {
                Logger.getLogger(BsFX.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
