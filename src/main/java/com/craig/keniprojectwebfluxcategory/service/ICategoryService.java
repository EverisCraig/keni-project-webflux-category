package com.craig.keniprojectwebfluxcategory.service;

import com.craig.keniprojectwebfluxcategory.document.Category;
import reactor.core.publisher.Mono;

public interface ICategoryService extends IBaseService<Category,String> {
    Mono<Category> findByName(String name);
}
