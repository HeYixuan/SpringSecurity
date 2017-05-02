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
}
