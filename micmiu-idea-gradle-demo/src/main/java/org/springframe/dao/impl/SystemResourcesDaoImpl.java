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
        builder.append("AND RS.SYSTEM_ROLE_ID = ?;");
        return this.getList(builder.toString(), new Object[]{role});
    }

    @Override
    public Collection<SystemResources> getListByParentId(Object[] params) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT T2.* FROM SYSTEM_RESOURCES T1 ");
        builder.append("LEFT JOIN SYSTEM_RESOURCES AS T2 ");
        builder.append("ON T2.PARENT_ID = T1.ID ");
        builder.append("WHERE T1.ID= ?;");
        return this.getList(builder.toString(), params);
    }

    @Override
    public Collection<SystemResources> getList() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM SYSTEM_RESOURCES R;");
        return this.getList(builder.toString());
    }

}
