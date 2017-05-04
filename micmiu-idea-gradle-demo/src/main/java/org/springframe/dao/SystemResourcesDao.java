package org.springframe.dao;

import org.springframe.domain.SystemResources;

import java.util.Collection;

/**
 * Created by HeYixuan on 2017/4/22.
 */
public interface SystemResourcesDao extends BaseDao<SystemResources> {

    /**
     * 根据角色查询所有资源
     * @param role
     * @return
     */
    public Collection<SystemResources> loadByRole(Integer role);

    /**
     * 根据父节点查询所有的子节点
     * @param params
     * @return
     */
    public Collection<SystemResources> getListByParentId(Object[] params);

    /**
     * 查询所有资源
     * @return
     */
    public Collection<SystemResources> getList();

}
