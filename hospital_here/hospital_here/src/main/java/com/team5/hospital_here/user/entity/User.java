package com.team5.hospital_here.user.entity;


import com.team5.hospital_here.common.baseEntity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "필수 입력값 입니다.")
    private String name;

    @NotEmpty(message = "필수 입력값 입니다.")
    private String phoneNumber;


    @NotEmpty(message = "필수 입력값 입니다.")
    private String address;

    private String addressDetail;

    private String img;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;

    @Enumerated(EnumType.STRING)
    private Role role;


}