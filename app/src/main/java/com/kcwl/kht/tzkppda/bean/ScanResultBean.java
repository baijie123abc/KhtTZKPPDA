/**
 * FileName: ScanResultBean
 * Author:baijie
 * Date: 2019/11/26 16:26
 * Description: 扫描列表的实体
 */
package com.kcwl.kht.tzkppda.bean;

/**
 * @ClassName: ScanResultBean
 * @Description: 扫描列表的实体
 * @Author: baijie
 * @Date: 2019/11/26 16:26
 */
public class ScanResultBean extends BaseBean
{

    /**
     * success : true
     * msg : 操作成功
     * body : {"pound":{"poundNo":"20191127145218001","plateNumber":"京A66666","grossWeight":31.39,"netWeight":17.3,"tareWeight":14.09,"settlement":{"id":"6c887a67995e47958fba5ee0744fea0d","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-26 11:16:43","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:16:43","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"东方大厦","takeAddress":"巨鑫国际","averageNetWeight":"19.0","freightUnitPrice":"210.0","startTime":1574219760000,"endTime":1574392560000,"deliverProvinceName":"北京","deliverCityName":"北京市","deliverCountyName":"东城区","deliverProvinceCode":"110000","deliverCityCode":"110100","deliverCountyCode":"110101","takeProvinceName":"山西省","takeCityName":"太原市","takeCountyName":"小店区","takeProvinceCode":"140000","takeCityCode":"140100","takeCountyCode":"140105","state":"1","company":{"id":"b5674a308a794244b16d7a3d1f8197b7","name":"寿阳县鑫晋源汽运服务中心","companyId":8995},"carrier":{"name":"快慧通测试"}},"truckLicense":{"id":"051454f858a44b84967c39e1fddb0f0b","remarks":"","createDate":"2019-11-20 09:50:37","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-25 10:18:35","truckLicense":"0CE2003412012C010000E9FBB6","labelNumber":"400004972","isBinding":"1","bindingTime":"2019-11-20 09:50:59","licenseType":"0","truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"}},"truckType":{"id":"4f63f77dbc2a468685b23b22c7d49811","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-07-17 14:57:49","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-07-17 14:57:49","typeName":"前四后八","openStatus":1,"vehicleTypeId":"9"},"truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","remarks":"","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-19 10:05:52","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:38:56","plateNumber":"京A66666","isBinding":"1","bindingTime":"2019-11-20 09:50:59","avgTare":24.46,"errorTare":2,"openStatus":1,"roadPermit":"255464877646","roadPermitPic":"","vehicleLicense":"2113465465","vehicleLicensePic":"","truckType":{"id":"4f63f77dbc2a468685b23b22c7d49811","typeName":"前四后八"},"isUnload":"1","isSend":"0"},"truckDriver":{"id":"c306f3c82fe141ba9fe7518e5eab5185","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-19 10:05:52","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-19 10:05:52","driverName":"吴哲","driverTel":"18235119392","driverCardNo":"12345687","driverLicense":"142322196610210358","openStatus":-1,"isDefault":"1","truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"},"bankCard":"6222023333322222222","address":"巨鑫国际","province":{"id":"140000","sort":30,"hasChildren":false,"parentId":"0"},"city":{"id":"140100","sort":30,"hasChildren":false,"parentId":"0"},"county":{"id":"140105","sort":30,"hasChildren":false,"parentId":"0"},"idCardPic":"","idCardReversePic":"","drivingLicencePic":""},"totalMoney":200,"dataType":1}}
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
         * pound : {"poundNo":"20191127145218001","plateNumber":"京A66666","grossWeight":31.39,"netWeight":17.3,"tareWeight":14.09,"settlement":{"id":"6c887a67995e47958fba5ee0744fea0d","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-26 11:16:43","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:16:43","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"东方大厦","takeAddress":"巨鑫国际","averageNetWeight":"19.0","freightUnitPrice":"210.0","startTime":1574219760000,"endTime":1574392560000,"deliverProvinceName":"北京","deliverCityName":"北京市","deliverCountyName":"东城区","deliverProvinceCode":"110000","deliverCityCode":"110100","deliverCountyCode":"110101","takeProvinceName":"山西省","takeCityName":"太原市","takeCountyName":"小店区","takeProvinceCode":"140000","takeCityCode":"140100","takeCountyCode":"140105","state":"1","company":{"id":"b5674a308a794244b16d7a3d1f8197b7","name":"寿阳县鑫晋源汽运服务中心","companyId":8995},"carrier":{"name":"快慧通测试"}},"truckLicense":{"id":"051454f858a44b84967c39e1fddb0f0b","remarks":"","createDate":"2019-11-20 09:50:37","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-25 10:18:35","truckLicense":"0CE2003412012C010000E9FBB6","labelNumber":"400004972","isBinding":"1","bindingTime":"2019-11-20 09:50:59","licenseType":"0","truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"}},"truckType":{"id":"4f63f77dbc2a468685b23b22c7d49811","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-07-17 14:57:49","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-07-17 14:57:49","typeName":"前四后八","openStatus":1,"vehicleTypeId":"9"},"truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","remarks":"","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-19 10:05:52","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:38:56","plateNumber":"京A66666","isBinding":"1","bindingTime":"2019-11-20 09:50:59","avgTare":24.46,"errorTare":2,"openStatus":1,"roadPermit":"255464877646","roadPermitPic":"","vehicleLicense":"2113465465","vehicleLicensePic":"","truckType":{"id":"4f63f77dbc2a468685b23b22c7d49811","typeName":"前四后八"},"isUnload":"1","isSend":"0"},"truckDriver":{"id":"c306f3c82fe141ba9fe7518e5eab5185","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-19 10:05:52","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-19 10:05:52","driverName":"吴哲","driverTel":"18235119392","driverCardNo":"12345687","driverLicense":"142322196610210358","openStatus":-1,"isDefault":"1","truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"},"bankCard":"6222023333322222222","address":"巨鑫国际","province":{"id":"140000","sort":30,"hasChildren":false,"parentId":"0"},"city":{"id":"140100","sort":30,"hasChildren":false,"parentId":"0"},"county":{"id":"140105","sort":30,"hasChildren":false,"parentId":"0"},"idCardPic":"","idCardReversePic":"","drivingLicencePic":""},"totalMoney":200,"dataType":1}
         */

