package jp.personal.gi.pipe_main.core.support.entity;

import java.util.Objects;

public abstract class Entity<T extends EntityId> {
    protected final T id;

    public Entity(T id) {
        this.id = id;
    }

    @Override
    public abstract String toString();

    public boolean matches(T id) {
        return Objects.equals(this.getId(), id);
    }

    public boolean notMatches(T id) {
        return !matches(id);
    }

    public T getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
