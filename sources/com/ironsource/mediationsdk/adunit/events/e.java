package com.ironsource.mediationsdk.adunit.events;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
/* compiled from: Init.java */
/* loaded from: classes2.dex */
public class e extends d {
    public e(AdUnitEventsWrapper adUnitEventsWrapper) {
        super(adUnitEventsWrapper);
    }

    public void c(long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        b(AdUnitEvents.INIT_ENDED, hashMap);
    }

    public void d() {
        a(AdUnitEvents.INIT_STARTED);
    }
}
