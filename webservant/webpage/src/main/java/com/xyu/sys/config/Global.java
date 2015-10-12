package com.xyu.sys.config;

import com.xyu.common.utlis.PropertiesLoader;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置类
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2015/10/6 0006
 */
public class Global {

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<String, String>();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader propertiesLoader = new PropertiesLoader("conf/project.properties");

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null){
            value = propertiesLoader.getProperty(key);
            map.put(key, value);
        }
        return value;
    }

    /////////////////////////////////////////////////////////

    /**
     * 获取管理端根路径
     */
    public static String getAdminPath() {
        return getConfig("admin.path");
    }

    /**
     * 获取前端根路径
     */
    public static String getFrontPath() {
        return getConfig("front.path");
    }

    /**
     * 获取URL后缀
     */
    public static String getUrlSuffix() {
        return getConfig("web.view.suffix");
    }

    /**
     * 是否是演示模式，演示模式下不能修改用户、角色、密码、菜单、授权
     */
    public static Boolean isDemoMode() {
        String dm = getConfig("demoMode");
        return "true".equals(dm) || "1".equals(dm);
    }

    /**
     * 获取CKFinder上传文件的根目录
     * @return
     */
    public static String getCkBaseDir() {
        String dir = getConfig("userfiles.basedir");
        Assert.hasText(dir, "配置文件里没有配置userfiles.basedir属性");
        if(!dir.endsWith("/")) {
            dir += "/";
        }
        return dir;
    }

    public static boolean isSSOLogin()
    {
        String mode = getConfig("login.mode");
        Assert.hasText(mode, "配置文件里没有配置login.mode属性");
        return mode.equalsIgnoreCase("sso");
    }

    /**加密算法配置参数*/
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    public static final String SALT_PUB_STR = "XYU";

}
