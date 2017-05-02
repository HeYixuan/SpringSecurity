package org.springframe.dao;

import org.springframe.domain.SystemUser;

/**
 * Created by HeYixuan on 2017/4/19.
 */
public interface SystemUserDao extends BaseDao<SystemUser> {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    SystemUser loadByUsername(String username);

    /**
     * 登陆失败,修改登陆次数+1
     * @param username
     */
    void updateAttempts(String username);

    /**
     * 登陆成功,重置登陆次数0
     * @param username
     */
    void resetAttempts(String username);

    /**
     * 检查用户是否存在
     * @param username
     * @return
     */
    boolean isExists(String username);

    /**
     * 锁定账户
     * @param username
     */
    void lock(String username, boolean bool);
}
