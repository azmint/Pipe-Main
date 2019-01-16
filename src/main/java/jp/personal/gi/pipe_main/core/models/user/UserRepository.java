package jp.personal.gi.pipe_main.core.models.user;

import jp.personal.gi.pipe_main.core.support.repository.Repository;
import jp.personal.gi.pipe_main.core.support.repository.Storable;

import java.util.Optional;

public interface UserRepository extends Repository<UserId, User>, Storable<User> {
    Optional<User> findBy(ContactInformation contactInformation);
}
