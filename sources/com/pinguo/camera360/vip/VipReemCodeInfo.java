package com.pinguo.camera360.vip;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: VipRedemCodeResponse.kt */
/* loaded from: classes3.dex */
public final class VipReemCodeInfo implements NoProguard {
    private final float expireTime;
    private boolean giftVip;
    private final float purchaseTime;

    public VipReemCodeInfo(boolean z, float f2, float f3) {
        this.giftVip = z;
        this.expireTime = f2;
        this.purchaseTime = f3;
    }

    public static /* synthetic */ VipReemCodeInfo copy$default(VipReemCodeInfo vipReemCodeInfo, boolean z, float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = vipReemCodeInfo.giftVip;
        }
        if ((i2 & 2) != 0) {
            f2 = vipReemCodeInfo.expireTime;
        }
        if ((i2 & 4) != 0) {
            f3 = vipReemCodeInfo.purchaseTime;
        }
        return vipReemCodeInfo.copy(z, f2, f3);
    }

    public final boolean component1() {
        return this.giftVip;
    }

    public final float component2() {
        return this.expireTime;
    }

    public final float component3() {
        return this.purchaseTime;
    }

    public final VipReemCodeInfo copy(boolean z, float f2, float f3) {
        return new VipReemCodeInfo(z, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VipReemCodeInfo) {
            VipReemCodeInfo vipReemCodeInfo = (VipReemCodeInfo) obj;
            return this.giftVip == vipReemCodeInfo.giftVip && s.c(Float.valueOf(this.expireTime), Float.valueOf(vipReemCodeInfo.expireTime)) && s.c(Float.valueOf(this.purchaseTime), Float.valueOf(vipReemCodeInfo.purchaseTime));
        }
        return false;
    }

    public final float getExpireTime() {
        return this.expireTime;
    }

    public final boolean getGiftVip() {
        return this.giftVip;
    }

    public final float getPurchaseTime() {
        return this.purchaseTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.giftVip;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + Float.floatToIntBits(this.expireTime)) * 31) + Float.floatToIntBits(this.purchaseTime);
    }

    public final void setGiftVip(boolean z) {
        this.giftVip = z;
    }

    public String toString() {
        return "VipReemCodeInfo(giftVip=" + this.giftVip + ", expireTime=" + this.expireTime + ", purchaseTime=" + this.purchaseTime + ')';
    }
}
