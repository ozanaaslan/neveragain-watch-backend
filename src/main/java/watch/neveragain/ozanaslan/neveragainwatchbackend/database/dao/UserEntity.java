package watch.neveragain.ozanaslan.neveragainwatchbackend.database.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;

    @Getter @Setter @Column(unique = true, nullable = false) private String email;
    @Getter @Setter @Column(unique = true, nullable = false) private String username;
    @Getter @Setter private String password;

    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String base64Avatar;

    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String description;

    @Getter @Setter private String position;
    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String permissions;
    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String roles;

    @Getter @Setter private long lastLoginTimestamp;
    @Getter private long creationTimestamp;

    @Getter @Setter private boolean enabled;
    @Getter @Setter private boolean locked;

    @ManyToMany
    @Getter private List<ArticleEntity> articles;

    public UserEntity() {}


    public UserEntity(String firstName, String lastName, String userName, String email, String password, boolean enabled){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.email = email;
        this.password = password;
        this.creationTimestamp = System.currentTimeMillis();
        this.lastLoginTimestamp = 0L;
        this.enabled = enabled;

    }


}
