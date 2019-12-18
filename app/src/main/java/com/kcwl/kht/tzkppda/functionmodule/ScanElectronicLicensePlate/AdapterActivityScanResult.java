/**
 * FileName: AdapterActivityScanResult
 * Author:baijie
 * Date: 2019/11/26 16:50
 * Description: 扫描结果列表的adapter
 */
package com.kcwl.kht.tzkppda.functionmodule.ScanElectronicLicensePlate;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kcwl.kht.tzkppda.R;
import com.kcwl.kht.tzkppda.bean.ScanResultBean;
import com.kcwl.kht.tzkppda.utils.Constant;
import com.kcwl.kht.tzkppda.utils.KhtStringUtils;

import java.util.List;

/**
 * @ClassName: AdapterActivityScanResult
 * @Description: 扫描结果列表的adapter
 * @Author: baijie
 * @Date: 2019/11/26 16:50
 */
public class AdapterActivityScanResult extends BaseQuickAdapter<ScanResultBean.BodyBean.PoundBean, BaseViewHolder>
{

    private Context mContext;

    public AdapterActivityScanResult(int layoutResId, @Nullable List<ScanResultBean.BodyBean.PoundBean> data, Context context)
    {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ScanResultBean.BodyBean.PoundBean item)
    {
        helper.setText(R.id.adapter_activityscanresult_item_tv_platenumber,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.PlateNumber),
                        item.getPlateNumber(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityscanresult_item_tv_todayfinishtime,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.TodayFinishTime),
                        item.getDataType(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityscanresult_item_tv_goodsname,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.GoodsName),
                        item.getSettlement().getGoodsName(), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityscanresult_item_tv_deliveryaddress,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.DeliveryAddress),
                        item.getSettlement().getDeliverProvinceName() + item.getSettlement().getDeliverCityName()
                                + item.getSettlement().getDeliverCountyName() + item.getSettlement().getDeliverAddress(),
                        mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));
        helper.getView(R.id.adapter_activityscanresult_item_tv_deliveryaddress).setSelected(true);

        helper.setText(R.id.adapter_activityscanresult_item_tv_receivingaddress,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.ReceivingAddress),
                        item.getSettlement().getTakeProvinceName() + item.getSettlement().getTakeCityName()
                                + item.getSettlement().getTakeCountyName(),
                        mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));
        helper.getView(R.id.adapter_activityscanresult_item_tv_receivingaddress).setSelected(true);

        helper.setText(R.id.adapter_activityscanresult_item_tv_tareweight,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.TareWeight),
                        KhtStringUtils.doubleChange2Str(item.getTareWeight()), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityscanresult_item_tv_grossweight,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.GrossWeight),
                        KhtStringUtils.doubleChange2Str(item.getGrossWeight()), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.setText(R.id.adapter_activityscanresult_item_tv_netweight,
                KhtStringUtils.getStringByFormatAndSpan(mContext.getResources().getString(R.string.NetWeight),
                        KhtStringUtils.doubleChange2Str(item.getNetWeight()), mContext.getColor(R.color.Text_Color), Constant.SYMBOL_COLON));

        helper.addOnClickListener(R.id.adapter_activityscanresult_item_btn_confirm);
    }
}