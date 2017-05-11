package GandF.MyGF.business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import GandF.MyGF.integracion.DAOGasolina;
import GandF.MyGF.integracion.TGasolina;
import GandF.MyGF.integracion.factorias.FactoriaIntegracion;

public class SAGasolina {
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
		public int darDeAlta(TGasolina tGas) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();

			TGasolina tGAux = daoG.leerPorNombre(tGas.getNombre());
			 
			if(tGAux == null){
				tGas.setActivo(true);
				tGas.setId(daoG.siguienteIdAux());
				daoG.insertar(tGas);
				return 0;
			}
			else{
				if(tGAux.getActivo()) return 2;
				else{
					//le pasamos el tipo y el activo.
					daoG.modificar(tGAux.getId(), true, tGas.getTipo());
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
		public int actualizarAlimento(TGasolina tGas, String nombre) throws IOException{
			/**0: no modificado 1: modificado*/
			/**CREAMOS EL DAO*/
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIRECCION DEL ESTABLECIMIENTO*/
			//TEstablecimiento tEAux = daoe.leer(nombre, dir);
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIR DEL ESTABLECIMIENTO A MODIFICAR*/
			TGasolina tGaux = daoG.leerPorId(tGas.getId());
			 /**SI NO EXISTE NO SE MODIFICA O SI EXISTE EL QUE HAY QUE MODIFICAR NO SE MODIFICA*/
			if(tGaux == null){  //si no existe no se modifica
				return 0;
			}
			else{
				/**no modificamos el id del establecimiento*/
				//tE.setId(tEAux.getId());
				return daoG.modificar(tGaux.getId(), tGas.getActivo(), tGas.getTipo()); /**modificamos*/
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
			
					
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();			
			TGasolina tGaux = daoG.leerPorId(id);
					
				if(null == tGaux){
					return 0;
				}
				else{
					if(tGaux.getActivo()){ 
						daoG.modificar(id, false, tGaux.getTipo());
						return 1;
						}
					else{
						return 2;
					}
				}
		}
		
		public List<TGasolina> leerTodo() throws FileNotFoundException{
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();		
			return daoG.readAll();
		}
		
		
		
		public TGasolina leerID(TGasolina tGas) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOGasolina daoG = fact.getDAOGasolina();
			TGasolina tGaux  = daoG.leerPorId(tGas.getId());
			if (tGaux == null) return null;
			else return tGaux;
		}
}
