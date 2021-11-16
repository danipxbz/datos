package tema1;
import java.io.*;
public class verDirRaiz {

	public static void main(String[] args) {
		File dir=new File(".") ;
		System.out.println("Los directorios raiz son: ");
		for (int i = 0; i < dir.listRoots().length; i++) {
			System.out.println(dir.listRoots()[i]);
		}		
	}
}