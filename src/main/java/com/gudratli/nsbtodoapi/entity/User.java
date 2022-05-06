package com.gudratli.nsbtodoapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "surname")
    @NonNull
    private String surname;
    @Column(name = "phone")
    @NonNull
    private String phone;
    @Column(name = "email")
    @NonNull
    private String email;
    @Column(name = "github")
    @NonNull
    private String github;
    @Column(name = "address")
    @NonNull
    private String address;
    @Column(name = "cv")
    @NonNull
    private String username;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "banned")
    private Boolean banned;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private Country country;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<UserLanguage> userLanguages;
    @OneToMany(mappedBy = "user")
    private List<UserTechnology> userTechnologies;
    @OneToMany(mappedBy = "user")
    private List<Process> processes;
    @OneToMany(mappedBy = "user")
    private List<Conversation> conversations;
}

