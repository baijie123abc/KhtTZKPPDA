/**
 * FileName: LoginBean
 * Author:baijie
 * Date: 2019/11/15 9:32
 * Description: 登录的实体类
 */
package com.kcwl.kht.tzkppda.bean;

/**
 * @ClassName: LoginBean
 * @Description: 登录的实体类
 * @Author: baijie
 * @Date: 2019/11/15 9:32
 */
public class LoginBean extends BaseBean
{

    /**
     * success : true
     * errorCode : -1
     * msg : 登录成功!
     * body : {"data":{"loginName":"2","name":"李四","roleName":"承运商管理","userId":"2ee0d4baf8dc4551906f0a0e73fdf07b","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZWUwZDRiYWY4ZGM0NTUxOTA2ZjBhMGU3M2ZkZjA3YiIsImlzcyI6ImdsaiJ9.fTI_W2bFAFGqxRavmZiPIVk5uJmYLWtWZEmGHLzzxeQ"}}
     */

    /**
     * 是否成功的标志
     */
    private boolean success;
    /**
     * 错误描述信息
     */
    private String msg;
    private BodyBean body;

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }


    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public BodyBean getBody()
    {
        return body;
    }

    public void setBody(BodyBean body)
    {
        this.body = body;
    }

    public static class BodyBean
    {
        /**
         * data : {"loginName":"2","name":"李四","roleName":"承运商管理","userId":"2ee0d4baf8dc4551906f0a0e73fdf07b","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZWUwZDRiYWY4ZGM0NTUxOTA2ZjBhMGU3M2ZkZjA3YiIsImlzcyI6ImdsaiJ9.fTI_W2bFAFGqxRavmZiPIVk5uJmYLWtWZEmGHLzzxeQ"}
         */

        private DataBean data;

        public DataBean getData()
        {
            return data;
        }

        public void setData(DataBean data)
        {
            this.data = data;
        }

        public static class DataBean
        {
            /**
             * loginName : 2
             * name : 李四
             * roleName : 承运商管理
             * userId : 2ee0d4baf8dc4551906f0a0e73fdf07b
             * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyZWUwZDRiYWY4ZGM0NTUxOTA2ZjBhMGU3M2ZkZjA3YiIsImlzcyI6ImdsaiJ9.fTI_W2bFAFGqxRavmZiPIVk5uJmYLWtWZEmGHLzzxeQ
             */


            /**
             * 用户名
             */
            private String loginName;

            /**
             * 用户名称
             */
            private String name;
            /**
             * userId
             */
            private String userId;

            public String getLoginName()
            {
                return loginName;
            }

            public void setLoginName(String loginName)
            {
                this.loginName = loginName;
            }

            public String getName()
            {
                return name;
            }

            public void setName(String name)
            {
                this.name = name;
            }


            public String getUserId()
            {
                return userId;
            }

            public void setUserId(String userId)
            {
                this.userId = userId;
            }
        }
    }
}