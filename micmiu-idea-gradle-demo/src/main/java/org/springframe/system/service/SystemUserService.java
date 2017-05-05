package org.springframe.system.service;

import org.springframework.security.authentication.LockedException;

/**
 * Created by HeYixuan on 2017/4/26.
 */

public interface SystemUserService {

    /**
     * 登陆失败,修改登陆次数+1
     * 登陆成功,重置登陆次数 0
     * @param username
     */
    void updateAttempts(String username);
}
