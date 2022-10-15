package com.job.time.tracker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "J_ROLE")
public class JRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "ROLE", nullable = false, length = 50)
    private String role;

    //bi-directional many-to-one association to UserRole
    @OneToMany(mappedBy="jRole")
    private List<UserRole> userRoles;

}