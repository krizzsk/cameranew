package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzox {
    private final Map<String, String> zzbjf = new HashMap();
    private Map<String, String> zzbjg;

    public final synchronized Map<String, String> zzis() {
        if (this.zzbjg == null) {
            this.zzbjg = Collections.unmodifiableMap(new HashMap(this.zzbjf));
        }
        return this.zzbjg;
    }
}
