package com.ironsource.mediationsdk.utils;

import java.util.Date;
/* compiled from: DurationMeasurement.java */
/* loaded from: classes2.dex */
public class e {
    private long a = new Date().getTime();

    public static long a(e eVar) {
        if (eVar == null) {
            return 0L;
        }
        return new Date().getTime() - eVar.a;
    }
}
