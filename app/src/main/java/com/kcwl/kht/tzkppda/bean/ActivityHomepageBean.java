/**
 * FileName: ActivityHomepageBean
 * Author:baijie
 * Date: 2019/11/26 15:29
 * Description: 首页的实体
 */
package com.kcwl.kht.tzkppda.bean;

/**
 * @ClassName: ActivityHomepageBean
 * @Description: 首页的实体
 * @Author: baijie
 * @Date: 2019/11/26 15:29
 */
public class ActivityHomepageBean extends BaseBean
{
    private String title;
    private String pageType;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPageType()
    {
        return pageType;
    }

    public void setPageType(String pageType)
    {
        this.pageType = pageType;
    }
}