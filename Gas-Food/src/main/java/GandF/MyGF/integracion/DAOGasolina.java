package GandF.MyGF.integracion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DAOGasolina {
	public void insertar(TGasolina tGasolina) throws IOException;
	public TGasolina leerPorId (String id) throws FileNotFoundException;
	public TGasolina leerPorNombre(String nombre) throws FileNotFoundException;
	public int modificar(String id, boolean activo, TipoGasolina tipo) throws IOException;
	public List<TGasolina> readAll() throws FileNotFoundException;
	public String siguienteIdAux() throws FileNotFoundException;
}
