package cruise.Entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * client profile class
 *
 * @author Edward
 */

@Entity
@Table(name = "user")
@NamedQuery(name = "findClientByName", query = "select s from Client s where s.userName=:userName")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * client's name
     */
    @Column(name = "user_name")
    @NaturalId
    private String userName;

    /**
     * client's password
     */
    @Column(name = "password")
    private String password;

    /**
     * role of the user
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 8)
    private Role role;

    /**
     * orders list of client
     */
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Order> orders;
//= new ArrayList<>()

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Enum for access rights
     */
    public enum Role {
        OWNER, CLIENT
    }

    public static class Builder {
        private Client client;

        public Builder() {
            client = new Client();
        }

        public Builder setId(Long id) {
            client.setId(id);
            return this;
        }

        public Builder setUserName(String userName) {
            client.setUserName(userName);
            return this;
        }

        public Builder setPassword(String password) {
            client.setPassword(password);
            return this;
        }

        public Builder setRole(Role role) {
            client.setRole(role);
            return this;
        }

        public Builder setOrders(List<Order> orders) {
            client.setOrders(orders);
            return this;
        }

        public Client build() {
            return client;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", user Name='" + userName + '\'' +
                ", password='" + password + '\'' +
//                ", role=" + role +
//                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId().equals(client.getId()) &&
                getUserName().equals(client.getUserName()) &&
                getPassword().equals(client.getPassword()) &&
                getRole() == client.getRole() &&
                getOrders().equals(client.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPassword(), getRole(), getOrders());
    }
}
