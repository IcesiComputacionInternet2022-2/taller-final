package co.edu.icesi.VirtualStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Table(name = "basket_items")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketItem {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "basket_item_id")
    private UUID id;

    @NotNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @PrePersist
    public void generateId(){
        this.id = UUID.randomUUID();
    }
}
