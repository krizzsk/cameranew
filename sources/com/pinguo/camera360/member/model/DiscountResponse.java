package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: RechargeGoodsInfo.kt */
/* loaded from: classes3.dex */
public final class DiscountResponse implements NoProguard {
    private final DiscountData data;
    private final String message;
    private final Integer status;

    public DiscountResponse(String str, Integer num, DiscountData discountData) {
        this.message = str;
        this.status = num;
        this.data = discountData;
    }

    public static /* synthetic */ DiscountResponse copy$default(DiscountResponse discountResponse, String str, Integer num, DiscountData discountData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = discountResponse.message;
        }
        if ((i2 & 2) != 0) {
            num = discountResponse.status;
        }
        if ((i2 & 4) != 0) {
            discountData = discountResponse.data;
        }
        return discountResponse.copy(str, num, discountData);
    }

    public final String component1() {
        return this.message;
    }

    public final Integer component2() {
        return this.status;
    }

    public final DiscountData component3() {
        return this.data;
    }

    public final DiscountResponse copy(String str, Integer num, DiscountData discountData) {
        return new DiscountResponse(str, num, discountData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscountResponse) {
            DiscountResponse discountResponse = (DiscountResponse) obj;
            return s.c(this.message, discountResponse.message) && s.c(this.status, discountResponse.status) && s.c(this.data, discountResponse.data);
        }
        return false;
    }

    public final DiscountData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        DiscountData discountData = this.data;
        return hashCode2 + (discountData != null ? discountData.hashCode() : 0);
    }

    public String toString() {
        return "DiscountResponse(message=" + ((Object) this.message) + ", status=" + this.status + ", data=" + this.data + ')';
    }
}
