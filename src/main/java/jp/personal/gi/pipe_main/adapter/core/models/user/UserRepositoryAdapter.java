package jp.personal.gi.pipe_main.adapter.core.models.user;

import jp.personal.gi.pipe_main.core.models.user.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.stream.Stream;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final Map<UserId, User> map;

    public UserRepositoryAdapter() {
        this.map = new HashMap<>();
        LongFunction<User> createUser = serialNo -> new User(
                new UserId(String.valueOf(serialNo)),
                new UserName(""),
                new ContactInformation(""),
                new Password(""),
                new Friends(Stream.empty()));
        Consumer<User> putUser = user -> this.map.put(user.getId(), user);
        LongConsumer createAndPutUser = serialNo -> {
            User newUser = createUser.apply(serialNo);
            putUser.accept(newUser);
        };
        createAndPutUser.accept(1L);
        createAndPutUser.accept(2L);
        createAndPutUser.accept(3L);
        createAndPutUser.accept(4L);
        createAndPutUser.accept(5L);
    }

    @Override
    public void store(User entity) {
        this.map.put(entity.getId(), entity);
    }

    @Override
    public void storeAll(Stream<? extends User> entities) {
        entities.forEach(this::store);
    }

    @Override
    public Optional<User> findBy(ContactInformation contactInformation) {
        return this.map.values().stream().filter(user -> user.getContactInformation().equals(contactInformation)).findFirst();
    }

    @Override
    public Optional<User> findBy(UserId id) {
        return Optional.ofNullable(this.map.get(id));
    }

    @Override
    public Stream<User> findAll() {
        return this.map.values().stream();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public String toString() {
        return "UserRepositoryAdapter{" +
                "map=" + map +
                '}';
    }
}
