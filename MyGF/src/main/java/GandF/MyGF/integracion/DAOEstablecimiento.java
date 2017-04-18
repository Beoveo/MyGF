package GandF.MyGF.integracion;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface DAOEstablecimiento {

	public void insertar(TEstablecimiento TEstablecimiento) throws IOException;
	public TEstablecimiento leer (String nombre, String dir) throws FileNotFoundException;
	public int update (int id);
	public int update (String Nombre, String dir);
	public int remove (int id);
	public int remove (String Nombre);
	public void actualizaActivo(String id, boolean act) throws IOException;
	
}
