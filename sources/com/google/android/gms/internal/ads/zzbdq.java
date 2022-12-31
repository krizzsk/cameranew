package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbdq {
    private final ArrayList<zzou> zzeqk = new ArrayList<>();
    private long zzeql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzou zzouVar) {
        this.zzeqk.add(zzouVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzacn() {
        Iterator<zzou> it = this.zzeqk.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.zzeql = Math.max(this.zzeql, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzeql;
    }
}
