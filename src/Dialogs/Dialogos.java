/*
    En esta clase introducire los metodos los cuales
    seran utilizados para ejecutar ventanas de dialogos.
*/
package Dialogs;

import DataBase.UsuarioDAO;
import Modelo.UsuarioModelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Dialogos {
    
    public int mostrarMenu(){
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Menu - ¿Que deseas hacer?");
        alerta.setHeaderText("Aqui se te presentaran las opciones principales.");
        alerta.setContentText("Escoge alguna.");
        
        //Declaracion de botones.
        ButtonType btnMostrarListaUsuarios = new ButtonType("Ver todos los usuarios.");
        ButtonType btnRegistrarUsuarios = new ButtonType("Registrar usuario.");
        ButtonType btnEliminarUsuario = new ButtonType("Eliminar registro");
        ButtonType btnSalir = new ButtonType("Salir", ButtonData.CANCEL_CLOSE);
        
        //Insertar en el dialogo
        alerta.getButtonTypes().setAll(btnMostrarListaUsuarios, btnRegistrarUsuarios, btnEliminarUsuario, btnSalir);
        
        Optional<ButtonType> resultado = alerta.showAndWait();
        if(resultado.get() == btnSalir)
            return 0;
        else if(resultado.get() == btnMostrarListaUsuarios)
            return 1;
        else if(resultado.get() == btnRegistrarUsuarios)
            return 2;
        else 
            return 3;
    }
    
    public void mostrarUsuarios(Stage primaryStage){
   //   UsuarioDAO dao = new UsuarioDAO();
   //   ArrayList<UsuarioModelo> usuarios = dao.listaDeUsuarios();
        Stage stage = new Stage();
        TableView tabla = new TableView();
        
        TableColumn usuario = new TableColumn("Username");
        TableColumn nombre = new TableColumn("Nombre");
        TableColumn apellido = new TableColumn("Apellido");
        
        tabla.getColumns().addAll(usuario, nombre, apellido);
        
        StackPane root = new StackPane();
        root.getChildren().add(tabla);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
    }
    
}
