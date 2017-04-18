package GandF.MyGF.integracion;

import java.io.IOException;

import GandF.MyGF.business.SAEstablecimiento;

public class Main {
	private static DAOEstablecimientoImp estab = new DAOEstablecimientoImp();
	private static SAEstablecimiento est = new SAEstablecimiento();
	
	public static void main(String... args) throws IOException{
		SAEstablecimiento sae = new SAEstablecimiento();
		
		// Dar de alta
		TEstablecimiento tEstab = new TEstablecimiento("89", "hiber", "jepeto" , 23456, false, "Y");
		TEstablecimiento tEstab1 = new TEstablecimiento("89", "efgop", "jepeto" , 20006, true, "Z");
		

		est.darDeAlta(tEstab);
		est.darDeAlta(tEstab1);
		
		
		//modificar
		TEstablecimiento tE = new TEstablecimiento("4", "hiberrrrr", "jepeto", 23456, false, "YYYY");
		int ret = sae.actualizarEstablecimiento(tE, "hiber", "jepeto");
		
		est.darDeAlta(tE);
		
		//Eliminar
		est.darDeBaja(tE);
	}
}
