package com.wenyu7980.basic.config.database.audit;

import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-02-01 
 */
@Component
public class UserAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(AuthorizationUtil.getUserId());
    }
}
