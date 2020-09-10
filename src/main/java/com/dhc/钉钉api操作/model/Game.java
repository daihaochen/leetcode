package com.dhc.钉钉api操作.model;

/**
 * @author Haochen.Dai
 * @date Created in 2020/6/17 20:08
 * @description
 */
public class Game {
    /**游戏id*/
   
    public int id;

    /**包名*/
   
    public String packageName;

    /**app名称*/
   
    public String appName;

    /**游戏展示名*/
   
    public String displayName;

    /**app版本*/
   
    public String appVersionName;

    /**app版本号*/
   
    public int appVersionCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAppVersionName() {
        return appVersionName;
    }

    public void setAppVersionName(String appVersionName) {
        this.appVersionName = appVersionName;
    }

    public int getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(int appVersionCode) {
        this.appVersionCode = appVersionCode;
    }
}
