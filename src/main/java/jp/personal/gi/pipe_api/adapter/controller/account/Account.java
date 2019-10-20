package jp.personal.gi.pipe_api.adapter.controller.account;

public class Account {
    private final String getAccountId;
    private final String getName;
    private final String getNameReading;
    private final String getAuthority;

    public Account(String getAccountId, String getName, String getNameReading, String getAuthority) {
        this.getAccountId = getAccountId;
        this.getName = getName;
        this.getNameReading = getNameReading;
        this.getAuthority = getAuthority;
    }

    public String getGetAccountId() {
        return getAccountId;
    }

    public String getGetName() {
        return getName;
    }

    public String getGetNameReading() {
        return getNameReading;
    }

    public String getGetAuthority() {
        return getAuthority;
    }

    @Override
    public String toString() {
        return "Account{" +
                "getAccountId='" + getAccountId + '\'' +
                ", getName='" + getName + '\'' +
                ", getNameReading='" + getNameReading + '\'' +
                ", getAuthority='" + getAuthority + '\'' +
                '}';
    }
}
