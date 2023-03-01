package com.alibou.security.booking;

import com.alibou.security.token.Token;
import com.alibou.security.user.Role;
import com.alibou.security.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String lastname;

    @Column(name = "type_of_document")
    private String type_of_document;

    private String identification;

    @Column(name = "email")
    private String email;


    @Enumerated(EnumType.STRING)
    private Status status;

    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_reserve")
    private Reserve type_of_reserve;

    @Column(name = "quantity_person")
    private Integer quantity_person;

    private String description;

    /*
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "created_user")
    private User created_user;
     */

    private Boolean active;
}

