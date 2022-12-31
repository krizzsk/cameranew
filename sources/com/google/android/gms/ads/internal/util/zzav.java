package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzav {
    private final List<String> a = new ArrayList();
    private final List<Double> b = new ArrayList();
    private final List<Double> c = new ArrayList();

    public final zzav zza(String str, double d2, double d3) {
        int i2 = 0;
        while (i2 < this.a.size()) {
            double doubleValue = this.c.get(i2).doubleValue();
            double doubleValue2 = this.b.get(i2).doubleValue();
            if (d2 < doubleValue || (doubleValue == d2 && d3 < doubleValue2)) {
                break;
            }
            i2++;
        }
        this.a.add(i2, str);
        this.c.add(i2, Double.valueOf(d2));
        this.b.add(i2, Double.valueOf(d3));
        return this;
    }

    public final zzau zzzo() {
        return new zzau(this);
    }
}
