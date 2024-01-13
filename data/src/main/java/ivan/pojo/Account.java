package ivan.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity
@Table(name = "T_ACCOUNT")
public class Account {

    @Id
    @GenericGenerator(strategy = "uuid", name = "account_uuid")
    @GeneratedValue(generator = "account_uuid")
    @Column(name = "ACCOUNT_ID")
    private String id;

    @Column(name = "ACCOUNT_VALUE")
    private String value;

    @Column(name = "ACCOUNT_AMOUNT")
    private String amount;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Account() {
    }

    public Account(String id, String value, String amount, Product product) {
        this.id = id;
        this.value = value;
        this.amount = amount;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!Objects.equals(id, account.id)) return false;
        if (!Objects.equals(value, account.value)) return false;
        return  (!Objects.equals(amount, account.amount));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
