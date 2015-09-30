
package Modelo;

import javafx.beans.property.SimpleStringProperty;
import util.Utilities;

/**
 *
 * @author Jorge Alan Villalon Perez   
 */
public class UsuarioModelo {    
    private final SimpleStringProperty usuario;
    private final SimpleStringProperty clave;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellido;
    private final SimpleStringProperty correo;
    private final SimpleStringProperty fechaNacimiento;
    private final SimpleStringProperty lugarNacimiento;

    public UsuarioModelo(String usuario, String clave, String nombre, String apellido, String correo, String fechaNacimiento, String lugarNacimiento){
        this.usuario = new SimpleStringProperty(usuario);
        this.clave = new SimpleStringProperty(clave);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        this.correo = new SimpleStringProperty(correo);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
        this.lugarNacimiento = new SimpleStringProperty(lugarNacimiento);
    }
    
    public void setUsuario(String usuario){
        this.usuario.set(usuario);
    }
    
    public String getUsuario(){
        return usuario.get();
    }
    
    public void setClave(String clave){
        this.clave.set(clave);
    }
    
    public String getClave(){
        return clave.get();
    }
    
    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }
    
    public String getNombre(){
        return nombre.get();
    }
    
    public void setApellido(String apellido){
        this.apellido.set(apellido);
    }
    
    public String getApellido(){
        return apellido.get();
    }
    
    public void setCorreo(String correo){
        this.correo.set(correo);
    }
    
    public String getCorreo(){
        return correo.get();
    }
    
    public void setFechaNacimiento(String fecha){
        fechaNacimiento.set(fecha);
    }
    
    public String getFechaNacimiento(){
        return fechaNacimiento.get();
    }
    
    public void lugarNacimiento(String lugar){
        lugarNacimiento.set(lugar);
    }
    
    public String getLugarNacimiento(){
        return lugarNacimiento.get();
    }
    
    /**
     * @return the usuarioS
     */
    public SimpleStringProperty getUsuarioS() {
        return usuario;
    }

    /**
     * @return the claveS
     */
    public SimpleStringProperty getClaveS() {
        return clave;
    }

    /**
     * @return the nombreS
     */
    public SimpleStringProperty getNombreS() {
        return nombre;
    }

    /**
     * @return the apellidoS
     */
    public SimpleStringProperty getApellidoS() {
        return apellido;
    }

    /**
     * @return the correoS
     */
    public SimpleStringProperty getCorreoS() {
        return correo;
    }

    /**
     * @return the fechaNacimientoS
     */
    public SimpleStringProperty getFechaNacimientoS() {
        return fechaNacimiento;
    }

    /**
     * @return the lugarNacimientoS
     */
    public SimpleStringProperty getLugarNacimientoS() {
        return lugarNacimiento;
    }

    
}