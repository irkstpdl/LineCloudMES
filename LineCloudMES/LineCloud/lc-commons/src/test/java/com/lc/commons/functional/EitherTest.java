package com.lc.commons.functional;

import java.math.BigInteger;

import org.junit.Test;

import junit.framework.Assert;

public class EitherTest {

    @Test
    public final void shouldProduceCorrectRightValue() {
        // given
        Either<String, Integer> right = Either.right(5);

        // then
        Assert.assertFalse(right.isLeft());
        Assert.assertTrue(right.isRight());
        Assert.assertEquals(5, (int) right.getRight());
        try {
            right.getLeft();
            Assert.fail();
        } catch (IllegalStateException e) {
            // success
        }
    }

    @Test
    public final void shouldProduceCorrectLeftValue() {
        // given
        Either<String, Integer> left = Either.left("Fail");

        // then
        Assert.assertTrue(left.isLeft());
        Assert.assertFalse(left.isRight());
        Assert.assertEquals("Fail", left.getLeft());
        try {
            left.getRight();
            Assert.fail();
        } catch (IllegalStateException e) {
            // success
        }
    }

    @Test
    public final void shouldMap() {
        // given
        Either<String, Integer> right = Either.right(5);

        // when
        Either<String, Integer> res = right.map(i -> i * 2);

        // then
        Assert.assertEquals(Either.<String, Integer> right(10), res);
    }

    @Test
    public final void shouldMapOnLeftDoNothing() {
        // given
        Either<String, Integer> left = Either.left("Fail");

        // when
        Either<String, Integer> res = left.map(i -> i * 2);

        // then
        Assert.assertEquals(left, res);
    }

    @Test
    public final void shouldFlatMapWithRight() {
        // given
        Either<String, Integer> right = Either.right(5);

        // when
        Either<String, BigInteger> res = right.flatMap(i -> Either.right(BigInteger.valueOf(i * 2L)));

        // then
        Assert.assertEquals(Either.<String, BigInteger> right(BigInteger.valueOf(10L)), res);
    }

    @Test
    public final void shouldFlatMapWithLeft() {
        // given
        Either<String, Integer> right = Either.right(5);

        // when
        Either<String, BigInteger> res = right.flatMap(i -> Either.left("Fail"));

        // then
        Assert.assertEquals(Either.<String, BigInteger> left("Fail"), res);
    }

    @Test
    public final void shouldFlatMapOnLeftDoNothing() {
        // given
        Either<String, Integer> left = Either.left("Fail");

        // when
        Either<String, Integer> resL = left.flatMap(i -> Either.left("YetAnotherFail"));
        Either<String, Integer> resR = left.flatMap(i -> Either.right(1000));

        // then
        Assert.assertEquals(left, resL);
        Assert.assertEquals(left, resR);
    }

    @Test
    public final void shouldFoldOnRight() {
        // given
        Either<String, Integer> right = Either.right(5);

        // when
        boolean res = right.fold(l -> false, r -> true);

        // then
        Assert.assertTrue(res);
    }

    @Test
    public final void shouldFoldOnLeft() {
        // given
        Either<String, Integer> left = Either.left("Fail");

        // when
        boolean res = left.fold(l -> false, r -> true);

        // then
        Assert.assertFalse(res);
    }
}
