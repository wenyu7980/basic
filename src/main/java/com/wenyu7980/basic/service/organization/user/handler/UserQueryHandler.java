package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.common.query.PageBody;
import com.wenyu7980.basic.service.organization.user.domain.UserDetail;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import com.wenyu7980.query.QueryPredicateExpress;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public interface UserQueryHandler {
    /**
     * 查询
     * @param express
     * @param pageable
     * @param detail
     * @return
     */
    PageBody<UserListDetail> getUsers(QueryPredicateExpress express,
            Pageable pageable, boolean detail);

    /**
     * 用户查询
     * @param userId
     * @param detail
     * @return
     */
    UserDetail getUser(String userId, boolean detail);
}
