package co.edu.icesi.store.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID orderId;

    private Double total;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    private List<OrderItem> orderItems;

    @PrePersist
    public void generateId(){
        this.orderId = UUID.randomUUID();
    }
}
