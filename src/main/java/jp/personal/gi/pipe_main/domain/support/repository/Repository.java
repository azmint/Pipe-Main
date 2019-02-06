package jp.personal.gi.pipe_main.domain.support.repository;

import jp.personal.gi.pipe_main.domain.support.entity.*;

import java.util.*;

public interface Repository<T extends EntityId, E extends Entity<T>> {
    Optional<E> findBy(T id);

    List<E> findAll();

    boolean isEmpty();

    default boolean isPresent() {
        return !isEmpty();
    }
}
