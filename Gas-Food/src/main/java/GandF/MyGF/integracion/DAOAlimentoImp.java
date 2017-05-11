package GandF.MyGF.integracion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOAlimentoImp implements DAOAlimento {

	@Override
	public void insertar(TAlimento tAlimento) throws IOException {
		File archivo = new File("Alimento.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		String activo = "0"; 
		 
		if(archivo.exists()) {
		
			writer.write(tAlimento.getId());
			writer.write(" ");
			writer.write(tAlimento.getNombre());
			writer.write(" ");
			if(tAlimento.getActivo()) activo = "1";
			writer.write(activo);
			writer.write(" ");
			writer.write(tAlimento.getTipo().toString());
			writer.newLine();
		} 
		writer.close();
		
	}

	@Override
	public TAlimento leerPorId(String id) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Alimento.txt"));
		
		String alimento;
		String alimArray[];
		TAlimento tAlim  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			alimento = sc.nextLine();
			
			alimArray = alimento.split(" ");
			/**si el id del establecimento recibido por parametro coincide con el del archivo*/
			if(alimArray[0].equalsIgnoreCase(""+id)){
				
				encontrado = true;
				
				if(alimArray[2].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tAlim = new TAlimento(alimArray[0], alimArray[1], act, TipoAlimento.stringToEnum(alimArray[3]));
				//parseo de string a enum alimArray[3].
			}
			
		}
		
		sc.close();
		return  tAlim;
	}

	@Override
	public TAlimento leerPorNombre(String nombre) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Alimento.txt"));
		
		String alimento;
		String alimArray[];
		TAlimento tAlim  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			alimento = sc.nextLine();
			
			alimArray = alimento.split(" ");
			/**si el id del establecimento recibido por parametro coincide con el del archivo*/
			if(alimArray[1].equalsIgnoreCase(""+nombre)){
				
				encontrado = true;
				
				if(alimArray[2].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
				
				else act = false;/**si no creo @boolean a <false>*/
				
				tAlim = new TAlimento(alimArray[0], alimArray[1], act, TipoAlimento.stringToEnum(alimArray[3]));
				//parsero de string a enum alimArray[3].
			}
			
			
		}
		
		sc.close();
		return  tAlim;
	}

	@Override
	public int modificar(String id, boolean activo, TipoAlimento tipo)
			throws IOException {
		String datos;
		String alimArray[];
		int ret = 0;
		int actAux;
		boolean act;
		
		File archivo = new File("Alimento.txt");
		archivo.renameTo(new File("AlimentoAux.txt"));
		File archivoViejo = new File("AlimentoAux.txt");			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			
			datos = sc.nextLine();
			
			alimArray = datos.split(" ");
			
			if(alimArray[0].equalsIgnoreCase(id)){
				/**si encuentro el establecimiento a modificar -> modifico*/
				TAlimento tAlim = new TAlimento(id, alimArray[1], activo, tipo);
				insertar(tAlim);/**inserto*/
				ret = 1;/**nos indica que se ha modificado el archivo*/
				
			}else {
				/**si no -> no modifico*/
				actAux = Integer.parseInt(alimArray[2]);
				if(actAux == 1) act = true;/**activo o no el establecimiento*/
				else act = false;
				TAlimento tAlim = new TAlimento(alimArray[0], alimArray[1], act, TipoAlimento.stringToEnum(alimArray[3]));
				insertar(tAlim);/**inserto*/
			}
		}	
		
		sc.close();
		archivoViejo.delete();
		return ret;
	}

	@Override
	public List<TAlimento> readAll() throws FileNotFoundException {
		List<TAlimento> alimentos = new ArrayList<TAlimento>();
		
		String alimento;
		String alimArray[];
		TAlimento tAlim  = null;
		boolean act;
		
		Scanner sc = new Scanner(new File("Alimento.txt"));
		//Falta el throw
		while(sc.hasNext()){
			
			alimento = sc.nextLine();
			
			alimArray = alimento.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(alimArray[2].equalsIgnoreCase("1")) act = true;/**si esta activo creo el @boolean a <true>*/
			else act = false;/**si no creo @boolean a <false>*/
			
			tAlim = new TAlimento(alimArray[0], alimArray[1], act, TipoAlimento.stringToEnum(alimArray[3]));
			alimentos.add(tAlim);
		}

		sc.close();
		return  alimentos;
	}

	@Override
	public String siguienteIdAux() throws FileNotFoundException {
		 String idFinal = " ";
		 String linea;
		 String alimArray[];
	     
	     Scanner sc = new Scanner(new File("Alimento.txt")); 
	     
	     while(sc.hasNext()) {
	           //para quedarnos con el idFinal, los lee todos y al salir se queda con el ultimo id.
	    	 linea = sc.nextLine();
	    	 alimArray = linea.split(" ");
	    	 idFinal = alimArray[0];	
	     }
	    sc.close();
	        
		int id = Integer.parseInt(idFinal) + 1;
		String idNuevo = Integer.toString(id);
		
		return idNuevo;
	}

}
