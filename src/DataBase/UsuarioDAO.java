
package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DataBase.SQL;
import Modelo.UsuarioModelo;

public class UsuarioDAO {
    
    public void registrarUsuario(UsuarioModelo usuario){
        SQL conex = new SQL();
        try{
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO usuarios VALUES (NULL, '"+usuario.getUsuario()+"', '"+usuario.getClave()+"', '"+usuario.getNombre()+"', "
                    + "'"+usuario.getApellido()+"', '"+usuario.getCorreo()+"', '"+usuario.getFechaNacimiento()+"', '"+usuario.getLugarNacimiento()+"') ");
            estatuto.close();
            conex.desconectar();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<UsuarioModelo> listaDeUsuarios(){
        ArrayList<UsuarioModelo> usuariosRegistrados = new ArrayList<UsuarioModelo>();
        SQL conex = new SQL();
        try{
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                usuariosRegistrados.add(new UsuarioModelo(res.getString("usuario"), null, res.getString("nombre"), res.getString("apellido"), res.getString("correo"), res.getString("fechaNacimiento"), res.getString("lugarNacimiento")));
            }
            System.out.println(usuariosRegistrados.get(0).getApellido());
            res.close();
            consulta.close();
            conex.desconectar();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return usuariosRegistrados;
    }
}
