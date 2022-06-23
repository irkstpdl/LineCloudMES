package com.lc.commons.functional;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * 包含任意类型值的无限、惰性求值流。 如果它们的元素是不可变的，则 Stream 将是不可变的。
 *
 * HashCode & Equality:
 * equals和hashCode的行为取决于元素内这两个方法的行为，并且还传递了归纳函数。
 * 如果传递的函数没有覆盖 equals/hashCode，则 LazyStream.equals将为使用同一函数的两个单独实例的 2 个相同的 LazyStreams 返回 false。 请注意这一点。
 *
 * 线程安全: 当前的实现不是线程安全的。
 *
 * 终止: 因为这个集合的长度是不确定的，简单地迭代它的元素就会导致无限循环。
 * 要获取任意数量的元素，请使用 Iterables.limit(lazyStream, n)或 FluentIterable.from(lazyStream).limit(n)
 * 或者，你可以使用 head() 和 tail() 方法“手动”遍历流。
 *
 * @param <T>
 *            Stream 元素的类型。 如果类型 T 是不可变的，那么整个 Stream 也将是不可变的。
 * @since 1.3.0
 */
public class LazyStream<T> implements Iterable<T> {

    private final T head;

    private LazyStream<T> lazyTail;

    private final Function<T, T> inductionStep;

    /**
     * 创建一个新的 LazyStream 实例。
     *
     * @param firstElement
     *            第一个元素，将用于计算尾部（因此是备用元素）
     * @param inductionStep
     *            函数消耗当前流的元素并产生下一个。
     * @param <U>
     *            Stream 元素的类型。
     * @return new instance of LazyStream
     */
    public static <U> LazyStream<U> create(final U firstElement, final Function<U, U> inductionStep) {
        return new LazyStream<U>(firstElement, inductionStep);
    }

    private LazyStream(final T head, final Function<T, T> inductionStep) {
        this.head = head;
        this.inductionStep = inductionStep;
    }

    /**
     * 返回包含在此特定 LazyStream 链中的基础值。
     *
     * @return underlying value
     */
    public T head() {
        return head;
    }

    /**
     * 将转发元素作为 LazyStream 返回。
     * 当你第一次调用 tail() 时，会延迟生成返回的流，并存储以供进一步调用。
     * 因此，tail() 的进一步调用将不会评估归纳函数。
     *
     * @return alternate elements as a LazyStream.
     */
    public LazyStream<T> tail() {
        // 同步我以获得线程安全
        if (lazyTail == null) {
            lazyTail = new LazyStream<T>(inductionStep.apply(head), inductionStep);
        }
        return lazyTail;
    }

    public LazyStream<T> dropWhile(final Predicate<T> predicate) {
        LazyStream<T> res = this;
        while (!predicate.apply(res.head())) {
            res = res.tail();
        }
        return res;
    }

    public List<T> takeWhile(final Predicate<T> predicate) {
        List<T> res = Lists.newArrayList();
        LazyStream<T> curr = this;
        while (predicate.apply(curr.head)) {
            res.add(curr.head);
            curr = curr.tail();
        }
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return new LazyStreamIterator<T>(this);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        LazyStream rhs = (LazyStream) obj;
        // I'm not sure about using inductionStep to prove objects' equality.
        return new EqualsBuilder().append(this.head, rhs.head).append(this.inductionStep, rhs.inductionStep).isEquals();
    }

    @Override
    public int hashCode() {
        // I'm not sure about using inductionStep to calculate object's hashCode.
        return new HashCodeBuilder().append(head).append(inductionStep).toHashCode();
    }

}

class LazyStreamIterator<T> implements Iterator<T> {

    private LazyStream<T> stream;

    LazyStreamIterator(final LazyStream<T> forStream) {
        this.stream = forStream;
    }

    @Override
    public boolean hasNext() {
        // LazyStream为无限的
        return true;
    }

    @Override
    public T next() {
        // 切断并返回一个流的头部，然后将底层流重新分配给它的尾部。
        T head = stream.head();
        stream = stream.tail();
        return head;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from functional LazyStream");
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        LazyStreamIterator rhs = (LazyStreamIterator) obj;
        return Objects.equals(this.stream, rhs.stream);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stream);
    }
}