/*
    En esta clase introducire los metodos los cuales
    seran utilizados para ejecutar ventanas de dialogos.
*/
package Dialogs;

import DataBase.UsuarioDAO;
import Modelo.UsuarioModelo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.beans.property.BooleanPropertyBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;


public class Dialogos {
    
    public int mostrarMenu(){
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Menu - ¿Que deseas hacer?");
        alerta.setHeaderText("Aqui se te presentaran las opciones principales.");
        alerta.setContentText("Escoge alguna.");
        
        //Declaracion de botones.
        ButtonType btnMostrarListaUsuarios = new ButtonType("Ver todos los usuarios");
        ButtonType btnRegistrarUsuarios = new ButtonType("Registrar usuario");
        ButtonType btnEliminarUsuario = new ButtonType("Eliminar usuario");
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
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<UsuarioModelo> usuariosDB = dao.listaDeUsuarios();
        //Lista
        ObservableList<UsuarioModelo> usuarios = FXCollections.observableArrayList(usuariosDB);
   
        Stage stage = new Stage();
        TableView tabla = new TableView();
        
        TableColumn usuarioT = new TableColumn("Username");
        TableColumn nombreT = new TableColumn("Nombre");
        TableColumn apellidoT = new TableColumn("Apellido");
        
        
        usuarioT.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        nombreT.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoT.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        
        tabla.setItems(usuarios);
        
        tabla.getColumns().addAll(usuarioT, nombreT, apellidoT);
        
        StackPane root = new StackPane();
        root.getChildren().add(tabla);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
    }
    
    //Dialogos completamente modificado.
    public UsuarioModelo registrarUsuario(UsuarioModelo user){
        Dialog<ButtonType> dialog = new Dialog<>();
        //Establecer titulo y el headerText
        dialog.setTitle("Registrar usuario");
        dialog.setHeaderText("Asegurate de llenar todos los campos.");
        
        //Establecer un icono.
        dialog.setGraphic(new ImageView(this.getClass().getResource("/img/login.png").toString()));
        //Establecer boton
        ButtonType btnRegistrar = new ButtonType("Registrar", ButtonData.OK_DONE);
        ButtonType btnCancelar = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        
        dialog.getDialogPane().getButtonTypes().addAll(btnRegistrar, btnCancelar);
        
        //Crear los labels y textfields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 50, 10, 10));
        
        TextField txtUsuario = new TextField();
        PasswordField txtPassword = new PasswordField();
        TextField txtNombre = new TextField();
        TextField txtApellido = new TextField();
        TextField txtCorreo = new TextField();
        TextField txtLugarNacimiento = new TextField();
        
        Label lblUsuario = new Label();
        Label lblPassword = new Label();
        Label lblNombre = new Label();
        Label lblApellido = new Label();
        Label lblCorreo = new Label();
        Label lblLugarNacimiento = new Label();
        
        lblUsuario.setText("Usuario: ");
        lblPassword.setText("Contraseña: ");
        lblNombre.setText("Nombre: ");
        lblApellido.setText("Apellido: ");
        lblCorreo.setText("Correo: ");
        lblLugarNacimiento.setText("Lugar Nacimiento:");
        
        //Crear calendario
        DatePicker calendario = new DatePicker();
        calendario.setPromptText("dd/mm/aaaa");
        
        //Establecer componentes en el grid
        grid.add(lblUsuario, 0, 0);
        grid.add(txtUsuario, 1, 0);
        grid.add(lblPassword, 0, 1);
        grid.add(txtPassword, 1, 1);
        grid.add(lblNombre, 0, 2);
        grid.add(txtNombre, 1, 2);
        grid.add(lblApellido, 0, 3);
        grid.add(txtApellido, 1, 3);
        grid.add(lblCorreo, 0, 4);
        grid.add(txtCorreo, 1, 4);
        grid.add(lblLugarNacimiento, 0, 5);
        grid.add(txtLugarNacimiento, 1, 5);
        grid.add(new Label("Fecha nacimiento:"), 0, 6);
        grid.add(calendario, 1, 6); //Establecer calendario en el grid.
        
        dialog.getDialogPane().setContent(grid); //Agregar el grid al dialogo
        
        Platform.runLater(() -> txtUsuario.requestFocus()); //Hacer focus al textfield del usuario al ejecutarse

        //Establecer boton
        Node btnTypeRegistrar = dialog.getDialogPane().lookupButton(btnRegistrar);
        btnTypeRegistrar.setDisable(false);

        //En caso de que el parametro no sea nulo establecer texto

        if(user != null){
            txtUsuario.setText(user.getUsuario());
            txtPassword.setText(user.getClave());
            txtNombre.setText(user.getNombre());
            txtApellido.setText(user.getApellido());
            txtCorreo.setText(user.getCorreo());
            txtLugarNacimiento.setText(user.getLugarNacimiento()); 
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
            DateTimeFormatter formatVIEW = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println(user.getFechaNacimiento());
            LocalDate date = user.getFechaNacimiento() == null ? null : LocalDate.parse(user.getFechaNacimiento(), format);
            calendario.setValue(date);
        }
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.get().equals(btnRegistrar)){    
            UsuarioModelo usuario = new UsuarioModelo(txtUsuario.getText(), txtPassword.getText(), txtNombre.getText(), txtApellido.getText(), txtCorreo.getText(), calendario.getValue() == null ? null : calendario.getValue().toString(), txtLugarNacimiento.getText());
            return usuario;
        }else{
            return null;
        }
    }
    
    public boolean comprobarDatos(UsuarioModelo usuario){
        UsuarioDAO dao = new UsuarioDAO();
        String error = "";
        
        if(dao.comprobarUsuario(usuario.getUsuario()))
            error += "El usuario se encuentra registrado\n";
        if(dao.comrpobarCorreo(usuario.getCorreo()))
            error += "El correo ya se encuentra registrado\n";
        
        
        if(error.equals("")){
            return false;
        }else{
            //Mostrar dialogo del error
            System.out.println("Datos corruptos");
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Ops, ocurrio un error.");
            alerta.setHeaderText("Ocurrio un problema al registrar los datos.");
            alerta.setContentText(error);
            alerta.showAndWait();
            return true;
        }
    }
    
    public void registroCompletado(String usuario){
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Registro completado.");
        alerta.setHeaderText("Se han registrado los datos con exito.");
        alerta.setContentText("El usuario: "+usuario+" ha sido registrado con exito!");
        alerta.showAndWait();
    }
    
    public void errorAlComrpobarFields(){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Ops, ocurrio un error.");
        alerta.setHeaderText("Ocurrio un problema al comprobar los datos.");
        alerta.setContentText("Verifica que todos los campos esten llenados correctamente.");
        alerta.showAndWait();
    }
}
