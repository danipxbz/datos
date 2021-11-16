package tema1;
import java.io.*;

public class verPermisos {

	public static void main(String[] args) {
		File archivo=new File("./verPermisos.java");
		System.out.println("El archivo "+archivo.getName()+" tiene los siguientes permisos:"
						+ "\nLectura: "+archivo.canRead()
						+ "\nEscritura: "+archivo.canWrite());
	}

}