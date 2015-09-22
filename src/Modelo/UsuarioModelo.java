
package Modelo;

import util.Utilities;

/**
 *
 * @author Jorge Alan Villalon Perez   
 */
public class UsuarioModelo {
    private String usuario;
    private String clave;
    private String nombre;
    private String apellido;
    private String correo;
    private String fechaNacimiento;
    private String lugarNacimiento;
    
    public UsuarioModelo(String usuario, String clave, String nombre, String apellido, String correo, String fechaNacimiento, String lugarNacimiento){
        setUsuario(usuario);
        setClave(clave);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setFechaNacimiento(fechaNacimiento);
        setLugarNacimiento(lugarNacimiento);
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setClave(String clave){
        this.clave = Utilities.cifrarDatos(clave);
    }
    
    public String getClave(){
        return clave;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getFechNacimiento(){
        return fechaNacimiento;
    }
    
    public void setLugarNacimiento(String lugarNacimiento){
        this.lugarNacimiento = lugarNacimiento;
    }
    
    public String getLugarNacimiento(){
        return lugarNacimiento;
    }
}