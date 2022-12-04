package com.chang.healthmate.repository.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String userName;
    private String password;
    private String region;
    private String Career;
    private String purpose;
    private Boolean matching;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


}
