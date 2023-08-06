package com.harisw.wenakk.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.harisw.wenakk.model.Category;
import com.harisw.wenakk.model.Origin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponse {
    private Integer id;
    private Category category;
    private Origin origin;
    private String name;
    private String totalTime;
    private Timestamp datePublished;
    private String description;
//    private List<String> images;
//    private List<String> keywords;
    private Float rating;
    private Integer reviewCount;
    private Float calories;
    private Float fat;
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
