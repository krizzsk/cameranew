package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.6m  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06376m {
    public final Map<Integer, AnonymousClass66<AbstractC06506z>> A00;
    @Nullable
    public static C06376m A02 = null;
    public static long A01 = 0;

    public C06376m(Map<Integer, AnonymousClass66<AbstractC06506z>> map) {
        this.A00 = map;
    }

    public static synchronized long A00() {
        long j2;
        synchronized (C06376m.class) {
            j2 = A01;
        }
        return j2;
    }

    @SuppressLint({"UseSparseArrays"})
    public static C06376m A01() {
        if (A02 == null) {
            A02 = new C06376m(Collections.synchronizedMap(new HashMap()));
        }
        return A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.66 != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    private synchronized void A02(AnonymousClass66<AbstractC06506z> anonymousClass66, int i2) {
        int i3 = 0;
        boolean z = false;
        if (anonymousClass66.A00() == 0) {
            z = true;
            i3 = anonymousClass66.A01().A05();
        }
        int updatedSize = i2 - i3;
        A01 += (z ? 0 : 4) + updatedSize;
    }

    @SuppressLint({"PublicMethodReturnMutableCollection"})
    public final Map<Integer, AnonymousClass66<AbstractC06506z>> A03() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.66 != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    public final synchronized void A04(int i2, AnonymousClass66<AbstractC06506z> anonymousClass66, int i3) {
        this.A00.put(Integer.valueOf(i2), anonymousClass66);
        A02(anonymousClass66, i3);
    }
}
