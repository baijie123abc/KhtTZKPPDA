/**
 * FileName: BaseModel
 * Author:baijie
 * Date: 2019/11/13 15:57
 * Description: BaseModel
 */
package com.kcwl.kht.tzkppda.base;


import com.kcwl.kht.tzkppda.http.NetApi;
import com.kcwl.kht.tzkppda.http.NetClient;

/**
 * @ClassName: BaseModel
 * @Description: BaseModel
 * @Author: baijie
 * @Date: 2019/11/13 15:57
 */
public class BaseModel
{
    protected static NetApi netApi;

    public BaseModel()
    {
        netApi = NetClient.getClient().create(NetApi.class);
    }

    public static void resetUrl(String url)
    {
        NetClient.getClient().resetUrl(url);
    }
}