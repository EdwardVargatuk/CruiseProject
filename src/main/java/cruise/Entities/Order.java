package cruise.Entities;

import javax.persistence.*;
import java.util.List;

/**
 * confirmed by client order
 *
 * @author Edward
 */
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public enum TicketClass {
        USUAL, PREMIUM
    }

    /**
     * From the ticket class, the cost and additional bonuses for the tour program depends
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_class", length = 10)
    private TicketClass ticketClass;

    /**
     * the total price, including the base cruise price,
     * and the additional price depending on the chosen excursion
     */
    @Column(name = "total_price")
    private double totalPrice;

    /**
     * association with cruise
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cruise_id")
    private Cruise cruise;

    /**
     * association with client
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Client client;

    /**
     * the excursions chosen by client are stored in the order
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_excursion", joinColumns = {@JoinColumn(name = ("order_id"))},
            inverseJoinColumns = {@JoinColumn(name = "excursion_id")})
    private List<Excursion> excursionList;

    /**
     * the bonuses added by admin are stored in the order
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_bonus", joinColumns = {@JoinColumn(name = ("ship_id"))},
            inverseJoinColumns = {@JoinColumn(name = "bonus_id")})
    private List<Bonus> bonusList;


    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Excursion> getExcursionList() {
        return excursionList;
    }

    public void setExcursionList(List<Excursion> excursionList) {
        this.excursionList = excursionList;
    }

    public List<Bonus> getBonusList() {
        return bonusList;
    }

    public void setBonusList(List<Bonus> bonusList) {
        this.bonusList = bonusList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ticketClass=" + ticketClass +
                ", totalPrice=" + totalPrice +
                ", cruise=" + cruise +
                ", client=" + client +
                ", excursionList=" + excursionList +
                ", bonusList=" + bonusList +
                '}';
    }

    public static class Builder {
        private Order order;

        public Builder() {
            order = new Order();
        }

        public Builder setId(Long id) {
            order.setId(id);
            return this;
        }

        public Builder setTicketClass(TicketClass ticketClass) {
            order.setTicketClass(ticketClass);
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            order.setTotalPrice(totalPrice);
            return this;
        }

        public Builder setCruise(Cruise cruise) {
            order.setCruise(cruise);
            return this;
        }

        public Builder setExcursionList(List<Excursion> excursionList) {
            order.setExcursionList(excursionList);
            return this;
        }

        public Builder setBonusList(List<Bonus> bonusList) {
            order.setBonusList(bonusList);
            return this;
        }

        public Order build() {
            return order;
        }
    }
}
