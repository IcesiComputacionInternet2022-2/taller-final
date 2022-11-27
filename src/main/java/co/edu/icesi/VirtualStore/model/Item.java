package co.edu.icesi.VirtualStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Table(name = "items")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "item_id")
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double price;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }
}