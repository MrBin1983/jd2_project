package ivan.pojo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.Objects;

@Entity
@Table(name = "T_SECURITY")
public class Security {

    @Id
    @GenericGenerator(strategy = "uuid", name = "security_uuid")
    @GeneratedValue(generator = "security_uuid")
    @Column(name = "SECURITY_ID")
    private String id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    public Security() {
    }

    public Security(String id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Security security = (Security) o;

        if (!Objects.equals(id, security.id)) return false;
        if (!Objects.equals(login, security.login)) return false;
        return  (!Objects.equals(password, security.password));
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
