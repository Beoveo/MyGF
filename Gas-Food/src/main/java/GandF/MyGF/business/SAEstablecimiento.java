package GandF.MyGF.business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import GandF.MyGF.integracion.DAOEstablecimiento;
import GandF.MyGF.integracion.TEstablecimiento;
import GandF.MyGF.integracion.factorias.FactoriaIntegracion;

public class SAEstablecimiento {
	
/**
 * Metodo que da de alta un establecimiento. Se le pasa como parametro un TEstablecimiento, primero se comprueba si ya
 * existe el establecimiento que queremos dar de alta. Si no existe ya, se cambia a ACTIVO el nuevo establecimiento y se le
 * proporciona el siguiente ID. Despues se inserta en el fichero.
 * 
 * En el caso de que ya exista en el fichero, solo se comprobara si ya esta ACTIVO, si no lo esta lo actualiza.
 * @param tE: Nuevo objeto del establecimiento a dar de alta.
 * @return 0: si se ha creado y esta activado.
 * 1: si esta activado.
 * 2: Error, ya ha sido activado anteriormente.
 * @throws IOException: Excepcion lanzada en caso de que no se pueda leer de fichero.
 */
	public int darDeAlta(TEstablecimiento tE) throws IOException{
		
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();

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
				//le pasamos el tipo y el activo.
				daoe.modificar(tEAux.getId(), true, tE.getTipo());
				return 1;
			}
		}
		
	}
/**
 * Actualizamos un tEstablecimiento comprobando que ya exista y sobreescribiendo el anterior
 * no se modifica el id.
 * @param tE
 * @param nombre
 * @param dir
 * @return
 * @throws IOException
 */
	public int actualizarEstablecimiento(TEstablecimiento tE, String nombre, String dir) throws IOException{
		/**0: no modificado 1: modificado*/
		/**CREAMOS EL DAO*/
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();
		/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIRECCION DEL ESTABLECIMIENTO*/
		//TEstablecimiento tEAux = daoe.leer(nombre, dir);
		/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIR DEL ESTABLECIMIENTO A MODIFICAR*/
		TEstablecimiento tEAux = daoe.leer(tE.getId());
		 /**SI NO EXISTE NO SE MODIFICA O SI EXISTE EL QUE HAY QUE MODIFICAR NO SE MODIFICA*/
		if(tEAux == null){  //si no existe no se modifica
			return 0;
		}
		else{
			/**no modificamos el id del establecimiento*/
			//tE.setId(tEAux.getId());
			return daoe.modificar(tEAux.getId(), tE.getActivo(), tE.getTipo()); /**modificamos*/
			}
		}
/**
 * Metodo que realiza las mismas acciones que el metodo anterior darDeAlta(), la unica diferencia es que en 
 * este caso cambia el boolean activo a FALSE. Desactiva el establecimiento.
 * @param tE: Establecimiento a dar de baja.
 * @return 0: si se ha creado y esta activado.
 * 1: si esta activado.
 * 2: Error, ya ha sido activado anteriormente.
 * @throws IOException
 */
	public int darDeBaja(String id) throws IOException{
		TEstablecimiento tEAux;
				
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();				
				tEAux = daoe.leer(id);
				
				if(null == tEAux){
					return 0;
				}
				else{
					if(tEAux.getActivo()){ 
						daoe.modificar(id, false, tEAux.getTipo());
						return 1;
						}
					else{
						return 2;
					}
				}
			}
	
	public List<TEstablecimiento> leerTodo() throws FileNotFoundException{
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();		
		return daoe.readAll();
	}
	
	
	
	public TEstablecimiento leerID(TEstablecimiento tE) throws IOException{
		TEstablecimiento tEAux;
		
		FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
		DAOEstablecimiento daoe = fact.getDAOEstablecimiento();
		tEAux = daoe.leer(tE.getId());
		if (tEAux == null) return null;
		else return tEAux;
	}
}
