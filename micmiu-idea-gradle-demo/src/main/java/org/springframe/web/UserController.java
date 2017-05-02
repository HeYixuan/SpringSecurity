package org.springframe.web;/**
 * Created by HeYixuan on 2017/4/25.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户控制器
 *
 * @author HeYixuan
 * @create 2017-04-25 15:59
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(){
        return "user/user";
    }
}
