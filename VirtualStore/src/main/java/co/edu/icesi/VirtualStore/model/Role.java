package co.edu.icesi.VirtualStore.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "roles")
@Entity
public class Role {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "role_id")
    private UUID id;

    private String name;

    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> rolePermissions;
}