package org.springframe.system.dao.impl;

import org.springframe.system.dao.SystemUserDao;
import org.springframe.system.domain.SystemUser;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by HeYixuan on 2017/4/20.
 */
@Repository
public class SystemUserDaoImpl extends BaseDaoImpl<SystemUser> implements SystemUserDao {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public SystemUser loadByUsername(String username) {
        String sql = "SELECT U.* FROM SYSTEM_USER U WHERE U.USERNAME = ?;";
        return this.get(sql, new Object[]{username});
    }

    /**
     * 登陆失败,修改登陆次数+1
     * @param username
     */
    public void updateAttempts(String username){
        String sql = "UPDATE SYSTEM_USER SET ATTEMPTS = ATTEMPTS + 1, LAST_TIME = ? WHERE USERNAME = ?;";
        this.update(sql, new Object[]{new Date(), username});
    }

    /**
     * 登陆成功,重置登陆次数0
     * @param username
     */
    public void resetAttempts(String username){
        String sql = "UPDATE SYSTEM_USER SET ATTEMPTS = 0, LAST_TIME = ? WHERE USERNAME = ?;";
        this.update(sql, new Object[]{new Date(), username});
    }

    /**
     * 检查用户是否存在
     * @param username
     * @return
     */
    public boolean isExists(String username) {
        boolean result = false;
        String sql = "SELECT COUNT(1) FROM SYSTEM_USER WHERE USERNAME = ?;";
        int count = count(sql, new Object[]{username});
        if (count > 0) {
            result = true;
        }
        return result;
    }

    /**
     * 锁定账户
     * @param username
     */
    public void lock(String username, boolean bool){
        String sql = "UPDATE SYSTEM_USER SET ACCOUNT_NON_LOCKED = ?, LAST_TIME = ? WHERE USERNAME = ?;";
        this.update(sql, new Object[]{bool, new Date(), username});
    }
}
