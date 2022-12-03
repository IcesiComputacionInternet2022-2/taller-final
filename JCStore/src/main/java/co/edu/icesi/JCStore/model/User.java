package co.edu.icesi.JCStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "`users`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    private String name;

    private String email;

    private String password;

    private String address;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Order> orders;

    @PrePersist
    public void generateData() {
        this.id = UUID.randomUUID();
    }
}