        private PoundBean pound;

        public PoundBean getPound()
        {
            return pound;
        }

        public void setPound(PoundBean pound)
        {
            this.pound = pound;
        }

        public static class PoundBean
        {
            /**
             * poundNo : 20191127145218001
             * plateNumber : 京A66666
             * grossWeight : 31.39
             * netWeight : 17.3
             * tareWeight : 14.09
             * settlement : {"id":"6c887a67995e47958fba5ee0744fea0d","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-26 11:16:43","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:16:43","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"东方大厦","takeAddress":"巨鑫国际","averageNetWeight":"19.0","freightUnitPrice":"210.0","startTime":1574219760000,"endTime":1574392560000,"deliverProvinceName":"北京","deliverCityName":"北京市","deliverCountyName":"东城区","deliverProvinceCode":"110000","deliverCityCode":"110100","deliverCountyCode":"110101","takeProvinceName":"山西省","takeCityName":"太原市","takeCountyName":"小店区","takeProvinceCode":"140000","takeCityCode":"140100","takeCountyCode":"140105","state":"1","company":{"id":"b5674a308a794244b16d7a3d1f8197b7","name":"寿阳县鑫晋源汽运服务中心","companyId":8995},"carrier":{"name":"快慧通测试"}}
             * truckLicense : {"id":"051454f858a44b84967c39e1fddb0f0b","remarks":"","createDate":"2019-11-20 09:50:37","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-25 10:18:35","truckLicense":"0CE2003412012C010000E9FBB6","labelNumber":"400004972","isBinding":"1","bindingTime":"2019-11-20 09:50:59","licenseType":"0","truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"}}
             * truckType : {"id":"4f63f77dbc2a468685b23b22c7d49811","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-07-17 14:57:49","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-07-17 14:57:49","typeName":"前四后八","openStatus":1,"vehicleTypeId":"9"}
             * truck : {"id":"a00abf604adf4eed9883c3312d9fdea8","remarks":"","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-19 10:05:52","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:38:56","plateNumber":"京A66666","isBinding":"1","bindingTime":"2019-11-20 09:50:59","avgTare":24.46,"errorTare":2,"openStatus":1,"roadPermit":"255464877646","roadPermitPic":"","vehicleLicense":"2113465465","vehicleLicensePic":"","truckType":{"id":"4f63f77dbc2a468685b23b22c7d49811","typeName":"前四后八"},"isUnload":"1","isSend":"0"}
             * truckDriver : {"id":"c306f3c82fe141ba9fe7518e5eab5185","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-19 10:05:52","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-19 10:05:52","driverName":"吴哲","driverTel":"18235119392","driverCardNo":"12345687","driverLicense":"142322196610210358","openStatus":-1,"isDefault":"1","truck":{"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"},"bankCard":"6222023333322222222","address":"巨鑫国际","province":{"id":"140000","sort":30,"hasChildren":false,"parentId":"0"},"city":{"id":"140100","sort":30,"hasChildren":false,"parentId":"0"},"county":{"id":"140105","sort":30,"hasChildren":false,"parentId":"0"},"idCardPic":"","idCardReversePic":"","drivingLicencePic":""}
             * totalMoney : 200.0
             * dataType : 1
             */

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
            private TruckBeanX truck;
            private TruckDriverBean truckDriver;
            //运费
            private String totalMoney;
            //今日已拉次数
            private String dataType;

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

