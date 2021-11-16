package tema2;

import java.sql.*;
import javax.sql.*;

public class ejemplo1 {

	public static void main(String[] args) {
		String basedatos = "gestion";       String login = "root";		String password = "";
		
        String url = "jdbc:mysql://localhost:3306/"+basedatos;
        Connection conexion;
        Statement st=null;
        ResultSet rs=null;
        String consulta="SELECT * FROM alumnos";        
        
        try {
        	// Conexion a la BBDD
        	
//        	Class.forName("com.mysql.cj.jdbc.Driver"); //No es necesario porque hemos añadido la libreria
        	
            conexion = DriverManager.getConnection(url,login,password); // el getConnection requiere siempre 3 parametros: su direccion, usuario y contraseña
            System.out.println("Conexion a base de datos "+basedatos+" correcta.");
            
            // Creacion del Statement
            st=conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            // Volcamos la consulta en un Resultset
            rs=st.executeQuery(consulta);
            
            // Leemos el resultset columna a columna
            while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
			}
            
            // Cerramos Resultset, Statement y conexion
            st.close();
            rs.close();
            
            conexion.close();
            
            
        } catch(SQLException e){
            e.getMessage();
        } catch(Exception e){
            e.getMessage();
        }
    }

}