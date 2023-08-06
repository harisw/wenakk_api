package com.harisw.wenakk.repository;

import com.harisw.wenakk.model.Category;
import com.harisw.wenakk.model.Origin;
import com.harisw.wenakk.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Page<Recipe> findAll(Pageable pageable);
    Page<Recipe> findByCategory(Category category, Pageable pageable);
    Page<Recipe> findByOrigin(Origin origin, Pageable pageable);
}
