package clases;

public class ContactosAgenda {

	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String movil;
	private String dni; 
	private String direccion;
    
	
	public ContactosAgenda(){
    	
    }    
	
	//constructor con dos atributos
    public ContactosAgenda(String dni, String nombre) {
    	this.dni = dni;
    	this.nombre = nombre;    		
	}

    //constructor con cuatro parametros
    public ContactosAgenda(String dni, String nombre, String apellido1, String apellido2){
    	this.nombre = nombre;
    	this.apellido1 = apellido1;
    	this.apellido2 = apellido2;
    	this.dni = dni;
    }
    
    //constructor con todos los atibutos
    public ContactosAgenda(String nombre, String apellido1, String apellido2, String dni, String movil, String direccion){
    	this.nombre = nombre;
    	this.apellido1 = apellido1;
    	this.apellido2 = apellido2;
    	this.dni = dni;
    	this.movil = movil;
    	this.direccion = direccion;
    }


	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
