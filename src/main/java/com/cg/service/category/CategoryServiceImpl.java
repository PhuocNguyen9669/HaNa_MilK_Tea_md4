package com.cg.service.category;

import com.cg.model.Category;
import com.cg.model.dto.CategoryDTO;
import com.cg.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void softDelete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<CategoryDTO> findAllCategoryDTO() {
        return categoryRepository.findAllCategoryDTO();
    }

    @Override
    public Optional<CategoryDTO> findCategoryDTOById(Long id) {
        return Optional.empty();
    }
}
