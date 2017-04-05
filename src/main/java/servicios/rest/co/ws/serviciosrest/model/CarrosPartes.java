package servicios.rest.co.ws.serviciosrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="carrospartes")
@XmlRootElement (name = "carrospartes")
@XmlType(propOrder = {"carrospartesPK","cantidad","partescodigo","carrosplaca"})
public class CarrosPartes {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CARROSPARTES")
    private String carrospartesPK;
    @Column(name="CANTIDAD")
    private int cantidad;
    @Column(name="PARTES_CODIGO")
    private String partescodigo;
    @Column(name="CARROS_PLACA")
    private String carrosplaca;

    /**
     * @return the carrospartesPK
     */
    @XmlElement
    public String getCarrospartesPK() {
        return carrospartesPK;
    }

    /**
     * @param carrospartesPK the carrospartesPK to set
     */
    public void setCarrospartesPK(String carrospartesPK) {
        this.carrospartesPK = carrospartesPK;
    }

    /**
     * @return the cantidad
     */
    @XmlElement
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the partescodigo
     */
    @XmlElement
    public String getPartescodigo() {
        return partescodigo;
    }

    /**
     * @param partescodigo the partescodigo to set
     */
    public void setPartescodigo(String partescodigo) {
        this.partescodigo = partescodigo;
    }

    /**
     * @return the carrosplaca
     */
    @XmlElement
    public String getCarrosplaca() {
        return carrosplaca;
    }

    /**
     * @param carrosplaca the carrosplaca to set
     */
    public void setCarrosplaca(String carrosplaca) {
        this.carrosplaca = carrosplaca;
    }
}
