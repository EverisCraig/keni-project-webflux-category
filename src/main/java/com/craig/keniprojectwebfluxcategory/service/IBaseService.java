package com.craig.keniprojectwebfluxcategory.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBaseService<T,S> {

    Mono<T> create(T t);
    Flux<T> findAll();
    Mono<T> findById(S id);
    Mono<T> update(T t);
    Mono<Void> delete(S id);

}
