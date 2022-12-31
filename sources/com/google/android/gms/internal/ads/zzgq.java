package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgq<T> {
    private final Map<String, AtomicReference<T>> zzaby = new HashMap();

    public final AtomicReference<T> zzas(String str) {
        synchronized (this) {
            if (!this.zzaby.containsKey(str)) {
                this.zzaby.put(str, new AtomicReference<>());
            }
        }
        return this.zzaby.get(str);
    }
}
