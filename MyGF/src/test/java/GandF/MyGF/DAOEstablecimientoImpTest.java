package GandF.MyGF;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import GandF.MyGF.integracion.DAOEstablecimientoImp;
import GandF.MyGF.integracion.TEstablecimiento;

public class DAOEstablecimientoImpTest {

	private DAOEstablecimientoImp DAOE = new DAOEstablecimientoImp();

	private String id = "55";
	private String nombre = "nombre";
	private String direccion = "direccion";
	private int CP = 33333;
	private boolean activo = false;
	private String tipo = "G";

	private TEstablecimiento test = new TEstablecimiento(id, nombre, direccion,
			CP, activo, tipo);

	@Test
	public void compruebaSiguienteID() throws IOException {
		DAOE.insertar(test);
		assertEquals(Integer.parseInt(id) + 1, Integer.parseInt(DAOE.siguienteIdAux()));
	}

	@Test
	public void insertaLee() throws IOException {
		DAOE.insertar(test);
		TEstablecimiento tEstabAux = DAOE.leer(nombre, direccion);
		if (tEstabAux.equals(test))
			assertEquals(1, 1);
		else
			assertEquals(0, 1);
	}

}
