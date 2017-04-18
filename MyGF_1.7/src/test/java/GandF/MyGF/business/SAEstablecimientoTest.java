package GandF.MyGF.business;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import GandF.MyGF.business.SAEstablecimiento;
import GandF.MyGF.integracion.DAOEstablecimientoImp;
import GandF.MyGF.integracion.TEstablecimiento;

public class SAEstablecimientoTest {
	@Test
	public void testActualizarEstablecimiento() throws IOException{
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento("4", "hiberrrrrr", "jepeto", 23456, true, "YYYY");
		int ret = sae.actualizarEstablecimiento(tE, "hiber", "jepeto");
		assertTrue(ret == 1);//Se ha actualizado
		
	}
	/**
	 * Caso en el que el establecimiento existe y esta activo
	 * */
	@Test
	public void testDarDeBaja1() throws IOException{    
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento("6", "hiberrrrrr", "jepeto", 23456, true, "YYYY");
		sae.darDeAlta(tE);
		int ret = sae.darDeBaja(tE);
		assertTrue(ret == 1);
	}
	/**
	 * Caso en el que el establecimiento no existe
	 * */
	@Test
	public void testDarDeBaja0() throws IOException{    
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento();
		int ret = sae.darDeBaja(tE);
		assertTrue(ret == 0);
	}
	/**
	 * Caso en el que el establecimiento existe y no esta activo
	 * */
	@Test
	public void testDarDeBaja2() throws IOException{    
		SAEstablecimiento sae = new SAEstablecimiento();
		TEstablecimiento tE = new TEstablecimiento("8", "hibex", "jepeto", 23756, false, "XYYY");
		sae.darDeAlta(tE);
		sae.darDeBaja(tE);  // lo desactivo primero una vez
		int ret = sae.darDeBaja(tE);
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
