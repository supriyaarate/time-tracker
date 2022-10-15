package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "J_USER")
public class JUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToMany (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )

    public Set<JRole> roles = new HashSet<>();

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "USERNAME", nullable = false, length = 50)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 1024)
    private String password;

    @Column(name = "CONFIRM_PASSWORD", nullable = false, length = 1024)
    private String confirmPassword;

    @Column(name = "OLD_PASSWORD", nullable = false, length = 1024)
    private String oldPassword;

    @Column(name = "STATUS", nullable = false)
    private boolean status = false;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled = false;

    @Column(name = "ACCOUNT_EXPIRED", nullable = false)
    private boolean accountExpired = false;

    @Column(name = "PASSWORD_EXPIRED", nullable = false)
    private boolean passwordExpired = false;

    @Column(name = "LOCKED_STATUS", nullable = false)
    private boolean lockedStatus = false;

    //bi-directional many-to-one association to UserRole
    @OneToMany(mappedBy="jUser" , fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

    public void addRole(JRole role) {
        this.roles.add(role);
    }

}