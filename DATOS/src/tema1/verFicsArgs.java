package tema1;
import java.io.*;
public class verFicsArgs {
	public static void main(String[] args) {
		File dir=new File(args[0]);
		String [] archivos=dir.list();
		System.out.println("Ficheros del directorio:");
		if(dir.exists()) {
			for (int i = 0; i < archivos.length; i++) {
				System.out.println(archivos[i]);
			}
		}
		else System.out.println("El directorio no existe.");
	}
}