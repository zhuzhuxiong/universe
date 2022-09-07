package com.universe.unishiro.first.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {

    Map<String, String> userMap = new HashMap<String, String>();

    {
        userMap.put("zhangsan", "123456");
        super.setName("myRealm");
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) principalCollection.getPrimaryPrincipal();
        Set<String> permission = getPermissionByUserName(principal);
        Set<String> roles = getRolesByUserName(principal);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permission);
        info.setRoles(roles);
        return info;
    }

    public Set<String> getRolesByUserName(String userName) {
        HashSet<String> set = new HashSet<>();
        set.add("admin");
        set.add("user");
        return set;
    }

    public Set<String> getPermissionByUserName(String userName) {
        HashSet<String> set = new HashSet<>();
        set.add("user:add");
        set.add("user:delete");
        return set;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String)authenticationToken.getPrincipal();
        String pwd = getPwdByUserName(principal);
        if (null == pwd){
            return null;
        }
        return new SimpleAuthenticationInfo("zhangsan",pwd,"myRealm");
    }

    public String getPwdByUserName(String userName) {
        return userMap.get(userName);
    }
}
