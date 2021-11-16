package tema1;
import java.io.*;
public class verEspacio {

	public static void main(String[] args) throws IOException {
		File dir=new File(".");
		new File(dir, "fichero1.txt").createNewFile();
		File archivo=new File(".", "/fichero1.txt");
		File particion=archivo.getParentFile();
		System.out.println("Espacio libre de la particion donde esta "+archivo.getName()+": "+((((archivo.getFreeSpace()/1024))/1024)/1024)+" GB");
		System.out.println("Espacio total de la particion donde esta "+archivo.getName()+": "+((((archivo.getTotalSpace()/1024))/1024)/1024)+" GB");
		System.out.println("Espacio usable de la particion donde esta "+archivo.getName()+": "+((((archivo.getUsableSpace()/1024))/1024)/1024)+" GB");
	}

}