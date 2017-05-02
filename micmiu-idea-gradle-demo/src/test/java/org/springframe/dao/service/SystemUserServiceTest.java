package org.springframe.dao.service;

import org.junit.Test;
import org.springframe.BaseTest;
import org.springframe.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 接口测试类
 *
 * @author HeYixuan
 * @create 2017-04-26 21:38
 */
public class SystemUserServiceTest extends BaseTest {

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 登陆失败,修改登陆次数+1
     * 登陆成功,重置登陆次数 0
     */
    @Test
    public void updateAttempts(){
        systemUserService.updateAttempts("HeYixuan");
    }


    @Test
    public void testTrue(){
        boolean bool = true;
        if (bool){
            System.err.println("结果1:" + bool);
        } else {
            System.err.println("结果2:" + bool);
        }
    }



}
