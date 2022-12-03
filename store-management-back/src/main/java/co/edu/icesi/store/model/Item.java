package co.edu.icesi.store.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID itemId;

    private String itemName;

    private String itemDescription;

    private Double price;

    @PrePersist
    public void generateId(){
        this.itemId = UUID.randomUUID();
    }
}
