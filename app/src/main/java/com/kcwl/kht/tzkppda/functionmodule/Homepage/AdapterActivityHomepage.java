/**
 * FileName: AdapterActivityHomepage
 * Author:baijie
 * Date: 2019/11/26 15:28
 * Description: 首页的adapter
 */
package com.kcwl.kht.tzkppda.functionmodule.Homepage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.bean.ActivityHomepageBean;

import java.util.List;

/**
 * @ClassName: AdapterActivityHomepage
 * @Description: 首页的adapter
 * @Author: baijie
 * @Date: 2019/11/26 15:28
 */
public class AdapterActivityHomepage extends BaseQuickAdapter<ActivityHomepageBean, BaseViewHolder>
{

    public AdapterActivityHomepage(int layoutResId, @Nullable List<ActivityHomepageBean> data)
    {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ActivityHomepageBean item)
    {
        helper.setText(R.id.adapter_activityhomepage_item_tv_title, item.getTitle());
    }
}