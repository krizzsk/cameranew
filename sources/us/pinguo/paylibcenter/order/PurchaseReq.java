package us.pinguo.paylibcenter.order;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class PurchaseReq implements Serializable {
    private String hmsProductId;
    private String productId;
    private String purchaseTag;
    private String purchaseToken;
    private String receipt;
    private String signture;
    private String subscribeId;
    private String userId;
    private String way;

    public PurchaseReq() {
        this.userId = "";
        this.way = "2";
    }

    public String getHmsProductId() {
        return this.hmsProductId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPurchaseTag() {
        return this.purchaseTag;
    }

    public String getPurchaseToken() {
        return this.purchaseToken;
    }

    public String getReceipt() {
        String str = this.receipt;
        return str == null ? "" : str;
    }

    public String getSignture() {
        return this.signture;
    }

    public String getSubscribeId() {
        return this.subscribeId;
    }

    public String getUserId() {
        String str = this.userId;
        return str == null ? "" : str;
    }

    public String getWay() {
        return this.way;
    }

    public void setHmsProductId(String str) {
        this.hmsProductId = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPurchaseTag(String str) {
        this.purchaseTag = str;
    }

    public void setPurchaseToken(String str) {
        this.purchaseToken = str;
    }

    public void setReceipt(String str) {
        this.receipt = str;
    }

    public void setSignture(String str) {
        this.signture = str;
    }

    public void setSubscribeId(String str) {
        this.subscribeId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWay(String str) {
        this.way = str;
    }

    public PurchaseReq(String str, String str2, String str3, String str4, String str5, String str6) {
        this.userId = "";
        this.way = "2";
        this.productId = str;
        this.userId = str2;
        this.receipt = str3;
        this.signture = str4;
        this.purchaseTag = str5;
        this.purchaseToken = str6;
    }
}