            public TruckBeanX getTruck()
            {
                return truck;
            }

            public void setTruck(TruckBeanX truck)
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

            public String getDataType()
            {
                return dataType;
            }

            public void setDataType(String dataType)
            {
                this.dataType = dataType;
            }

            public static class SettlementBean
            {
                /**
                 * id : 6c887a67995e47958fba5ee0744fea0d
                 * createBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * createDate : 2019-11-26 11:16:43
                 * updateBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * updateDate : 2019-11-26 11:16:43
                 * businessId : 20191126111639000
                 * goodsName : 土渣
                 * equipmentId : 1
                 * deliverAddress : 东方大厦
                 * takeAddress : 巨鑫国际
                 * averageNetWeight : 19.0
                 * freightUnitPrice : 210.0
                 * startTime : 1574219760000
                 * endTime : 1574392560000
                 * deliverProvinceName : 北京
                 * deliverCityName : 北京市
                 * deliverCountyName : 东城区
                 * deliverProvinceCode : 110000
                 * deliverCityCode : 110100
                 * deliverCountyCode : 110101
                 * takeProvinceName : 山西省
                 * takeCityName : 太原市
                 * takeCountyName : 小店区
                 * takeProvinceCode : 140000
                 * takeCityCode : 140100
                 * takeCountyCode : 140105
                 * state : 1
                 * company : {"id":"b5674a308a794244b16d7a3d1f8197b7","name":"寿阳县鑫晋源汽运服务中心","companyId":8995}
                 * carrier : {"name":"快慧通测试"}
                 */

                private String id;
                private CreateByBean createBy;
                private String createDate;
                private UpdateByBean updateBy;
                private String updateDate;
                //业务单号
                private String businessId;
                //货物名称
                private String goodsName;
                private String equipmentId;
                //发货地址
                private String deliverAddress;
                //收货地址
                private String takeAddress;
                private String averageNetWeight;
                private String freightUnitPrice;
                private String startTime;
                private String endTime;
                //发货地址的省
                private String deliverProvinceName;
                //发货地址的市
                private String deliverCityName;
                //发货地址的县
                private String deliverCountyName;
                private String deliverProvinceCode;
                private String deliverCityCode;
                private String deliverCountyCode;
                //收货地址的省
                private String takeProvinceName;
                //收货地址的市
                private String takeCityName;
                //收货地址的县
                private String takeCountyName;
                private String takeProvinceCode;
                private String takeCityCode;
                private String takeCountyCode;
                private String state;
                private CompanyBean company;
                private CarrierBean carrier;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public CreateByBean getCreateBy()
                {
                    return createBy;
                }

                public void setCreateBy(CreateByBean createBy)
                {
                    this.createBy = createBy;
                }

                public String getCreateDate()
                {
                    return createDate;
                }

                public void setCreateDate(String createDate)
                {
                    this.createDate = createDate;
                }

                public UpdateByBean getUpdateBy()
                {
                    return updateBy;
                }

                public void setUpdateBy(UpdateByBean updateBy)
                {
                    this.updateBy = updateBy;
                }

