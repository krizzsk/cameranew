package com.pinguo.camera360.vip;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: VipRedemCodeResponse.kt */
/* loaded from: classes3.dex */
public final class VipRestoreInfo implements NoProguard {
    private final float appleExpireTime;
    private final int appleVip;
    private final int errorCode;
    private final float expireTime;
    private final int giftVip;
    private final int isTrialPeriod;
    private final int operationVip;
    private final String productId;
    private final float purchaseTime;
    private final int sandbox;

    public VipRestoreInfo(float f2, int i2, int i3, float f3, int i4, int i5, int i6, String productId, float f4, int i7) {
        s.h(productId, "productId");
        this.appleExpireTime = f2;
        this.appleVip = i2;
        this.errorCode = i3;
        this.expireTime = f3;
        this.giftVip = i4;
        this.isTrialPeriod = i5;
        this.operationVip = i6;
        this.productId = productId;
        this.purchaseTime = f4;
        this.sandbox = i7;
    }

    public final float component1() {
        return this.appleExpireTime;
    }

    public final int component10() {
        return this.sandbox;
    }

    public final int component2() {
        return this.appleVip;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final float component4() {
        return this.expireTime;
    }

    public final int component5() {
        return this.giftVip;
    }

    public final int component6() {
        return this.isTrialPeriod;
    }

    public final int component7() {
        return this.operationVip;
    }

    public final String component8() {
        return this.productId;
    }

    public final float component9() {
        return this.purchaseTime;
    }

    public final VipRestoreInfo copy(float f2, int i2, int i3, float f3, int i4, int i5, int i6, String productId, float f4, int i7) {
        s.h(productId, "productId");
        return new VipRestoreInfo(f2, i2, i3, f3, i4, i5, i6, productId, f4, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VipRestoreInfo) {
            VipRestoreInfo vipRestoreInfo = (VipRestoreInfo) obj;
            return s.c(Float.valueOf(this.appleExpireTime), Float.valueOf(vipRestoreInfo.appleExpireTime)) && this.appleVip == vipRestoreInfo.appleVip && this.errorCode == vipRestoreInfo.errorCode && s.c(Float.valueOf(this.expireTime), Float.valueOf(vipRestoreInfo.expireTime)) && this.giftVip == vipRestoreInfo.giftVip && this.isTrialPeriod == vipRestoreInfo.isTrialPeriod && this.operationVip == vipRestoreInfo.operationVip && s.c(this.productId, vipRestoreInfo.productId) && s.c(Float.valueOf(this.purchaseTime), Float.valueOf(vipRestoreInfo.purchaseTime)) && this.sandbox == vipRestoreInfo.sandbox;
        }
        return false;
    }

    public final float getAppleExpireTime() {
        return this.appleExpireTime;
    }

    public final int getAppleVip() {
        return this.appleVip;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final float getExpireTime() {
        return this.expireTime;
    }

    public final int getGiftVip() {
        return this.giftVip;
    }

    public final int getOperationVip() {
        return this.operationVip;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final float getPurchaseTime() {
        return this.purchaseTime;
    }

    public final int getSandbox() {
        return this.sandbox;
    }

    public int hashCode() {
        return (((((((((((((((((Float.floatToIntBits(this.appleExpireTime) * 31) + this.appleVip) * 31) + this.errorCode) * 31) + Float.floatToIntBits(this.expireTime)) * 31) + this.giftVip) * 31) + this.isTrialPeriod) * 31) + this.operationVip) * 31) + this.productId.hashCode()) * 31) + Float.floatToIntBits(this.purchaseTime)) * 31) + this.sandbox;
    }

    public final int isTrialPeriod() {
        return this.isTrialPeriod;
    }

    public String toString() {
        return "VipRestoreInfo(appleExpireTime=" + this.appleExpireTime + ", appleVip=" + this.appleVip + ", errorCode=" + this.errorCode + ", expireTime=" + this.expireTime + ", giftVip=" + this.giftVip + ", isTrialPeriod=" + this.isTrialPeriod + ", operationVip=" + this.operationVip + ", productId=" + this.productId + ", purchaseTime=" + this.purchaseTime + ", sandbox=" + this.sandbox + ')';
    }
}
