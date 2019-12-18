/**
 * FileName: AdapterActivitySelectBusiness
 * Author:baijie
 * Date: 2019/11/26 14:25
 * Description: 业务选择列表的adapter
 */
package com.kcwl.kht.tzkppda.functionmodule.SelectBusiness;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.bean.SelectBusinessListBean;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.KhtStringUtils;

import java.util.List;

/**
 * @ClassName: AdapterActivitySelectBusiness
 * @Description: 业务选择列表的adapter
 * @Author: baijie
 * @Date: 2019/11/26 14:25
 */
public class AdapterActivitySelectBusiness extends BaseQuickAdapter<SelectBusinessListBean.BodyBean.RowsBean, BaseViewHolder>
{

    private Context mContext;

    public AdapterActivitySelectBusiness(int layoutResId, @Nullable List<SelectBusinessListBean.BodyBean.RowsBean> data, Context context)
    {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, SelectBusinessListBean.BodyBean.RowsBean item)
    {
        helper.setText(R.id.adapter_activityselectbusiness_item_tv_businessnumber,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.BusinessNumber),
                        item.getBusinessId(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityselectbusiness_item_tv_goodsname,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.GoodsName),
                        item.getGoodsName(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityselectbusiness_item_tv_deliveryaddress,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.DeliveryAddress), item.getDeliverAddress(),
                        mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));
        helper.getView(R.id.adapter_activityselectbusiness_item_tv_deliveryaddress).setSelected(true);

        helper.setText(R.id.adapter_activityselectbusiness_item_tv_receivingaddress,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.ReceivingAddress), item.getTakeAddress(),
                        mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));
        helper.getView(R.id.adapter_activityselectbusiness_item_tv_receivingaddress).setSelected(true);
    }
}