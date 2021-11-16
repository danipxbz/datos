package tema1;
import java.io.*;
public class crearFicTemp {

	public static void main(String[] args) {
		File dir=new File(".");
		try {
			File archivoTemp=File.createTempFile("archivoTemporal", ".txt", dir);
			// Para eliminar un archivo cuando se termine de ejecutar el codigo  
			// archivoTemp.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}