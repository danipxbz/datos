package XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ejemplo2 {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document document=builder.parse(new File("Empleados.xml"));
			document.getDocumentElement().normalize();
			System.out.println("Elemento raiz: "+document.getDocumentElement().getNodeName());
			NodeList empleados=document.getElementsByTagName("empleado");
			System.out.println("Nodos empleado a recorrer: "+empleados.getLength());
			
			for (int i = 0; i < empleados.getLength(); i++) {
				Node emple=empleados.item(i);
				if (emple.getNodeType()==Node.ELEMENT_NODE) {
					Element elemento=(Element) emple;
					System.out.printf("ID = %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.printf(" - Apellido = %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.printf(" - Departamento = %s %n", elemento.getElementsByTagName("dep").item(0).getTextContent());
					System.out.printf(" - Salario = %s %n", elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
