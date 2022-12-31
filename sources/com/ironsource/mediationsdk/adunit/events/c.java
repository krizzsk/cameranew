package com.ironsource.mediationsdk.adunit.events;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
/* compiled from: Auction.java */
/* loaded from: classes2.dex */
public class c extends d {
    public c(AdUnitEventsWrapper adUnitEventsWrapper) {
        super(adUnitEventsWrapper);
    }

    public void c(long j2, int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        hashMap.put("errorCode", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("reason", str);
        }
        b(AdUnitEvents.AUCTION_FAILED, hashMap);
    }

    public void d() {
        a(AdUnitEvents.AUCTION_REQUEST);
    }

    public void e(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ext1", str);
        b(AdUnitEvents.AUCTION_REQUEST_WATERFALL, hashMap);
    }

    public void f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ext1", str);
        b(AdUnitEvents.AUCTION_RESULT_WATERFALL, hashMap);
    }

    public void g(long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(j2));
        b(AdUnitEvents.AUCTION_SUCCESS, hashMap);
    }
}
