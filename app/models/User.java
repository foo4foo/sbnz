package models;

import io.ebean.Finder;
import io.ebean.Model;
import lombok.*;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User extends Model {

    @Id
    private Long id;

    @Column(unique = true)
    @Constraints.Email
    @Constraints.Required
    private String email;

    @Column(unique = true)
    @Constraints.Required
    private String username;

    @Constraints.Required
    @Constraints.MinLength(8)
    private String password;

    @Constraints.Required
    private Role role;

    public static final Finder<Long, User> find = new Finder<>(User.class);

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = Role.Doctor;
    }
}
