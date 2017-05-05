package org.springframe.test.dao;

import org.junit.Test;
import org.springframe.test.BaseTest;
import org.springframe.system.domain.SystemUser;
import org.springframe.system.dao.SystemUserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by HeYixuan on 2017/4/19.
 */
public class SystemUserTest extends BaseTest {

    @Autowired
    private SystemUserDao systemUserDao;


    @Test
    public void loadByUsername(){
        SystemUser systemUser = systemUserDao.loadByUsername("HeYixuan");
        System.err.println("用户名:" + systemUser.getUsername());
        System.err.println("手机号:" + systemUser.getPhone());
        /*if (StringUtils.isEmpty(systemUser)){
            logger.error("Object is not null.");
            return null;
        }
        if (CollectionUtils.isEmpty(roles)){
            logger.error("Collections is not null.");
        }*/
    }



    /**
     * 登陆失败,修改登陆次数+1
     */
    @Test
    public void updateAttempts(){
        //String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format();
        System.err.println("系统当前时间："+new Date());
        systemUserDao.updateAttempts("HeYixuan");
    }

    /**
     * 登陆成功,重置登陆次数0
     */
    @Test
    public void resetAttempts(){
        systemUserDao.resetAttempts("HeYixuan");
    }

    /**
     * 检查用户是否存在
     * @return
     */
    @Test
    public void isExists(){
        boolean bool = systemUserDao.isExists("HeYixuan");
        System.err.println("结果：" + bool);
    }


    /**
     * 锁定账户
     */
    @Test
    public void lock(){
        systemUserDao.lock("HeYixuan",false);
    }

}
