package GandF.MyGF.integracion;

public enum TipoAlimento {
	BEBIDAS ("BEBIDAS"),
	BOLLERIA("BOLLERIA"),
	DULCES("DULCES"),
	CONGELADOS("CONGELADOS"),
	SNACKS("SNACKS"),
	A_FRESCOS("A_FRESCOS"),
	VERDURAS("VERDURAS"),
	FRUTAS("FRUTAS");
	
	private final String nombre; 
	
	private TipoAlimento(String nombre){
		this.nombre = nombre;
	}
	
	public String toString(){
		return this.nombre;
	}
	
	public static TipoAlimento stringToEnum(String tipo){
		boolean encontrado = false;
		int i = 0;
		TipoAlimento[] alimentos =  TipoAlimento.values();
		TipoAlimento alimento = null;
		
		while(i < alimentos.length && !encontrado){
			if (alimentos[i].toString().equalsIgnoreCase(tipo)) {
				encontrado = true;
				alimento = alimentos[i];
			}
			else i++;
		}
		return alimento;
	}
}
