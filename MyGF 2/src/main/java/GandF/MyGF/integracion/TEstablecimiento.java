package GandF.MyGF.integracion;


public class TEstablecimiento {
	private String id;
	private String nombre;
	private String tipo;
	private String direccion;
	private int CP;
	private boolean activo;
	
	public TEstablecimiento(){
		this.id = "";
		this.nombre = "";
		this.tipo = "";
		this.direccion = "";
		this.CP = 0;
		this.activo = false;
	}
	public TEstablecimiento(String id, String nombre, String direccion, int CP, boolean activo, String tipo){
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.direccion = direccion;
		this.CP = CP;
		this.activo = activo;
	}

	
	public String getId(){
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getCP() {
		return CP;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCP(int cp) {
		this.CP = cp;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
