package tema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej5Flujo1 {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduce el nombre del archivo: "); String archivo=sc.next();
		String [] palabras=new String[3];
		
		System.out.println("Introduce las palabras: "); palabras[0]=sc.next();
														palabras[1]=sc.next();
														palabras[2]=sc.next();
		
		crearArchivo(palabras, archivo);
		
	}
	
	public static void crearArchivo(String [] palabras, String archivo) throws IOException {
		File file=new File(".", archivo+".txt");
		if (file.exists()==false) new File(".", archivo+".txt").createNewFile();
		BufferedWriter writer=new BufferedWriter(new FileWriter(file, true));
		
		for (int i = 0; i < palabras.length; i++) {
			writer.write(palabras[i]);
			writer.newLine();
		}
		writer.close();
		leerArchivo(file);
		
	}
	
	public static void leerArchivo(File archivo) throws IOException{
		BufferedReader reader=new BufferedReader(new FileReader(archivo));
		String linea;
		while ((linea=reader.readLine())!=null) {
			System.out.println(linea);
		}
		reader.close();
	}

}
