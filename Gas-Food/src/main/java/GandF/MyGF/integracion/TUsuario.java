package GandF.MyGF.integracion;


public class TUsuario {
	private String nombre;
	private String contrase�a;
	private String id;
	private String usuario;
	private String email;
	
	public TUsuario(){
		this.nombre="";
		this.contrase�a="";
		this.id="";
		this.usuario="";
		this.email="";
	}
	public TUsuario(String nombre, String contrase�a, String id, String usuario, String email){
		this.nombre=nombre;
		this.contrase�a=contrase�a;
		this.id=id;
		this.usuario=usuario;
		this.email=email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
