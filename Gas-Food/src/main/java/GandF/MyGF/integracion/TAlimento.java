package GandF.MyGF.integracion;

public class TAlimento {
	private String id;
	private String nombre;
	private TipoAlimento tipo;
	private boolean activo;
	
	public TAlimento(){
		this.id = "";
		this.nombre = "";
		this.activo = false;
		this.tipo = null;
	}
	public TAlimento(String id, String nombre, boolean activo, TipoAlimento tipo){
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.tipo = tipo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoAlimento getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoAlimento tipo) {
		this.tipo = tipo;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
