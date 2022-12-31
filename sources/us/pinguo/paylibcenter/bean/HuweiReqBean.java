package us.pinguo.paylibcenter.bean;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class HuweiReqBean implements Serializable {
    private String amount;
    private String applicationID;
    private String country;
    private String currency;
    private String extReserved;
    private String merchantId;
    private String merchantName;
    private String oid;
    private String productDesc;
    private String productName;
    private String requestId;
    private int sdkChannel;
    private String serviceCatalog;
    private String sign;
    private String url;
    private String urlver;

    public String getAmount() {
        return this.amount;
    }

    public String getApplicationID() {
        return this.applicationID;
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

    public String getOid() {
        return this.oid;
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

    public int getSdkChannel() {
        return this.sdkChannel;
    }

    public String getServiceCatalog() {
        return this.serviceCatalog;
    }

    public String getSign() {
        return this.sign;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlver() {
        return this.urlver;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setApplicationID(String str) {
        this.applicationID = str;
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

    public void setOid(String str) {
        this.oid = str;
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

    public void setSdkChannel(int i2) {
        this.sdkChannel = i2;
    }

    public void setServiceCatalog(String str) {
        this.serviceCatalog = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrlver(String str) {
        this.urlver = str;
    }
}
