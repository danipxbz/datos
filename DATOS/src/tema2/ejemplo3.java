package tema2;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import model.DB;

public class ejemplo3 {

	public static void main(String[] args) throws SQLException {
		DB bdGestion=new DB("jdbc:mysql://localhost:3306/", "gestion", "root", "");
		bdGestion.conexionDB();
		
		
//		crearTabla(bdGestion);
//		insertDatos(bdGestion);
//		listarEmpleados(bdGestion);
		listarFiltro(bdGestion, "empleados", "oficio", "director");
		insertEmpleado(bdGestion, "empleados", 7542, "PEREZ", "DIRECTOR", 7889, "1993-07-15" , 2154, 745, 20);
		
		bdGestion.getConexion().close();
	}
	


	public static void crearTabla(DB bdGestion) throws SQLException {
		Statement st=bdGestion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String table="CREATE TABLE empleados ("
				+ "emp_no    INT NOT NULL PRIMARY KEY,"
				+ "apellido  VARCHAR(10),"
				+ "oficio    VARCHAR(10),"
				+ "dir       INT,"
				+ "fecha_alt DATE,"
				+ "salario   FLOAT,"
				+ "comision  FLOAT,"
				+ "dept_no   INT NOT NULL REFERENCES departamentos(dept_no)"
				+ ")";
		
		st.executeUpdate(table);
		
		st.close();
	}

	public static void insertDatos(DB bdGestion) throws SQLException {
		Statement st=bdGestion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		st.executeUpdate("INSERT INTO empleados VALUES (7369, 'SANCHEZ', 'EMPLEADO', 7902, '1990-12-17', 1040, NULL, 20)");
		st.executeUpdate("INSERT INTO empleados VALUES (7499, 'ARROYO', 'VENDEDOR', 7698, '1990-02-20', 1500, 390, 30)");
		st.executeUpdate("INSERT INTO empleados VALUES (7521, 'SALA', 'VENDEDOR', 7698, '1991-02-22', 1625, 650, 30)");
		st.executeUpdate("INSERT INTO empleados VALUES (7566, 'JIMENEZ', 'DIRECTOR', 7839, '1991-04-02', 2900, NULL, 20)");
		st.executeUpdate("INSERT INTO empleados VALUES (7654, 'MARTIN', 'VENDEDOR', 7698, '1991-09-29', 1600, 1020, 30)");
		st.executeUpdate("INSERT INTO empleados VALUES (7698, 'NEGRO', 'DIRECTOR', 7839, '1991-05-01', 3005, NULL, 30)");
		st.executeUpdate("INSERT INTO empleados VALUES (7782, 'CEREZO', 'DIRECTOR', 7839, '1991-06-09', 2885, NULL, 10)");
		st.executeUpdate("INSERT INTO empleados VALUES (7788, 'GIL', 'ANALISTA', 7566, '1991-11-09', 3000, NULL, 20)");
		st.executeUpdate("INSERT INTO empleados VALUES (7839, 'REY', 'PRESIDENTE', NULL, '1991-11-17', 4100, NULL, 10)");
		st.executeUpdate("INSERT INTO empleados VALUES (7844, 'TOVAR', 'VENDEDOR', 7698, '1991-09-08', 1350, 0, 30)");
		st.executeUpdate("INSERT INTO empleados VALUES (7876, 'ALONSO', 'EMPLEADO', 7788, '1991-09-23', 1430, NULL, 20)");
		st.executeUpdate("INSERT INTO empleados VALUES (7900, 'JIMENO', 'EMPLEADO', 7698, '1991-12-03', 1335, NULL, 30)");
		st.executeUpdate("INSERT INTO empleados VALUES (7902, 'FERNANDEZ', 'ANALISTA', 7566, '1991-12-03', 3000, NULL, 20)");
		st.executeUpdate("INSERT INTO empleados VALUES (7934, 'MUÑOZ', 'EMPLEADO', 7782, '1992-01-23', 1690, NULL, 10)");
	
		st.close();
	}
	
	public static void listarEmpleados(DB bdGestion) throws SQLException {
		Statement st=bdGestion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String consulta="select * from empleados";
		ResultSet rs=st.executeQuery(consulta);
		
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getFloat(6)+" "+rs.getFloat(7)+" "+rs.getInt(8));
		}
		
		rs.close();
		st.close();
		
	}
	
	public static void listarFiltro(DB bdGestion,String tabla, String campo, String registro) throws SQLException {
		Statement st=bdGestion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String consulta="select * from "+tabla+" where lower("+campo+")='"+registro+"'";
		ResultSet rs=st.executeQuery(consulta);
		
		while (rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getDate(5)+" "+rs.getFloat(6)+" "+rs.getFloat(7)+" "+rs.getInt(8));
		}
		
		rs.close();
		st.close();
	}
	
	public static void insertEmpleado(DB bdGestion, String tabla, int emp_no, String apellido, String oficio, int dir, String fecha_alt, float salario, float comision, int dept_no) throws SQLException {
		String insert = "INSERT INTO "+tabla+" VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	    PreparedStatement ps = bdGestion.getConexion().prepareStatement(insert);
	    ps.setInt(1, emp_no);
	    ps.setString(2, apellido);
	    ps.setString(3, oficio);
	    ps.setInt(4, dir);
	    ps.setDate(5, Date.valueOf(fecha_alt));
	    ps.setFloat(6, salario);
	    ps.setFloat(7, comision);
	    ps.setInt(8, dept_no);
	    
	    ps.close();
	}
}
