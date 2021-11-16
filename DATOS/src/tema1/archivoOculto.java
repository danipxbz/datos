package tema1;
import java.io.*;
public class archivoOculto {
	public static void main(String[] args) {
		File archivo=new File("./archivoOculto.java");
		String estado;
		if (archivo.isHidden()) estado="esta oculto.";
		else estado=" no esta oculto.";
		System.out.println("El archivo "+archivo.getName()+estado);
	}
}