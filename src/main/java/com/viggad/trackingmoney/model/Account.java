package com.viggad.trackingmoney.model;

import com.viggad.trackingmoney.utils.Auditable;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class Account extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String avatarURL;

    @OneToMany(mappedBy = "account")
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private List<Category> categories = new ArrayList<>();


}
