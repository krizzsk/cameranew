package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: RechargeGoodsInfo.kt */
/* loaded from: classes3.dex */
public final class RechargeGoodsInfo implements NoProguard {
    private MemberPriceInfo data;
    private String exetime;
    private String message;
    private float serverTime;
    private int status;

    public RechargeGoodsInfo(int i2, String message, float f2, String exetime, MemberPriceInfo data) {
        s.h(message, "message");
        s.h(exetime, "exetime");
        s.h(data, "data");
        this.status = i2;
        this.message = message;
        this.serverTime = f2;
        this.exetime = exetime;
        this.data = data;
    }

    public static /* synthetic */ RechargeGoodsInfo copy$default(RechargeGoodsInfo rechargeGoodsInfo, int i2, String str, float f2, String str2, MemberPriceInfo memberPriceInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = rechargeGoodsInfo.status;
        }
        if ((i3 & 2) != 0) {
            str = rechargeGoodsInfo.message;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            f2 = rechargeGoodsInfo.serverTime;
        }
        float f3 = f2;
        if ((i3 & 8) != 0) {
            str2 = rechargeGoodsInfo.exetime;
        }
        String str4 = str2;
        if ((i3 & 16) != 0) {
            memberPriceInfo = rechargeGoodsInfo.data;
        }
        return rechargeGoodsInfo.copy(i2, str3, f3, str4, memberPriceInfo);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final float component3() {
        return this.serverTime;
    }

    public final String component4() {
        return this.exetime;
    }

    public final MemberPriceInfo component5() {
        return this.data;
    }

    public final RechargeGoodsInfo copy(int i2, String message, float f2, String exetime, MemberPriceInfo data) {
        s.h(message, "message");
        s.h(exetime, "exetime");
        s.h(data, "data");
        return new RechargeGoodsInfo(i2, message, f2, exetime, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RechargeGoodsInfo) {
            RechargeGoodsInfo rechargeGoodsInfo = (RechargeGoodsInfo) obj;
            return this.status == rechargeGoodsInfo.status && s.c(this.message, rechargeGoodsInfo.message) && s.c(Float.valueOf(this.serverTime), Float.valueOf(rechargeGoodsInfo.serverTime)) && s.c(this.exetime, rechargeGoodsInfo.exetime) && s.c(this.data, rechargeGoodsInfo.data);
        }
        return false;
    }

    public final MemberPriceInfo getData() {
        return this.data;
    }

    public final String getExetime() {
        return this.exetime;
    }

    public final String getMessage() {
        return this.message;
    }

    public final float getServerTime() {
        return this.serverTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((this.status * 31) + this.message.hashCode()) * 31) + Float.floatToIntBits(this.serverTime)) * 31) + this.exetime.hashCode()) * 31) + this.data.hashCode();
    }

    public final void setData(MemberPriceInfo memberPriceInfo) {
        s.h(memberPriceInfo, "<set-?>");
        this.data = memberPriceInfo;
    }

    public final void setExetime(String str) {
        s.h(str, "<set-?>");
        this.exetime = str;
    }

    public final void setMessage(String str) {
        s.h(str, "<set-?>");
        this.message = str;
    }

    public final void setServerTime(float f2) {
        this.serverTime = f2;
    }

    public final void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "RechargeGoodsInfo(status=" + this.status + ", message=" + this.message + ", serverTime=" + this.serverTime + ", exetime=" + this.exetime + ", data=" + this.data + ')';
    }
}
