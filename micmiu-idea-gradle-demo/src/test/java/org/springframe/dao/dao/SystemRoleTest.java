package org.springframe.dao.dao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframe.BaseTest;
import org.springframe.domain.SystemRole;
import org.springframe.service.SystemRoleService;
import org.springframe.dao.SystemRoleDao;
import org.springframe.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by HeYixuan on 2017/4/20.
 */
public class SystemRoleTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SystemRoleDao systemRoleDao;

    @Autowired
    private SystemRoleService systemRoleService;

    @Test
    public void getList(){
        String sql ="SELECT * FROM SYSTEM_ROLE";
        Page<SystemRole> pageList = systemRoleDao.getList(sql,new Object[]{},1,10);
        System.err.println("结果:"+pageList.getRows());
    }

   @Test
   public void loadByUsername(){
       List<SystemRole> roles = systemRoleService.getRoles("ZM");
       try{
           roles.forEach(role -> {
               System.err.println("角色:" + role.getName());
           });
       }catch (Exception e){
           logger.error("数据查询失败...", e.getMessage());

       }

   }

    @Test
    public void getList2(){
        String sql ="SELECT * FROM SYSTEM_ROLE";
        Page<SystemRole> pageList = systemRoleDao.getList(sql,new Object[]{},1,10);
        System.err.println("结果:"+pageList.getRows());
    }

    @Test
    public void getList3(){
        List<SystemRole> roles = systemRoleDao.getList("SELECT * FROM SYSTEM_ROLE WHERE ID = ?", new Object[]{1});

        roles.forEach(role->{
            System.err.println("角色集合:"+role.getName());
        });

    }
}
