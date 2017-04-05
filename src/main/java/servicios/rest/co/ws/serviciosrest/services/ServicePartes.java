
package servicios.rest.co.ws.serviciosrest.services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicios.rest.co.ws.serviciosrest.dao.PartesDao;
import servicios.rest.co.ws.serviciosrest.model.Partes;

@Path("servicePartes")
public class ServicePartes {
private PartesDao partesDao = new PartesDao();

    //Metodo en el cua se retorna el codigo de una parte en formato JSON

    @GET
    @Path("/getPartesPorCodigoJSON/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Partes getPartesPorCodigoJSON(@PathParam("codigo") String codigo) {
        return partesDao.getPartesPorCodigo(codigo);
    }
    
    //Metodo en el cua se retorna una lista de partes en formato JSON
    @GET
    @Path("/getListadoPartesPorJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Partes> getListadoPartesPorJSON(){
        return partesDao.getListadoPartes();
    }
    
    //Metodo en el cua se ingresa un parte y se retorna respuesta en formato JSON
    @GET
    @Path("/savePartes/{codigo}/{nombre}/{descripcion}")
    @Produces(MediaType.APPLICATION_JSON)
    public String savePartes(@PathParam("codigo") String codigo,@PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion){
        Partes partes= new Partes();
        partes.setCodigo(codigo);
        partes.setNombre(nombre);
        partes.setDescripcion(descripcion);
        if (!partesDao.savePartes(partes)) {
            return "{\"estado\":\"Ok\"}";
        }else{
            return "{\"estado\":\"Mal\"}";
        
        }
    }
}
