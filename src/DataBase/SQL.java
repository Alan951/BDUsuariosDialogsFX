
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQL {
    private static String bd;
    private static String login;
    private static String password;
    private static String url;
    
    Connection connection;
    
    public SQL(){
        bd = "usuarios";
        login = "Java";
        password = "wepo";
        url = "jdbc:mysql://localhost/"+bd;
        
        try{
            //Obtenemos el driver para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Obtenemos la conexion
            connection = DriverManager.getConnection(url, login, password);
            
            if(connection!=null){
                System.out.println("Se ha logrado la conexión a "+bd);
            }
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        try {
            connection.close();
            connection = null;
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
