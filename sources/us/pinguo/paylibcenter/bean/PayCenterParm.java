package us.pinguo.paylibcenter.bean;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class PayCenterParm implements Serializable {
    String googleId;
    private String huaweiAppId;
    private String huaweiCpId;
    private String huaweiPublicKey;
    public boolean isSubscription;
    boolean isSupportGoogleOnly;
    boolean isSupportHuawei;
    String productId;
    String purchaseTag;
    int requestCode;
    String userId;
    int version;

    public PayCenterParm(String str, String str2, int i2) {
        this.isSubscription = false;
        this.requestCode = 0;
        this.googleId = "";
        this.purchaseTag = "c360";
        this.productId = str;
        this.userId = str2;
        this.requestCode = i2;
    }

    public String getGoogleId() {
        return this.googleId;
    }

    public String getHuaweiAppId() {
        return this.huaweiAppId;
    }

    public String getHuaweiCpId() {
        return this.huaweiCpId;
    }

    public String getHuaweiPublicKey() {
        return this.huaweiPublicKey;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPurchaseTag() {
        return this.purchaseTag;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isSupportGoogleOnly() {
        return this.isSupportGoogleOnly;
    }

    public boolean isSupportHuawei() {
        return this.isSupportHuawei;
    }

    public void setGoogleId(String str) {
        this.googleId = str;
    }

    public void setHuaweiAppId(String str) {
        this.huaweiAppId = str;
    }

    public void setHuaweiCpId(String str) {
        this.huaweiCpId = str;
    }

    public void setHuaweiPublicKey(String str) {
        this.huaweiPublicKey = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPurchaseTag(String str) {
        this.purchaseTag = str;
    }

    public void setRequestCode(int i2) {
        this.requestCode = i2;
    }

    public void setSupportGoogleOnly(boolean z) {
        this.isSupportGoogleOnly = z;
    }

    public void setSupportHuawei(boolean z) {
        this.isSupportHuawei = z;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public PayCenterParm(String str, String str2, boolean z, int i2) {
        this.isSubscription = false;
        this.requestCode = 0;
        this.googleId = "";
        this.purchaseTag = "c360";
        this.productId = str;
        this.userId = str2;
        this.isSubscription = z;
        this.requestCode = i2;
    }

    public PayCenterParm(String str, String str2) {
        this.isSubscription = false;
        this.requestCode = 0;
        this.googleId = "";
        this.purchaseTag = "c360";
        this.productId = str;
        this.userId = str2;
    }

    public PayCenterParm() {
        this.isSubscription = false;
        this.requestCode = 0;
        this.googleId = "";
        this.purchaseTag = "c360";
    }
}
