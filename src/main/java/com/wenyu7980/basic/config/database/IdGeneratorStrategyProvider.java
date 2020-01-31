package com.wenyu7980.basic.config.database;

import com.wenyu7980.basic.config.database.generator.UUIDGenerator;
import org.hibernate.jpa.spi.IdentifierGeneratorStrategyProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * ID生成器
 * @author wenyu
 * @date 2020-01-31 
 */
public class IdGeneratorStrategyProvider
        implements IdentifierGeneratorStrategyProvider {
    @Override
    public Map<String, Class<?>> getStrategies() {
        Map<String, Class<?>> strategies = new HashMap<>();
        strategies.put("uuid32", UUIDGenerator.class);
        return strategies;
    }

}
