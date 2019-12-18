/**
 * FileName: SelectBusinessListBean
 * Author:baijie
 * Date: 2019/11/26 14:01
 * Description: 选择业务列表的实体
 */
package com.kcwl.kht.tzkppda.bean;

import java.util.List;

/**
 * @ClassName: SelectBusinessListBean
 * @Description: 选择业务列表的实体
 * @Author: baijie
 * @Date: 2019/11/26 14:01
 */
public class SelectBusinessListBean extends BaseBean
{

    /**
     * success : true
     * msg : 获取业务列表成功
     * body : {"rows":[{"id":"ee7bfed91d934491afc8e256d089ba28","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-26 12:22:02","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 12:22:02","businessId":"20191126122201000","goodsName":"土渣","equipmentId":"2","deliverAddress":"中心大厦","takeAddress":"西方大厦","averageNetWeight":"19.0","freightUnitPrice":"50.0","startTime":1574740800000,"endTime":1575000000000,"deliverProvinceName":"北京","deliverCityName":"北京市","deliverCountyName":"西城区","deliverProvinceCode":"110000","deliverCityCode":"110100","deliverCountyCode":"110102","takeProvinceName":"天津","takeCityName":"天津市","takeCountyName":"南开区","takeProvinceCode":"120000","takeCityCode":"120100","takeCountyCode":"120104","state":"1","company":{"id":"f81a618f6b2a4c789a41ed26c1288422","name":"快成李伦","companyId":9117}},{"id":"6c887a67995e47958fba5ee0744fea0d","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-26 11:16:43","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:16:43","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"东方大厦","takeAddress":"巨鑫国际","averageNetWeight":"19.0","freightUnitPrice":"210.0","startTime":1574219760000,"endTime":1574392560000,"deliverProvinceName":"北京","deliverCityName":"北京市","deliverCountyName":"东城区","deliverProvinceCode":"110000","deliverCityCode":"110100","deliverCountyCode":"110101","takeProvinceName":"山西省","takeCityName":"太原市","takeCountyName":"小店区","takeProvinceCode":"140000","takeCityCode":"140100","takeCountyCode":"140105","state":"1","company":{"id":"b5674a308a794244b16d7a3d1f8197b7","name":"寿阳县鑫晋源汽运服务中心","companyId":8995}}],"total":2,"pageNum":1}
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
         * rows : [{"id":"ee7bfed91d934491afc8e256d089ba28","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-26 12:22:02","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 12:22:02","businessId":"20191126122201000","goodsName":"土渣","equipmentId":"2","deliverAddress":"中心大厦","takeAddress":"西方大厦","averageNetWeight":"19.0","freightUnitPrice":"50.0","startTime":1574740800000,"endTime":1575000000000,"deliverProvinceName":"北京","deliverCityName":"北京市","deliverCountyName":"西城区","deliverProvinceCode":"110000","deliverCityCode":"110100","deliverCountyCode":"110102","takeProvinceName":"天津","takeCityName":"天津市","takeCountyName":"南开区","takeProvinceCode":"120000","takeCityCode":"120100","takeCountyCode":"120104","state":"1","company":{"id":"f81a618f6b2a4c789a41ed26c1288422","name":"快成李伦","companyId":9117}},{"id":"6c887a67995e47958fba5ee0744fea0d","createBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"createDate":"2019-11-26 11:16:43","updateBy":{"id":"1","loginFlag":"1","admin":true,"roleNames":""},"updateDate":"2019-11-26 11:16:43","businessId":"20191126111639000","goodsName":"土渣","equipmentId":"1","deliverAddress":"东方大厦","takeAddress":"巨鑫国际","averageNetWeight":"19.0","freightUnitPrice":"210.0","startTime":1574219760000,"endTime":1574392560000,"deliverProvinceName":"北京","deliverCityName":"北京市","deliverCountyName":"东城区","deliverProvinceCode":"110000","deliverCityCode":"110100","deliverCountyCode":"110101","takeProvinceName":"山西省","takeCityName":"太原市","takeCountyName":"小店区","takeProvinceCode":"140000","takeCityCode":"140100","takeCountyCode":"140105","state":"1","company":{"id":"b5674a308a794244b16d7a3d1f8197b7","name":"寿阳县鑫晋源汽运服务中心","companyId":8995}}]
         * total : 2
         * pageNum : 1
         */

        //总条数
        private int total;
        //总页数
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
             * id : ee7bfed91d934491afc8e256d089ba28
             * createBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
             * createDate : 2019-11-26 12:22:02
             * updateBy : {"id":"1","loginFlag":"1","admin":true,"roleNames":""}
             * updateDate : 2019-11-26 12:22:02
             * businessId : 20191126122201000
             * goodsName : 土渣
             * equipmentId : 2
             * deliverAddress : 中心大厦
             * takeAddress : 西方大厦
             * averageNetWeight : 19.0
             * freightUnitPrice : 50.0
             * startTime : 1574740800000
             * endTime : 1575000000000
             * deliverProvinceName : 北京
             * deliverCityName : 北京市
             * deliverCountyName : 西城区
             * deliverProvinceCode : 110000
             * deliverCityCode : 110100
             * deliverCountyCode : 110102
             * takeProvinceName : 天津
             * takeCityName : 天津市
             * takeCountyName : 南开区
             * takeProvinceCode : 120000
             * takeCityCode : 120100
             * takeCountyCode : 120104
             * state : 1
             * company : {"id":"f81a618f6b2a4c789a41ed26c1288422","name":"快成李伦","companyId":9117}
             */

            private String id;
            private CreateByBean createBy;
            private String createDate;
            private UpdateByBean updateBy;
            private String updateDate;
            //业务编号
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
                 * id : f81a618f6b2a4c789a41ed26c1288422
                 * name : 快成李伦
                 * companyId : 9117
                 */

                private String id;
                private String name;
                private int companyId;

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

                public int getCompanyId()
                {
                    return companyId;
                }

                public void setCompanyId(int companyId)
                {
                    this.companyId = companyId;
                }
            }
        }
    }
}