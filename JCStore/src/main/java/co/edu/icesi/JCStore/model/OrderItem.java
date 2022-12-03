package co.edu.icesi.JCStore.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "`order_item`")
public class OrderItem {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID orderItemId;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "item_id")
    private Item item;

    @PrePersist
    public void generateData() {
        this.orderItemId = UUID.randomUUID();
    }
}