                public String getUpdateDate()
                {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate)
                {
                    this.updateDate = updateDate;
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

                public String getAverageNetWeight()
                {
                    return averageNetWeight;
                }

                public void setAverageNetWeight(String averageNetWeight)
                {
                    this.averageNetWeight = averageNetWeight;
                }

                public String getFreightUnitPrice()
                {
                    return freightUnitPrice;
                }

                public void setFreightUnitPrice(String freightUnitPrice)
                {
                    this.freightUnitPrice = freightUnitPrice;
                }

                public String getStartTime()
                {
                    return startTime;
                }

                public void setStartTime(String startTime)
                {
                    this.startTime = startTime;
                }

                public String getEndTime()
                {
                    return endTime;
                }

                public void setEndTime(String endTime)
                {
                    this.endTime = endTime;
                }

                public String getDeliverProvinceName()
                {
                    return deliverProvinceName;
                }

                public void setDeliverProvinceName(String deliverProvinceName)
                {
                    this.deliverProvinceName = deliverProvinceName;
                }

                public String getDeliverCityName()
                {
                    return deliverCityName;
                }

                public void setDeliverCityName(String deliverCityName)
                {
                    this.deliverCityName = deliverCityName;
                }

                public String getDeliverCountyName()
                {
                    return deliverCountyName;
                }

                public void setDeliverCountyName(String deliverCountyName)
                {
                    this.deliverCountyName = deliverCountyName;
                }

                public String getDeliverProvinceCode()
                {
                    return deliverProvinceCode;
                }

                public void setDeliverProvinceCode(String deliverProvinceCode)
                {
                    this.deliverProvinceCode = deliverProvinceCode;
                }

                public String getDeliverCityCode()
                {
                    return deliverCityCode;
                }

                public void setDeliverCityCode(String deliverCityCode)
                {
                    this.deliverCityCode = deliverCityCode;
                }

                public String getDeliverCountyCode()
                {
                    return deliverCountyCode;
                }

                public void setDeliverCountyCode(String deliverCountyCode)
                {
                    this.deliverCountyCode = deliverCountyCode;
                }

                public String getTakeProvinceName()
                {
                    return takeProvinceName;
                }

                public void setTakeProvinceName(String takeProvinceName)
                {
                    this.takeProvinceName = takeProvinceName;
                }

                public String getTakeCityName()
                {
                    return takeCityName;
                }

                public void setTakeCityName(String takeCityName)
                {
                    this.takeCityName = takeCityName;
                }

                public String getTakeCountyName()
                {
                    return takeCountyName;
                }

                public void setTakeCountyName(String takeCountyName)
                {
                    this.takeCountyName = takeCountyName;
                }

                public String getTakeProvinceCode()
                {
                    return takeProvinceCode;
                }

                public void setTakeProvinceCode(String takeProvinceCode)
                {
                    this.takeProvinceCode = takeProvinceCode;
                }

                public String getTakeCityCode()
                {
                    return takeCityCode;
                }

                public void setTakeCityCode(String takeCityCode)
                {
                    this.takeCityCode = takeCityCode;
                }

                public String getTakeCountyCode()
                {
                    return takeCountyCode;
                }

                public void setTakeCountyCode(String takeCountyCode)
                {
                    this.takeCountyCode = takeCountyCode;
                }

                public String getState()
                {
                    return state;
                }

                public void setState(String state)
                {
                    this.state = state;
                }

                public CompanyBean getCompany()
                {
                    return company;
                }

                public void setCompany(CompanyBean company)
                {
                    this.company = company;
                }

                public CarrierBean getCarrier()
                {
                    return carrier;
                }

                public void setCarrier(CarrierBean carrier)
                {
                    this.carrier = carrier;
                }

                public static class CreateByBean
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class UpdateByBean
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class CompanyBean
                {
                    /**
                     * id : b5674a308a794244b16d7a3d1f8197b7
                     * name : 寿阳县鑫晋源汽运服务中心
                     * companyId : 8995
                     */

                    private String id;
                    private String name;
                    private String companyId;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getName()
                    {
                        return name;
                    }

                    public void setName(String name)
                    {
                        this.name = name;
                    }

                    public String getCompanyId()
                    {
                        return companyId;
                    }

                    public void setCompanyId(String companyId)
                    {
                        this.companyId = companyId;
                    }
                }

                public static class CarrierBean
                {
                    /**
                     * name : 快慧通测试
                     */

                    private String name;

                    public String getName()
                    {
                        return name;
                    }

                    public void setName(String name)
                    {
                        this.name = name;
                    }
                }
            }

