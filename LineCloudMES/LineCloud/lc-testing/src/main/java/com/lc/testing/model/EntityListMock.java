package com.lc.testing.model;

import java.util.Collections;
import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;

import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.lc.model.api.Entity;
import com.lc.model.api.EntityList;
import com.lc.model.api.search.SearchCriteriaBuilder;

/**
 * EntityList 模拟类，用于单元测试。
 *
 * @since 1.2.1
 */
public class EntityListMock extends LinkedList<Entity> implements EntityList{

    /**
     * 默认情况下，每次调用 find 都将返回 SearchCriteriaBuilder 模拟的唯一实例
     */
    private static final Supplier<SearchCriteriaBuilder>CRITERIA_BUILDER_SUPPLIER = new Supplier<SearchCriteriaBuilder>() {
        @Override
        public SearchCriteriaBuilder get() {
            return Mockito.mock(SearchCriteriaBuilder.class);
        }
    };

    private final Supplier<SearchCriteriaBuilder> criteriaBuilderSupplier;
    private final Supplier<SearchCriteriaBuilder> criteriaBuilderFactory;

    /**
     * 创建一个空 EntityList 模拟的新实例。
     *
     * @return 一个新的实体列表模拟实例
     */
    public static EntityList create() {
        return create(Collections.<Entity> emptyList());
    }
    /**
     * Create a new mock instance of an EntityList, containing given values.
     *
     * @param elements
     *            content of new mock
     * @return a new instance of an EntityList mock
     */
    public static EntityList create(final Collection<Entity> elements) {
        return create(elements, CRITERIA_MOCK_SUPPLIER);
    }

    /**
     * Create a new mock instance of an EntityList, containing given values, with find() method stubbed for returning
     * SearchCriteriaBuilder objects produced by given supplier (factory, provider).
     *
     * @param elements
     *            content of new mock
     * @param criteriaBuilderFactory
     *            SearchCriteriaBuilder objects supplier
     * @return a new instance of an EntityList mock
     */
    public static EntityList create(final Collection<Entity> elements,
                                    final Supplier<SearchCriteriaBuilder> criteriaBuilderFactory) {
        return new EntityListMock(Lists.newLinkedList(elements), criteriaBuilderFactory);
    }

    public static EntityList copyOf(final EntityList entityList) {
        return create(entityList, new Supplier<SearchCriteriaBuilder>() {

            @Override
            public SearchCriteriaBuilder get() {
                return entityList.find();
            }
        });
    }

    private EntityListMock(final Collection<Entity> elements, final Supplier<SearchCriteriaBuilder> criteriaBuilderFactory) {
        super(elements);
        this.criteriaBuilderFactory = criteriaBuilderFactory;
    }

    @Override
    public SearchCriteriaBuilder find() {
        return criteriaBuilderFactory.get();
    }


}
