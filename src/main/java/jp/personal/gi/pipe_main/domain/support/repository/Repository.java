package jp.personal.gi.pipe_main.domain.support.repository;

import jp.personal.gi.pipe_main.domain.support.entity.Entity;
import jp.personal.gi.pipe_main.domain.support.entity.EntityId;

import java.util.Optional;
import java.util.stream.Stream;

public interface Repository<T extends EntityId, E extends Entity<T>> {
    Optional<E> findBy(T id);

    Stream<E> findAll();

    boolean isEmpty();

    default boolean isPresent() {
        return !isEmpty();
    }
}
