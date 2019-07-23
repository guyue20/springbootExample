package com.baizhi.conf;

import com.baizhi.entity.Teacher;
import com.baizhi.mapper.TeacherMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    TeacherMapper teacherMapper;

    @Override//授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("===================");
        String primary = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("super");
        authorizationInfo.addStringPermission("user:add");
        return authorizationInfo;
    }

    @Override //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String)authenticationToken.getPrincipal();
        //查数据库
        Teacher teacher = new Teacher();
        teacher.setUser_name(principal);
        System.out.println(teacherMapper.select(teacher));

        if("zhangsan".equals(principal))
        {
            AuthenticationInfo  authenticationInfo=new SimpleAuthenticationInfo("zhangsan","3d53b73c485f523ef2fe45f2b8dd3c58", ByteSource.Util.bytes("ABCD"),this.getName());
            return authenticationInfo;
        }
        return null;
    }
}
