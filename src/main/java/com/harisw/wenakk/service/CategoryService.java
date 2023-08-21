package com.harisw.wenakk.service;

import com.harisw.wenakk.dto.CategoryResponse;
import com.harisw.wenakk.model.Category;
import com.harisw.wenakk.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> get() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::mapToCategoryResponse).toList();
    }

    public CategoryResponse get(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(this::mapToCategoryResponse).orElse(null);
    }

    private CategoryResponse mapToCategoryResponse(Category Category) {
        return CategoryResponse.builder().
                id(Category.getId())
                .name(Category.getName())
                .build();
    }

}
