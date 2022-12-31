package com.ironsource.mediationsdk.model;

import com.zhy.android.percent.support.PercentLayoutHelper;
/* loaded from: classes2.dex */
public enum PlacementCappingType {
    PER_DAY("d"),
    PER_HOUR(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H);
    
    public String value;

    PlacementCappingType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
