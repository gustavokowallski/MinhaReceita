package com.project.miinhareceita.category.service;

import com.project.miinhareceita.category.domain.Category;
import com.project.miinhareceita.category.dto.CategoryMinDTO;
import com.project.miinhareceita.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryMinDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryMinDTO(x)).toList();
    }
}