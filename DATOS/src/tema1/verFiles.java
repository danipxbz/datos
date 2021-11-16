package tema1;

import java.io.*;

public class verFiles {
	public static void main(String[] args) {
		File dir=new File(".");
		File [] archivos=dir.listFiles();
		System.out.println("Ficheros del directorio:");
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
		}
	}
}