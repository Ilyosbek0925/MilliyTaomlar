package org.spring.milliytaomlar.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Basket extends BaseEntity {

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, orphanRemoval = true)
    List<BasketItem> basketItems;

    @OneToOne
    private User user;
}
