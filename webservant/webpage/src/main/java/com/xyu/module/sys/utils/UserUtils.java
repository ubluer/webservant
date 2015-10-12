package com.xyu.module.sys.utils;

import com.xyu.core.spring.SpringContextHolder;
import com.xyu.module.sys.config.Global;
import com.xyu.module.sys.shiro.Principal;
import com.xyu.module.sys.user.bean.User;
import com.xyu.module.sys.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/6 0006
 */
public class UserUtils {
    private static IUserService userService = SpringContextHolder.getBean("userService");

    public static final String CACHE_USER = "user";

    public static User getUser(){
        User user = (User)getCache(CACHE_USER);
        if (user == null){
            try{
                Subject subject = SecurityUtils.getSubject();
                Principal principal = (Principal)subject.getPrincipal();
                if (principal!=null){
                    user = userService.selectByKey(principal.getId());
                    user =new User();
                    putCache(CACHE_USER, user);
                }
            }catch (UnavailableSecurityManagerException e) {

            }catch (InvalidSessionException e){

            }
        }
        if (user == null){
            user = new User();
            try{
                SecurityUtils.getSubject().logout();
            }catch (UnavailableSecurityManagerException e) {

            }catch (InvalidSessionException e){

            }
        }
        return user;
    }

    public static User getUser(boolean isRefresh){
        if (isRefresh){
            removeCache(CACHE_USER);
        }
        return getUser();
    }
    // ============== User Cache ==============

    public static Object getCache(String key) {
        return getCache(key, null);
    }

    public static Object getCache(String key, Object defaultValue) {
        Object obj = getCacheMap().get(key);
        return obj==null?defaultValue:obj;
    }

    public static void putCache(String key, Object value) {
        getCacheMap().put(key, value);
    }

    public static void removeCache(String key) {
        getCacheMap().remove(key);
    }

    public static Map<String, Object> getCacheMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Subject subject = SecurityUtils.getSubject();
            Principal principal = (Principal)subject.getPrincipal();
            return principal!=null?principal.getCacheMap():map;
        }catch (UnavailableSecurityManagerException e) {

        }catch (InvalidSessionException e){

        }
        return map;
    }

    /**
     * 用户密码加密
     * @param password 用户密码
     * @return 加密后字符串
     */
    public static String encodePassword(String password){
        String secret = new SimpleHash(
                Global.HASH_ALGORITHM,
                password,
                ByteSource.Util.bytes(Global.SALT_PUB_STR),
                Global.HASH_INTERATIONS).toHex();
//        String secret = Encoder.encodeHex(password.getBytes());
//        secret = Encoder.encodeBase62(secret.getBytes());
//        secret = Encoder.encodeHex(secret.getBytes());
        return secret;
    }
    /**
     * 用户密码加密
     * @param password 用户密码
     * @return 加密后字符串
     */
    public static String encodePassword(char[] password){
        String secret = String.valueOf(password);
        return encodePassword(secret);
    }
}
