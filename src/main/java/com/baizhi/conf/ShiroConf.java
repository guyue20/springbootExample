package com.baizhi.conf;


import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConf {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        HashMap<String, String> map = new HashMap<>();
        map.put("/user/loginuser","anon");
        map.put("/index.jsp","anon");
        map.put("/**","anon");
        shiroFilterFactoryBean.setLoginUrl("/commmon/login.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager getSecurityManager(Realm realm,EhCacheManager cacheManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //添加缓存
        defaultWebSecurityManager.setCacheManager(cacheManager);
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    @Bean
    public Realm getRealm(CredentialsMatcher credentialsMatcher){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }
    @Bean
    public CredentialsMatcher getCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }
    @Bean
    public EhCacheManager getCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
    }
}
