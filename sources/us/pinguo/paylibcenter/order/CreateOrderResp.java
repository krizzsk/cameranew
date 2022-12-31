package us.pinguo.paylibcenter.order;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class CreateOrderResp extends BaseResp implements Serializable {
    private Data data;

    /* loaded from: classes5.dex */
    public class Data implements Serializable {
        private String Package;
        private String accessKey;
        private String amount;
        private String api_key;
        private String appid;
        private String applicationID;
        private String callbackUrl;
        private String country;
        private String currency;
        private String extReserved;
        private String merchantId;
        private String merchantName;
        private String noncestr;
        private String oid;
        private String orderAmount;
        private String orderNumber;
        private String packageValue;
        private String partnerid;
        private String prepayid;
        private String productDesc;
        private String productName;
        private String requestId;
        private int respCode;
        private String respMsg;
        private int sdkChannel;
        private String secret_key;
        private String serviceCatalog;
        private String sign;
        private String signMethod;
        private String signature;
        private String timestamp;
        private String url;
        private String urlver;

        public Data() {
        }

        public String getAccessKey() {
            return this.accessKey;
        }

        public String getAmount() {
            return this.amount;
        }

        public String getApikey() {
            return this.api_key;
        }

        public String getAppid() {
            return this.appid;
        }

        public String getApplicationID() {
            return this.applicationID;
        }

        public String getCallbackUrl() {
            return this.callbackUrl;
        }

        public String getCountry() {
            return this.country;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getExtReserved() {
            return this.extReserved;
        }

        public String getMerchantId() {
            return this.merchantId;
        }

        public String getMerchantName() {
            return this.merchantName;
        }

        public String getNoncestr() {
            return this.noncestr;
        }

        public String getOid() {
            return this.oid;
        }

        public String getOrderAmount() {
            return this.orderAmount;
        }

        public String getOrderNumber() {
            return this.orderNumber;
        }

        public String getPackage() {
            return "Sign=WXPay";
        }

        public String getPackageValue() {
            return this.packageValue;
        }

        public String getPartnerid() {
            return this.partnerid;
        }

        public String getPrepayid() {
            return this.prepayid;
        }

        public String getProductDesc() {
            return this.productDesc;
        }

        public String getProductName() {
            return this.productName;
        }

        public String getRequestId() {
            return this.requestId;
        }

        public int getRespCode() {
            return this.respCode;
        }

        public String getRespMsg() {
            return this.respMsg;
        }

        public int getSdkChannel() {
            return this.sdkChannel;
        }

        public String getSecretkey() {
            return this.secret_key;
        }

        public String getServiceCatalog() {
            return this.serviceCatalog;
        }

        public String getSign() {
            return this.sign;
        }

        public String getSignMethod() {
            return this.signMethod;
        }

        public String getSignature() {
            return this.signature;
        }

        public String getTimestamp() {
            return this.timestamp;
        }

        public String getUrl() {
            return this.url;
        }

        public String getUrlver() {
            return this.urlver;
        }

        public void setAccessKey(String str) {
            this.accessKey = str;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setApikey(String str) {
            this.api_key = str;
        }

        public void setAppid(String str) {
            this.appid = str;
        }

        public void setApplicationID(String str) {
            this.applicationID = str;
        }

        public void setCallbackUrl(String str) {
            this.callbackUrl = str;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setExtReserved(String str) {
            this.extReserved = str;
        }

        public void setMerchantId(String str) {
            this.merchantId = str;
        }

        public void setMerchantName(String str) {
            this.merchantName = str;
        }

        public void setNoncestr(String str) {
            this.noncestr = str;
        }

        public void setOid(String str) {
            this.oid = str;
        }

        public void setOrderAmount(String str) {
            this.orderAmount = str;
        }

        public void setOrderNumber(String str) {
            this.orderNumber = str;
        }

        public void setPackageValue(String str) {
            this.packageValue = str;
        }

        public void setPartnerid(String str) {
            this.partnerid = str;
        }

        public void setPrepayid(String str) {
            this.prepayid = str;
        }

        public void setProductDesc(String str) {
            this.productDesc = str;
        }

        public void setProductName(String str) {
            this.productName = str;
        }

        public void setRequestId(String str) {
            this.requestId = str;
        }

        public void setRespCode(int i2) {
            this.respCode = i2;
        }

        public void setRespMsg(String str) {
            this.respMsg = str;
        }

        public void setSdkChannel(int i2) {
            this.sdkChannel = i2;
        }

        public void setSecretkey(String str) {
            this.secret_key = str;
        }

        public void setServiceCatalog(String str) {
            this.serviceCatalog = str;
        }

        public void setSign(String str) {
            this.sign = str;
        }

        public void setSignMethod(String str) {
            this.signMethod = str;
        }

        public void setSignature(String str) {
            this.signature = str;
        }

        public void setTimestamp(String str) {
            this.timestamp = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUrlver(String str) {
            this.urlver = str;
        }
    }

    /* loaded from: classes5.dex */
    public class Sdk implements Serializable {
        private String appid;
        private String noncestr;
        private String order_info;
        private String partnerid;
        private String prepayid;
        private String sign;
        private String sign_type;
        private int timestamp;

        public Sdk() {
        }

        public String getAppid() {
            return this.appid;
        }

        public String getNoncestr() {
            return this.noncestr;
        }

        public String getOrder_info() {
            return this.order_info;
        }

        public String getPackage() {
            return "Sign=WXPay";
        }

        public String getPartnerid() {
            return this.partnerid;
        }

        public String getPrepayid() {
            return this.prepayid;
        }

        public String getSign() {
            return this.sign;
        }

        public String getSign_type() {
            return this.sign_type;
        }

        public int getTimestamp() {
            return this.timestamp;
        }

        public void setAppid(String str) {
            this.appid = str;
        }

        public void setNoncestr(String str) {
            this.noncestr = str;
        }

        public void setOrder_info(String str) {
            this.order_info = str;
        }

        public void setPartnerid(String str) {
            this.partnerid = str;
        }

        public void setPrepayid(String str) {
            this.prepayid = str;
        }

        public void setSign(String str) {
            this.sign = str;
        }

        public void setSign_type(String str) {
            this.sign_type = str;
        }

        public void setTimestamp(int i2) {
            this.timestamp = i2;
        }
    }

    /* loaded from: classes5.dex */
    public class Trade implements Serializable {
        private String pp_sign;
        private String pp_sign_type;

        public Trade() {
        }

        public String getPp_sign() {
            return this.pp_sign;
        }

        public String getPp_sign_type() {
            return this.pp_sign_type;
        }

        public void setPp_sign(String str) {
            this.pp_sign = str;
        }

        public void setPp_sign_type(String str) {
            this.pp_sign_type = str;
        }
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
