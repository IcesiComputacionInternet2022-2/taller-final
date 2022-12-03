package co.edu.icesi.JCStore.model;

import co.edu.icesi.JCStore.constants.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "`orders`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "total")
    private double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class)
    private List<OrderItem> orderItems;

    /*@ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER, targetEntity = User.class)*/
    //@JoinColumn(name = "id")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID userId;

    @PrePersist
    public void generateData() {
        this.orderId = UUID.randomUUID();
    }

}
