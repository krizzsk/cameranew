package com.pinguo.lib.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
/* compiled from: DebugHelper.java */
/* loaded from: classes3.dex */
class DebugProfile implements Comparable<DebugProfile> {
    private static NumberFormat percent = NumberFormat.getPercentInstance();
    public long inc;
    public String incPercent;
    public String tag;

    public DebugProfile(String str, long j2, double d2) {
        this.tag = str;
        this.inc = j2;
        DecimalFormat decimalFormat = new DecimalFormat("0.00#%");
        percent = decimalFormat;
        this.incPercent = decimalFormat.format(d2);
    }

    @Override // java.lang.Comparable
    public int compareTo(DebugProfile debugProfile) {
        return (int) (debugProfile.inc - this.inc);
    }
}
