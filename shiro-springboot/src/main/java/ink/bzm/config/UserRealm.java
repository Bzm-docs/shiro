package ink.bzm.config;

import ink.bzm.pojo.User;
import ink.bzm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lijincan
 * @date: 2020年02月26日 13:19
 * @Description: TODO
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        //授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加授权信息,登入成功的用户都会经过
//        info.addStringPermission("user:add");

        //获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();

        //获得下面认证查询传入的user对象信息
        User currentUser = (User) subject.getPrincipal();
        info.addStringPermission(currentUser.getPrams());

        return info;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthenticationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从真实数据库去查数据
        User user = userService.queryUserByName(userToken.getUsername());

        if (DefaultFilter.user ==null){
            return null;
        }

        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);

        //可以加密
        //Object principal, Object credentials, String realmName
        //Object principal      用个传入一个对象
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