            public static class TruckLicenseBean
            {
                /**
                 * id : 051454f858a44b84967c39e1fddb0f0b
                 * remarks :
                 * createDate : 2019-11-20 09:50:37
                 * updateBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * updateDate : 2019-11-25 10:18:35
                 * truckLicense : 0CE2003412012C010000E9FBB6
                 * labelNumber : 400004972
                 * isBinding : 1
                 * bindingTime : 2019-11-20 09:50:59
                 * licenseType : 0
                 * truck : {"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"}
                 */

                private String id;
                private String remarks;
                private String createDate;
                private UpdateByBeanX updateBy;
                private String updateDate;
                private String truckLicense;
                private String labelNumber;
                private String isBinding;
                private String bindingTime;
                private String licenseType;
                private TruckBean truck;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getRemarks()
                {
                    return remarks;
                }

                public void setRemarks(String remarks)
                {
                    this.remarks = remarks;
                }

                public String getCreateDate()
                {
                    return createDate;
                }

                public void setCreateDate(String createDate)
                {
                    this.createDate = createDate;
                }

                public UpdateByBeanX getUpdateBy()
                {
                    return updateBy;
                }

                public void setUpdateBy(UpdateByBeanX updateBy)
                {
                    this.updateBy = updateBy;
                }

                public String getUpdateDate()
                {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate)
                {
                    this.updateDate = updateDate;
                }

                public String getTruckLicense()
                {
                    return truckLicense;
                }

                public void setTruckLicense(String truckLicense)
                {
                    this.truckLicense = truckLicense;
                }

                public String getLabelNumber()
                {
                    return labelNumber;
                }

                public void setLabelNumber(String labelNumber)
                {
                    this.labelNumber = labelNumber;
                }

                public String getIsBinding()
                {
                    return isBinding;
                }

                public void setIsBinding(String isBinding)
                {
                    this.isBinding = isBinding;
                }

                public String getBindingTime()
                {
                    return bindingTime;
                }

                public void setBindingTime(String bindingTime)
                {
                    this.bindingTime = bindingTime;
                }

                public String getLicenseType()
                {
                    return licenseType;
                }

                public void setLicenseType(String licenseType)
                {
                    this.licenseType = licenseType;
                }

                public TruckBean getTruck()
                {
                    return truck;
                }

                public void setTruck(TruckBean truck)
                {
                    this.truck = truck;
                }

                public static class UpdateByBeanX
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class TruckBean
                {
                    /**
                     * id : a00abf604adf4eed9883c3312d9fdea8
                     * plateNumber : 京A66666
                     */

                    private String id;
                    private String plateNumber;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getPlateNumber()
                    {
                        return plateNumber;
                    }

                    public void setPlateNumber(String plateNumber)
                    {
                        this.plateNumber = plateNumber;
                    }
                }
            }

            public static class TruckTypeBean
            {
                /**
                 * id : 4f63f77dbc2a468685b23b22c7d49811
                 * createBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * createDate : 2019-07-17 14:57:49
                 * updateBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * updateDate : 2019-07-17 14:57:49
                 * typeName : 前四后八
                 * openStatus : 1
                 * vehicleTypeId : 9
                 */

                private String id;
                private CreateByBeanX createBy;
                private String createDate;
                private UpdateByBeanXX updateBy;
                private String updateDate;
                private String typeName;
                private String openStatus;
                private String vehicleTypeId;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public CreateByBeanX getCreateBy()
                {
                    return createBy;
                }

                public void setCreateBy(CreateByBeanX createBy)
                {
                    this.createBy = createBy;
                }

                public String getCreateDate()
                {
                    return createDate;
                }

                public void setCreateDate(String createDate)
                {
                    this.createDate = createDate;
                }

                public UpdateByBeanXX getUpdateBy()
                {
                    return updateBy;
                }

                public void setUpdateBy(UpdateByBeanXX updateBy)
                {
                    this.updateBy = updateBy;
                }

                public String getUpdateDate()
                {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate)
                {
                    this.updateDate = updateDate;
                }

                public String getTypeName()
                {
                    return typeName;
                }

                public void setTypeName(String typeName)
                {
                    this.typeName = typeName;
                }

                public String getOpenStatus()
                {
                    return openStatus;
                }

                public void setOpenStatus(String openStatus)
                {
                    this.openStatus = openStatus;
                }

                public String getVehicleTypeId()
                {
                    return vehicleTypeId;
                }

