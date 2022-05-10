package com.lc.model.api.unit;

import java.util.Collection;
import java.util.function.Function;

import com.google.common.base.Optional;
import com.google.common.collect.Collections2;
//com.lc.commons.functional.Optionals;
import com.lc.model.api.Entity;

public class EntityUtils {

    private EntityUtils() {

    }

    private static final Function<Entity, Long> FUNC_EXTRACT_ID = new Function<Entity, Long>() {

        @Override
        public Long apply(final Entity entity) {
            if (entity == null) {
                return null;
            }
            Long id =entity.getId();
            if (id ==null) {
                id = (Long) entity.getFields("id");
            }
            return id;
        }
    };

    public static <T> Function<Entity,T> getFieldExtractor(final  String fieldName) {
        return new Function<Entity, T>() {

            @Override
            public T apply(Entity entity) {
                if (entity ==null) {
                    return null;
                }
                return (T) entity.getField(fieldName);
            }
        };
    }

    private static Function<Entity,Entity> getBelongsToFieldExtractor(final String belongsToFieldName) {
        return new Function<Entity, Entity>() {

            @Override
            public Entity apply(Entity entity) {
                if (entity == null) {
                    return null;
                }
                return entity.getBelongsToField(belongsToFieldName);
            }
        };
    }

    public static <T> Function<Entity, Optional<T>> getSafeFieldExtractor(final String fieldName) {
        Function<Entity, T> getFieldFunc = getFieldExtractor(fieldName);
        return Optionals.lift(getFieldFunc);
    }

    public static Function<Entity, Long> getIdExtractor() {
        return FUNC_EXTRACT_ID;
    }

    public static Function<Entity, Optional<Long>> getSafeIdExtractor() {
        return Optionals.lift(FUNC_EXTRACT_ID);
    }

    public static Collection<Long> getIdsView(final Collection<Entity> entities) {
        return Collections2.transform(entities, getIdExtractor());
    }

    public static <T> Collection<T> getFieldsView(final Collection<Entity> entities, final String fieldName) {
        return Collections2.transform(entities, (Function<Entity, T>) getFieldExtractor(fieldName));
    }
}
