package com.craig.keniprojectwebfluxcategory.service;

import com.craig.keniprojectwebfluxcategory.repository.IBaseRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class BaseService<T,S> implements IBaseService<T,S> {

    protected abstract IBaseRepository<T,S> getRepository();

    @Override
    public Mono<T> create(T t) {
        return getRepository().save(t);
    }

    @Override
    public Flux<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Mono<T> findById(S id) {
        return getRepository().findById(id);
    }

    @Override
    public Mono<T> update(T t) {
        return getRepository().save(t);
    }

    @Override
    public Mono<Void> delete(S id) {
        return getRepository().deleteById(id);
    }
}
