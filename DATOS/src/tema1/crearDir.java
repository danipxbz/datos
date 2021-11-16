package tema1;
import java.io.*;
public class crearDir {
	public static void main(String[] args) {
		
		// Creando nuevo directorio con el nombre NUEVODIR;
		File dir=new File("J:/CESUR/2º/DATOS/tema1");
		if (new File(dir+"/NUEVODIR").mkdir()) {
			System.out.println("Creado el directorio: "+dir);
		}
		File nuevoDir=new File(dir+"/NUEVODIR");
		//Creando los dos ficheros
		
		try {
			new File(nuevoDir, "fichero1.txt").createNewFile();
			new File(nuevoDir, "fichero2.txt").createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// Renombrando un fichero

			File archivo1=new File(nuevoDir+"/fichero1.txt");
			archivo1.renameTo(new File(nuevoDir+"/archivoNuevo.txt"));
			System.out.println("Archivo1 reenombrado");
		
		
		// Borrando un fichero
		File archivo2=new File(nuevoDir+"/fichero2.txt");
		archivo2.delete();
		System.out.println("Archivo2 borrado");
	}
}