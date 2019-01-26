package jp.personal.gi.pipe_main.domain.support.repository;

import jp.personal.gi.pipe_main.domain.support.entity.EntityId;

public interface IdentifierGeneratable<T extends EntityId> {
    T nextId();
}
