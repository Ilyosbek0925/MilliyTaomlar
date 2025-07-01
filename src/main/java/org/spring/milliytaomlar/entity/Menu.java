package org.spring.milliytaomlar.entity;


import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;
@Entity
@Getter
@Setter
public class Menu extends BaseEntity {
private String name;
private String description;
private String photoDownload;
private double price;
private List<String> ingredients;
private LocalTime preparationTime;
private double calories;
}
