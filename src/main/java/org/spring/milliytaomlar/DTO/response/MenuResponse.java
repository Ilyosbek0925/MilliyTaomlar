package org.spring.milliytaomlar.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuResponse {
    private Integer id;
    private String name;
    private String description;
    private String photoDownload;
    private double price;
    private List<String> ingredients;
    private LocalTime preparationTime;
    private double calories;

}
