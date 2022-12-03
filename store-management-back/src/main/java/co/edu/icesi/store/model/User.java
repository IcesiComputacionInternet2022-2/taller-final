package co.edu.icesi.store.model;

import co.edu.icesi.store.validation.CustomAnnotations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID userId;

    private String userName;

    private String email;

    @CustomAnnotations.PasswordValidation
    private String password;

    private String address;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @PrePersist
    public void generateId(){
        this.userId = UUID.randomUUID();
    }
}