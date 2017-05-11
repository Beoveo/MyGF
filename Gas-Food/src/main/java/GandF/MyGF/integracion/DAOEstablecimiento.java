package GandF.MyGF.integracion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public interface DAOEstablecimiento {

	public void insertar(TEstablecimiento TEstablecimiento) throws IOException;
	public TEstablecimiento leer (String id) throws FileNotFoundException;
	public TEstablecimiento leer (String nombre, String dir) throws FileNotFoundException;
	public int modificar(String id, boolean activo, String tipo) throws IOException;
	//public void actualizaActivo(String id, boolean act) throws IOException;
	public List<TEstablecimiento> readAll() throws FileNotFoundException;
	public String siguienteIdAux() throws FileNotFoundException;
	
}
