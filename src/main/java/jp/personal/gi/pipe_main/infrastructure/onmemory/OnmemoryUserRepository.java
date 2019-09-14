package jp.personal.gi.pipe_main.infrastructure.onmemory;

import jp.personal.gi.pipe_main.domain.models.account.*;
import jp.personal.gi.pipe_main.domain.models.user.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@Repository
public class OnmemoryUserRepository implements UserRepository {
    private final Map<UserId, User> map;

    public OnmemoryUserRepository() {
        this.map = new HashMap<>();

        LongFunction<User> toUser = longValue -> new User(
                new UserId(String.valueOf(longValue)),
                new AccountId(""),
                new UserName(""),
                Friends.empty());
        LongConsumer putUser = longValue -> {
            final User user = toUser.apply(longValue);
            this.map.put(user.getId(), user);
        };
        putUser.accept(1L);
        putUser.accept(2L);
        putUser.accept(3L);
        putUser.accept(4L);
        putUser.accept(5L);
    }

    @Override
    public Optional<User> findBy(UserId id) {
        return Optional.ofNullable(this.map.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.map.values());
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
}
