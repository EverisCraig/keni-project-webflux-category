package com.craig.keniprojectwebfluxcategory.config;

import com.craig.keniprojectwebfluxcategory.controller.CategoryHandler;
import com.craig.keniprojectwebfluxcategory.document.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CategoryConfig {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/categories",
                    produces = APPLICATION_JSON_VALUE,
                    method = RequestMethod.GET,
                    beanClass = CategoryHandler.class,
                    beanMethod = "findAllCategories",
                    operation = @Operation(
                            summary = "Get all categories",
                            description = "Get all categories",
                            tags = {"categories"},
                            operationId = "findAllCategories",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Successful operation",
                                            content = @io.swagger.v3.oas.annotations.media.Content(
                                                    mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                                            implementation = Category.class
                                                    )
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "400",
                                            description = "Bad request",
                                            content = @io.swagger.v3.oas.annotations.media.Content(
                                                    mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                                            implementation = Category.class
                                                    )
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "401",
                                            description = "Unauthorized",
                                            content = @io.swagger.v3.oas.annotations.media.Content(
                                                    mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                                            implementation = Category.class
                                                    )
                                            )
                                    ),
                                    @ApiResponse(
                                            responseCode = "403",
                                            description = "Forbidden",
                                            content = @io.swagger.v3.oas.annotations.media.Content(
                                                    mediaType = APPLICATION_JSON_VALUE,
                                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                                            implementation = Category.class
                                                    )
                                            )
                                    ),
                            }

                    )



            )
    })
    public RouterFunction<ServerResponse> routes(CategoryHandler categoryHandler) {
        return route(GET("/categories"), request -> categoryHandler.findAllCategories())
                .andRoute(GET("/categories/{id}"), categoryHandler::findCategoryById)
                .andRoute(POST("/categories"), categoryHandler::createCategory);
    }

}
