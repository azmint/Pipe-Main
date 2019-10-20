package jp.personal.gi.pipe_api.core.usecase.account.register;

import java.util.*;

public class OutputData {
    public final String getAccountId;
    public final String getName;
    public final String getNameReading;
    public final String getAuthority;

    public OutputData(String getAccountId, String getName, String getNameReading, String getAuthority) {
        this.getAccountId = getAccountId;
        this.getName = getName;
        this.getNameReading = getNameReading;
        this.getAuthority = getAuthority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OutputData that = (OutputData) o;
        return Objects.equals(getAccountId, that.getAccountId) &&
                Objects.equals(getName, that.getName) &&
                Objects.equals(getNameReading, that.getNameReading) &&
                Objects.equals(getAuthority, that.getAuthority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId, getName, getNameReading, getAuthority);
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "getAccountId='" + getAccountId + '\'' +
                ", getName='" + getName + '\'' +
                ", getNameReading='" + getNameReading + '\'' +
                ", getAuthority='" + getAuthority + '\'' +
                '}';
    }
}
