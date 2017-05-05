package org.springframe.system.dao.impl;

import org.springframe.system.dao.SystemRoleResoucesDao;
import org.springframe.system.vo.SystemRoleResouces;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author: HeYixuan
 * @create: 2017-05-05 13:22
 */
@Repository
public class SystemRoleResourcesDaoImpl extends BaseDaoImpl<SystemRoleResouces> implements SystemRoleResoucesDao {
    @Override
    public Collection<SystemRoleResouces> getList() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ROLE.`NAME` ROLENAME, R.`NAME` RESOUCENAME,R.URL URL, R.ACTION ACTION ");
        builder.append("FROM SYSTEM_ROLE ROLE ,SYSTEM_RESOURCES R ,SYSTEM_ROLE_RESOURCE P ");
        builder.append("WHERE P.SYSTEM_ROLE_ID=ROLE.ID AND P.SYSTEM_RESOURCE_ID=R.ID;");
        return this.getList(builder.toString());
    }
}
