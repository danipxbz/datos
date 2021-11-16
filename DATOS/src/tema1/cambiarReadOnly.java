package tema1;
import java.io.*;
public class cambiarReadOnly {

	public static void main(String[] args) {
		File archivo=new File("./fichero1.txt");
		
		archivo.setReadOnly();
		if (archivo.canWrite()!=true)
		System.out.println("El archivo "+archivo.getName()+" es ahora solo lectura.");
		else
			System.out.println("El archivo "+archivo.getName()+" se puede escribir.");

	}

}