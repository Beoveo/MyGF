package GandF.MyGF.integracion;

public enum TipoGasolina {
	DIESEL("DIESEL"),
	GASOLINA("GASOLINA"),
	BIOGASOLINA("BIOGASOLINA");
	
	private final String nombre; 
	
	private TipoGasolina(String nombre){
		this.nombre = nombre;
	}
	
	public String toString(){
		return this.nombre;
	}
	
	public static TipoGasolina stringToEnum(String tipo){
		boolean encontrado = false;
		int i = 0;
		TipoGasolina[] gasolinas =  TipoGasolina.values();
		TipoGasolina gasolina = null;
		
		while(i < gasolinas.length && !encontrado){
			if (gasolinas[i].toString().equalsIgnoreCase(tipo)) {
				encontrado = true;
				gasolina = gasolinas[i];
			}
			else i++;
		}
		return gasolina;
	}
}
