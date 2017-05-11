package GandF.MyGF.business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import GandF.MyGF.integracion.DAOAlimento;
import GandF.MyGF.integracion.TAlimento;
import GandF.MyGF.integracion.factorias.FactoriaIntegracion;

public class SAAlimento {
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
		public int darDeAlta(TAlimento tAlim) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();

			TAlimento tAAux = daoA.leerPorNombre(tAlim.getNombre());
			 
			if(tAAux == null){
				tAlim.setActivo(true);
				tAlim.setId(daoA.siguienteIdAux());
				daoA.insertar(tAlim);
				return 0;
			}
			else{
				if(tAAux.getActivo()) return 2;
				else{
					//le pasamos el tipo y el activo.
					daoA.modificar(tAAux.getId(), true, tAlim.getTipo());
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
		public int actualizarAlimento(TAlimento tAlim, String nombre) throws IOException{
			/**0: no modificado 1: modificado*/
			/**CREAMOS EL DAO*/
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIRECCION DEL ESTABLECIMIENTO*/
			//TEstablecimiento tEAux = daoe.leer(nombre, dir);
			/**BUSCAMOS EN EL ARCHIVO EL NOMBRE Y LA DIR DEL ESTABLECIMIENTO A MODIFICAR*/
			TAlimento tAaux = daoA.leerPorId(tAlim.getId());
			 /**SI NO EXISTE NO SE MODIFICA O SI EXISTE EL QUE HAY QUE MODIFICAR NO SE MODIFICA*/
			if(tAaux == null){  //si no existe no se modifica
				return 0;
			}
			else{
				/**no modificamos el id del establecimiento*/
				//tE.setId(tEAux.getId());
				return daoA.modificar(tAaux.getId(), tAlim.getActivo(), tAlim.getTipo()); /**modificamos*/
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
			DAOAlimento daoA = fact.getDAOAlimento();			
			TAlimento tAaux = daoA.leerPorId(id);
					
				if(null == tAaux){
					return 0;
				}
				else{
					if(tAaux.getActivo()){ 
						daoA.modificar(id, false, tAaux.getTipo());
						return 1;
						}
					else{
						return 2;
					}
				}
		}
		
		public List<TAlimento> leerTodo() throws FileNotFoundException{
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();		
			return daoA.readAll();
		}
		
		
		
		public TAlimento leerID(TAlimento tAlim) throws IOException{
			
			FactoriaIntegracion fact = FactoriaIntegracion.getInstance();
			DAOAlimento daoA = fact.getDAOAlimento();
			TAlimento tAaux  = daoA.leerPorId(tAlim.getId());
			if (tAaux == null) return null;
			else return tAaux;
		}
}
