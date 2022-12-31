package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: RechargeGoodsInfo.kt */
/* loaded from: classes3.dex */
public final class RechargeGoodsDiscountInfo implements NoProguard {
    private int month;
    private String originalPrice;
    private float pay;
    private String price;
    private String productId;
    private String title;

    public RechargeGoodsDiscountInfo(String productId, float f2, String price, String originalPrice, String title, int i2) {
        s.h(productId, "productId");
        s.h(price, "price");
        s.h(originalPrice, "originalPrice");
        s.h(title, "title");
        this.productId = productId;
        this.pay = f2;
        this.price = price;
        this.originalPrice = originalPrice;
        this.title = title;
        this.month = i2;
    }

    public static /* synthetic */ RechargeGoodsDiscountInfo copy$default(RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo, String str, float f2, String str2, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = rechargeGoodsDiscountInfo.productId;
        }
        if ((i3 & 2) != 0) {
            f2 = rechargeGoodsDiscountInfo.pay;
        }
        float f3 = f2;
        if ((i3 & 4) != 0) {
            str2 = rechargeGoodsDiscountInfo.price;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            str3 = rechargeGoodsDiscountInfo.originalPrice;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = rechargeGoodsDiscountInfo.title;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            i2 = rechargeGoodsDiscountInfo.month;
        }
        return rechargeGoodsDiscountInfo.copy(str, f3, str5, str6, str7, i2);
    }

    public final String component1() {
        return this.productId;
    }

    public final float component2() {
        return this.pay;
    }

    public final String component3() {
        return this.price;
    }

    public final String component4() {
        return this.originalPrice;
    }

    public final String component5() {
        return this.title;
    }

    public final int component6() {
        return this.month;
    }

    public final RechargeGoodsDiscountInfo copy(String productId, float f2, String price, String originalPrice, String title, int i2) {
        s.h(productId, "productId");
        s.h(price, "price");
        s.h(originalPrice, "originalPrice");
        s.h(title, "title");
        return new RechargeGoodsDiscountInfo(productId, f2, price, originalPrice, title, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RechargeGoodsDiscountInfo) {
            RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo = (RechargeGoodsDiscountInfo) obj;
            return s.c(this.productId, rechargeGoodsDiscountInfo.productId) && s.c(Float.valueOf(this.pay), Float.valueOf(rechargeGoodsDiscountInfo.pay)) && s.c(this.price, rechargeGoodsDiscountInfo.price) && s.c(this.originalPrice, rechargeGoodsDiscountInfo.originalPrice) && s.c(this.title, rechargeGoodsDiscountInfo.title) && this.month == rechargeGoodsDiscountInfo.month;
        }
        return false;
    }

    public final int getMonth() {
        return this.month;
    }

    public final String getOriginalPrice() {
        return this.originalPrice;
    }

    public final float getPay() {
        return this.pay;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.productId.hashCode() * 31) + Float.floatToIntBits(this.pay)) * 31) + this.price.hashCode()) * 31) + this.originalPrice.hashCode()) * 31) + this.title.hashCode()) * 31) + this.month;
    }

    public final void setMonth(int i2) {
        this.month = i2;
    }

    public final void setOriginalPrice(String str) {
        s.h(str, "<set-?>");
        this.originalPrice = str;
    }

    public final void setPay(float f2) {
        this.pay = f2;
    }

    public final void setPrice(String str) {
        s.h(str, "<set-?>");
        this.price = str;
    }

    public final void setProductId(String str) {
        s.h(str, "<set-?>");
        this.productId = str;
    }

    public final void setTitle(String str) {
        s.h(str, "<set-?>");
        this.title = str;
    }

    public String toString() {
        return "RechargeGoodsDiscountInfo(productId=" + this.productId + ", pay=" + this.pay + ", price=" + this.price + ", originalPrice=" + this.originalPrice + ", title=" + this.title + ", month=" + this.month + ')';
    }
}
