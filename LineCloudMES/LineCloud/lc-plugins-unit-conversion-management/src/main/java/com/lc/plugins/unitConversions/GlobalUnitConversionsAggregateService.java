package com.lc.plugins.unitConversions;

/**
 * 管理单位转换的服务
 *
 * @since 1.0.8
 * @author Terry
 */
public interface GlobalUnitConversionsAggregateService {

    /**
     * 返回现有 UnitConversionsAggregate 实体的标识符。 如果实体不存在，则创建新实体。
     * @return 现有或刚刚创建的 UnitConversionsAggregate 实体的标识符
     *
     * @throws IllegalStateException
     *         如果创建的实体有验证错误
     */
    Long getAggregateId();
}
