package GandF.MyGF.business;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import GandF.MyGF.business.SAEstablecimiento;
import GandF.MyGF.integracion.DAOEstablecimientoImp;
import GandF.MyGF.integracion.TEstablecimiento;

public class SAEstablecimientoTest {
	@Test
	public void testActualizarEstablecimiento() throws IOException {
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento("6", "hiberx", "jepeto",
				23756, true, "YXYY");
		sae.darDeAlta(tE);
		TEstablecimiento tE2 = new TEstablecimiento("6", "lolnombre", "fxdir",
				98765, false, "YXXY"); // nombre, direccion y cp no usados
		int ret = sae.actualizarEstablecimiento(tE2, "lolnombre", "fxdir");
		assertTrue(ret == 1);// Se ha actualizado

	}

	/**
	 * Caso en el que el establecimiento existe y esta activo
	 * */
	@Test
	public void testDarDeBaja1() throws IOException {
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento("6", "hiberrrrrr", "jepeto",
				23456, true, "YYYY");
		sae.darDeAlta(tE);
		int ret = sae.darDeBaja(tE.getId());
		assertTrue(ret == 1);
	}

	/**
	 * Caso en el que el establecimiento no existe
	 * */
	@Test
	public void testDarDeBaja0() throws IOException {
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento();
		int ret = sae.darDeBaja(tE.getId());
		assertTrue(ret == 0);
	}

	/**
	 * Caso en el que el establecimiento existe y no esta activo
	 * */
	@Test
	public void testDarDeBaja2() throws IOException {
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento("8", "hibex", "jepeto",
				23756, false, "XYYY");
		sae.darDeAlta(tE);
		sae.darDeBaja(tE.getId()); // lo desactivo primero una vez
		int ret = sae.darDeBaja(tE.getId());
		assertTrue(ret == 2);
	}

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
		SAEstablecimiento sae = new SAEstablecimiento();
		List<TEstablecimiento> lte = sae.leerTodo();
		TEstablecimiento te = lte.get(lte.size()-1);
		DAOEstablecimientoImp daoe = new DAOEstablecimientoImp();
		assertEquals(Integer.parseInt(te.getId()) + 1,
				Integer.parseInt(daoe.siguienteIdAux()));
	}

	@Test
	public void insertaLee() throws IOException {
		SAEstablecimiento sae = new SAEstablecimiento();
		sae.darDeAlta(test);
		sae.darDeBaja(test.getId());
		
		TEstablecimiento tEstabAux = sae.leerID(test);
		if (tEstabAux.getId().equals(test.getId())
				&& tEstabAux.getNombre().equals(test.getNombre())
				&& tEstabAux.getDireccion().equals(test.getDireccion())
				&& tEstabAux.getCP() == test.getCP()
				&& tEstabAux.getActivo() == test.getActivo()
				&& tEstabAux.getTipo().equals(test.getTipo()))
			assertEquals(1, 1);
		else
			assertEquals(0, 1);
	}

}
