package org.springframe.system.dao;

import org.springframe.system.vo.SystemRoleResouces;

import java.util.Collection;

/**
 * @author: HeYixuan
 * @create: 2017-05-05 13:21
 */
public interface SystemRoleResoucesDao extends BaseDao<SystemRoleResouces> {

    public Collection<SystemRoleResouces> getList();
}
