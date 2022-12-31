package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: RechargeGoodsInfo.kt */
/* loaded from: classes3.dex */
public final class DiscountData implements NoProguard {
    private final DiscountInfo product;

    public DiscountData(DiscountInfo discountInfo) {
        this.product = discountInfo;
    }

    public static /* synthetic */ DiscountData copy$default(DiscountData discountData, DiscountInfo discountInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            discountInfo = discountData.product;
        }
        return discountData.copy(discountInfo);
    }

    public final DiscountInfo component1() {
        return this.product;
    }

    public final DiscountData copy(DiscountInfo discountInfo) {
        return new DiscountData(discountInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DiscountData) && s.c(this.product, ((DiscountData) obj).product);
    }

    public final DiscountInfo getProduct() {
        return this.product;
    }

    public int hashCode() {
        DiscountInfo discountInfo = this.product;
        if (discountInfo == null) {
            return 0;
        }
        return discountInfo.hashCode();
    }

    public String toString() {
        return "DiscountData(product=" + this.product + ')';
    }
}
