package org.springframe.test.dao;

import org.junit.Test;
import org.springframe.test.BaseTest;
import org.springframe.domain.SystemResources;
import org.springframe.dao.SystemResourcesDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;


/**
 * Created by HeYixuan on 2017/4/22.
 */
public class SystemResoucesTest extends BaseTest {

    @Autowired
    private SystemResourcesDao systemResourcesDao;

    /**
     * 根据角色查询所有资源
     * @return
     */
    @Test
    public void loadByRole(){
        Collection<SystemResources> resourcesList = systemResourcesDao.loadByRole(1);
        System.err.println("Collection is:" + resourcesList.size());
        resourcesList.forEach(resources->{
            System.err.println(resources.toString());
        });
    }


    /**
     * 根据父节点查询所有的子节点
     * @return
     */
    @Test
    public void getListByParentId(){
        Collection<SystemResources> resources = systemResourcesDao.getListByParentId(new Object[]{1});
        resources.forEach(r->{
            System.err.println(r.toString());
        });
    }

    /**
     * 查询所有资源
     * @return
     */
    @Test
    public void getList(){
        Collection<SystemResources> resources = systemResourcesDao.getList();
        resources.forEach(r->{
            System.err.println(r.toString());
        });
    }
}
