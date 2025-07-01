package org.spring.milliytaomlar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BasketItem extends BaseEntity {
    @ManyToOne
    private Basket basket;
    @ManyToOne
    private Menu menu;
    private Integer count;


}
