package org.springframe.dao;

import org.springframe.domain.SystemRole;

import java.util.List;

/**
 * Created by HeYixuan on 2017/4/20.
 */
public interface SystemRoleDao extends BaseDao<SystemRole> {

    /**
     * 根据用户ID查询用户所拥有的角色
     * @param params
     * @return
     */
    public List<SystemRole> getRoles(Object[] params);


    /**
     * 查询所有的角色
     * @return
     */
    public List<SystemRole> getList();
}
