package GandF.MyGF.integracion.factorias;

import GandF.MyGF.integracion.DAOAlimento;
import GandF.MyGF.integracion.DAODescuento;
import GandF.MyGF.integracion.DAOEstablecimiento;
import GandF.MyGF.integracion.DAOGasolina;
import GandF.MyGF.integracion.DAOUsuario;

public abstract class FactoriaIntegracion {
	private static FactoriaIntegracion factoria;
	
	public static FactoriaIntegracion getInstance(){
		if(factoria == null) factoria = new FactoriaIntegracionFicheros();
			return factoria;
	}
	
	public abstract DAOEstablecimiento getDAOEstablecimiento();
	public abstract DAOUsuario getDAOUsuario();
	public abstract DAOGasolina getDAOGasolina();
	public abstract DAOAlimento  getDAOAlimento();
	public abstract DAODescuento getDAODescuento();

}
