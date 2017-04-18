package GandF.MyGF.business;

import java.io.FileNotFoundException;
import java.io.IOException;

import GandF.MyGF.integracion.DAOEstablecimientoImp;
import  GandF.MyGF.integracion.TEstablecimiento;

public class SAEstablecimiento {
	//0 creado y activado
	//1 activado
	//2 error, ya ha sido activado
	
	/**
	 * Da de alta a un nuevo establecimiento
	 * @param tE: Establecimiento que se va a dar de alta
	 * @return resultado de la ejecución del método. 0 creado y activado, 1 activado, 2 error, ya ha sido activado
	 * @throws IOException: No se encuentra el archivo 
	 */
	public int darDeAlta(TEstablecimiento tE) throws IOException{
				
		DAOEstablecimientoImp daoe = new DAOEstablecimientoImp();
		TEstablecimiento tEAux = daoe.leer(tE.getNombre(), tE.getDireccion());
		 
		if(tEAux == null){
			tE.setActivo(true);
			tE.setId(daoe.siguienteIdAux());
			daoe.insertar(tE);
			return 0;
		}
		else{
			if(tEAux.getActivo()) return 2;
			else{
				
				daoe.actualizaActivo(tEAux.getId(), true);
				return 1;
			}
		}
		
	}
	
	
	
}
