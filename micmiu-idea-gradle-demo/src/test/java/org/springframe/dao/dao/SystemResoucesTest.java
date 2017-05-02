package org.springframe.dao.dao;

import org.junit.Test;
import org.springframe.BaseTest;
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

    @Test
    public void loadByRole(){
        Collection<SystemResources> resourcesList = systemResourcesDao.loadByRole(1);
        System.err.println("Collection is:" + resourcesList.size());
        resourcesList.forEach(resources->{
            System.err.println(resources.toString());
        });
    }
}
