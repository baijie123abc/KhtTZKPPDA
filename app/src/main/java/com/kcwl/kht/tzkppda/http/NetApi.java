/**
 * FileName: NetApi
 * Author:baijie
 * Date: 2019/11/13 16:31
 * Description: 所有接口请求
 */
package com.kcwl.kht.tzkppda.http;

import com.kcwl.kht.tzkppda.bean.ScanResultBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @ClassName: NetApi
 * @Description: 所有接口请求
 * @Author: baijie
 * @Date: 2019/11/13 16:31
 */
public interface NetApi
{
    /**
     * 登录接口
     *
     * @param userName 用户名
     * @param passWord 密码
     * @return
     */
    @GET("tf/login")
    Observable<ResponseBody> login(
            @Query("userName") String userName,
            @Query("password") String passWord
    );

    /**
     * 获取业务列表
     *
     * @param goodsName 产品名称
     * @param ywCode    业务编号
     * @param pageNo    当前页
     * @param pageSize  每页几条
     * @param userId    用户id
     * @return
     */
    @GET("tf/findYwList")
    Observable<ResponseBody> getSelectBusinessList(
            @Query("goodsName") String goodsName,
            @Query("ywCode") String ywCode,
            @Query("pageNo") int pageNo,
            @Query("pageSize") int pageSize,
            @Query("userId") String userId
    );

    /**
     * 根据扫描到的电子车牌查询扫描列表
     *
     * @param electronicLicensePlate 搜索内容或者是扫描的多个电子车牌拼接的字符串
     * @param ywId                   业务id
     * @param type                   0 搜索，1，扫描
     * @param pageNo                 当前页
     * @param pageSize               每页几条
     * @return
     */
    @GET("tf/getPound")
    Observable<ResponseBody> getScanResult(
            @Query("data") String electronicLicensePlate,
            @Query("ywCode") String ywId,
            @Query("type") String type,
            @Query("pageNo") int pageNo,
            @Query("pageSize") int pageSize
    );

    /**
     * 根据车牌号查询磅单列表
     *
     * @param plateNumber 车牌号
     * @param ywId        业务id
     * @param type        0 搜索，1，扫描
     * @param pageNo      当前页
     * @param pageSize    每页几条
     * @return
     */
    @GET("tf/findList")
    Observable<ResponseBody> getScanList(
            @Query("plateNumber") String plateNumber,
            @Query("ywCode") String ywId,
            @Query("type") String type,
            @Query("pageNo") int pageNo,
            @Query("pageSize") int pageSize
    );

    /**
     * 保存扫描磅单的接口
     *
     * @param pound 请求的实体
     * @return
     */
    @POST("tf/save")
    Observable<ResponseBody> saveScanPound(
            @Body() ScanResultBean.BodyBean.PoundBean pound
    );

}