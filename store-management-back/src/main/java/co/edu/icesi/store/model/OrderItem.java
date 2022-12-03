package co.edu.icesi.store.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "order_item")
public class OrderItem {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID orderItemId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @PrePersist
    public void generateId(){
        this.orderItemId = UUID.randomUUID();
    }
}
