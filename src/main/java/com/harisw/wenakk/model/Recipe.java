package com.harisw.wenakk.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.harisw.wenakk.helpers.JsonHandler;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;

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
    private Date datePublished;
    private String description;
    private String images;
    private String keywords;
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
    private String instructions;
    private String ingredients;
    private Integer recipeId;

}
