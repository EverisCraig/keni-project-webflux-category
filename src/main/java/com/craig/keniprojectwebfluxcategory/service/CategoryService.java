package com.craig.keniprojectwebfluxcategory.service;

import com.craig.keniprojectwebfluxcategory.document.Category;
import com.craig.keniprojectwebfluxcategory.repository.IBaseRepository;
import com.craig.keniprojectwebfluxcategory.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CategoryService extends BaseService<Category, String> implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    protected IBaseRepository<Category, String> getRepository() {
        return categoryRepository;
    }

    @Override
    public Mono<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
