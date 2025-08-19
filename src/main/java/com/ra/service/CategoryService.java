package com.ra.service;

import com.ra.model.Category;
import com.ra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
       return categoryRepository.findById(id);
    }
    @Transactional
    public boolean deleteById(Long id) {
        return categoryRepository.delete(id);
    }
    @Transactional
    public boolean findByName(String cateName) {
        return categoryRepository.findByName( cateName );
    }
}
