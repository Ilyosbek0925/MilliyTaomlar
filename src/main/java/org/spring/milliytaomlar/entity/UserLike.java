package org.spring.milliytaomlar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class UserLike extends BaseEntity {

    @ManyToMany
    @JoinTable(
            name = "like_menu",
            joinColumns = @JoinColumn(name = "like_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menus;

    @OneToOne
    private User user;



}
