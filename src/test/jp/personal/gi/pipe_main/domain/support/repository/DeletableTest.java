package jp.personal.gi.pipe_main.domain.support.repository;

import jp.personal.gi.pipe_main.domain.support.entity.*;
import org.junit.*;

import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.*;

public class DeletableTest {
    class MockId implements EntityId {
        private final int value;

        private MockId(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final MockId mockId = (MockId) o;
            return value == mockId.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "MockId{" +
                    "value=" + value +
                    '}';
        }
    }

    class MockEntity extends Entity<MockId> {
        private final String name;

        private MockEntity(MockId id, String name) {
            super(id);
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            final MockEntity that = (MockEntity) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), name);
        }

        @Override
        public String toString() {
            return "MockEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    class MockRepository implements Deletable<MockId, MockEntity> {
        boolean isDeleted = false;

        @Override
        public void deleteBy(MockId id) {
            if (id.value == 1) this.isDeleted = true;
        }

        @Override
        public void deleteAll(Stream<? extends MockEntity> entities) {

        }
    }

    @Test
    public void deleteTest() {
        final MockRepository repository = new MockRepository();
        final MockEntity entity = new MockEntity(new MockId(1), "Taro");
        repository.delete(entity);
        assertTrue(repository.isDeleted);
    }
}