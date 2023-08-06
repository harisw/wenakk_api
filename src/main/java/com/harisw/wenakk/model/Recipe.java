package com.harisw.wenakk.model;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "recipes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id")
    private Origin origin;
    private String name;
    private String totalTime;
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datePublished;
    private String description;
//    private List<String> images;
//    private List<String> keywords;
//    private JsonNode images;
//    private JsonNode keywords;
    private Float rating;
    @Column(name = "reviewCount")
    private Integer reviewCount;
    private Float calories;
    private Float fat;
    @Column(name = "saturatedFat")
    private Float saturatedFat;
    private Float cholesterol;
    private Float sodium;
    private Float carbohydrate;
    private Float fiber;
    private Float sugar;
    private Float protein;
    private String recipeYield;
//    private List<String> instructions;
//    private JsonNode ingredients;
    private Integer recipeId;

}
