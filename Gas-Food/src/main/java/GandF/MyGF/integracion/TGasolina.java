package GandF.MyGF.integracion;

public class TGasolina {
	private String id;
	private String nombre;
	private TipoGasolina tipo;
	private boolean activo;
	
	public TGasolina(){
		this.id = "";
		this.nombre = "";
		this.activo = false;
		this.tipo = null;
	}
	public TGasolina(String id, String nombre, boolean activo, TipoGasolina tipo){
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
	
	public TipoGasolina getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoGasolina tipo) {
		this.tipo = tipo;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
