package com.craig.keniprojectwebfluxcategory.repository;

import com.craig.keniprojectwebfluxcategory.document.Category;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ICategoryRepository extends IBaseRepository<Category, String> {
    Mono<Category> findByName(String name);
}
