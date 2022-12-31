package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzau {
    private final String[] a;
    private final double[] b;
    private final double[] c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f3478d;

    /* renamed from: e  reason: collision with root package name */
    private int f3479e;

    private zzau(zzav zzavVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzavVar.b;
        int size = list.size();
        list2 = zzavVar.a;
        this.a = (String[]) list2.toArray(new String[size]);
        list3 = zzavVar.b;
        this.b = a(list3);
        list4 = zzavVar.c;
        this.c = a(list4);
        this.f3478d = new int[size];
        this.f3479e = 0;
    }

    private static double[] a(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = list.get(i2).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d2) {
        this.f3479e++;
        int i2 = 0;
        while (true) {
            double[] dArr = this.c;
            if (i2 >= dArr.length) {
                return;
            }
            if (dArr[i2] <= d2 && d2 < this.b[i2]) {
                int[] iArr = this.f3478d;
                iArr[i2] = iArr[i2] + 1;
            }
            if (d2 < dArr[i2]) {
                return;
            }
            i2++;
        }
    }

    public final List<zzaw> zzzn() {
        ArrayList arrayList = new ArrayList(this.a.length);
        int i2 = 0;
        while (true) {
            String[] strArr = this.a;
            if (i2 >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i2];
            double d2 = this.c[i2];
            double d3 = this.b[i2];
            int[] iArr = this.f3478d;
            arrayList.add(new zzaw(str, d2, d3, iArr[i2] / this.f3479e, iArr[i2]));
            i2++;
        }
    }
}
