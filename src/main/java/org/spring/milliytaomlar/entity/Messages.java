package org.spring.milliytaomlar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Messages extends BaseEntity {
    private String name;
    private String theme;
    private String phoneNumber;
    private String email;
    private String message;
    @ManyToOne
    private User user;


}
