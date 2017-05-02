package org.springframe.dao.impl;

import org.springframe.dao.SystemResourcesDao;
import org.springframe.domain.SystemResources;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by HeYixuan on 2017/4/22.
 */
@Repository
public class SystemResourcesDaoImpl extends BaseDaoImpl<SystemResources> implements SystemResourcesDao {
    @Override
    public Collection<SystemResources> loadByRole(Integer role) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT S.* FROM SYSTEM_RESOURCES S,SYSTEM_ROLE_RESOURCE RS ");
        builder.append("WHERE RS.SYSTEM_RESOURCE_ID = S.ID ");
        builder.append("AND RS.SYSTEM_ROLE_ID = ?");
        Collection<SystemResources> resources = this.getList(builder.toString(), new Object[]{role});
        return resources;
    }
}
