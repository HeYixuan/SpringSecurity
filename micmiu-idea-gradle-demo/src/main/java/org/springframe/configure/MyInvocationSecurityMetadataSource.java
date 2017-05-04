package org.springframe.configure;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

/**
 * 该类是资源的访问权限的定义，实现资源和访问权限的对应关系
 * 该类的主要作用是在Spring Security的整个过滤链启动后，
 * 在容器启动的时候，程序就会进入到该类中的init()方法，init调用了loadResourceDefine()方法，
 * 该方法的主要目的是将数据库中的所有资源与权限读取到本地缓存中保存起来！
 * 类中的resourceMap就是保存的所有资源和权限的集合，URL为Key，权限作为Value！
 *
 * @author HeYixuan
 * @create 2017-04-27 22:05
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private ConcurrentMap<String, Collection<ConfigAttribute>> resourceMap = null;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // object 是一个URL，被用户请求的url。</span>
        FilterInvocation filterInvocation = (FilterInvocation) object;
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
