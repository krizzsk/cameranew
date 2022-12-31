package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class b<O extends a.d> {
    private final boolean a = false;
    private final int b;
    private final com.google.android.gms.common.api.a<O> c;

    /* renamed from: d  reason: collision with root package name */
    private final O f3606d;

    private b(com.google.android.gms.common.api.a<O> aVar, O o) {
        this.c = aVar;
        this.f3606d = o;
        this.b = com.google.android.gms.common.internal.p.b(aVar, o);
    }

    public static <O extends a.d> b<O> b(com.google.android.gms.common.api.a<O> aVar, O o) {
        return new b<>(aVar, o);
    }

    public final String a() {
        return this.c.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return !this.a && !bVar.a && com.google.android.gms.common.internal.p.a(this.c, bVar.c) && com.google.android.gms.common.internal.p.a(this.f3606d, bVar.f3606d);
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }
}
