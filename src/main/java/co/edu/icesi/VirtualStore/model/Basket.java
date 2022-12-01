package co.edu.icesi.VirtualStore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "baskets")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Basket {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "basket_id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }

}
