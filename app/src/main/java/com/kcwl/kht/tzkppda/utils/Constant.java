/**
 * FileName: Constant
 * Author:baijie
 * Date: 2019/11/13 15:59
 * Description: 常量类
 */
package com.kcwl.kht.tzkppda.utils;

/**
 * @ClassName: Constant
 * @Description: 常量类
 * @Author: baijie
 * @Date: 2019/11/13 15:59
 */
public class Constant
{
    //key的前缀
    private static final String PREFIX = "TZKPPDA";
    //是否登录Key
    public static final String KEY_LOGIN = PREFIX + "Key_Login";
    //登录名Key
    public static final String KEY_LOGINNAME = PREFIX + "Key_LoginName";
    //登录密码的Key
    public static final String KEY_PASSWORD = PREFIX + "KeyPassword";
    //UserId Key
    public static final String KEY_USERID = PREFIX + "Key_UserId";
    //用户真实姓名的Key
    public static final String KEY_USERNAME = PREFIX + "Key_UserName";
    //用户角色的Key
    public static final String KEY_ROLE = PREFIX + "Key_Role";
    //扫描枪每次扫描的总时长的key，单位是秒
    public static final String KEY_SCANTIME = PREFIX + "Key_ScanTime";
    //配置访问IP使用的KEY
    public static final String KEY_IP = PREFIX + "Key_IP";
    //业务编号的KEY
    public static final String KEY_BUSINESSCODE = PREFIX + "Key_BusinessCode";
    //跳转页面携带电子车牌参数的key
    public static final String KEY_PLATE = PREFIX + "Key_plate";
    //UserToken
    public static String USER_TOKEN = "";
    //是否登录标识
    public static boolean isLogin = false;
    /*
     * 当前网络状态
     * */
    public static int NET_STATE = -1;

    public static final String PAGE_TITLE_LOGIN = "登录";
    public static final String PAGE_TITLE_MAINPAGE = "主页";
    public static final String PAGE_TITLE_SELECTBUSINESS = "选择业务";
    public static final String PAGE_TITLE_SCANRESULT = "扫描结果";
    public static final String PAGE_TITLE_QUERY = "查询";
    public static final String PAGE_TITLE_SETTING = "设置";

    public static final String IP_NOT_EMPTY = "IP地址不能为空！";
    public static final String IP_REGEX = "IP地址不正确，请输入正确的IP地址！";
    public static final String IP_NOT_CHANGE = "IP地址未作任何改变!";
    public static final String SAVE_SUCCESS = "保存成功！";
    public static final String OLD_PASSWORD_NOT_EMPTY = "原密码不能为空！";
    public static final String NEW_PASSWORD_NOT_EMPTY = "新密码不能为空！";
    public static final String NET_DATA_ERRORWORD = "后台未返回数据，请检查后台！";
    public static final String NET_IS_NOT_AVAILABLE = "当前无网络连接，请检查网络！";
    public static final String NO_URL_WORD = "当前无访问地址，请在设置页面配置访问地址！";
    public static final String LOGIN_SUCCESS = "登录成功！";
    public static final String EXIT_WORD = "再按一次返回键退出应用！";
    public static final String EXIT_LOGIN_WORD = "还未登录，请先登录！";
    public static final String CHANGEWORD_NOT_LOGIN_WORD = "请登录后修改密码！";
    public static final String CHANGEWORD_RELOGIN_WORD = "密码修改成功，需要重新登录！";
    public static final String ACCOUNT_NOTEMPTY = "账号不能为空！";
    public static final String PASSWORD_NOTEMPTY = "密码不能为空！";
    public static final String PASSWORD_LENGTH_NOTENOUGHLONG = "密码长度要大于6位！";


    public static final String SYMBOL_COLON = "：";

}