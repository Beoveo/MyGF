package GandF.MyGF.integracion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DAOEstablecimientoImp  implements DAOEstablecimiento{

	//id nombre dir cp activo tipo
	//0  1      2    3   4     5
	/**
	 * Metodo que introduce el establecimiento ,que se pasa como parametro , dentro del fichero "Establecimientos.txt".
	 * Comprueba que el archivo exista y si existe escribe cada dato del establecimiento dentro del fichero.
	 */
	public void insertar(TEstablecimiento TEstablecimiento) throws IOException {
		File archivo = new File("Establecimientos.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		String activo = "0"; 
		 
		if(archivo.exists()) {
		
			writer.write(TEstablecimiento.getId());
			writer.write(" ");
			writer.write(TEstablecimiento.getNombre());
			writer.write(" ");
			writer.write(TEstablecimiento.getDireccion());
			writer.write(" ");
			String cp = Integer.toString(TEstablecimiento.getCP());
			writer.write(cp);
			writer.write(" ");
			if(TEstablecimiento.getActivo()) activo = "1";
			writer.write(activo);
			writer.write(" ");
			writer.write(TEstablecimiento.getTipo());
			writer.newLine();
		} 
		writer.close();
	}
	
	/**
	 * Metodo que comprueba cual es el ultimo ID del fichero y que calcula el siguiente ID a partir de este.
	 * Lo devuelve como un String para escribirlo directamente.
	 * @return El siguiente ID de tipo string.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String siguienteIdAux() throws FileNotFoundException, IOException{
		 String idFinal = " ";
		 String linea;
		 String estabArray[];
	     
	     Scanner sc = new Scanner(new File("Establecimientos.txt")); 
	     
	     while(sc.hasNext()) {
	           //para quedarnos con el idFinal, los lee todos y al salir se queda con el ultimo id.
	    	 linea = sc.nextLine();
	    	 estabArray = linea.split(" ");
	    	 idFinal = estabArray[0];	
	     }
	    sc.close();
	        
		int id = Integer.parseInt(idFinal) + 1;
		String idNuevo = Integer.toString(id);
		
		return idNuevo;
	}
	
	/**
	 * Metodo que cambia el boolean activo de un establecimiento. Es decir, en caso de que se quiera dar de baja,
	 * el booleano se cambiara a FALSE y si se quiere dar de alta justo lo contrario.
	 * Recorre el archivo buscando el ID del establecimiento a modificar y cuando lo encuentra lo cambia y lo vuelve
	 * a insertar.
	 * Si el resto no tienen ese ID se insertan tal cual estan.
	 */
	public void actualizaActivo(String id, boolean activo) throws IOException{
		String datos;
		String estabArray[];
		int actAux;
		boolean act;
		
		File archivo = new File("Establecimientos.txt");
		archivo.renameTo(new File("EstablecimientoAux.txt"));
		File archivoViejo = new File("EstablecimientoAux.txt");
		
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			
			datos = sc.nextLine();
			
			estabArray = datos.split(" ");
			
			if(estabArray[0].equalsIgnoreCase(id)){
				
				TEstablecimiento tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2] , 
						Integer.parseInt(estabArray[3]), activo, estabArray[5]);
				insertar(tEstab);
				
			}else {
				actAux = Integer.parseInt(estabArray[4]);
				if(actAux == 1) act = true;
				else act = false;
				TEstablecimiento tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2] , 
						Integer.parseInt(estabArray[3]), act, estabArray[5]);
				insertar(tEstab);
			}
		}	
		
		sc.close();
		archivoViejo.delete();
	}
	/**
	 * lee los establecimientos del archivo hasta encontrar el que coincida con los parametros de entrada: <id>
	 * @param establecimiento
	 * @param estabArray
	 * @param encontrado
	 * @param actAux
	 * @param act
	 * @param sc
	 * @return
	 * @throws FileNotFoundException
	 */		
	
	public TEstablecimiento leer(int id) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("Establecimientos.txt"));
		
		String establecimiento;
		String estabArray[];
		TEstablecimiento tEstab  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			establecimiento = sc.nextLine();
			
			estabArray = establecimiento.split(" ");
			/**si el id del establecimento recibido por parametro coincide con el del archivo*/
			if(estabArray[0].equalsIgnoreCase(""+id)){
				
				encontrado = true;
				
				if(estabArray[4].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2], Integer.parseInt(estabArray[3]), act,
						estabArray[5]);
		}
			
			
		}
		
		sc.close();
		return  tEstab;
	}
	/**
	 * lee los establecimientos del archivo hasta encontrar el que coincida con los parametros de entrada: <nombre> <dir>
	 * @param establecimiento
	 * @param estabArray
	 * @param encontrado
	 * @param actAux
	 * @param act
	 * @param sc
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public TEstablecimiento leer(String nombre, String dir) throws FileNotFoundException {
		/**accedemos al fichero*/
		Scanner sc = new Scanner(new File("Establecimientos.txt"));
		
		String  establecimiento;
		String estabArray[];
		TEstablecimiento tEstab  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			establecimiento = sc.nextLine();
			
			estabArray = establecimiento.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(estabArray[1].equalsIgnoreCase(nombre) && estabArray[2].equalsIgnoreCase(dir)){
				
				encontrado = true;
				
				if(estabArray[4].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2], Integer.parseInt(estabArray[3]), act,
						estabArray[5]);
		}
			
			
		}
		
		sc.close();
		return  tEstab;
	}
	
/**
 * recibe un transfer a modificar comprueba de que exista entre los establecimientos del archivo 
 * si es el caso lo modifica
 * @param datos
 * @param estabArray
 * @param ret
 * @param actAux
 * @param act
 * @param archivo
 * @param sc
 * @param tEstab
 * @return
 * @throws IOException
 */
	public int actualizarEstablecimiento(TEstablecimiento tE) throws IOException{
			String datos;
			String estabArray[];
			int ret = 0;
			int actAux;
			boolean act;
			
			File archivo = new File("Establecimientos.txt");
			archivo.renameTo(new File("EstablecimientoAux.txt"));
			File archivoViejo = new File("EstablecimientoAux.txt");			
			Scanner sc = new Scanner(archivoViejo);  
			
			while(sc.hasNext()){
				
				
				datos = sc.nextLine();
				
				estabArray = datos.split(" ");
				
				if(estabArray[0].equalsIgnoreCase(tE.getId())){
					/**si encuentro el establecimiento a modificar -> modifico*/
					TEstablecimiento tEstab = new TEstablecimiento(tE.getId(), tE.getNombre(),
							tE.getDireccion(), tE.getCP(), tE.getActivo(), tE.getTipo());
					insertar(tEstab);/**inserto*/
					ret = 1;/**nos indica que se ha modificado el archivo*/
					
				}else {
					/**si no -> no modifico*/
					actAux = Integer.parseInt(estabArray[4]);
					if(actAux == 1) act = true;/**activo o no el establecimiento*/
					else act = false;
					TEstablecimiento tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2] , 
							Integer.parseInt(estabArray[3]), act, estabArray[5]);
					insertar(tEstab);/**inserto*/
				}
			}	
			
			sc.close();
			archivoViejo.delete();
			return ret;
		}

}
