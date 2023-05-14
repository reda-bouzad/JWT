package maroc.reda.jwt.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String userPassword;
    /* we use Set<Role> because a user might have a lot of roles */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userRole",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name= "roleId") }
    )
    private Set<Role> roles;
}
