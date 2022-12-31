package com.pinguo.camera360.member.model;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: RechargeGoodsInfo.kt */
/* loaded from: classes3.dex */
public final class MemberPriceInfo implements NoProguard {
    private List<RechargeGoodsDiscountInfo> list;
    private int miguway;
    private int mmgzway;

    public MemberPriceInfo(List<RechargeGoodsDiscountInfo> list, int i2, int i3) {
        s.h(list, "list");
        this.list = list;
        this.miguway = i2;
        this.mmgzway = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MemberPriceInfo copy$default(MemberPriceInfo memberPriceInfo, List list, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = memberPriceInfo.list;
        }
        if ((i4 & 2) != 0) {
            i2 = memberPriceInfo.miguway;
        }
        if ((i4 & 4) != 0) {
            i3 = memberPriceInfo.mmgzway;
        }
        return memberPriceInfo.copy(list, i2, i3);
    }

    public final List<RechargeGoodsDiscountInfo> component1() {
        return this.list;
    }

    public final int component2() {
        return this.miguway;
    }

    public final int component3() {
        return this.mmgzway;
    }

    public final MemberPriceInfo copy(List<RechargeGoodsDiscountInfo> list, int i2, int i3) {
        s.h(list, "list");
        return new MemberPriceInfo(list, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MemberPriceInfo) {
            MemberPriceInfo memberPriceInfo = (MemberPriceInfo) obj;
            return s.c(this.list, memberPriceInfo.list) && this.miguway == memberPriceInfo.miguway && this.mmgzway == memberPriceInfo.mmgzway;
        }
        return false;
    }

    public final List<RechargeGoodsDiscountInfo> getList() {
        return this.list;
    }

    public final int getMiguway() {
        return this.miguway;
    }

    public final int getMmgzway() {
        return this.mmgzway;
    }

    public int hashCode() {
        return (((this.list.hashCode() * 31) + this.miguway) * 31) + this.mmgzway;
    }

    public final void setList(List<RechargeGoodsDiscountInfo> list) {
        s.h(list, "<set-?>");
        this.list = list;
    }

    public final void setMiguway(int i2) {
        this.miguway = i2;
    }

    public final void setMmgzway(int i2) {
        this.mmgzway = i2;
    }

    public String toString() {
        return "MemberPriceInfo(list=" + this.list + ", miguway=" + this.miguway + ", mmgzway=" + this.mmgzway + ')';
    }
}
