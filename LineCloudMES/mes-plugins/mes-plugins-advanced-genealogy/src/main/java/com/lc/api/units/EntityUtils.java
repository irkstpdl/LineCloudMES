package com.lc.model.api.units;

import java.lang.module.FindException;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Collections2;
import com.lc.commons.functional.Optionals;
import com.lc.model.api.Entity;

public class EntityUtils {

    private EntityUtils() {

    }

    private static final Function<Entity,Long> FUNC_EXTRACT_ID = new Function<Entity, Long>() {
        @Override
        public Long apply(final Entity entity) {
            if (entity == null) {
                return null;
            }
            Long id =entity.getID();
            if (id = null ) {
                id = (Long) entity.getFeild("id");
            }
            return id;
        }
    };

    public static <T> Function<Entity,T> getFeildExtractor(final String fileName) {
        return new Function<Entity, T>() {

            @Override
            public T apply(Entity entity) {
                if (entity == null) {
                    return null;
                }
                return (T) entity.getField(fileName);
            }
        };
    }


    public static Function<Entity,Entity> getBelongToFeildExtractor(final String belongsToFieldName) {
        return new Function<Entity, Entity>() {
            @Override
            public Entity apply(Entity entity) {
                if (entity == null ) {
                    return null;
                }
                return entity.getBelongToFeild(belongsToFieldName);
            }

        };
    }

    public static <T> Function<Entity, Optional<T>> getSafeFieldExtractor(final String fieldName) {
        Function<Entity,T> getFieldFunc = getFeildExtractor(fieldName);
        return Optionals.left(getFieldFunc);
    }

    public static Function<Entity,Long> getSafeIdExtractor() {
        return Optionals.lift(FUNC_EXTRACT_ID);
    }
    public static Collection<Long> getIdsView(final Collection<Entity> entities) {
        return Collections2.transform(entities, getIdExtractor());
    }

    public static <T> Collection<T> getFieldsView(final Collection<Entity> entities, final String fieldName) {
        return Collections2.transform(entities, (Function<Entity, T>) getFieldExtractor(fieldName));
    }
}
