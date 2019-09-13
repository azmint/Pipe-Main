package jp.personal.gi.pipe_main.domain.support.entity;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class EntityTest {
    private static class MockId implements EntityId {
        final int value;

        MockId(int value) {
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

    private static class MockEntity extends Entity<MockId> {
        final String name;
        final int age;

        MockEntity(MockId id, String name, int age) {
            super(id);
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "MockEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private static final MockId MOCK_ID_1 = new MockId(1);
    private static final MockId MOCK_ID_2 = new MockId(2);
    private static final MockEntity MOCK_ENTITY_1_TARO_80 = new MockEntity(new MockId(1), "Taro", 80);
    private static final MockEntity MOCK_ENTITY_1_JIRO_80 = new MockEntity(new MockId(1), "Jiro", 80);
    private static final MockEntity MOCK_ENTITY_1_TARO_75 = new MockEntity(new MockId(1), "Taro", 75);
    private static final MockEntity MOCK_ENTITY_2_TARO_80 = new MockEntity(new MockId(2), "Taro", 80);

    @Test
    public void matchesTest() {
        assertTrue(MOCK_ENTITY_1_TARO_80.matches(MOCK_ID_1));
        assertFalse(MOCK_ENTITY_1_TARO_80.matches(MOCK_ID_2));
    }

    @Test
    public void notMatchesTest() {
        assertFalse(MOCK_ENTITY_1_TARO_80.matches(MOCK_ID_1));
        assertTrue(MOCK_ENTITY_1_TARO_80.matches(MOCK_ID_2));
    }

    @Test
    public void getIdTest() {
        final MockId mockId = MOCK_ENTITY_1_TARO_80.getId();
        assertEquals(mockId, MOCK_ID_1);
    }

    @Test
    public void equalsTest() {
        assertEquals(MOCK_ENTITY_1_TARO_80, MOCK_ENTITY_1_JIRO_80);
        assertEquals(MOCK_ENTITY_1_TARO_80, MOCK_ENTITY_1_TARO_75);
        assertNotEquals(MOCK_ENTITY_1_TARO_80, MOCK_ENTITY_2_TARO_80);
    }

    @Test
    public void hashCodeTest() {
        assertEquals(MOCK_ENTITY_1_TARO_80.hashCode(), MOCK_ENTITY_1_JIRO_80.hashCode());
        assertEquals(MOCK_ENTITY_1_TARO_80.hashCode(), MOCK_ENTITY_1_TARO_75.hashCode());
        assertNotEquals(MOCK_ENTITY_1_TARO_80.hashCode(), MOCK_ENTITY_2_TARO_80.hashCode());
    }
}