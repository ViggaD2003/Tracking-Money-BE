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
@Table(name = "category")
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String icon;

    private String color;

    private boolean isDefault;

    @OneToMany(mappedBy = "category")
    private List<Purchase> purchases = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
