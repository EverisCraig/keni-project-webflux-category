package com.craig.keniprojectwebfluxcategory.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T, S> extends ReactiveMongoRepository<T, S> {
}
