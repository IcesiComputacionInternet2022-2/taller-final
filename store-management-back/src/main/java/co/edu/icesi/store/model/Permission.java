package co.edu.icesi.store.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_permission")
public class Permission {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID permissionId;

    private String uri;

    private String permissionKey;

    private String permissionMethod;
}