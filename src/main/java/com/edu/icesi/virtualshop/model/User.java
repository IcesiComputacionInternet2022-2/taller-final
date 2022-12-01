package com.edu.icesi.virtualshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Data
@Table(name = "users")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID user_id;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String getLoginAttribute(){
        if(email!=null){
            return email;
        }
        else{
            return phoneNumber;
        }
    }

    @PrePersist
    public void generateId(){
        this.user_id = UUID.randomUUID();
    }


}
