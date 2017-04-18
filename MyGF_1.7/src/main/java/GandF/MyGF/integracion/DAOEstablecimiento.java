package GandF.MyGF.integracion;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface DAOEstablecimiento {

	public void insertar(TEstablecimiento TEstablecimiento) throws IOException;
	public TEstablecimiento leer (int id) throws FileNotFoundException;
	public TEstablecimiento leer (String nombre, String dir) throws FileNotFoundException;
	public int actualizarEstablecimiento (TEstablecimiento tE) throws IOException;
	public void actualizaActivo(String id, boolean act) throws IOException;
	
}
