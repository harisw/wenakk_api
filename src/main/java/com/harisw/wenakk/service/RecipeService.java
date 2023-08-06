package com.harisw.wenakk.service;

import com.harisw.wenakk.dto.RecipeResponse;
import com.harisw.wenakk.model.Recipe;
import com.harisw.wenakk.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {
    private final RecipeRepository recipeRepository;
    public RecipeResponse get(Integer id) {
        Optional<Recipe> queryRecipe = recipeRepository.findById(id);
        if (queryRecipe.isEmpty())
            return null;
        Recipe recipe = queryRecipe.get();
        return mapToRecipeResponse(recipe);
    }

    public List<RecipeResponse> get(Integer offset, Integer pageSize) {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Pageable paging = PageRequest.of(offset, pageSize);
        Page<Recipe> pageRecipes = recipeRepository.findAll(paging);
        recipes = pageRecipes.getContent();

        return recipes.stream().map(this::mapToRecipeResponse).toList();
    }

    private RecipeResponse mapToRecipeResponse(Recipe recipe) {
        return RecipeResponse.builder()
                .category(recipe.getCategory())
                .origin(recipe.getOrigin())
                .id(recipe.getId())
                .name(recipe.getName())
                .totalTime(recipe.getTotalTime())
                .datePublished(recipe.getDatePublished())
                .description(recipe.getDescription())
//                .images(recipe.getImages())
//                .keywords(recipe.getKeywords())
                .rating(recipe.getRating())
                .reviewCount(recipe.getReviewCount())
                .calories(recipe.getCalories())
                .fat(recipe.getFat())
                .saturatedFat(recipe.getSaturatedFat())
                .cholesterol(recipe.getCholesterol())
                .sodium(recipe.getSodium())
                .carbohydrate(recipe.getCarbohydrate())
                .fiber(recipe.getFiber())
                .sugar(recipe.getSugar())
                .protein(recipe.getProtein())
                .recipeYield(recipe.getRecipeYield())
//                .instructions(recipe.getInstructions())
//                .ingredients(recipe.getIngredients())
                .recipeId(recipe.getRecipeId()).build();
    }
}
