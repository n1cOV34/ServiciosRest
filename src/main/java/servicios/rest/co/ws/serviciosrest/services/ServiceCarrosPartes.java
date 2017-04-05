
package servicios.rest.co.ws.serviciosrest.services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicios.rest.co.ws.serviciosrest.dao.CarrosPartesDao;
import servicios.rest.co.ws.serviciosrest.model.CarrosPartes;

@Path("serviceCarrosPartes")
public class ServiceCarrosPartes {

    private CarrosPartesDao carrospartesDao = new CarrosPartesDao();

    //Metodo en el cua se retorna la placa de un carro en formato JSON
    @GET
    @Path("/getCarrosPartePorCodigoJSON/{carrospartesPK}")
    @Produces(MediaType.APPLICATION_JSON)
    public CarrosPartes getCarrosPartePorCodigoJSON(@PathParam("carrospartesPK") String carrospartesPK) {
        return carrospartesDao.getCarrosPartesPorCodigo(carrospartesPK);
    }

    //Metodo en el cua se retorna una lista de carros en formato JSON
    @GET
    @Path("/getListadoCarrosPartesPorJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarrosPartes> getListadoCarrosPartesPorJSON() {
        return carrospartesDao.getListadoCarrosPartes();
    }
}
