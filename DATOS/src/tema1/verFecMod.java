package tema1;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
public class verFecMod {

	public static void main(String[] args) {
		File archivo=new File("./program.txt");
		long ultMod = archivo.lastModified();
		
		SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
		
		Date fecUltMod=new Date(ultMod);
		
		System.out.println("La ultima modificacion del archivo "+archivo.getName()+" ha sido el "+formato.format(fecUltMod));
	}
}