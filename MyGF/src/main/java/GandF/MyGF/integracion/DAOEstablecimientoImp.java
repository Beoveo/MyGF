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
	
	public void actualizaActivo(String id, boolean activo) throws IOException{
		String datos;
		String estabArray[];
		int actAux = 0;
		boolean act = false;
		
		File archivo = new File("Establecimientos.txt");
		archivo.renameTo(new File("EstablecimientoAux.txt"));
		File archivoViejo = new File("EstablecimientoAux.txt");
		File archivoAux = new File("Establecimientos.txt");
		
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
				TEstablecimiento tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2] , 
						Integer.parseInt(estabArray[3]), act, estabArray[5]);
				insertar(tEstab);
			}
		}	
		
		sc.close();
		archivoViejo.delete();
	}
			
			
	

	
	public TEstablecimiento read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public TEstablecimiento leer(String nombre, String dir) throws FileNotFoundException {
		//accedemos al fichero
		Scanner sc = new Scanner(new File("Establecimientos.txt"));
		
		String n, d, establecimiento;
		String estabArray[];
		TEstablecimiento tEstab  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			establecimiento = sc.nextLine();
			estabArray = establecimiento.split(" ");
			if(estabArray[1].equalsIgnoreCase(nombre) && estabArray[2].equalsIgnoreCase(dir)){
				encontrado = true;
				if(estabArray[4].equalsIgnoreCase("1")) act = true;
				else act = false;
				tEstab = new TEstablecimiento(estabArray[0], estabArray[1], estabArray[2], Integer.parseInt(estabArray[3]), act,
						estabArray[5]);
		}
			
			
		}
		
		sc.close();
		return  tEstab;
	}
	
	

	
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int remove(String Nombre) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public int update(String Nombre, String dir) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TEstablecimiento read(String nombre, String dir)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
