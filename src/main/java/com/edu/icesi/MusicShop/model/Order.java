package com.edu.icesi.MusicShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "`order`")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    private double total;

    private String status;

    //@PrePersist
    public void generateId() {
        this.id = UUID.randomUUID();
    }

}
