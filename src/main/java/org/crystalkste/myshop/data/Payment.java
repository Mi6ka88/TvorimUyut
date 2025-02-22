package org.crystalkste.myshop.data;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Payment {

    private Long id;
    private Double amount;

    public Payment(Long id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

}