                public void setVehicleTypeId(String vehicleTypeId)
                {
                    this.vehicleTypeId = vehicleTypeId;
                }

                public static class CreateByBeanX
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class UpdateByBeanXX
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }
            }

            public static class TruckBeanX
            {
                /**
                 * id : a00abf604adf4eed9883c3312d9fdea8
                 * remarks :
                 * createBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * createDate : 2019-11-19 10:05:52
                 * updateBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * updateDate : 2019-11-26 11:38:56
                 * plateNumber : 京A66666
                 * isBinding : 1
                 * bindingTime : 2019-11-20 09:50:59
                 * avgTare : 24.46
                 * errorTare : 2.0
                 * openStatus : 1
                 * roadPermit : 255464877646
                 * roadPermitPic :
                 * vehicleLicense : 2113465465
                 * vehicleLicensePic :
                 * truckType : {"id":"4f63f77dbc2a468685b23b22c7d49811","typeName":"前四后八"}
                 * isUnload : 1
                 * isSend : 0
                 */

                private String id;
                private String remarks;
                private CreateByBeanXX createBy;
                private String createDate;
                private UpdateByBeanXXX updateBy;
                private String updateDate;
                private String plateNumber;
                private String isBinding;
                private String bindingTime;
                private String avgTare;
                private String errorTare;
                private int openStatus;
                private String roadPermit;
                private String roadPermitPic;
                private String vehicleLicense;
                private String vehicleLicensePic;
                private TruckTypeBeanX truckType;
                private String isUnload;
                private String isSend;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getRemarks()
                {
                    return remarks;
                }

                public void setRemarks(String remarks)
                {
                    this.remarks = remarks;
                }

                public CreateByBeanXX getCreateBy()
                {
                    return createBy;
                }

                public void setCreateBy(CreateByBeanXX createBy)
                {
                    this.createBy = createBy;
                }

                public String getCreateDate()
                {
                    return createDate;
                }

                public void setCreateDate(String createDate)
                {
                    this.createDate = createDate;
                }

                public UpdateByBeanXXX getUpdateBy()
                {
                    return updateBy;
                }

                public void setUpdateBy(UpdateByBeanXXX updateBy)
                {
                    this.updateBy = updateBy;
                }

                public String getUpdateDate()
                {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate)
                {
                    this.updateDate = updateDate;
                }

                public String getPlateNumber()
                {
                    return plateNumber;
                }

                public void setPlateNumber(String plateNumber)
                {
                    this.plateNumber = plateNumber;
                }

                public String getIsBinding()
                {
                    return isBinding;
                }

                public void setIsBinding(String isBinding)
                {
                    this.isBinding = isBinding;
                }

                public String getBindingTime()
                {
                    return bindingTime;
                }

                public void setBindingTime(String bindingTime)
                {
                    this.bindingTime = bindingTime;
                }

                public String getAvgTare()
                {
                    return avgTare;
                }

                public void setAvgTare(String avgTare)
                {
                    this.avgTare = avgTare;
                }

                public String getErrorTare()
                {
                    return errorTare;
                }

                public void setErrorTare(String errorTare)
                {
                    this.errorTare = errorTare;
                }

                public int getOpenStatus()
                {
                    return openStatus;
                }

                public void setOpenStatus(int openStatus)
                {
                    this.openStatus = openStatus;
                }

                public String getRoadPermit()
                {
                    return roadPermit;
                }

                public void setRoadPermit(String roadPermit)
                {
                    this.roadPermit = roadPermit;
                }

                public String getRoadPermitPic()
                {
                    return roadPermitPic;
                }

                public void setRoadPermitPic(String roadPermitPic)
                {
                    this.roadPermitPic = roadPermitPic;
                }

                public String getVehicleLicense()
                {
                    return vehicleLicense;
                }

                public void setVehicleLicense(String vehicleLicense)
                {
                    this.vehicleLicense = vehicleLicense;
                }

                public String getVehicleLicensePic()
                {
                    return vehicleLicensePic;
                }

                public void setVehicleLicensePic(String vehicleLicensePic)
                {
                    this.vehicleLicensePic = vehicleLicensePic;
                }

                public TruckTypeBeanX getTruckType()
                {
                    return truckType;
                }

                public void setTruckType(TruckTypeBeanX truckType)
                {
                    this.truckType = truckType;
                }

                public String getIsUnload()
                {
                    return isUnload;
                }

