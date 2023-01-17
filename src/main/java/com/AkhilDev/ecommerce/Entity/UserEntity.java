package com.AkhilDev.ecommerce.Entity;

import com.AkhilDev.ecommerce.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean accountStatus;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column
    private Integer phone;

    public UserEntity(String firstName, String lastName, String email, String password, Integer phone, Role user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = user;
    }
}
