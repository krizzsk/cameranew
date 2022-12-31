package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbo {
    private Map<Integer, Bitmap> a = new ConcurrentHashMap();

    public zzbo() {
        new AtomicInteger(0);
    }

    public final Bitmap zza(Integer num) {
        return this.a.get(num);
    }
}
