package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class v0 {
    private final ArrayMap<b<?>, ConnectionResult> a;
    private final ArrayMap<b<?>, String> b;
    private final com.google.android.gms.tasks.h<Map<b<?>, String>> c;

    /* renamed from: d  reason: collision with root package name */
    private int f3639d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3640e;

    public final void a(b<?> bVar, ConnectionResult connectionResult, @Nullable String str) {
        this.a.put(bVar, connectionResult);
        this.b.put(bVar, str);
        this.f3639d--;
        if (!connectionResult.U()) {
            this.f3640e = true;
        }
        if (this.f3639d == 0) {
            if (this.f3640e) {
                this.c.b(new AvailabilityException(this.a));
                return;
            }
            this.c.c(this.b);
        }
    }

    public final Set<b<?>> b() {
        return this.a.keySet();
    }
}
