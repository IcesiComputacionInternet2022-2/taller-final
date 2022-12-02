package com.edu.icesi.virtualshop.security;

import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@Setter
@Data
@EqualsAndHashCode
@ToString
@CrossOrigin(origins = "*")
public class SecurityContext implements Serializable {

    @Getter(AccessLevel.NONE)
    private static final long SERIAL__VERSION_UID = 1L;

    private UUID userId;
    private UUID roleId;
    private String roleName;
    private UUID organizationId;
    private String token;



}
