/**
 * FileName: AdapterActivityQuery
 * Author:baijie
 * Date: 2019/11/26 18:25
 * Description: 查询页面的adapter
 */
package com.kcwl.kht.tzkppda.functionmodule.Query;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.bean.ScanListBean;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.KhtStringUtils;

import java.util.List;

/**
 * @ClassName: AdapterActivityQuery
 * @Description: 查询页面的adapter
 * @Author: baijie
 * @Date: 2019/11/26 18:25
 */
public class AdapterActivityQuery extends BaseQuickAdapter<ScanListBean.BodyBean.RowsBean, BaseViewHolder>
{
    private Context mContext;

    public AdapterActivityQuery(int layoutResId, @Nullable List<ScanListBean.BodyBean.RowsBean> data, Context context)
    {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ScanListBean.BodyBean.RowsBean item)
    {
        helper.setText(R.id.adapter_activityquery_item_tv_weighednumber,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.WeighedNumber),
                        item.getPoundNo(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_businessnumber,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.BusinessNumber),
                        item.getSettlement().getBusinessId(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_goodsname,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.GoodsName),
                        item.getSettlement().getGoodsName(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_platenumber,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.PlateNumber),
                        item.getPlateNumber(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_driver,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.Driver),
                        item.getTruckDriver().getDriverName(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_drivertel,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.DriverTel),
                        item.getTruckDriver().getDriverTel(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_grossweight,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.GrossWeight),
                        KhtStringUtils.doubleChange2Str(item.getGrossWeight()), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_tareweight,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.TareWeight),
                        KhtStringUtils.doubleChange2Str(item.getTareWeight()), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_netweight,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.NetWeight),
                        KhtStringUtils.doubleChange2Str(item.getNetWeight()), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_weighedtime,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.WeighedTime),
                        item.getCreateDate(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityquery_item_tv_deliveryaddress,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.DeliveryAddress),
                        item.getSettlement().getDeliverAddress(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));
        helper.getView(R.id.adapter_activityquery_item_tv_deliveryaddress).setSelected(true);

        helper.setText(R.id.adapter_activityquery_item_tv_receivingaddress,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.ReceivingAddress),
                        item.getSettlement().getTakeAddress(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));
        helper.getView(R.id.adapter_activityquery_item_tv_receivingaddress).setSelected(true);

        helper.setText(R.id.adapter_activityquery_item_tv_freight,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.Freight),
                        KhtStringUtils.doubleChange2Str(item.getTotalMoney()), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));
    }
}