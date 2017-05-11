package GandF.MyGF.integracion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DAOAlimento {
	public void insertar(TAlimento tAlimento) throws IOException;
	public TAlimento leerPorId (String id) throws FileNotFoundException;
	public TAlimento leerPorNombre(String nombre) throws FileNotFoundException;
	public int modificar(String id, boolean activo, TipoAlimento tipo) throws IOException;
	public List<TAlimento> readAll() throws FileNotFoundException;
	public String siguienteIdAux() throws FileNotFoundException;
}
