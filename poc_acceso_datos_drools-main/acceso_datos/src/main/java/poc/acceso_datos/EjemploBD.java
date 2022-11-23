package poc.acceso_datos;

import java.util.List;
import poc.acceso_datos.entities.Actividad;
import poc.acceso_datos.managers.ActividadManager;

public class EjemploBD {

	public static List<Actividad> obtenerActividades(long nroEmpresa) {
		//	Connection connection = HikariCPDataSource.getConnection();
		return new ActividadManager().listaActividades(nroEmpresa);

		/*if (nroPersona != null && nroPersona.length() > 0) {
			String fin = nroPersona.substring(nroPersona.length() - 1);
			Integer intFin = parseIntOrNull(fin);
			if (intFin == null || (intFin % 2) == 1) {
				return 1;
			}
		}
		return 0;*/
	}

	private static Integer parseIntOrNull(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}