package com.harisw.wenakk.controller;

import com.harisw.wenakk.service.RecipeService;
import com.harisw.wenakk.dto.RecipeResponse;
import com.harisw.wenakk.model.Recipe;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Recipe", description = "Recipe endpoints")
@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @Operation(
            summary = "Get Recipe by Id",
            description = "",
            tags = {"Recipe"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Recipe.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{recipe_id}")
    @ResponseStatus(HttpStatus.OK)
    public RecipeResponse getRecipe(@PathVariable("recipe_id") Integer recipe_id) {
        return recipeService.get(recipe_id);
    }

    @Operation(summary = "Retrieve all recipes paginated",
            description = "Get all recipes collections in pagination",
            tags = {"Recipe"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Recipe.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<RecipeResponse> getRecipes(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return recipeService.get(page != null ? page : 0, limit != null ? limit : 1);
    }

}
