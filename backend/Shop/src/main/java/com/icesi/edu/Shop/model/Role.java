package com.icesi.edu.Shop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(name = "`user_role`")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "role_name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> rolePermissions;

    @PrePersist
    public void generateId(){
        this.roleId = UUID.randomUUID();
    }

}