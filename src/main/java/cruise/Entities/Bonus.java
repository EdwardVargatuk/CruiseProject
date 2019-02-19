package cruise.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Bonus of cruise depend on cruise class
 *
 * @author Edward
 */

@Entity
@Table(name = ("bonus"))
public class Bonus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * bonus name
     */
    @Column(name = "bonus_name")
    private String bonusName;

    public Bonus() {
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static class Builder {
        private Bonus bonus;

        public Builder() {
            bonus = new Bonus();
        }

        public Builder setId(Long id) {
            bonus.setId(id);
            return this;
        }

        public Builder setBonusName(String bonusName) {
            bonus.setBonusName(bonusName);
            return this;
        }

        public Bonus build() {
            return bonus;
        }
    }


    @Override
    public String toString() {
        return "Bonus{" +
                "id=" + id +
                ", bonusName='" + bonusName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bonus)) return false;
        Bonus bonus = (Bonus) o;
        return getId().equals(bonus.getId()) &&
                getBonusName().equals(bonus.getBonusName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBonusName());
    }
}
