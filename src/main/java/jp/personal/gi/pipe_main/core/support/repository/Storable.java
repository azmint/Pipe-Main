package jp.personal.gi.pipe_main.core.support.repository;

import jp.personal.gi.pipe_main.core.support.entity.Entity;

import java.util.stream.Stream;

public interface Storable<E extends Entity<?>> {
    void store(E entity);

    void storeAll(Stream<? extends E> entities);
}
