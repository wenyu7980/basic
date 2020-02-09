package com.wenyu7980.basic.service.common.dictionary.starter;

import com.wenyu7980.basic.common.dictionary.DictionaryEnum;
import com.wenyu7980.basic.service.common.dictionary.entity.DictionaryEntity;
import com.wenyu7980.basic.service.common.dictionary.entity.DictionaryItemEntity;
import com.wenyu7980.basic.service.common.dictionary.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
@Component
public class DictionaryStarter implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DictionaryStarter.class);
    @Autowired
    private DictionaryService dictionaryService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {
            RuntimeException.class
    })
    public void run(String... args) throws Exception {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
                false);
        // 筛选
        provider.addIncludeFilter(
                new AssignableTypeFilter(DictionaryEnum.class));
        final Set<BeanDefinition> definitions = provider
                .findCandidateComponents("com.wenyu7980");
        // 删除系统字典
        for (DictionaryEntity entity : dictionaryService
                .findBySystemFlag(true)) {
            dictionaryService.delete(entity);
        }
        for (BeanDefinition definition : definitions) {
            final Class<?> clazz = Class.forName(definition.getBeanClassName());
            Method values = clazz.getMethod("values");
            Enum<? extends DictionaryEnum>[] enums = (Enum<? extends DictionaryEnum>[]) values
                    .invoke(null);
            if (enums.length == 0) {
                continue;
            }
            DictionaryEnum dict = (DictionaryEnum) enums[0];
            DictionaryEntity entity = new DictionaryEntity(dict.dictCode(),
                    dict.dictName(), true, null);
            for (DictionaryEnum e : dict.items()) {
                entity.addItem(
                        new DictionaryItemEntity(entity, e.code(), e.name()));
            }
            dictionaryService.save(entity);
            LOGGER.debug("系统字典:{}插入，共{}个字典选项", dict.code(),
                    dict.items().length);
        }
        LOGGER.info("完成{}个系统字典插入", definitions.size());
    }
}
