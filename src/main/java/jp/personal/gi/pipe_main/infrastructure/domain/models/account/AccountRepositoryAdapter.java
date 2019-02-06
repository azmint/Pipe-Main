package jp.personal.gi.pipe_main.infrastructure.domain.models.account;

import jp.personal.gi.pipe_main.domain.models.account.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@Repository
public class AccountRepositoryAdapter implements AccountRepository {
    private long nextNo;
    private final Map<AccountId, Account> map;

    public AccountRepositoryAdapter() {
        this.nextNo = 1L;
        this.map = new HashMap<>();
        LongFunction<Account> createAccount = serialNo -> new Account(
                new AccountId(String.valueOf(serialNo)),
                new MailAddress(""),
                new Password(""),
                Authority.GENERAL);
        Consumer<Account> putAccount = user -> this.map.put(user.getId(), user);
        LongConsumer createAndPutAccount = serialNo -> {
            Account newAccount = createAccount.apply(serialNo);
            putAccount.accept(newAccount);
        };
        createAndPutAccount.accept(this.nextNo++);
        createAndPutAccount.accept(this.nextNo++);
        createAndPutAccount.accept(this.nextNo++);
        createAndPutAccount.accept(this.nextNo++);
        createAndPutAccount.accept(this.nextNo++);
    }

    @Override
    public AccountId nextId() {
        return new AccountId(String.valueOf(this.nextNo++));
    }

    @Override
    public void store(Account entity) {
        this.map.put(entity.getId(), entity);
    }

    @Override
    public void storeAll(List<? extends Account> entities) {
        entities.forEach(this::store);
    }

    @Override
    public Optional<Account> findBy(MailAddress mailAddress) {
        return this.map
                .values()
                .stream()
                .filter(user -> user.getMailAddress().equals(mailAddress))
                .findFirst();
    }

    @Override
    public Optional<Account> findBy(AccountId id) {
        return Optional.ofNullable(this.map.get(id));
    }

    @Override
    public List<Account> findAll() {
        return this.map.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public String toString() {
        return "AccountRepositoryAdapter{" +
                "map=" + map +
                '}';
    }
}
