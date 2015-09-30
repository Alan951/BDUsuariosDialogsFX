/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Dialogs.Dialogos;
import Modelo.UsuarioModelo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Jorge Alan Villalon Perez
 */
public class Principal extends Application{
    @Override
    public void start(Stage primaryStage) {
        Dialogos dialogos = new Dialogos();
        
        boolean close = false;
        while(!close){
            
            int opcion = dialogos.mostrarMenu();
            switch(opcion){
                case 1:
                    dialogos.mostrarUsuarios(primaryStage);
                    break;
                case 0:
                    close = true;
                    break;
                case 2:
                    dialogos.registrarUsuario();
                    break;
            }
        }
        
    }
    

    public static void main(String[] args) {
        launch(args);
        
    }
    
}
