package org.crystalkste.myshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String category;
    private String productName;

}
