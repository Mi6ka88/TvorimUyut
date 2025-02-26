package org.crystalkste.myshop.data;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Payment1 {

    private Long id;
    private Double amount;

    public Payment1(Long id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

}