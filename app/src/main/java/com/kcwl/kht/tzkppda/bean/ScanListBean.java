/**
 * FileName: ScanListBean
 * Author:baijie
 * Date: 2019/11/26 18:26
 * Description: 查询磅单列表的实体
 */
package com.kcwl.kht.tzkppda.bean;

import java.util.List;

/**
 * @ClassName: ScanListBean
 * @Description: 查询磅单列表的实体
 * @Author: baijie
 * @Date: 2019/11/26 18:26
 */
public class ScanListBean extends BaseBean
{
    /**
     * success : true
     * msg : 获取列表成功
     * body : {"rows":[{"id":"41651321","createDate":"2019-11-25 08:35:59","poundNo":"21911250001","plateNumber":"晋QM4397","grossWeight":28.5,"netWeight":17,"tareWeight":11.5,"settlement":{"id":"6c887a67995e47958fba5ee0744fea0d","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"北京北京市东城区东方大厦","takeAddress":"山西省太原市小店区巨鑫国际"},"truckLicense":{"id":"8917ca2d745740628764e8cb6d115418"},"truckType":{"id":"1359c6d4ff1844ae86c75315a0fd9258"},"truck":{"id":"08880bd0f766497a812f8367dabcfe02"},"truckDriver":{"id":"98f840a3c10b4566be90cfafd32add48","driverName":"张建国","driverTel":"18577779988"},"totalMoney":210,"deficitTonValue":0,"weightRangeBottom":0,"weightRangeTop":0,"money":210}],"total":1,"pageNum":1}
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
         * rows : [{"id":"41651321","createDate":"2019-11-25 08:35:59","poundNo":"21911250001","plateNumber":"晋QM4397","grossWeight":28.5,"netWeight":17,"tareWeight":11.5,"settlement":{"id":"6c887a67995e47958fba5ee0744fea0d","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"北京北京市东城区东方大厦","takeAddress":"山西省太原市小店区巨鑫国际"},"truckLicense":{"id":"8917ca2d745740628764e8cb6d115418"},"truckType":{"id":"1359c6d4ff1844ae86c75315a0fd9258"},"truck":{"id":"08880bd0f766497a812f8367dabcfe02"},"truckDriver":{"id":"98f840a3c10b4566be90cfafd32add48","driverName":"张建国","driverTel":"18577779988"},"totalMoney":210,"deficitTonValue":0,"weightRangeBottom":0,"weightRangeTop":0,"money":210}]
         * total : 1
         * pageNum : 1
         */

        private int total;
        private int pageNum;
        private List<RowsBean> rows;

        public int getTotal()
        {
            return total;
        }

        public void setTotal(int total)
        {
            this.total = total;
        }

        public int getPageNum()
        {
            return pageNum;
        }

        public void setPageNum(int pageNum)
        {
            this.pageNum = pageNum;
        }

        public List<RowsBean> getRows()
        {
            return rows;
        }

        public void setRows(List<RowsBean> rows)
        {
            this.rows = rows;
        }

        public static class RowsBean
        {
            /**
             * id : 41651321
             * createDate : 2019-11-25 08:35:59
             * poundNo : 21911250001
             * plateNumber : 晋QM4397
             * grossWeight : 28.5
             * netWeight : 17.0
             * tareWeight : 11.5
             * settlement : {"id":"6c887a67995e47958fba5ee0744fea0d","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"北京北京市东城区东方大厦","takeAddress":"山西省太原市小店区巨鑫国际"}
             * truckLicense : {"id":"8917ca2d745740628764e8cb6d115418"}
             * truckType : {"id":"1359c6d4ff1844ae86c75315a0fd9258"}
             * truck : {"id":"08880bd0f766497a812f8367dabcfe02"}
             * truckDriver : {"id":"98f840a3c10b4566be90cfafd32add48","driverName":"张建国","driverTel":"18577779988"}
             * totalMoney : 210.0
             * deficitTonValue : 0.0
             * weightRangeBottom : 0.0
             * weightRangeTop : 0.0
             * money : 210.0
             */

            private String id;
            //过磅时间
            private String createDate;
            //过磅单号
            private String poundNo;
            //车牌号
            private String plateNumber;
            //毛重
            private String grossWeight;
            //净重
            private String netWeight;
            //皮重
            private String tareWeight;
            private SettlementBean settlement;
            private TruckLicenseBean truckLicense;
            private TruckTypeBean truckType;
            private TruckBean truck;
            private TruckDriverBean truckDriver;
            //运费
            private String totalMoney;
            private String deficitTonValue;
            private String weightRangeBottom;
            private String weightRangeTop;
            private String money;

            public String getId()
            {
                return id;
            }

            public void setId(String id)
            {
                this.id = id;
            }

            public String getCreateDate()
            {
                return createDate;
            }

            public void setCreateDate(String createDate)
            {
                this.createDate = createDate;
            }

            public String getPoundNo()
            {
                return poundNo;
            }

            public void setPoundNo(String poundNo)
            {
                this.poundNo = poundNo;
            }

