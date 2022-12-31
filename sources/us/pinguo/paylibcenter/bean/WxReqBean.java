package us.pinguo.paylibcenter.bean;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class WxReqBean implements Serializable {
    String appId;
    String extData = "app data";
    String nonceStr;
    String packageValue;
    String partnerId;
    String prepayId;
    String sign;
    String timeStamp;

    public WxReqBean() {
    }

    public String getAppId() {
        return this.appId;
    }

    public String getExtData() {
        return this.extData;
    }

    public String getNonceStr() {
        return this.nonceStr;
    }

    public String getPackageValue() {
        return this.packageValue;
    }

    public String getPartnerId() {
        return this.partnerId;
    }

    public String getPrepayId() {
        return this.prepayId;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setExtData(String str) {
        this.extData = str;
    }

    public void setNonceStr(String str) {
        this.nonceStr = str;
    }

    public void setPackageValue(String str) {
        this.packageValue = str;
    }

    public void setPartnerId(String str) {
        this.partnerId = str;
    }

    public void setPrepayId(String str) {
        this.prepayId = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public WxReqBean(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.appId = str;
        this.partnerId = str2;
        this.prepayId = str3;
        this.nonceStr = str4;
        this.timeStamp = str5;
        this.packageValue = str6;
        this.sign = str7;
    }
}
