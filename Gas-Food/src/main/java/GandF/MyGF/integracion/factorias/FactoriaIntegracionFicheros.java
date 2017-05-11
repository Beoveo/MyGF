package GandF.MyGF.integracion.factorias;

import GandF.MyGF.integracion.DAOAlimento;
import GandF.MyGF.integracion.DAOAlimentoImp;
import GandF.MyGF.integracion.DAODescuento;
import GandF.MyGF.integracion.DAODescuentoImp;
import GandF.MyGF.integracion.DAOEstablecimiento;
import GandF.MyGF.integracion.DAOEstablecimientoImp;
import GandF.MyGF.integracion.DAOGasolina;
import GandF.MyGF.integracion.DAOGasolinaImp;
import GandF.MyGF.integracion.DAOUsuario;
import GandF.MyGF.integracion.DAOUsuarioImp;

public class FactoriaIntegracionFicheros extends FactoriaIntegracion {

	@Override
	public DAOEstablecimiento getDAOEstablecimiento() {
		return new DAOEstablecimientoImp();
	}

	@Override
	public DAOUsuario getDAOUsuario() {
		return new DAOUsuarioImp();
	}

	@Override
	public DAOGasolina getDAOGasolina() {
		return new DAOGasolinaImp();
	}

	@Override
	public DAOAlimento getDAOAlimento() {
		return new DAOAlimentoImp();
	}

	@Override
	public DAODescuento getDAODescuento() {
		return new DAODescuentoImp();
	}

}
