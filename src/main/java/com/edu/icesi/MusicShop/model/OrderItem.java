package com.edu.icesi.MusicShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "`order_item`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "order_fk"))
    private UUID orderId;

    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "item_fk"))
    private UUID itemId;

    private int quantity;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID();
    }

}
