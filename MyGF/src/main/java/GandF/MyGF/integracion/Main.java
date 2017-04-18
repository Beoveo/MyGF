package GandF.MyGF.integracion;

import java.io.IOException;

import GandF.MyGF.business.SAEstablecimiento;

public class Main {
	private static DAOEstablecimientoImp estab = new DAOEstablecimientoImp();
	private static SAEstablecimiento est = new SAEstablecimiento();
	
	public static void main(String... args) throws IOException{
		
		//TEstablecimiento tEstab = new TEstablecimiento(estab.siguienteIdAux("Establecimientos.txt"), "hiber", "jepeto" , 23456, false, "Y");
		//TEstablecimiento tEstab = new TEstablecimiento("89", "hiber", "jepeto" , 23456, false, "Y");
		TEstablecimiento tEstab = new TEstablecimiento("89", "efgop", "jepeto" , 20006, false, "Z");

		est.darDeAlta(tEstab);
		//estab.insertar(tEstab);
		//estab.actualizaActivo("2", false);
		//estab.leer("mercadona", "brisas");
	}
}