            public String getPlateNumber()
            {
                return plateNumber;
            }

            public void setPlateNumber(String plateNumber)
            {
                this.plateNumber = plateNumber;
            }

            public String getGrossWeight()
            {
                return grossWeight;
            }

            public void setGrossWeight(String grossWeight)
            {
                this.grossWeight = grossWeight;
            }

            public String getNetWeight()
            {
                return netWeight;
            }

            public void setNetWeight(String netWeight)
            {
                this.netWeight = netWeight;
            }

            public String getTareWeight()
            {
                return tareWeight;
            }

            public void setTareWeight(String tareWeight)
            {
                this.tareWeight = tareWeight;
            }

            public SettlementBean getSettlement()
            {
                return settlement;
            }

            public void setSettlement(SettlementBean settlement)
            {
                this.settlement = settlement;
            }

            public TruckLicenseBean getTruckLicense()
            {
                return truckLicense;
            }

            public void setTruckLicense(TruckLicenseBean truckLicense)
            {
                this.truckLicense = truckLicense;
            }

            public TruckTypeBean getTruckType()
            {
                return truckType;
            }

            public void setTruckType(TruckTypeBean truckType)
            {
                this.truckType = truckType;
            }

            public TruckBean getTruck()
            {
                return truck;
            }

            public void setTruck(TruckBean truck)
            {
                this.truck = truck;
            }

            public TruckDriverBean getTruckDriver()
            {
                return truckDriver;
            }

            public void setTruckDriver(TruckDriverBean truckDriver)
            {
                this.truckDriver = truckDriver;
            }

            public String getTotalMoney()
            {
                return totalMoney;
            }

            public void setTotalMoney(String totalMoney)
            {
                this.totalMoney = totalMoney;
            }

            public String getDeficitTonValue()
            {
                return deficitTonValue;
            }

            public void setDeficitTonValue(String deficitTonValue)
            {
                this.deficitTonValue = deficitTonValue;
            }

            public String getWeightRangeBottom()
            {
                return weightRangeBottom;
            }

            public void setWeightRangeBottom(String weightRangeBottom)
            {
                this.weightRangeBottom = weightRangeBottom;
            }

            public String getWeightRangeTop()
            {
                return weightRangeTop;
            }

            public void setWeightRangeTop(String weightRangeTop)
            {
                this.weightRangeTop = weightRangeTop;
            }

            public String getMoney()
            {
                return money;
            }

            public void setMoney(String money)
            {
                this.money = money;
            }

            public static class SettlementBean
            {
                /**
                 * id : 6c887a67995e47958fba5ee0744fea0d
                 * businessId : 20191126111639000
                 * goodsName : 土渣
                 * equipmentId : 1
                 * deliverAddress : 北京北京市东城区东方大厦
                 * takeAddress : 山西省太原市小店区巨鑫国际
                 */

                private String id;
                //业务单号
                private String businessId;
                //货物名称
                private String goodsName;
                private String equipmentId;
                //发货地址
                private String deliverAddress;
                //收货地址
                private String takeAddress;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getBusinessId()
                {
                    return businessId;
                }

                public void setBusinessId(String businessId)
                {
                    this.businessId = businessId;
                }

                public String getGoodsName()
                {
                    return goodsName;
                }

                public void setGoodsName(String goodsName)
                {
                    this.goodsName = goodsName;
                }

                public String getEquipmentId()
                {
                    return equipmentId;
                }

                public void setEquipmentId(String equipmentId)
                {
                    this.equipmentId = equipmentId;
                }

                public String getDeliverAddress()
                {
                    return deliverAddress;
                }

                public void setDeliverAddress(String deliverAddress)
                {
                    this.deliverAddress = deliverAddress;
                }

                public String getTakeAddress()
                {
                    return takeAddress;
                }

                public void setTakeAddress(String takeAddress)
                {
                    this.takeAddress = takeAddress;
                }
            }

            public static class TruckLicenseBean
            {
                /**
                 * id : 8917ca2d745740628764e8cb6d115418
                 */

                private String id;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }
            }

            public static class TruckTypeBean
            {
                /**
                 * id : 1359c6d4ff1844ae86c75315a0fd9258
                 */

                private String id;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }
            }

            public static class TruckBean
            {
                /**
                 * id : 08880bd0f766497a812f8367dabcfe02
                 */

                private String id;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }
            }

            public static class TruckDriverBean
            {
                /**
                 * id : 98f840a3c10b4566be90cfafd32add48
                 * driverName : 张建国
                 * driverTel : 18577779988
                 */

                private String id;
                //司机姓名
                private String driverName;
                //司机电话
                private String driverTel;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getDriverName()
                {
                    return driverName;
                }

                public void setDriverName(String driverName)
                {
                    this.driverName = driverName;
                }

                public String getDriverTel()
                {
                    return driverTel;
                }

                public void setDriverTel(String driverTel)
                {
                    this.driverTel = driverTel;
                }
            }
        }
    }
}