package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class r {
    private final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap());
    private final Map<com.google.android.gms.tasks.h<?>, Boolean> b = Collections.synchronizedMap(new WeakHashMap());

    private final void c(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.a) {
            hashMap = new HashMap(this.a);
        }
        synchronized (this.b) {
            hashMap2 = new HashMap(this.b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).zab(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((com.google.android.gms.tasks.h) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(BasePendingResult<? extends com.google.android.gms.common.api.g> basePendingResult, boolean z) {
        this.a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.addStatusListener(new q(this, basePendingResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return (this.a.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    public final void e() {
        c(false, f.n);
    }

    public final void f() {
        c(true, p0.a);
    }
}
