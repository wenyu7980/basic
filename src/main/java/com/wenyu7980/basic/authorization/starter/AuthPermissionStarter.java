package com.wenyu7980.basic.authorization.starter;

import com.wenyu7980.basic.authorization.annotation.AuthRequest;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.permission.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 配合
 *
 * RestController RequestMapping AuthRequest ApiOperator等注解使用
 * @author wenyu
 * @date 2020-02-08 
 */
@Component
public class AuthPermissionStarter implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AuthPermissionStarter.class);
    @Autowired
    private PermissionService permissionService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void run(String... args) throws Exception {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
                false);
        // 筛选
        provider.addIncludeFilter(
                new AnnotationTypeFilter(RestController.class));
        final Set<BeanDefinition> definitions = provider
                .findCandidateComponents("com.wenyu7980");
        // 旧的
        Set<PermissionEntity> olds = permissionService.findAll();
        // 新的
        Set<PermissionEntity> news = new HashSet<>();
        for (BeanDefinition definition : definitions) {
            final Class<?> clazz = Class.forName(definition.getBeanClassName());
            RequestMapping requestMapping = clazz
                    .getAnnotation(RequestMapping.class);
            if (Objects.isNull(requestMapping)) {
                continue;
            }
            // 将类上的RequestMapping的path取出
            String path = this
                    .getPath(requestMapping.value(), requestMapping.path());
            // controller类中所有方法
            for (Method method : clazz.getDeclaredMethods()) {
                AuthRequest request = method.getAnnotation(AuthRequest.class);
                if (Objects.nonNull(request) && !request.required() && !request
                        .check()) {
                    // 无需权限校验的接口
                    continue;
                }
                for (Annotation annotation : method.getAnnotations()) {
                    MappingInfo info = new MappingInfo();
                    info.addPath(path);
                    if (!this.fetchMappingToInfo(annotation, info)) {
                        continue;
                    }
                    // 获取接口权限名
                    ApiOperation operation = method
                            .getAnnotation(ApiOperation.class);
                    if (Objects.nonNull(operation)) {
                        info.setName(operation.value());
                    }
                    news.add(new PermissionEntity(info.getMethod(),
                            info.getPath(), info.getName()));
                    LOGGER.debug("接口:{}", info);
                }

            }
        }
        // 删除废除的
        olds.removeAll(news);
        permissionService.deleteAll(olds);
        // 保存
        permissionService.saveAll(news);
        LOGGER.info("权限接口共{}个", news.size());

    }

    private boolean fetchMappingToInfo(Annotation annotation, MappingInfo info)
            throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        if (annotation instanceof RequestMapping) {
            RequestMapping mapping = (RequestMapping) annotation;
            info.setMethod(mapping.method().toString());
            info.addPath(getPath(mapping.value(), mapping.path()));
            return true;
        }
        if (null != annotation.annotationType()
                .getAnnotation(RequestMapping.class)) {
            info.setMethod(annotation.annotationType()
                    .getAnnotation(RequestMapping.class).method()[0]
                    .toString());
            Method value = annotation.getClass().getMethod("value");
            Method path = annotation.getClass().getMethod("path");
            info.addPath(getPath((String[]) value.invoke(annotation),
                    (String[]) path.invoke(annotation)));
            return true;
        }
        return false;
    }

    private String getPath(String[] value, String[] path) {
        StringBuilder builder = new StringBuilder();
        for (String p : value) {
            builder.append("/" + p);
        }
        for (String p : path) {
            builder.append("/" + p);
        }
        return builder.toString();
    }

    private static class MappingInfo {
        private String name;
        private String method;
        private String path = "";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getPath() {
            return path.replaceAll("\\{[^{]*\\}", "*");
        }

        public void addPath(String path) {
            this.path = this.path + path;
        }

        @Override
        public String toString() {
            return "MappingInfo{" + "name='" + name + '\'' + ", method='"
                    + method + '\'' + ", path='" + path + '\'' + '}';
        }
    }
}