                public void setIsUnload(String isUnload)
                {
                    this.isUnload = isUnload;
                }

                public String getIsSend()
                {
                    return isSend;
                }

                public void setIsSend(String isSend)
                {
                    this.isSend = isSend;
                }

                public static class CreateByBeanXX
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class UpdateByBeanXXX
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class TruckTypeBeanX
                {
                    /**
                     * id : 4f63f77dbc2a468685b23b22c7d49811
                     * typeName : 前四后八
                     */

                    private String id;
                    private String typeName;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getTypeName()
                    {
                        return typeName;
                    }

                    public void setTypeName(String typeName)
                    {
                        this.typeName = typeName;
                    }
                }
            }

            public static class TruckDriverBean
            {
                /**
                 * id : c306f3c82fe141ba9fe7518e5eab5185
                 * createBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * createDate : 2019-11-19 10:05:52
                 * updateBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
                 * updateDate : 2019-11-19 10:05:52
                 * driverName : 吴哲
                 * driverTel : 18235119392
                 * driverCardNo : 12345687
                 * driverLicense : 142322196610210358
                 * openStatus : -1
                 * isDefault : 1
                 * truck : {"id":"a00abf604adf4eed9883c3312d9fdea8","plateNumber":"京A66666"}
                 * bankCard : 6222023333322222222
                 * address : 巨鑫国际
                 * province : {"id":"140000","sort":30,"hasChildren":false,"parentId":"0"}
                 * city : {"id":"140100","sort":30,"hasChildren":false,"parentId":"0"}
                 * county : {"id":"140105","sort":30,"hasChildren":false,"parentId":"0"}
                 * idCardPic :
                 * idCardReversePic :
                 * drivingLicencePic :
                 */

                private String id;
                private CreateByBeanXXX createBy;
                private String createDate;
                private UpdateByBeanXXXX updateBy;
                private String updateDate;
                //司机姓名
                private String driverName;
                //司机手机号
                private String driverTel;
                private String driverCardNo;
                private String driverLicense;
                private String openStatus;
                private String isDefault;
                private TruckBeanXX truck;
                private String bankCard;
                private String address;
                private ProvinceBean province;
                private CityBean city;
                private CountyBean county;
                private String idCardPic;
                private String idCardReversePic;
                private String drivingLicencePic;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public CreateByBeanXXX getCreateBy()
                {
                    return createBy;
                }

                public void setCreateBy(CreateByBeanXXX createBy)
                {
                    this.createBy = createBy;
                }

                public String getCreateDate()
                {
                    return createDate;
                }

                public void setCreateDate(String createDate)
                {
                    this.createDate = createDate;
                }

                public UpdateByBeanXXXX getUpdateBy()
                {
                    return updateBy;
                }

                public void setUpdateBy(UpdateByBeanXXXX updateBy)
                {
                    this.updateBy = updateBy;
                }

                public String getUpdateDate()
                {
                    return updateDate;
                }

