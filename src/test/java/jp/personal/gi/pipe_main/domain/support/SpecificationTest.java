package jp.personal.gi.pipe_main.domain.support;

import org.junit.*;

import java.util.*;
import java.util.function.*;

import static org.junit.Assert.*;

public class SpecificationTest {

    @Test
    public void notSatisfiedBy_inCaseOfTrue() {
        Specification<String> instance = "AAA"::equals;
        assertFalse(instance.notSatisfiedBy("aaa"));
    }

    @Test
    public void notSatisfiedBy_inCaseOfFalse() {
        Specification<String> instance = "AAA"::equals;
        assertFalse(instance.notSatisfiedBy("AAA"));
    }

    @Test
    public void not() {
        Specification<String> instance = "AAA"::equals;
        assertFalse(instance.not().isSatisfiedBy("AAA"));
    }

    @Test
    public void and() {
        Specification<String> isAAA = "AAA"::equals;
        Specification<String> isThreeDigits = arg -> arg.length() == 3;
        Specification<String> instance = isAAA.and(isThreeDigits);
        assertTrue(instance.isSatisfiedBy("AAA"));
    }

    @Test
    public void andNot() {
        Specification<String> notLessThanThreeDigits = arg -> !(arg.length() < 3);
        Specification<String> isOverThanThreeDigits = arg -> arg.length() > 3;
        Specification<String> instance = notLessThanThreeDigits.andNot(isOverThanThreeDigits);
        assertTrue(instance.isSatisfiedBy("AAA"));
    }

    @Test
    public void or() {
        {
            Specification<String> isAAA = "AAA"::equals;
            Specification<String> isBBB = "BBB"::equals;
            Specification<String> instance = isAAA.or(isBBB);
            assertTrue(instance.isSatisfiedBy("AAA"));
            assertTrue(instance.isSatisfiedBy("BBB"));
        }
    }

    @Test
    public void orNot() {
        Specification<String> isLessThanThreeDigits = arg -> arg.length() < 3;
        Specification<String> isOverThanThreeDigits = arg -> arg.length() > 3;
        Specification<String> instance = isLessThanThreeDigits.orNot(isOverThanThreeDigits);
        assertTrue(instance.isSatisfiedBy("AAA"));
    }

    @Test
    public void toPredicate() {
        Specification<String> specification = "AAA"::equals;
        Predicate<String> predicate = specification.toPredicate();
        assertTrue(predicate.test("AAA"));
    }

    @Test
    public void satisfy() {
        Specification<String> specification = "AAA"::equals;
        Optional<String> maybeAAA = specification.satisfy("AAA");
        assertEquals(maybeAAA, Optional.of("AAA"));
    }
}