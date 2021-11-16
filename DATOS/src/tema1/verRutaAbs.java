package tema1;
import java.io.*;
public class verRutaAbs {
	public static void main(String[] args) {
		File dir=new File(".");
		String nombre_archivo="program.txt";
		try {
			new File(dir, nombre_archivo).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File archivo=new File(dir+"/"+nombre_archivo);
		System.out.println("Ruta absoluta del espacio de trabajo: "+dir.getAbsolutePath()+
							"\nRuta absoluta del archivo: "+archivo.getAbsolutePath());
	}
}