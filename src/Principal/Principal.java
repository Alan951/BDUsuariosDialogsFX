/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import DataBase.UsuarioDAO;
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
                    boolean error = false;
                    UsuarioModelo usuario1 = null;
                    UsuarioModelo usuario2 = null;
                    UsuarioModelo usuarioDialog = null;
                    do{
                        error = false;
                        usuarioDialog = dialogos.registrarUsuario(usuario1 == null ? null : usuario2);
                        usuario1 = usuarioDialog;
                        if(usuario1 == null){
                            error = false;
                        }else{
                            //comprobar fields.
                            if(usuario1.getUsuario().trim().isEmpty()) error = true;
                            if(usuario1.getClave().trim().isEmpty()) error = true;
                            if(usuario1.getNombre().trim().isEmpty()) error = true;
                            if(usuario1.getApellido().trim().isEmpty()) error = true;
                            if(usuario1.getCorreo().trim().isEmpty()) error = true;
                            if(usuario1.getFechaNacimiento() == null) error = true;
                            if(usuario1.getLugarNacimiento().trim().isEmpty()) error = true;
                            if(!error) 
                                error = dialogos.comprobarDatos(usuario1);
                            else
                                dialogos.errorAlComrpobarFields();
                            if(!error){
                                UsuarioDAO dao = new UsuarioDAO();
                                dao.registrarUsuario(usuario1);
                                dialogos.registroCompletado(usuario1.getUsuario());
                            }else{
                                usuario2 = usuario1;
                            }
                        }
                    }while(error);
                    break;
                
            }
        }
        
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
