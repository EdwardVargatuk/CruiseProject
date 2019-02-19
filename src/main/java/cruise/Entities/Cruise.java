package cruise.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * cruise entity
 *
 * @author Edward
 */

@Entity
@Table(name = "cruise")
public class Cruise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * ship from cruise company
     */
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="ship_id")
    private Ship ship;

    /**
     * the total price of cruise
     */
    @Column(name = "price", scale = 2)
    private double price;

    /**
     * date when cruise starts
     */
    @Temporal(value = TemporalType.DATE)
    private Date date;

    public Cruise() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "id=" + id +
                ", ship=" + ship +
                ", price=" + price +
                ", date=" + date +
                '}';
    }

    public static class Builder {
        private Cruise cruise;

        public Builder() {
            cruise =new Cruise();
        }

        public Builder setId(Long id) {
            cruise.setId(id);
            return this;
        }

        public Builder setShip(Ship ship) {
            cruise.setShip(ship);
            return this;
        }
        public Builder setPrice(double price) {
            cruise.setPrice(price);
            return this;
        }

        public Builder setDate(Date date) {
            cruise.setDate(date);
            return this;
        }
        public Cruise build() {
            return cruise;
        }
    }
}
