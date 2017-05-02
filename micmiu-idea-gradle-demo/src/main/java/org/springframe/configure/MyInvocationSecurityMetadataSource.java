package org.springframe.configure;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

/**
 * ${DESCRIPTION}
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
