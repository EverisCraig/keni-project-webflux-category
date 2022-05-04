package com.craig.keniprojectwebfluxcategory.controller;

import com.craig.keniprojectwebfluxcategory.document.Category;
import com.craig.keniprojectwebfluxcategory.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Component
public class CategoryHandler {

    private final ICategoryService categoryService;

    @Autowired
    public CategoryHandler(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Mono<ServerResponse> findAllCategories() {
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .body(categoryService.findAll(), Category.class);
    }

    public Mono<ServerResponse> findCategoryById(ServerRequest request) {
        String id= request.pathVariable("id");
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .body(categoryService.findById(id), Category.class);
    }

    public Mono<ServerResponse> createCategory(ServerRequest  request) {
        Mono<Category> category = request.bodyToMono(Category.class);
        return category.flatMap(categoryService::create)
                .flatMap( categoryDto -> ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .body(Mono.just(category), Category.class));
    }

    public Mono<ServerResponse> updateCategory(Category category) {
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .body(categoryService.update(category), Category.class);
    }

    public Mono<ServerResponse> deleteCategory(String id) {
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .body(categoryService.delete(id), Category.class);
    }
}
