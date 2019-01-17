package jp.personal.gi.pipe_main.core.support.repository;

import jp.personal.gi.pipe_main.core.support.entity.EntityId;

public interface IdentifierGeneratable<T extends EntityId> {
    T nextId();
}
