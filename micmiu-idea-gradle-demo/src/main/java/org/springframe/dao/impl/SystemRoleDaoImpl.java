package org.springframe.dao.impl;

import org.springframe.dao.SystemRoleDao;
import org.springframe.domain.SystemRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HeYixuan on 2017/4/20.
 */
@Repository
public class SystemRoleDaoImpl extends BaseDaoImpl<SystemRole> implements SystemRoleDao {


    public List<SystemRole> getRoles(Object[] params){
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT R.NAME FROM SYSTEM_ROLE R,SYSTEM_USER_ROLE UR ");
        builder.append("WHERE R.ID = UR.SYSTEM_ROLE_ID ");
        builder.append("AND UR.SYSTEM_USER_ID = ?;");
        return this.getList(builder.toString(), params);
    }
}
