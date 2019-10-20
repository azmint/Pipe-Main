package jp.personal.gi.pipe_api.core.entity;

import java.util.*;

public interface Entity<T extends Entity<T, U>, U> {
    U getId();

    default boolean isMatches(U id) {
        return Objects.equals(id, this.getId());
    }

    default boolean isSame(T entity) {
        if (Objects.isNull(entity)) return false;
        return this.isMatches(entity.getId());
    }
}
