package jp.personal.gi.pipe_main.domain.support.repository;

import jp.personal.gi.pipe_main.domain.support.entity.Entity;

import java.util.stream.Stream;

public interface Storable<E extends Entity<?>> {
    void store(E entity);

    void storeAll(Stream<? extends E> entities);
}
