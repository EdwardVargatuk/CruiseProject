package cruise.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * class with information about ships belonging to cruise company
 *
 * @author Edward
 */

@Entity
@Table(name = "ship")
public class Ship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * ship name
     */
    @Column(name = "ship_name")
    private String shipName;

    /**
     * how many passengers can getById on board the ship
     */
    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    /**
     * route of the tour
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ship_port", joinColumns = {@JoinColumn(name = ("ship_id"))},
            inverseJoinColumns = {@JoinColumn(name = "port_id")})
    private List<Port> route;

    /**
     * how many ports is the route
     */
    @Column(name = "count_of_ports")
    private int countOfPorts;

    /**
     * the number of days how long the tour lasts
     */
    @Column(name = "tour_duration")
    private int tourDuration;

    /**
     * how many people giving service on the ship
     */
    @Column(name = "staff")
    private int staff;

    /**
     * which bonus can be added to ticket according to current ship
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ship_bonus", joinColumns = {@JoinColumn(name = ("ship_id"))},
            inverseJoinColumns = {@JoinColumn(name = "bonus_id")})
    private List<Bonus> availableBonuses;

//    /**
//     * to which cruise the ship belongs
//     */
//    @OneToMany(mappedBy = "ship", cascade = CascadeType.PERSIST)
//    private List<Cruise> cruiseList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }


    public int getCountOfPorts() {
        return countOfPorts;
    }

    public void setCountOfPorts(int countOfPorts) {
        this.countOfPorts = countOfPorts;
    }


    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }


    public void setRoute(List<Port> route) {
        this.route = route;
    }

    public List<Port> getRoute() {
        return route;
    }

    public List<Bonus> getAvailableBonuses() {
        return availableBonuses;
    }

    public void setAvailableBonuses(List<Bonus> availableBonuses) {
        this.availableBonuses = availableBonuses;
    }

    public Ship() {
    }

    public static class Builder {
        private Ship ship;

        public Builder() {
            ship = new Ship();
        }

        public Builder setId(Long id) {
            ship.setId(id);
            return this;
        }

        public Builder setShipName(String shipName) {
            ship.setShipName(shipName);
            return this;
        }

        public Builder setPassengerCapacity(int countOfPorts) {
            ship.setPassengerCapacity(countOfPorts);
            return this;
        }

        public Builder setRoute(List<Port> route) {
            ship.setRoute(route);
            return this;
        }

        public Builder setCountOfPorts(int countOfPorts) {
            ship.setCountOfPorts(countOfPorts);
            return this;
        }

        public Builder setTourDuration(int tourDuration) {
            ship.setTourDuration(tourDuration);
            return this;
        }

        public Builder setStaff(int staff) {
            ship.setStaff(staff);
            return this;
        }

        public Builder setAvailableBonuses(List<Bonus> availableBonuses) {
            ship.setAvailableBonuses(availableBonuses);
            return this;
        }

        public Ship build() {
            return ship;
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", shipName='" + shipName + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", route=" + route +
                ", countOfPorts=" + countOfPorts +
                ", tourDuration=" + tourDuration +
                ", staff=" + staff +
                ", availableBonuses=" + availableBonuses +
                '}';
    }
}
