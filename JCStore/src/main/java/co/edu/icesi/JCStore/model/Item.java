package co.edu.icesi.JCStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "item")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(name = "item_id", columnDefinition = "uuid", updatable = false )
    private UUID itemId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "url")
    private String url;

    @PrePersist
    public void generateId() { this.itemId = UUID.randomUUID();}

}
