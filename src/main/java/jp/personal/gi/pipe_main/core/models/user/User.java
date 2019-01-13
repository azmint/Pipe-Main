package jp.personal.gi.pipe_main.core.models.user;

import jp.personal.gi.pipe_main.core.support.entity.Entity;

public class User extends Entity<UserId> {
    private final UserName userName;
    private final ContactInformation contactInformation;
    private final Password password;
    private final Friends friends;

    public User(UserId id, UserName userName, ContactInformation contactInformation, Password password, Friends friends) {
        super(id);
        this.userName = userName;
        this.contactInformation = contactInformation;
        this.password = password;
        this.friends = friends;
    }

    public UserName getUserName() {
        return userName;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public Password getPassword() {
        return password;
    }

    public Friends getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName=" + userName +
                ", contactInformation=" + contactInformation +
                ", password=" + password +
                ", friends=" + friends +
                '}';
    }
}
