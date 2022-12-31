package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: RechargeGoodsInfo.kt */
/* loaded from: classes3.dex */
public final class DiscountInfo implements NoProguard {
    private final String originProductId;
    private final String productId;

    public DiscountInfo(String str, String str2) {
        this.originProductId = str;
        this.productId = str2;
    }

    public static /* synthetic */ DiscountInfo copy$default(DiscountInfo discountInfo, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = discountInfo.originProductId;
        }
        if ((i2 & 2) != 0) {
            str2 = discountInfo.productId;
        }
        return discountInfo.copy(str, str2);
    }

    public final String component1() {
        return this.originProductId;
    }

    public final String component2() {
        return this.productId;
    }

    public final DiscountInfo copy(String str, String str2) {
        return new DiscountInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscountInfo) {
            DiscountInfo discountInfo = (DiscountInfo) obj;
            return s.c(this.originProductId, discountInfo.originProductId) && s.c(this.productId, discountInfo.productId);
        }
        return false;
    }

    public final String getOriginProductId() {
        return this.originProductId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        String str = this.originProductId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.productId;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DiscountInfo(originProductId=" + ((Object) this.originProductId) + ", productId=" + ((Object) this.productId) + ')';
    }
}
