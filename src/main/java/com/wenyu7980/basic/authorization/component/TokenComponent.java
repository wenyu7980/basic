package com.wenyu7980.basic.authorization.component;

import com.wenyu7980.basic.authorization.constant.TokenType;
import com.wenyu7980.basic.authorization.entity.TokenEntity;
import com.wenyu7980.basic.authorization.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@Component
public class TokenComponent {
    @Autowired
    private TokenService tokenService;
    @Value("${application.login.expire:900}")
    private Long expire;

    /**
     * 生成token
     * @param userId
     * @param departmentId
     * @param username
     * @return
     */
    public Map<TokenType, String> getTokens(String userId, String departmentId,
            Boolean system, String username) {
        Map<TokenType, String> tokens = new HashMap<>(2);
        TokenEntity header = TokenEntity
                .ofHeader(userId, departmentId, system, username, expire);
        tokens.put(TokenType.HEADER, header.getToken());
        tokenService.save(header);
        TokenEntity query = TokenEntity
                .ofQuery(userId, departmentId, system, username, expire);
        tokens.put(TokenType.QUERY, query.getToken());
        tokenService.save(query);
        return tokens;
    }

    /**
     * 旧token失效
     * @param userId
     */
    public void invalidToken(String userId) {
        List<TokenEntity> tokens = tokenService.findByUserIdAndValid(userId);
        for (TokenEntity entity : tokens) {
            entity.invalid();
            tokenService.save(entity);
        }
    }

    /**
     * 获取最新的token
     * @param userId
     * @return
     */
    public Optional<TokenEntity> getLastestToken(String userId) {
        return tokenService.findLatestByUserId(userId);
    }

}
