package com.ironsource.mediationsdk.adunit.events;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
/* compiled from: Load.java */
/* loaded from: classes2.dex */
public class f extends d {
    public f(AdUnitEventsWrapper adUnitEventsWrapper) {
        super(adUnitEventsWrapper);
    }

    public void c(long j2, int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        hashMap.put("errorCode", Integer.valueOf(i2));
        hashMap.put("reason", str);
        b(AdUnitEvents.LOAD_AD_FAILED, hashMap);
    }

    public void d() {
        a(AdUnitEvents.LOAD_AD);
    }

    public void e(long j2, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        hashMap.put("errorCode", Integer.valueOf(i2));
        b(AdUnitEvents.LOAD_AD_NO_FILL, hashMap);
    }

    public void f(long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        b(AdUnitEvents.LOAD_AD_SUCCESS, hashMap);
    }
}
