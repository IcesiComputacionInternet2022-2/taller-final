package com.edu.icesi.virtualshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "user_permission")
@Entity
@Data
public class Permission {

        @Id
        @Type(type="org.hibernate.type.PostgresUUIDType")
        private UUID permissionId;

        private String uri;

        private String permissionKey;

        @Column(name = "permission_method")
        private String method;


}
