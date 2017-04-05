
package servicios.rest.co.ws.serviciosrest.services;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicios.rest.co.ws.serviciosrest.dao.CarrosDao;
import servicios.rest.co.ws.serviciosrest.model.Carros;

@Path("serviceCarros")
public class ServiceCarros {

    private CarrosDao carrosDao = new CarrosDao();

    //Metodo en el cua se retorna la placa de un carro en formato JSON

    @GET
    @Path("/getCarrosPorPlacaJSON/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carros getCarrosPorPlacaJSON(@PathParam("placa") String placa) {
        return carrosDao.getCarrosPorPlaca(placa);
    }
    
    //Metodo en el cua se retorna una lista de carros en formato JSON
    @GET
    @Path("/getListadoCarrosPorJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carros> getListadoCarrosPorJSON(){
        return carrosDao.getListadoCarros();
    }
    
    //Metodo en el cua se ingresa un carro y se retorna respuesta en formato JSON
    @GET
    @Path("/saveCarros/{placa}/{marca}/{modelo}/{color}")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveCarros(@PathParam("placa") String placa,@PathParam("marca") String marca,@PathParam("modelo") String modelo,@PathParam("color") String color){
        Carros carros= new Carros();
        carros.setPlaca(placa);
        carros.setMarca(marca);
        carros.setModelo(modelo);
        carros.setColor(color);
        if (!carrosDao.saveCarros(carros)) {
            return "{\"estado\":\"Ok\"}";
        }else{
            return "{\"estado\":\"Mal\"}";
        
        }
    }
    
}
