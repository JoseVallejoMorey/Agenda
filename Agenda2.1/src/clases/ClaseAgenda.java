package clases;

import java.util.Scanner;




public class ClaseAgenda {
	
	public static int instruccion;
	
    public static Scanner sc;
    public static ContactosAgenda[] agendaList = new ContactosAgenda[100];
    public static ContactosAgenda agenda = new ContactosAgenda();
	
    
    public static void main(String[] args) {
		    	
    	//creo uno de entrada
    	agendaList[0] = new ContactosAgenda("777","juan","perez","lopez");
    	
    	
    	
    	while(instruccion == 0){
    		System.out.println("¿Que quieres hacer?");	
    		System.out.println("1: Añadir contacto.");
    		System.out.println("2: Buscar contacto.");
    		System.out.println("3: Eliminar contacto.");
    		System.out.println("4: Mostrar todos.");
    		System.out.println("5: Generar XML.");
    		System.out.println("6: Generar JSON.");
    		sc= new Scanner(System.in);
    		instruccion = sc.nextInt();
    		
    		switch(instruccion){
    		case 1: ClaseAgenda.annadirContacto(); 	break;
    		case 2: ClaseAgenda.buscar();			break;
    		case 3: ClaseAgenda.borrar(); 			break;
    		case 4: ClaseAgenda.showAll(); 			break;
    		case 5: ClaseAgenda.generate(); 		break;
    		case 6: ClaseAgenda.generateJson(); 	break;
    		default: instruccion = 0; 				break;
    		}	
    	}
	
    }

    
    
    public static void annadirContacto(){
    	
    	
    	sc = new Scanner(System.in);
		System.out.println("inrocuce un nombre");		
		agenda.setNombre(sc.nextLine());
		System.out.println("inrocuce primer apellido");		
		agenda.setApellido1(sc.nextLine());
		System.out.println("inrocuce segundo apellido");		
		agenda.setApellido2(sc.nextLine());
//		System.out.println("inrocuce un telefono movil");		
//		agenda.movil = sc.nextLine();
//		System.out.println("inrocuce una direccion");		
//		agenda.direccion = sc.nextLine();
		System.out.println("inrocuce un DNI");		
		agenda.setDni(sc.nextLine());
    	
    	
    	
    	
		if(agendaList[99] == null){

			for(int i = 0; i<100; i++){
				if(agendaList[i] == null){
					System.out.println("se asigna un array( i vale "+i+" )");
					agendaList[i] = new ContactosAgenda(agenda.getDni(),
														agenda.getNombre(),
														agenda.getApellido1(),
														agenda.getApellido2());

					System.out.println("Dato Guardado");
					break;
				}
			}			
			
		}else{
			System.out.println("Matriz esta llena");
		}
		instruccion = 0;
    }
    
    
    
    public static void buscar(){
    	
    	System.out.println("inrocuce un DNI para BUSCAR");	
    	sc= new Scanner(System.in);
		agenda.setDni(sc.nextLine());
		
    	boolean existe = false;
    	for(int i = 0; i<100; i++){
    		
    		if(agendaList[i] != null && agendaList[i].getDni().equals(agenda.getDni())){
    			existe = true;
    			System.out.println("Contacto: "+agendaList[i].getDni()+" | "
    										   +agendaList[i].getNombre() +" | "
    										   +agendaList[i].getApellido1()+" | "
    										   +agendaList[i].getApellido2());
    			break;
    		}
    	}
    	
    	if(existe == false){
    		System.out.println("No existe usuario con ese dni");
    	}
    	instruccion = 0;
    }
    

    
    public static void borrar(){
    	
    	System.out.println("inrocuce un DNI para BORRAR");
    	sc= new Scanner(System.in);
		agenda.setDni(sc.nextLine());    	
    	
    	boolean existe = false;
    	for(int i = 0; i<100; i++){
    		if(agendaList[i] != null && agendaList[i].getDni().equals(agenda.getDni())){
    			//este bucle vaciara el array de ese usuario
    			System.out.println("se borra ( i vale "+i+" )");
    			agendaList[i] = null;
    			
    			existe = true;
    			break;
    		}
    	}
    	
    	if(existe == false){
    		System.out.println("No existe usuario con ese dni");
    	}
    	instruccion = 0;
    }
    
    
    
    public static void showAll(){
    	for(int i = 0; i<100;i++){
    		if(agendaList[i] != null){
    			System.out.println("Contacto: "+agendaList[i].getDni()+" | "
						   +agendaList[i].getNombre() +" | "
						   +agendaList[i].getApellido1()+" | "
						   +agendaList[i].getApellido2());	
    		}
    	}
    	instruccion = 0;
    }
    
    

    
    
    
    
    
    public static void generate(){
    	try {
			XmlParse.generateXml(agendaList);
			System.out.println("XML Generado con exito");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	instruccion = 0;
    }
    
    
    public static void generateJson(){
    	
    	try{
    		JSONWrite.JsonParse(agendaList);
    		System.out.println("JSON Generado con exito");
    	}catch (Exception e){
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	instruccion = 0;
    }
    
    
    
    
    
}
