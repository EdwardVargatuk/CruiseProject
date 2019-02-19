package cruise.Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Excursion available in some ports for addition price
 *
 * @author Edward
 */

@Entity
@Table(name = "excursion")
public class Excursion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * excursion name
     */
    @Column(name = "excursion_name")
    private String excursionName;

    /**
     * excursion price
     */
    @Column(name = "excursion_price", scale = 2)
    private double excursionPrice;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="port_id")
    private Port port;


    public Excursion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public String getExcursionName() {
        return excursionName;
    }

    public void setExcursionName(String excursionName) {
        this.excursionName = excursionName;
    }

    public double getExcursionPrice() {
        return excursionPrice;
    }

    public void setExcursionPrice(double excursionPrice) {
        this.excursionPrice = excursionPrice;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", excursionName='" + excursionName + '\'' +
                ", excursionPrice=" + excursionPrice +
                ", port=" + port +
                '}';
    }

    public static class Builder {
        private Excursion excursion;

        public Builder() {
            excursion = new Excursion();
        }

        public Builder setId(Long id) {
            excursion.setId(id);
            return this;
        }

        public Builder setExcursionName(String excursionName) {
            excursion.setExcursionName(excursionName);
            return this;
        }

        public Builder setExcursionPrice(double excursionPrice) {
            excursion.setExcursionPrice(excursionPrice);
            return this;
        }

        public Builder setPort(Port port) {
            excursion.setPort(port);
            return this;
        }

        public Excursion build() {
            return excursion;
        }
    }
/////////////////////////NOT COMPLETE//////////////////////////////////////////////


}
