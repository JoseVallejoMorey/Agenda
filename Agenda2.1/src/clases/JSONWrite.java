package clases;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class JSONWrite {

	public static void main(String[] args) {

	}
  
  
  	public static void JsonParse(ContactosAgenda list[]){

  		JSONObject obj = new JSONObject();
		JSONObject innerObj = new JSONObject();

		for(int i = 0; i<100;i++){
			if(list[i] != null){
				innerObj.put("Dni",list[i].getDni());
				innerObj.put("Nombre",list[i].getNombre());
				innerObj.put("Apellido1",list[i].getApellido1());
				innerObj.put("Apellido2",list[i].getApellido2());
			}
			
		}
		
		obj.put("Contacto",innerObj);

		try {

			FileWriter file = new FileWriter("prueba.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
			System.out.print("se crea bien parece");
		} catch (IOException e) {
			//manejar error
			System.out.print(e);
		}

		System.out.print(obj);	
  	}

}