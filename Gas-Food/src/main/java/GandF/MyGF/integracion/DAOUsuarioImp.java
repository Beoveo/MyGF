package GandF.MyGF.integracion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOUsuarioImp implements DAOUsuario{

	@Override
	public void insertar(TUsuario TUsuario) throws IOException {
		File archivo = new File("Usuarios.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true)); //sin el parametro true borraba lo que habia antes en el txt
		 
		if(archivo.exists()) {
		
			writer.write(TUsuario.getId());
			writer.write(" ");
			writer.write(TUsuario.getNombre());
			writer.write(" ");
			writer.write(TUsuario.getEmail());
			writer.write(" ");
			writer.write(TUsuario.getUsuario());
			writer.write(" ");
			writer.write(TUsuario.getContraseña());
			writer.write(" ");
			writer.newLine();
		} 
		writer.close();
	}

	@Override
	public TUsuario leer(String id) throws FileNotFoundException {
Scanner sc = new Scanner(new File("Usuarios.txt"));
		
		String usuario;
		String usuarioArray[];
		TUsuario TUsu  = null;
		boolean encontrado = false, act;
		
		while(sc.hasNext() && !encontrado){
			
			usuario = sc.nextLine();
			
			usuarioArray = usuario.split(" ");
			/**si el id del usuario recibido por parametro coincide con el del archivo*/
			if(usuarioArray[0].equalsIgnoreCase(id)){
				encontrado = true;
				TUsu = new TUsuario(usuarioArray[0], usuarioArray[1], usuarioArray[2], usuarioArray[3], usuarioArray[4]);
			}
			
			
		}
		
		sc.close();
		return  TUsu;
	}

	@Override
	public TUsuario leer(String usuario, String contraseña)
			throws FileNotFoundException {
Scanner sc = new Scanner(new File("Usuarios.txt"));
		
		String  nick;
		String estabArray[];
		TUsuario TUsu  = null;
		boolean encontrado = false;
		
		while(sc.hasNext() && !encontrado){
			
			nick = sc.nextLine();
			
			estabArray = nick.split(" ");
			/**si el nombre del establecimiento y la direccion coinciden con los recibidos por parametros crea
			 * un tEstalecimiento*/
			if(estabArray[4].equalsIgnoreCase(usuario) && estabArray[2].equalsIgnoreCase(contraseña)){
				
				encontrado = true;
				
				TUsu = new TUsuario(estabArray[0], estabArray[1], estabArray[2], estabArray[3], estabArray[4]);
			}
			
			
		}
		
		sc.close();
		return  TUsu;
	}

	@Override
	public int modificar(String id, String contraseña) throws IOException {
		String datos;
		String usuarioArray[];
		int ret = 0;
		
		File archivo = new File("Usuarios.txt");
		archivo.renameTo(new File("UsuariosAux.txt"));
		File archivoViejo = new File("UsuariosAux.txt");			
		Scanner sc = new Scanner(archivoViejo);  
		
		while(sc.hasNext()){
			
			
			datos = sc.nextLine();
			
			usuarioArray = datos.split(" ");
			
			if(usuarioArray[0].equalsIgnoreCase(id)){
				/**si encuentro el usuario a modificar -> modifico*/
				TUsuario TUsu = new TUsuario(id, usuarioArray[1],
						usuarioArray[2], usuarioArray[3], contraseña);
				insertar(TUsu);/**inserto*/
				ret = 1;/**nos indica que se ha modificado el archivo*/
				
			}else {
				TUsuario TUsu = new TUsuario(id, usuarioArray[1],
						usuarioArray[2], usuarioArray[3], usuarioArray[4]);
				insertar(TUsu);/**inserto*/
			}
		}	
		
		sc.close();
		archivoViejo.delete();
		return ret;
	}

	@Override
	public List<TUsuario> readAll() throws FileNotFoundException {
		List<TUsuario> usuarios = new ArrayList<TUsuario>();
		
		String usuario;
		String usuArray[];
		TUsuario TUsu  = null;
		boolean act;
		
		Scanner sc = new Scanner(new File("Usuarios.txt"));
		//Falta el throw
		while(sc.hasNext()){
			
			usuario = sc.nextLine();
			usuArray = usuario.split(" ");
			TUsu = new TUsuario(usuArray[0], usuArray[1], usuArray[2], usuArray[3], usuArray[4]);
			usuarios.add(TUsu);
		}

		
		sc.close();
		return usuarios;
	}

	@Override
	public String siguienteIdAux() throws FileNotFoundException {
		String idFinal = " ";
		 String linea;
		 String usuArray[];
	     
	     Scanner sc = new Scanner(new File("Usuarios.txt")); 
	     
	     while(sc.hasNext()) {
	           //para quedarnos con el idFinal, los lee todos y al salir se queda con el ultimo id.
	    	 linea = sc.nextLine();
	    	 usuArray = linea.split(" ");
	    	 idFinal = usuArray[0];	
	     }
	    sc.close();
	        
		int id = Integer.parseInt(idFinal) + 1;
		String idNuevo = Integer.toString(id);
		
		return idNuevo;
	}

}
