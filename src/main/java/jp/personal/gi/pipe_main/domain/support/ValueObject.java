package jp.personal.gi.pipe_main.domain.support;

public interface ValueObject {
    int hashCode();

    boolean equals(Object obj);

    String toString();
}
