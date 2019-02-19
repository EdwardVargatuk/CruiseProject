package cruise.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The main ports through which ships of cruise company are passes
 *
 * @author Edward
 */

@Entity
@Table(name = "port")
public class Port implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * port name
     */
    @Column(name = "port_name")
    private String portName;

    /**
     * available in port excursions
     */
    @OneToMany(mappedBy = "port", cascade = CascadeType.PERSIST)
    private List<Excursion> availableExcursions;

    public Port() {
    }

    public List<Excursion> getAvailableExcursions() {
        return availableExcursions;
    }

    public void setAvailableExcursions(List<Excursion> availableExcursions) {
        this.availableExcursions = availableExcursions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public static class Builder {
        private Port port;

        public Builder() {
            port= new Port();
        }

        public Builder setId(Long id) {
            port.setId(id);
            return this;
        }

        public Builder setPortName(String portName) {
            port.setPortName(portName);
            return this;
        }

        public Builder setAvailableExcursions(List<Excursion> availableExcursions) {
            port.setAvailableExcursions(availableExcursions);
            return this;
        }

        public Port build() {
            return port;
        }
    }

    @Override
    public String toString() {
        return "Port{" +
                "id=" + id +
                ", portName='" + portName + '\'' +
                ", availableExcursions=" + availableExcursions +
                '}';
    }

    //////////////NOT COMPLETE

}
