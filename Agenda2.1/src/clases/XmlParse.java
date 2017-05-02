package clases;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class XmlParse {

	
	
    public static void generateXml(ContactosAgenda list[]) throws Exception{

		String name = "Contactos";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, name, null);
        document.setXmlVersion("1.0");

        //Main Node
        Element raiz = document.getDocumentElement();
        //Por cada key creamos un item que contendrá la key y el value
        for(int i=0; i<100;i++){
        	if(list[i] != null){
        		
                //Item Node
                Element itemNode = document.createElement("CONTACTO"); 
                
                //Dni Node
                Element dniNode = document.createElement("DNI"); 
                Text nodeDniValue = document.createTextNode(list[i].getDni());
                dniNode.appendChild(nodeDniValue);      
                  
                //Nombre node
                Element nombreNode = document.createElement("NOMBRE");
                Text nodeNombreValue = document.createTextNode(list[i].getNombre());
                nombreNode.appendChild(nodeNombreValue);
                
                //Value Apellido1
                Element ap1Node = document.createElement("APELLIDO1"); 
                Text nodeap1Value = document.createTextNode(list[i].getApellido1());                
                ap1Node.appendChild(nodeap1Value);                
                
                //Value Apellido2
                Element ap2Node = document.createElement("APELLIDO2"); 
                Text nodeap2Value = document.createTextNode(list[i].getApellido2());                
                ap2Node.appendChild(nodeap2Value);                
                
                
//                //Value Movil
//                Element movilNode = document.createElement("MOVIL"); 
//                Text nodeMovilValue = document.createTextNode(list[i].getMovil());                
//                movilNode.appendChild(nodeMovilValue);                
//                
//                
//                //Value Direccion
//                Element dirNode = document.createElement("VALUE"); 
//                Text nodeDirValue = document.createTextNode(list[i].getDireccion());                
//                dirNode.appendChild(nodeDirValue);
                
             
                //metiendo parametros a itemNode
                itemNode.appendChild(dniNode);
                itemNode.appendChild(nombreNode);
                itemNode.appendChild(ap1Node);
                itemNode.appendChild(ap2Node);
//                itemNode.appendChild(movilNode);
//                itemNode.appendChild(dirNode);
                //append itemNode to raiz
                raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"           		
        		
        	}
        	
        	

        }                
        //Generate XML
        Source source = new DOMSource(document);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new java.io.File(name+".xml")); //nombre del archivo
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    
    }
}
