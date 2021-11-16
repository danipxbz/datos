package tema2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DB;

public class ejemplo2 {

	public static void main(String[] args) {
		DB bdGestion=new DB("jdbc:mysql://localhost:3306/", "gestion", "root", "");
		Statement st=null;
		ResultSet rs=null;
		String consulta="SELECT * FROM alumnos";
		
		try {
			bdGestion.conexionDB();
			st=bdGestion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery(consulta);
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
			}
			st.close();
            rs.close();
            
            bdGestion.getConexion().close();
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Conexion a base de datos "+bdGestion.getBasedatos()+" correcta.");
		
	}

}