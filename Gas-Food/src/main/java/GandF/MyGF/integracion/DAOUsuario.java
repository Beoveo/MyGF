package GandF.MyGF.integracion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public interface DAOUsuario {

	public void insertar(TUsuario TUsuario) throws IOException;
	public TUsuario leer (String id) throws FileNotFoundException;
	public TUsuario leer (String usuario, String contraseña) throws FileNotFoundException;
	public int modificar(String id, String contraseña) throws IOException;
	//public void actualizaActivo(String id, boolean act) throws IOException;
	public List<TUsuario> readAll() throws FileNotFoundException;
	public String siguienteIdAux() throws FileNotFoundException;
	
}