                public void setUpdateDate(String updateDate)
                {
                    this.updateDate = updateDate;
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

                public String getDriverCardNo()
                {
                    return driverCardNo;
                }

                public void setDriverCardNo(String driverCardNo)
                {
                    this.driverCardNo = driverCardNo;
                }

                public String getDriverLicense()
                {
                    return driverLicense;
                }

                public void setDriverLicense(String driverLicense)
                {
                    this.driverLicense = driverLicense;
                }

                public String getOpenStatus()
                {
                    return openStatus;
                }

                public void setOpenStatus(String openStatus)
                {
                    this.openStatus = openStatus;
                }

                public String getIsDefault()
                {
                    return isDefault;
                }

                public void setIsDefault(String isDefault)
                {
                    this.isDefault = isDefault;
                }

                public TruckBeanXX getTruck()
                {
                    return truck;
                }

                public void setTruck(TruckBeanXX truck)
                {
                    this.truck = truck;
                }

                public String getBankCard()
                {
                    return bankCard;
                }

                public void setBankCard(String bankCard)
                {
                    this.bankCard = bankCard;
                }

                public String getAddress()
                {
                    return address;
                }

                public void setAddress(String address)
                {
                    this.address = address;
                }

                public ProvinceBean getProvince()
                {
                    return province;
                }

                public void setProvince(ProvinceBean province)
                {
                    this.province = province;
                }

                public CityBean getCity()
                {
                    return city;
                }

                public void setCity(CityBean city)
                {
                    this.city = city;
                }

                public CountyBean getCounty()
                {
                    return county;
                }

                public void setCounty(CountyBean county)
                {
                    this.county = county;
                }

                public String getIdCardPic()
                {
                    return idCardPic;
                }

                public void setIdCardPic(String idCardPic)
                {
                    this.idCardPic = idCardPic;
                }

                public String getIdCardReversePic()
                {
                    return idCardReversePic;
                }

                public void setIdCardReversePic(String idCardReversePic)
                {
                    this.idCardReversePic = idCardReversePic;
                }

                public String getDrivingLicencePic()
                {
                    return drivingLicencePic;
                }

                public void setDrivingLicencePic(String drivingLicencePic)
                {
                    this.drivingLicencePic = drivingLicencePic;
                }

                public static class CreateByBeanXXX
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class UpdateByBeanXXXX
                {
                    /**
                     * id : 1
                     * loginFlag : 1
                     * admin : true
                     * roleNames :
                     */

                    private String id;
                    private String loginFlag;
                    private boolean admin;
                    private String roleNames;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getLoginFlag()
                    {
                        return loginFlag;
                    }

                    public void setLoginFlag(String loginFlag)
                    {
                        this.loginFlag = loginFlag;
                    }

                    public boolean isAdmin()
                    {
                        return admin;
                    }

                    public void setAdmin(boolean admin)
                    {
                        this.admin = admin;
                    }

                    public String getRoleNames()
                    {
                        return roleNames;
                    }

                    public void setRoleNames(String roleNames)
                    {
                        this.roleNames = roleNames;
                    }
                }

                public static class TruckBeanXX
                {
                    /**
                     * id : a00abf604adf4eed9883c3312d9fdea8
                     * plateNumber : 京A66666
                     */

                    private String id;
                    private String plateNumber;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getPlateNumber()
                    {
                        return plateNumber;
                    }

                    public void setPlateNumber(String plateNumber)
                    {
                        this.plateNumber = plateNumber;
                    }
                }

                public static class ProvinceBean
                {
                    /**
                     * id : 140000
                     * sort : 30
                     * hasChildren : false
                     * parentId : 0
                     */

                    private String id;
                    private String sort;
                    private boolean hasChildren;
                    private String parentId;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getSort()
                    {
                        return sort;
                    }

                    public void setSort(String sort)
                    {
                        this.sort = sort;
                    }

                    public boolean isHasChildren()
                    {
                        return hasChildren;
                    }

                    public void setHasChildren(boolean hasChildren)
                    {
                        this.hasChildren = hasChildren;
                    }

                    public String getParentId()
                    {
                        return parentId;
                    }

                    public void setParentId(String parentId)
                    {
                        this.parentId = parentId;
                    }
                }

                public static class CityBean
                {
                    /**
                     * id : 140100
                     * sort : 30
                     * hasChildren : false
                     * parentId : 0
                     */

                    private String id;
                    private String sort;
                    private boolean hasChildren;
                    private String parentId;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getSort()
                    {
                        return sort;
                    }

                    public void setSort(String sort)
                    {
                        this.sort = sort;
                    }

                    public boolean isHasChildren()
                    {
                        return hasChildren;
                    }

                    public void setHasChildren(boolean hasChildren)
                    {
                        this.hasChildren = hasChildren;
                    }

                    public String getParentId()
                    {
                        return parentId;
                    }

                    public void setParentId(String parentId)
                    {
                        this.parentId = parentId;
                    }
                }

                public static class CountyBean
                {
                    /**
                     * id : 140105
                     * sort : 30
                     * hasChildren : false
                     * parentId : 0
                     */

                    private String id;
                    private String sort;
                    private boolean hasChildren;
                    private String parentId;

                    public String getId()
                    {
                        return id;
                    }

                    public void setId(String id)
                    {
                        this.id = id;
                    }

                    public String getSort()
                    {
                        return sort;
                    }

                    public void setSort(String sort)
                    {
                        this.sort = sort;
                    }

                    public boolean isHasChildren()
                    {
                        return hasChildren;
                    }

                    public void setHasChildren(boolean hasChildren)
                    {
                        this.hasChildren = hasChildren;
                    }

                    public String getParentId()
                    {
                        return parentId;
                    }

                    public void setParentId(String parentId)
                    {
                        this.parentId = parentId;
                    }
                }
            }
        }
    }
}